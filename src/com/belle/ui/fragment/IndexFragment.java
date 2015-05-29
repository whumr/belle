package com.belle.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.belle.R;
import com.belle.common.BaseFragment;

public class IndexFragment extends BaseFragment {

	public IndexFragment() {
		super();
		this.text_id = R.string.tab_index;
		this.defalt_ui = false;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.index_fragment, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
}