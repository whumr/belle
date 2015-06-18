package com.belle.ui.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.belle.R;
import com.belle.common.BaseFragment;
import com.belle.ui.widget.TestView;

public class MallFragment extends BaseFragment {

	TestView testView;
	
	public MallFragment() {
		super();
		this.text_id = R.string.tab_mall;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.mall_fragment, container, false);
		testView = (TestView)view.findViewById(R.id.testView);
		return view;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		testView.setRect(new Rect(300, 300, 500, 500));
	}
}