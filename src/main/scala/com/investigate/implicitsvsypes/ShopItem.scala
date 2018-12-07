package com.investigate.implicitsvsypes

class ShopItem(id: Int, desc: String, unitCost: Float) {
  def getUnitCost: Float = unitCost

  def getDesc: String = desc
  def getId: Int = id
}

object ShopItem {
  def create(id: Int, description:String, unitPrice: Float): Option[ShopItem] = {
    Some(new ShopItem(id, description, unitPrice))
  }
}

