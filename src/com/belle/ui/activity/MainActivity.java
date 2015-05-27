package com.belle.ui.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.Toast;

import com.belle.R;
import com.belle.common.BaseFragment;
import com.belle.common.BaseFragmentActivity;
import com.belle.ui.fragment.FindFragment;
import com.belle.ui.fragment.IndexFragment;
import com.belle.ui.fragment.MallFragment;
import com.belle.ui.fragment.MyFragment;

public class MainActivity extends BaseFragmentActivity implements OnClickListener {

	private static FragmentManager fragmentManager;
	
	private SparseArray<BaseFragment> fragmentMap = new SparseArray<BaseFragment>();
	private List<RadioButton> navigations = new ArrayList<RadioButton>();
	
	private long exitTime;
	private int current_index = -1;
	private int quit_idle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		fragmentManager = getSupportFragmentManager();
		init();
	}

	/**
	 * 初始化首个Fragment
	 */
	private void init() {
		navigations.add((RadioButton)findViewById(R.id.tab_index));
		navigations.add((RadioButton)findViewById(R.id.tab_mall));
		navigations.add((RadioButton)findViewById(R.id.tab_find));
		navigations.add((RadioButton)findViewById(R.id.tab_my));
		for (RadioButton btn : navigations) 
			btn.setOnClickListener(this);
		
		fragmentMap.put(R.id.tab_index, new IndexFragment());
		fragmentMap.put(R.id.tab_mall, new MallFragment());
		fragmentMap.put(R.id.tab_find, new FindFragment());
		fragmentMap.put(R.id.tab_my, new MyFragment());
		
		navigations.get(0).performClick();
		
		quit_idle = Integer.parseInt(getString(R.string.quite_idle));
	}
	
	@Override
	public void onBackPressed() {
		boolean quit = true;
		if (System.currentTimeMillis() - exitTime > quit_idle) {
			Toast.makeText(this, getString(R.string.alert_msg_quit), Toast.LENGTH_SHORT).show();
			exitTime = System.currentTimeMillis();
			quit = false;
		}
		if (quit)
			finish();
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (current_index != id) {
			BaseFragment fragment = fragmentMap.get(id);
			FragmentTransaction ft = fragmentManager.beginTransaction();
			if (!fragment.isAdded())
				ft.add(R.id.fragmentRoot, fragment);
			if (current_index > 0)
				ft.hide(fragmentMap.get(current_index));
			ft.show(fragment);
			ft.commit();
			for (RadioButton btn : navigations) {
				if (btn.getId() != id)
					btn.setChecked(false);
			}
			current_index = id;
		}
	}
}
