import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingCartDiscounts {
    static class ShoppingCart {
        private List<String> items = new ArrayList<>();
        private boolean bookAdded = false;

        public void addItem(String item) {
            items.add(item);
            if (item.equals("Book")) {
                bookAdded = true;
            }
        }
        
        public int getDiscountPercentage() {
            if (bookAdded) {
                return 5;
            } else {
                return 0;
            }
        }

        public List<String> getItems() {
            return items;
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple");
        assert(cart.getDiscountPercentage() == 0);
        System.out.println(cart.getDiscountPercentage());
        
        cart.addItem("Lemon");
        assert(cart.getDiscountPercentage() == 0);

        cart.addItem("Book");
        assert(cart.getDiscountPercentage() == 5);
        System.out.println(cart.getDiscountPercentage());

    }
}