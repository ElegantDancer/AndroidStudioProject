package com.example.zhenzhen.myslingmenu;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import com.example.zhenzhen.myapplication.R;

import java.util.List;

public class ComplexClient extends AppCompatActivity {

    private IPet petService;
    private Button get;
    private EditText personView;
    private ListView showView;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            petService = IPet.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            petService = null;
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unbindService(conn);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personView = (EditText) findViewById(R.id.person);
        showView = (ListView) findViewById(R.id.show);
        get = (Button) findViewById(R.id.get);
        //创建所需绑定Service的Inteng

        Intent intent = new Intent();
        intent.setAction("com.zhenzhen.ComplexService");
        intent.setPackage("com.example.zhenzhen.myslingmenu");
        //远程绑定service
        bindService(intent, conn, Service.BIND_AUTO_CREATE);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String personName = personView.getText().toString();
                //调用远程service方法
                try {
                    List<Pet> pets = petService.getPets(new Person(1, personName, personName));
                    //将程序返回的List包装成ArrayAdapter
                    ArrayAdapter<Pet> adapter = new ArrayAdapter<>(ComplexClient.this, android.R.layout.simple_expandable_list_item_1, pets);
                    showView.setAdapter(adapter);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
