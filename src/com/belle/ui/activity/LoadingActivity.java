package com.belle.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.belle.R;
import com.belle.common.BaseActivity;

public class LoadingActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loding);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
			    startActivity(intent);
			    LoadingActivity.this.finish();
			}
		}).start();
	}
}