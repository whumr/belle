package com.belle.ui.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;

import com.belle.R;
import com.belle.common.BaseFragment;
import com.belle.common.widget.ProductListAdapter;
import com.belle.common.widget.SlideShowView;
import com.belle.entity.Product;

public class IndexFragment extends BaseFragment {

	private List<Product> proList;
	
	public IndexFragment() {
		super();
		this.text_id = R.string.tab_index;
		this.defalt_ui = false;
		
		proList = new ArrayList<Product>();
		proList.add(new Product("皇室假期美食水疗会", "东门商业圈", "仅售219元，价值394元按摩套餐，免费WiFi，男女通用，含淋浴！罗湖/皇岗口岸免费接送，无需支付技师费！", 
				"", 219, 20, 1));
		proList.add(new Product("皇室假期美食水疗会", "东门商业圈", "仅售219元，价值394元按摩套餐，免费WiFi，男女通用，含淋浴！罗湖/皇岗口岸免费接送，无需支付技师费！", 
				"", 219, 20, 1));
		proList.add(new Product("皇室假期美食水疗会", "东门商业圈", "仅售219元，价值394元按摩套餐，免费WiFi，男女通用，含淋浴！罗湖/皇岗口岸免费接送，无需支付技师费！", 
				"", 219, 20, 1));
		proList.add(new Product("皇室假期美食水疗会", "东门商业圈", "仅售219元，价值394元按摩套餐，免费WiFi，男女通用，含淋浴！罗湖/皇岗口岸免费接送，无需支付技师费！", 
				"", 219, 20, 1));
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("aaaaaaaa", "IndexFragment onCreate");
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("aaaaaaaa", "IndexFragment onCreateView");
		View view = inflater.inflate(R.layout.index_fragment, container, false);
		ListView list = (ListView)view.findViewById(R.id.product_list);
		list.setAdapter(new ProductListAdapter(view.getContext(), proList));
		ScrollView sv = (ScrollView)view.findViewById(R.id.index_scroll);
		sv.smoothScrollTo(0, 0);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.d("aaaaaaaa", "IndexFragment onActivityCreated");
		super.onActivityCreated(savedInstanceState);
		SlideShowView slideShowView = (SlideShowView)getView().findViewById(R.id.index_slideshow);
		slideShowView.startAutoPlay();
	}
	
}