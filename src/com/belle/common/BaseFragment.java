package com.belle.common;

import com.belle.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BaseFragment extends Fragment {

	protected int text_id;
	protected boolean defalt_ui = true;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment, container, false);
		if (defalt_ui)
			((TextView)view.findViewById(R.id.fragment_text)).setText(getString(text_id));
		return view;
	}
	
//	@Override
//	public void onActivityCreated(Bundle savedInstanceState) {
//		super.onActivityCreated(savedInstanceState);
//		if (defalt_ui)
//			((TextView)getView().findViewById(R.id.fragment_text)).setText(getString(text_id));
//	}
}