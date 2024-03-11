public class LineItem
{
    private Product product;
    private int quantity;

    public LineItem(Product product, int quantity)
    {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice()
    {
        return product.getPrice() * quantity;
    }

    public String productLineFormat()
    {
        return String.format("%-30s%8.2f%7d%9.2f", product.getDescription(), product.getPrice(), quantity, getTotalPrice());
    }


}
