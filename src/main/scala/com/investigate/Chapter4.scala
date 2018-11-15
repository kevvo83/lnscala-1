package com.investigate

object Chapter4 extends App {

  val shoppingCartInst: ShoppingCartImpl[String] = new ShoppingCartImpl[String]
  shoppingCartInst.additem("Item Number 1")
  shoppingCartInst.updateItem("Item Number 1")
  shoppingCartInst.searchItem("Item Number 1")
  shoppingCartInst.removeItem("Item Number 1")

}
