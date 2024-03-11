import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InvoiceFrame extends JFrame
{
    JPanel wholePanel;
    JPanel addressPanel, addressPanelOne, addressPanelTwo, itemPanelOne, itemButtonPanel, addressButtonPanel, invoicePanelOne, buttonsTwoPanel, invoicePanel, productPanel;

    JTextField nameTF, streetTF, cityTF, stateTF, zipCodeTF, descriptionTF, quantityTF, priceTF;

    JLabel nameL, streetL, cityL, stateL, zipCodeL, descriptionL, quantityL, priceL;

    JButton addProductButton, clearButton, quitButton, setAddressButton;

    JTextArea invoiceTA;
    JScrollPane scrollPaneVariable;

    Font fontM = new Font(Font.MONOSPACED, Font.PLAIN, 12);

    Address invoiceAddress;
    Invoice newInvoice;

    int invalidA = 1;

    public InvoiceFrame()
    {
        wholePanel = new JPanel();
        createAddressPanel();
        wholePanel.add(addressPanel);
        createProductPanel();
        wholePanel.add(productPanel);
        createInvoicePanel();
        wholePanel.add(invoicePanel);
        add(wholePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(700,700);
    }

    

}