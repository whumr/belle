package com.belle.common.widget;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.belle.R;
import com.belle.entity.Product;

public class ProductListAdapter extends BaseAdapter {
	
	private static final int DEFAULT_APP_IMAGE_ID = R.drawable.product;
	private static final int DEFAULT_APP_SCORE_IMAGE_ID = R.drawable.score;

	private List<Product> proList;
	private LayoutInflater inflater;
	
	public ProductListAdapter(Context context, List<Product> appList) {
		super();
		this.proList = appList;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return proList.size();
	}

	@Override
	public Object getItem(int position) {
		return proList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, final ViewGroup parent) {
		Log.d("aaaaaaaa", "ProductListAdapter getView");
		ProductItemView  productItemView = null;   
        if (convertView == null) {   
        	productItemView = new ProductItemView();    
            //获取list_item布局文件的视图   
            convertView = inflater.inflate(R.layout.pro_list_item, parent, false);
            productItemView.pro_img = (ImageView)convertView.findViewById(R.id.pro_list_item_img);
            productItemView.score_img = (ImageView)convertView.findViewById(R.id.pro_list_item_scoreImg);
            productItemView.title_text = (TextView)convertView.findViewById(R.id.pro_list_item_title);
            productItemView.content_text = (TextView)convertView.findViewById(R.id.pro_list_item_content);
            productItemView.price_text = (TextView)convertView.findViewById(R.id.pro_list_item_price);
            productItemView.sold_text = (TextView)convertView.findViewById(R.id.pro_list_item_sold);
            //设置控件集到convertView   
            convertView.setTag(productItemView);
        } else {
        	productItemView = (ProductItemView)convertView.getTag();  
        }
        //设值
        final Product product = proList.get(position);
        productItemView.pro_img.setImageDrawable(convertView.getResources().getDrawable(DEFAULT_APP_IMAGE_ID));
        productItemView.score_img.setImageDrawable(convertView.getResources().getDrawable(DEFAULT_APP_SCORE_IMAGE_ID));
        
        productItemView.title_text.setText(product.title);
        productItemView.content_text.setText("[" + product.place + "]" + product.content);
        productItemView.price_text.setText(product.price + "元");
        productItemView.sold_text.setText("已售" + product.sold);
        
        final Context context = convertView.getContext();
        convertView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "order " + product.title, Toast.LENGTH_SHORT).show();
			}
		});
		return convertView;
	}

	protected final class ProductItemView {
		public ImageView pro_img, score_img;
		public TextView title_text, content_text, price_text, sold_text;
	}
}
