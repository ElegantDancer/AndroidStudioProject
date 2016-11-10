/**
 *
 */
package com.example.zhenzhen.musicdemo;

import java.io.IOException;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.IBinder;
import android.util.Log;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class MusicService extends Service
{
	MyReceiver serviceReceiver;
	AssetManager am;
	String[] musics = new String[] { "wish.mp3", "promise.mp3",
		"beautiful.mp3" };
	MediaPlayer mPlayer;
	int status = 0x11;
	int current = 0;

	@Override
	public IBinder onBind(Intent intent)
	{
		return null;
	}

	@Override
	public void onCreate()
	{

		Log.i("service onCreate是否存在", "haha");
		am = getAssets();
		serviceReceiver = new MyReceiver();
		// ����IntentFilter
		IntentFilter filter = new IntentFilter();
		filter.addAction(MusicBox.CTL_ACTION);
		registerReceiver(serviceReceiver, filter);
		mPlayer = new MediaPlayer();
		mPlayer.setOnCompletionListener(new OnCompletionListener() //��
		{
			@Override
			public void onCompletion(MediaPlayer mp)
			{
				current++;
				if (current >= 3)
				{
					current = 0;
				}
				// ���͹㲥֪ͨActivity�����ı���
				Intent sendIntent = new Intent(MusicBox.UPDATE_ACTION);
				sendIntent.putExtra("current", current);
				sendBroadcast(sendIntent);
				prepareAndPlay(musics[current]);
			}
		});
		super.onCreate();
	}

	public class MyReceiver extends BroadcastReceiver
	{
		private String  total = "对象是否存在";
		@Override
		public void onReceive(final Context context, Intent intent)
		{

			Log.i("OnReceive----->", serviceReceiver.total);
			int control = intent.getIntExtra("control", -1);
			switch (control)
			{
				case 1:
					if (status == 0x11)
					{
						prepareAndPlay(musics[current]);
						status = 0x12;
					}
					else if (status == 0x12)
					{

						mPlayer.pause();
						status = 0x13;
					}

					else if (status == 0x13)
					{
						// ����
						mPlayer.start();
						// �ı�״̬
						status = 0x12;
					}
					break;
				// ֹͣ����
				case 2:
					if (status == 0x12 || status == 0x13)
					{
						// ֹͣ����
						mPlayer.stop();
						status = 0x11;
					}
			}
			// ���͹㲥֪ͨActivity����ͼ�ꡢ�ı���
			Intent sendIntent = new Intent(MusicBox.UPDATE_ACTION);
			sendIntent.putExtra("update", status);
			sendIntent.putExtra("current", current);
			// ���͹㲥 ������Activity����е�BroadcastReceiver���յ�
			sendBroadcast(sendIntent);
		}
	}

	private void prepareAndPlay(String music)
	{
		try
		{
			// ��ָ�������ļ�
			AssetFileDescriptor afd = am.openFd(music);
			mPlayer.reset();
			// ʹ��MediaPlayer����ָ���������ļ���
			mPlayer.setDataSource(afd.getFileDescriptor(),
				afd.getStartOffset(), afd.getLength());
			// ׼������
			mPlayer.prepare();
			// ����
			mPlayer.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
