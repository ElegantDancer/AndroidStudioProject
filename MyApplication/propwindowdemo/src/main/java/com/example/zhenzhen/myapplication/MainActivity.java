package com.example.zhenzhen.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;

/**
 * Description: <br/>
 * site: <a href="http://www.crazyit.org">crazyit.org</a> <br/>
 * Copyright (C), 2001-2012, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class MainActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // װ��R.layout.popup��Ӧ�Ľ��沼��
        View root = this.getLayoutInflater().inflate(R.layout.popu, null);
        // ����PopupWindow����
        final PopupWindow popup = new PopupWindow(root, 280, 360);
        Button button = (Button) findViewById(R.id.bn);
        button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // ��������ʽ��ʾ��
//				popup.showAsDropDown(v);
                //��PopupWindow��ʾ��ָ��λ��
                popup.showAtLocation(findViewById(R.id.bn), Gravity.CENTER, 20,
                        20);

            }
        });
        // ��ȡPopupWindow�еĹرհ�ť��
        root.findViewById(R.id.close).setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        // �ر�PopupWindow
                        popup.dismiss(); //��
                    }
                });
    }
}