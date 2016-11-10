package com.iqiyi.zhenzhen.mysimpleonestep;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.one_step_img);

        findViewById(R.id.one_step_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "This is what I want!");
                intent.setType("text/plain");
                startActivity(intent);
                mImageView.setImageDrawable(getInstalledAppList(intent));
            }
        });

    }

    private Drawable getInstalledAppList(Intent intent){
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> infos = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return infos.get(1).activityInfo.loadIcon(packageManager);
    }

    private void getInstalledApp(){
        PackageManager packageManager = getPackageManager();
        List<PackageInfo> infos = packageManager.getInstalledPackages(0);
    }
}
