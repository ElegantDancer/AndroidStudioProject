package com.example.zhenzhen.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import android.app.Activity;


public class MainActivity extends Activity implements
        SearchView.OnQueryTextListener
{
    private SearchView sv;
    private ListView lv;
    private final String[] mStrings = { "aaaaa", "bbbbbb", "cccccc" };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mStrings));
        lv.setTextFilterEnabled(true);
        sv = (SearchView) findViewById(R.id.sv);
        sv.setIconifiedByDefault(false);
        sv.setOnQueryTextListener(this);
        sv.setSubmitButtonEnabled(true);
        sv.setQueryHint("search");
    }

    // ÓÃ»§ÊäÈë×Ö·ûÊ±¼¤·¢¸Ã·½·¨
    @Override
    public boolean onQueryTextChange(String newText)
    {
        if (TextUtils.isEmpty(newText))
        {
            lv.clearTextFilter();
        }
        else
        {
            lv.setFilterText(newText);
        }
        return true;
    }

    // µ¥»÷ËÑË÷°´Å¥Ê±¼¤·¢¸Ã·½·¨
    @Override
    public boolean onQueryTextSubmit(String query)
    {
        // Êµ¼ÊÓ¦ÓÃÖÐÓ¦¸ÃÔÚ¸Ã·½·¨ÄÚÖ´ÐÐÊµ¼Ê²éÑ¯
        // ´Ë´¦½öÊ¹ÓÃToastÏÔÊ¾ÓÃ»§ÊäÈëµÄ²éÑ¯ÄÚÈÝ
        Toast.makeText(this, "ÄúµÄÑ¡ÔñÊÇ:" + query
                , Toast.LENGTH_SHORT).show();
        return false;
    }
}
