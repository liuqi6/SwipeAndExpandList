package com.ai.testlist;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.TextView;

import com.nhaarman.listviewanimations.itemmanipulation.ExpandableListItemAdapter;

public class ShopGoodAdapter extends ExpandableListItemAdapter<ShopGood>{
private List<ShopGood>sgLists;
private LayoutInflater inflater;   
private Context mContext;
public ShopGoodAdapter(Context context,List<ShopGood>shopGoods) {
	 super(context);
	 setActionViewResId(R.id.goodname);
	sgLists=shopGoods;
	mContext=context;
    this.inflater = LayoutInflater.from(context);  
}
	@Override
	public int getCount() {
		return  sgLists.size();
	}

	@Override
	public ShopGood getItem(int position) {
		return sgLists.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
   @Override
	public int getItemViewType(int position) {
	  return sgLists.get(position).getType();
	}
     private class ViewHolder {  
       View shopHeadView;    
       View shopGoodView;
       CheckBox shopCheckBox;
       CheckBox goodCheckBox;
       TextView  ShopNameTextView;
       TextView  goodNameTextView;
       
   }
     private class ViewHolderExpand {  
    	 TextView expandview;   
    	 
     }
	@Override
	public View getTitleView(int position, View convertView, ViewGroup parent) {
		int Type=getItemViewType(position);
		ShopGood sg=getItem(position);
		 ViewHolder holder = null;
		 if(convertView==null){
			 holder=new ViewHolder();
			 convertView = inflater.inflate(R.layout.shop_goods, null);  
			 holder.shopHeadView=(View)convertView.findViewById(R.id.shophead);
			 holder.shopGoodView=(View)convertView.findViewById(R.id.shopgood);
			 holder.shopCheckBox=(CheckBox)convertView.findViewById(R.id.shopcheckbox);
			 holder.ShopNameTextView=(TextView)holder.shopHeadView.findViewById(R.id.shopname);
			 holder.goodCheckBox=(CheckBox)convertView.findViewById(R.id.goodcheckbox);
			 holder.goodNameTextView=(TextView)holder.shopGoodView.findViewById(R.id.goodname);
			 convertView.setTag(holder);    
		 }
		 else{
          holder= (ViewHolder)convertView.getTag();
		 }
		 if(Type==ShopGood.TYPE_SHOPHEAD){
			 holder.shopHeadView.setVisibility(View.VISIBLE); 
			 holder.shopGoodView.setVisibility(View.GONE);
			 holder.ShopNameTextView.setText(sg.getShopName()); 
		 }else{
			 holder.shopGoodView.setVisibility(View.VISIBLE);
			 holder.shopHeadView.setVisibility(View.GONE);
			 holder.goodNameTextView.setText(sg.getGood().getName()); 
		 }
		return convertView;
	}
	@Override
	public View getContentView(int position, View convertView, ViewGroup parent) {
		ShopGood sg=getItem(position);
		int Type=getItemViewType(position);
		ViewHolderExpand holderexpands = null;
		 if(convertView==null){
			 holderexpands=new ViewHolderExpand();
			 convertView = inflater.inflate(R.layout.good_content, null);  
			 holderexpands.expandview=(TextView)convertView.findViewById(R.id.goodcontentext);
			 convertView.setTag(holderexpands);  
		 }else{
			 holderexpands= (ViewHolderExpand)convertView.getTag();
		 }
		 if(Type==ShopGood.TYPE_GOOD){
		  holderexpands.expandview.setText(sg.getGood().getName());
		 }else{
			 holderexpands.expandview.setText(sg.getShopName());
		 }
		return convertView;
	}  
}
