object TipCalculator {
    def getTipPercentage(names: List[String]): Int = {
        if (names.size > 5) 20
        else if (names.size > 0) 10
        else 0
    }
}
