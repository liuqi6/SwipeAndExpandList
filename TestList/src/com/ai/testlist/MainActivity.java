package com.ai.testlist;

import java.util.ArrayList;
import java.util.List;

import com.nhaarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.DismissableManager;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeDismissAdapter;
import com.nhaarman.listviewanimations.swinginadapters.prepared.AlphaInAnimationAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.AbsListView;
import android.widget.ListView;

public class MainActivity extends Activity {
List<Shop>ShopList;
List<ShopGood>ShopGoodList;
ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview=(ListView)findViewById(R.id.listview);
		initData();
		ShopGoodList=new ArrayList<ShopGood>();
		for(Shop shop :ShopList){
			ShopGood sg=new ShopGood();
			sg.setShopId(shop.getShopId());
			sg.setShopName(shop.getName());
			sg.setType(ShopGood.TYPE_SHOPHEAD);
			ShopGoodList.add(sg);
			for(Good good:shop.getGoods()){
				ShopGood sgood=new ShopGood();
				sgood.setShopId(shop.getShopId());
				sgood.setShopName(sg.getShopName());
				sgood.setGood(good);
				sgood.setType(ShopGood.TYPE_GOOD);
				ShopGoodList.add(sgood);
			}
		}
		final ShopGoodAdapter sgAdapter=new ShopGoodAdapter(this, ShopGoodList);
        sgAdapter.setLimit(1);
		SwipeDismissChildAdapter swipeAnimationAdapter = new SwipeDismissChildAdapter(sgAdapter,new OnDismissCallback() {
			
			@Override
			public void onDismiss(AbsListView listView, int[] reverseSortedPositions) {

				
			}
			
		}){
			@Override
			public void setAbsListView(AbsListView listView) {
				super.setAbsListView(listView);
				mSwipeDismissListViewTouchListener.setDismissableManager(new DismissableManager() {
					
					@Override
					public boolean isDismissable(long id, int position) {
						if(sgAdapter.getItemViewType(position)==ShopGood.TYPE_SHOPHEAD){
							return false;
						}
						else{
							return true;	
						}
					}
				});
				
			}
		};
		swipeAnimationAdapter.setAbsListView(listview);
		listview.setAdapter(sgAdapter);
	}

	private void initData() {
		ShopList=new ArrayList<Shop>();
    for(int j=0;j<5;j++){
      Shop shop=new Shop();
      shop.setName("µêÆÌ"+j);
      shop.setShopId(j*1000+"");
      List<Good>goodList=new ArrayList<Good>(); 
	for(int i=0;i<5;i++){
		Good good=new Good();
		good.setId(j*1000+i+"");
		good.setName("µêÆÌ"+j+"µÄ"+"ÉÌÆ·"+i);
		good.setPrice(j*1000+i+"");
		good.setShopName("µêÆÌ"+j);
		goodList.add(good);
	}
	 shop.setGoods(goodList);
	 ShopList.add(shop);
} 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
