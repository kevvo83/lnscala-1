package com.investigate

class ShoppingCartImpl[A] extends ShoppingCart[A] {

  override def additem(itemId: A): Boolean = {
    true
  }

  override def removeItem(itemId: A): Boolean = {
    true
  }

  override def updateItem(itemId: A): Boolean = {
    true
  }

  override def searchItem(itemId: A): Option[A] = {
    Some(itemId)
  }
}
