package com.belle.entity;

import com.belle.common.BaseEntity;

public class Product extends BaseEntity {

	private static final long serialVersionUID = 6563004014384293994L;

	public Product(String title, String place, String content, String img,
			float price, int sold, int score) {
		super();
		this.title = title;
		this.place = place;
		this.content = content;
		this.img = img;
		this.price = price;
		this.sold = sold;
		this.score = score;
	}
	
	public String title, place, content, img;
	public float price;
	public int sold, score;
}