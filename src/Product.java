public class Product
{
    // instance variables
    private String descriptionStr;
    private double priceDbl;

    // constructor
    public Product(String productDescription, double productPrice)
    {
        // initialize instance variables
        descriptionStr = productDescription;
        priceDbl = productPrice;
    }

    // method that returns the product description
    public String getDescription()
    {
        return descriptionStr;
    }

    // method that returns the product price
    public double getPrice()
    {
        return priceDbl;
    }
}