package com.investigate.implicitsvsypes

import scala.collection.mutable.ArrayStack

class ShoppingCartInstance extends ShoppingCart {

  private var totalBill: Float = 0.0f
  private var listOfShopItemsInCart: ArrayStack[ShopItem] = ArrayStack()

  def addItem[D <: ShopItem](item: D): Unit = {
    listOfShopItemsInCart += item
  }

  def removeItem[D <: ShopItem](item: D): Unit = {
    listOfShopItemsInCart += item
  }

  def computeTotalBill: Float = {
    listOfShopItemsInCart.foreach(item => totalBill = item.getUnitCost + totalBill)
    totalBill
  }

  def listBillForReference: Unit = {
    listOfShopItemsInCart.foreach(item => println(s"Description: ${item.getDesc}, of ID: ${item.getId.toString}, and of Unit Cost: ${item.getUnitCost.toString}"))
  }
}
