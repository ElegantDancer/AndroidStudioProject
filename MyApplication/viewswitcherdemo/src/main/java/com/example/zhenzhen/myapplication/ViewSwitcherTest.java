package com.example.zhenzhen.myapplication;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import android.widget.ViewSwitcher.ViewFactory;

public class ViewSwitcherTest extends Activity
{
    // ¶¨ÒåÒ»¸ö³£Á¿£¬ÓÃÓÚÏÔÊ¾Ã¿ÆÁÏÔÊ¾µÄÓ¦ÓÃ³ÌÐòÊý
    public static final int NUMBER_PER_SCREEN = 12;

    // ´ú±íÓ¦ÓÃ³ÌÐòµÄÄÚ²¿Àà£¬
    public static class DataItem
    {
        // Ó¦ÓÃ³ÌÐòÃû³Æ
        public String dataName;
        // Ó¦ÓÃ³ÌÐòÍ¼±ê
        public Drawable drawable;
    }

    // ±£´æÏµÍ³ËùÓÐÓ¦ÓÃ³ÌÐòµÄList¼¯ºÏ
    private ArrayList<DataItem> items = new ArrayList<DataItem>();
    // ¼ÇÂ¼µ±Ç°ÕýÔÚÏÔÊ¾µÚ¼¸ÆÁµÄ³ÌÐò
    private int screenNo = -1;
    // ±£´æ³ÌÐòËùÕ¼µÄ×ÜÆÁÊý
    private int screenCount;
    ViewSwitcher switcher;
    // ´´½¨LayoutInflater¶ÔÏó
    LayoutInflater inflater;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        inflater = LayoutInflater.from(ViewSwitcherTest.this);
        // ´´½¨Ò»¸ö°üº¬40¸öÔªËØµÄList¼¯ºÏ£¬ÓÃÓÚÄ£Äâ°üº¬40¸öÓ¦ÓÃ³ÌÐò
        for (int i = 0; i < 40; i++)
        {
            String label = "" + i;
            Drawable drawable = getResources().getDrawable(
                    R.mipmap.ic_launcher);
            DataItem item = new DataItem();
            item.dataName = label;
            item.drawable = drawable;
            items.add(item);
        }
        // ¼ÆËãÓ¦ÓÃ³ÌÐòËùÕ¼µÄ×ÜÆÁÊý¡£
        // Èç¹ûÓ¦ÓÃ³ÌÐòµÄÊýÁ¿ÄÜÕû³ýNUMBER_PER_SCREEN£¬³ý·¨µÄ½á¹û¾ÍÊÇ×ÜÆÁÊý¡£
        // Èç¹û²»ÄÜÕû³ý£¬×ÜÆÁÊýÓ¦¸ÃÊÇ³ý·¨µÄ½á¹ûÔÙ¼Ó1¡£
        screenCount = items.size() % NUMBER_PER_SCREEN == 0 ?
                items.size()/ NUMBER_PER_SCREEN :
                items.size() / NUMBER_PER_SCREEN	+ 1;
        switcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
        switcher.setFactory(new ViewFactory()
        {
            // Êµ¼ÊÉÏ¾ÍÊÇ·µ»ØÒ»¸öGridView×é¼þ
            @Override
            public View makeView()
            {
                // ¼ÓÔØR.layout.slidelistview×é¼þ£¬Êµ¼ÊÉÏ¾ÍÊÇÒ»¸öGridView×é¼þ¡£
                return inflater.inflate(R.layout.slidelistview, null);
            }
        });
        // Ò³Ãæ¼ÓÔØÊ±ÏÈÏÔÊ¾µÚÒ»ÆÁ¡£
        next(null);
    }

    public void next(View v)
    {
        if (screenNo < screenCount - 1)
        {
            screenNo++;
            // ÎªViewSwitcherµÄ×é¼þÏÔÊ¾¹ý³ÌÉèÖÃ¶¯»­
            switcher.setInAnimation(this, android.R.anim.slide_out_right);
            // ÎªViewSwitcherµÄ×é¼þÒþ²Ø¹ý³ÌÉèÖÃ¶¯»­
            switcher.setOutAnimation(this, android.R.anim.slide_in_left);
            // ¿ØÖÆÏÂÒ»ÆÁ½«ÒªÏÔÊ¾µÄGridView¶ÔÓ¦µÄ Adapter
            ((GridView) switcher.getNextView()).setAdapter(adapter);
            // µã»÷ÓÒ±ß°´Å¥£¬ÏÔÊ¾ÏÂÒ»ÆÁ£¬
            // Ñ§Ï°ÊÖÊÆ¼ì²âºó£¬Ò²¿ÉÍ¨¹ýÊÖÊÆ¼ì²âÊµÏÖÏÔÊ¾ÏÂÒ»ÆÁ.
            switcher.showNext();  // ¢Ù
        }
    }

    public void prev(View v)
    {
        if (screenNo > 0)
        {
            screenNo--;
            // ÎªViewSwitcherµÄ×é¼þÏÔÊ¾¹ý³ÌÉèÖÃ¶¯»­
            switcher.setInAnimation(this, android.R.anim.slide_in_left);
            // ÎªViewSwitcherµÄ×é¼þÒþ²Ø¹ý³ÌÉèÖÃ¶¯»­
            switcher.setOutAnimation(this, android.R.anim.slide_out_right);
            // ¿ØÖÆÏÂÒ»ÆÁ½«ÒªÏÔÊ¾µÄGridView¶ÔÓ¦µÄ Adapter
            ((GridView) switcher.getNextView()).setAdapter(adapter);
            // µã»÷×ó±ß°´Å¥£¬ÏÔÊ¾ÉÏÒ»ÆÁ£¬µ±È»¿ÉÒÔ²ÉÓÃÊÖÊÆ
            // Ñ§Ï°ÊÖÊÆ¼ì²âºó£¬Ò²¿ÉÍ¨¹ýÊÖÊÆ¼ì²âÊµÏÖÏÔÊ¾ÉÏÒ»ÆÁ.
            switcher.showPrevious();   // ¢Ú
        }
    }

    // ¸ÃBaseAdapter¸ºÔðÎªÃ¿ÆÁÏÔÊ¾µÄGridViewÌá¹©ÁÐ±íÏî
    private BaseAdapter adapter = new BaseAdapter()
    {
        @Override
        public int getCount()
        {
            // Èç¹ûÒÑ¾­µ½ÁË×îºóÒ»ÆÁ£¬ÇÒÓ¦ÓÃ³ÌÐòµÄÊýÁ¿²»ÄÜÕû³ýNUMBER_PER_SCREEN
            if (screenNo == screenCount - 1
                    && items.size() % NUMBER_PER_SCREEN != 0)
            {
                // ×îºóÒ»ÆÁÏÔÊ¾µÄ³ÌÐòÊýÎªÓ¦ÓÃ³ÌÐòµÄÊýÁ¿¶ÔNUMBER_PER_SCREENÇóÓà
                return items.size() % NUMBER_PER_SCREEN;
            }
            // ·ñÔòÃ¿ÆÁÏÔÊ¾µÄ³ÌÐòÊýÁ¿ÎªNUMBER_PER_SCREEN
            return NUMBER_PER_SCREEN;
        }

        @Override
        public DataItem getItem(int position)
        {
            // ¸ù¾ÝscreenNo¼ÆËãµÚposition¸öÁÐ±íÏîµÄÊý¾Ý
            return items.get(screenNo * NUMBER_PER_SCREEN + position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position
                , View convertView, ViewGroup parent)
        {
            View view = convertView;
            if (convertView == null)
            {
                // ¼ÓÔØR.layout.labelicon²¼¾ÖÎÄ¼þ
                view = inflater.inflate(R.layout.labelicon, null);
            }
            // »ñÈ¡R.layout.labelicon²¼¾ÖÎÄ¼þÖÐµÄImageView×é¼þ£¬²¢ÎªÖ®ÉèÖÃÍ¼±ê
            ImageView imageView = (ImageView)
                    view.findViewById(R.id.imageview);
            imageView.setImageDrawable(getItem(position).drawable);
            // »ñÈ¡R.layout.labelicon²¼¾ÖÎÄ¼þÖÐµÄTextView×é¼þ£¬²¢ÎªÖ®ÉèÖÃÎÄ±¾
            TextView textView = (TextView)
                    view.findViewById(R.id.textview);
            textView.setText(getItem(position).dataName);
            return view;
        }
    };
}