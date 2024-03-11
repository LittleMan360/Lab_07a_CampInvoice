import java.util.ArrayList;

// This class represents an invoice for a set of purchased products.
public class Invoice
{
    // The address of the customer who will be billed.
    private Address billingAddress;
    private ArrayList<LineItem> items;

    // Constructs an invoice with a given billing address.
    public Invoice(Address address)
    {
        // Initialize instance variables
        billingAddress = address;
        items = new ArrayList<LineItem>();
    }

    // Adds a charge for a product to this invoice.
    public void addProduct(Product product, int quantity)
    {
        // Create a new line item for the product
        LineItem item = new LineItem(product, quantity);
        // Add the line item to the invoice
        items.add(item);
    }

    // Formats the invoice.
    public String formatInvoice()
    {
        // Create a string to store the formatted invoice
        String r = "                       I N V O I C E\n\n" + billingAddress.AddressFormat() + "\n";
        for(int i = 0; i < 58; i++){r = r+"=";}
        r = r + String.format("\n\n%-30s%8s%7s%9s\n", "Description", "Price", "Qty", "Total");
        for(int i = 0; i < 58; i++){r = r+"-";}
        r = r+"\n";
        for(LineItem itemLI : items){r = r + itemLI.productLineFormat() + "\n";}
        for(int i = 0; i < 58; i++){r = r+"=";}
        r = r+"\n";
        r = r + String.format("\nAMOUNT DUE: $%8.2f", getAmountDue());
        return r;
    }

    // Returns the total amount due for this invoice.
    private double getAmountDue()
    {
        // Initialize the amount due to 0
        double amountDue = 0;
        // Add up the total price for each line item
        for (LineItem item : items)
        {
            amountDue += item.getTotalPrice();
        }
        return amountDue;
    }
}