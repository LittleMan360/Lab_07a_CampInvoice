public class LineItem
{

    private Product product;
    private int quantity;

    // Constructor
    public LineItem(Product product, int quantity)
    {
        // Initialize the product and quantity
        this.product = product;
        this.quantity = quantity;
    }

    // Get the total price of the product
    public double getTotalPrice()
    {
        // Return the product price times the quantity
        return product.getPrice() * quantity;
    }

    // Format the product line for the invoice
    public String productLineFormat()
    {
        // Return the formatted product line
        return String.format("%-30s%8.2f%7d%9.2f", product.getDescription(), product.getPrice(), quantity, getTotalPrice());
    }


}
