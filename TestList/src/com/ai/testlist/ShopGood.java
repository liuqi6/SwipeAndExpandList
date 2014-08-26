package com.ai.testlist;

public class ShopGood {
	public static final int TYPE_SHOPHEAD=0;
	public static final int TYPE_GOOD=1;
private Good  good;
private String  shopId;
private String shopName;
private  int Type;
private boolean isCheck;
public Good getGood() {
	return good;
}
public void setGood(Good good) {
	this.good = good;
}
public String getShopId() {
	return shopId;
}
public boolean isCheck() {
	return isCheck;
}
public void setCheck(boolean isCheck) {
	this.isCheck = isCheck;
}
public void setShopId(String shopId) {
	this.shopId = shopId;
}
public String getShopName() {
	return shopName;
}
public void setShopName(String shopName) {
	this.shopName = shopName;
}
public int getType() {
	return Type;
}
public void setType(int type) {
	Type = type;
}

}
