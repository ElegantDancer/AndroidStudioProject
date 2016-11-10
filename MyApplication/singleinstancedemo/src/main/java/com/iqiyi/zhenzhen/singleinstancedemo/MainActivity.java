package com.iqiyi.zhenzhen.singleinstancedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mButton = (Button) findViewById(R.id.single_btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomPlayer player= CustomPlayer.getInstance();
                player.setName("第一个");
                mButton.setText(player.getName());
                Intent mIntent = new Intent(MainActivity.this, OtherActivity.class);
                startActivity(mIntent);
            }
        });
    }
}
