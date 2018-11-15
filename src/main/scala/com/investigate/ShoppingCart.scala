package com.investigate

trait ShoppingCart[A] {

  def additem(itemId: A): Boolean
  def removeItem(itemId: A): Boolean
  def updateItem(itemId: A): Boolean
  def searchItem(itemId: A): Option[A]

}
