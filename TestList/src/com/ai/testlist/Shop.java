package com.ai.testlist;

import java.util.List;

public class Shop {
private String name;
private List<Good>goods;
private String owner;
private String shopId;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Good> getGoods() {
	return goods;
}
public void setGoods(List<Good> goods) {
	this.goods = goods;
}
public String getOwner() {
	return owner;
}
public void setOwner(String owner) {
	this.owner = owner;
}
public String getShopId() {
	return shopId;
}
public void setShopId(String shopId) {
	this.shopId = shopId;
}

}
