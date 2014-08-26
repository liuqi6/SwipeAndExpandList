package com.ai.testlist;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;

import com.nhaarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.DismissableManager;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeDismissAdapter;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeOnScrollListener;

public abstract class CardSwipeListAdapter extends BaseAdapter{
private List<Shop>Shops;
private List<CardItempiece> items;
public static final int ITEM_TYPE_HEAD=0;
public static final int ITEM_TYPE_ITEM=1;
public static final int ITEM_INVALID=-1;


	
	public List<CardItempiece> getItems() {
		return items;
	}


	public void setItems(List<CardItempiece> items) {
		this.items = items;
	}



	
	@Override
	public int getCount() {
		return items.size();
	}
	@Override
	public CardItempiece getItem(int position) {
		return items.get(position);
		}
	@Override
	public int getItemViewType(int position) {
		CardItempiece card=(CardItempiece) getItem(position);
	   return card.Type;
	}
@Override
public View getView(int position, View convertView, ViewGroup parent) {
	   int type = getItemViewType(position);
		   switch (type) {
		   case ITEM_TYPE_HEAD:
			   convertView= getHeadView(position,convertView,parent);
			   break;
		   case ITEM_TYPE_ITEM:
			   convertView=getItemView(position,convertView,parent);
			   break;
		   }
	   return convertView;
}
public abstract View getItemView(int position, View convertView, ViewGroup parent);
public abstract View getHeadView(int position, View convertView, ViewGroup parent);

protected class CardItempiece{
	public Object CardHead;
	public Object CardGroup;
	public int Type;
	public Object  CardItem;
}
}
