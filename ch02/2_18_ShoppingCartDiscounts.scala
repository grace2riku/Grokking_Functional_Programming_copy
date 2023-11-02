// objectに関数が含まれる
object ShoppingCart {
    def getDiscountPercenage(items: List[String]): Int = {
        // ScalaなどのFP言語では、ifは式であるため、
        // returnキーワードはない
        // 関数内の最後の式が戻り値として使われる
        if (items.contains("Book")) {
            5
        } else {
            0
        }
    }
}

object ShoppingCartDiscounts extends App {
    assert(ShoppingCart.getDiscountPercenage(List.empty) == 0)

    val justApple = List("Apple")
    assert(ShoppingCart.getDiscountPercenage(justApple) == 0)

    val appleAndBook = List("Apple", "Book")
    assert(ShoppingCart.getDiscountPercenage(appleAndBook) == 5)
}