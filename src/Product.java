public class Product
{
    private String descriptionStr;
    private double priceDbl;

    public Product(String productDescription, double productPrice)
    {
        descriptionStr = productDescription;
        priceDbl = productPrice;
    }

    public String getDescription()
    {
        return descriptionStr;
    }

    public double getPrice()
    {
        return priceDbl;
    }
}