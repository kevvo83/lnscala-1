package com.investigate.implicitsvsypes

trait ShoppingCart {
  def addItem[D <: ShopItem](item: D)
  def removeItem[D <: ShopItem](item: D)
  def computeTotalBill: Float
}
