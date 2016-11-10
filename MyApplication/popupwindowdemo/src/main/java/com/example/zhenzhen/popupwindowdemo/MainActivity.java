package com.example.zhenzhen.popupwindowdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PopupWindow myWindow = new PopupWindow();
        myWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        View root = this.getLayoutInflater().inflate(R.layout.popup, null);
        // ¥¥Ω®PopupWindow∂‘œÛ
        final PopupWindow popup = new PopupWindow(root, 280, 360, true);

        Button button = (Button) findViewById(R.id.bn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // “‘œ¬¿≠∑Ω Ωœ‘ æ°£
//				popup.showAsDropDown(v);
                //Ω´PopupWindowœ‘ æ‘⁄÷∏∂®Œª÷√
                popup.showAtLocation(findViewById(R.id.bn), Gravity.CENTER, 20,
                        20);
            }
        });
        // ªÒ»°PopupWindow÷–µƒπÿ±’∞¥≈•°£
        root.findViewById(R.id.close).setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // πÿ±’PopupWindow
                        popup.dismiss(); //¢Ÿ
                    }
                });

        TextView htmlTex = (TextView) findViewById(R.id.html_show);
        final String str = "<ul>\n" +
                "<li>1.<font color=\"#333\" style=\"line-height:1.5;\">预订国内酒店需要提供入住人的姓名。需与入住时所持证件完全一致。</font></li><br><br>\n" +
                "<li>2.预订港澳台及国际酒店，必须填写入住人的英文名。</li><br><br>\n" +
                "<li>3.<font color=\"#000\" style=\"line-height:1.5;\"><b>英文姓名填写格式（last/first middle）：</b></font>\n" +
                "    <font color=\"#333\" style=\"line-height:1.5;\"><br>姓在前，姓和名之间用“/”隔开，如有中间名则空一格紧随名之后,例：\n" +
                "\t<br>Zhang/Sanfeng（张三丰）；\n" +
                "\t<br>Green/Jim Stephanie。\n" +
                "\t</font>\n" +
                "</li><br><br>\n" +
                "<li> 4.<font  color=\"#333\" style=\"line-height:1.5;\">中文姓名中不能包含英文字母</font></li>\n" +
                "</ul>";

        final String str2 = "<ul>\n" +
                "<li><font color=\"#333\" style=\"line-height:1.5;\"><b>?中文姓名中不能包含英文字母。</b></font></li><br/>\n" +
                "<li><font color=\"#333\" style=\"line-height:1.5;\"><b>?英文姓名填写格式（last/first middle）：</b></font>\n" +
                "    <font color=\"#333\" style=\"line-height:1.5;\"><br>   建议姓在前，姓和名之间用“/”隔开，如有中间名则空一格紧随名之后,例：\n" +
                "\t<br>   Zhang/Sanfeng（张三丰）；\n" +
                "\t<br>   Green/Jim Stephanie。\n" +
                "\t</font>\n" +
                "</li><br/>\n" +
                "<li><font color=\"#333\" style=\"line-height:1.5;\">?请与有效证件保持一致。</font></li>\n" +
                "</ul>" ;

        htmlTex.setText(Html.fromHtml(str2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
