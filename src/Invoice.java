import java.util.ArrayList;

public class Invoice
{
    private Address billingAddress;
    private ArrayList<LineItem> items;

    public Invoice(Address address)
    {
        billingAddress = address;
        items = new ArrayList<LineItem>();
    }

    public void addProduct(Product product, int quantity)
    {
        LineItem item = new LineItem(product, quantity);
        items.add(item);
    }

    public String formatInvoice()
    {
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

    private double getAmountDue()
    {
        double amountDue = 0;
        for (LineItem item : items)
        {
            amountDue += item.getTotalPrice();
        }
        return amountDue;
    }
}