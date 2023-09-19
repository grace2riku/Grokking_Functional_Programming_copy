import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingCartDiscounts {
    static class ShoppingCartBad { // named ShoppingCart in the book
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

    static class ShoppingCartCopying {  // named ShoppingCart in the book
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
            return new ArrayList<>(items);
        }
    }


    static class ShoppingCartWithRemove {  // named ShoppingCart in the book
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
            return new ArrayList<>(items);
        }

        public void removeItem(String item) {
            items.remove(item);
            if (item.equals("Book")) {
                bookAdded = false;
            }
        }
    }


    static class ShoppingCartRecalculating {  // named ShoppingCart in the book
        private List<String> items = new ArrayList<>();

        public void addItem(String item) {
            items.add(item);
        }
        
        public int getDiscountPercentage() {
            if (items.contains("Book")) {
                return 5;
            } else {
                return 0;
            }
        }

        public List<String> getItems() {
            return new ArrayList<>(items);
        }

        public void removeItem(String item) {
            items.remove(item);
        }
    }

    static class ShoppingCart {
        public static int getDiscountPercentage(List<String> items) {
            if (items.contains("Book")) {
                return 5;
            } else {
                return 0;
            }
        }
    }
    
    public static void main(String[] args) {
        {
            ShoppingCartBad cart = new ShoppingCartBad();
            cart.addItem("Apple");
            assert(cart.getDiscountPercentage() == 0);
            System.out.println(cart.getDiscountPercentage());
            
            cart.addItem("Lemon");
            assert(cart.getDiscountPercentage() == 0);

            cart.addItem("Book");
            assert(cart.getDiscountPercentage() == 5);
            System.out.println(cart.getDiscountPercentage());

            List<String> itemsBad = cart.getItems();
            itemsBad.remove("Book");

            assert(!cart.getItems().contains("Book"));
            assert(cart.getDiscountPercentage() == 5);  // 
        }

        // SOLUTION 1: COPYING ch02 2.4
        {
            ShoppingCartCopying cart = new ShoppingCartCopying();
            cart.addItem("Apple");
            assert(cart.getDiscountPercentage() == 0);

            cart.addItem("Lemon");
            assert(cart.getDiscountPercentage() == 0);

            cart.addItem("Book");
            assert(cart.getDiscountPercentage() == 5);

            List<String> itemsCopying = cart.getItems();
            itemsCopying.remove("Book");

            assert(cart.getItems().contains("Book"));
            assert(cart.getDiscountPercentage() == 5);
        }

        // PROBLEM 2: ch02 2.5
        {
            ShoppingCartWithRemove cart = new ShoppingCartWithRemove();
            cart.addItem("Book");
            cart.addItem("Book");
            assert(cart.getDiscountPercentage() == 5);
            cart.removeItem("Book");

            assert(cart.getItems().contains("Book"));   // a book is in the cart
            assert(cart.getDiscountPercentage() == 0);  // BUT THE DISCOUNT IS 0!!!
        }

        // SOLUTION 2: RECALCULATING ch02 2.6
        {
            ShoppingCartRecalculating cart = new ShoppingCartRecalculating();
            cart.addItem("Book");
            cart.addItem("Book");
            assert(cart.getDiscountPercentage() == 5);
            cart.removeItem("Book");

            assert(cart.getItems().contains("Book"));
            assert(cart.getDiscountPercentage() == 5);
        }

        // SOLUTION 3: JUST A FUNCTION
        List<String> empty = new ArrayList<>();
        assert(ShoppingCart.getDiscountPercentage(empty) == 0);

        List<String> justApple = Arrays.asList("Apple");
        assert(ShoppingCart.getDiscountPercentage(justApple) == 0);

        List<String> appleAndBook = Arrays.asList("Apple", "Book");
        assert(ShoppingCart.getDiscountPercentage(appleAndBook) == 5);

    }
}