package com.ai.testlist;

import android.widget.BaseAdapter;

import com.nhaarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.DismissableManager;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeDismissAdapter;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeOnScrollListener;

public class SwipeDismissChildAdapter extends SwipeDismissAdapter{

	public SwipeDismissChildAdapter(BaseAdapter baseAdapter,
			OnDismissCallback onDismissCallback) {
		super(baseAdapter, onDismissCallback);
	}

	public SwipeDismissChildAdapter(BaseAdapter baseAdapter,
			OnDismissCallback onDismissCallback,
			SwipeOnScrollListener swipeOnScrollListener) {
		super(baseAdapter, onDismissCallback, swipeOnScrollListener);
		// TODO Auto-generated constructor stub
	}
    public void SetDismissableManager(DismissableManager dismissableManager){
    	this.mSwipeDismissListViewTouchListener.setDismissableManager(dismissableManager);
    }
}
