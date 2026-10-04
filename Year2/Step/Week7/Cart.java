package Step.Week7;

public class Cart {
    private final String cartId;
    private final double[] prices;
    private int count;

    public Cart(String cartId, int capacity) {
        this.cartId = cartId;
        this.prices = new double[capacity];
        this.count = 0;
    }

    public String getCartId() {
        return cartId;
    }

    public void addItem(double price) {
        if (count < prices.length) {
            prices[count++] = price;
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }
}
