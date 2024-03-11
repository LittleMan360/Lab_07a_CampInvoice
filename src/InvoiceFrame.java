import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// This class is a JFrame that contains the GUI for the invoice program.
public class InvoiceFrame extends JFrame
{
    // The wholePanel is the main panel that contains all the other panels.
    JPanel wholePanel;
    JPanel addressPanel, addressPanelOne, addressPanelTwo, itemPanelOne, itemButtonPanel, addressButtonPanel, invoicePanelOne, buttonsTwoPanel, invoicePanel, productPanel;

    // These are the text fields for the address panel.
    JTextField nameTF, streetTF, cityTF, stateTF, zipCodeTF, descriptionTF, quantityTF, priceTF;

    // These are the labels for the address panel.
    JLabel nameL, streetL, cityL, stateL, zipCodeL, descriptionL, quantityL, priceL;

    // These are the buttons for the address panel.
    JButton addProductButton, clearButton, quitButton, setAddressButton;

    // This is the text area for the invoice panel.
    JTextArea invoiceTA;
    // This is the scroll pane for the invoice panel.
    JScrollPane scrollPaneVariable;

    // This is the font for the text areas and labels.
    Font fontM = new Font(Font.MONOSPACED, Font.PLAIN, 12);

    // This is the address for the invoice.
    Address invoiceAddress;
    // This is the invoice for the program.
    Invoice newInvoice;

    // This is a flag to check if the address has been set.
    int invalidA = 1;

    // This is the constructor for the InvoiceFrame.
    public InvoiceFrame()
    {
        // Create the wholePanel and add the other panels to it.
        wholePanel = new JPanel();
        createAddressPanel();
        wholePanel.add(addressPanel);
        createProductPanel();
        wholePanel.add(productPanel);
        createInvoicePanel();
        wholePanel.add(invoicePanel);
        add(wholePanel);
        // Set the default close operation, make the frame visible, and set the size.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1000,700);
    }

    // This method creates the address panel.
public void createAddressPanel()
    {
        // Create the address panel and set the layout to a 3x1 grid.
        addressPanel = new JPanel();
        addressPanel.setLayout(new GridLayout(3,1));
        createAddressOne();
        addressPanel.add(addressPanelOne);
        createAddressTwo();
        addressPanel.add(addressPanelTwo);
        createAddressButton();
        addressPanel.add(addressButtonPanel);
    }

    // This method creates the first part of the address panel.
    public void createAddressOne()
    {
        // Create the addressPanelOne and add the name and street labels and text fields to it.
        addressPanelOne = new JPanel();
        nameL = new JLabel("Name: ", JLabel.RIGHT);
        nameTF = new JTextField(33);
        streetL = new JLabel("    Street: ", JLabel.RIGHT);
        streetTF = new JTextField(30);

        // Set the font for the labels and text fields.
        nameL.setFont(fontM);
        streetL.setFont(fontM);
        nameTF.setFont(fontM);
        streetTF.setFont(fontM);
        // Add the labels and text fields to the panel.

        addressPanelOne.add(nameL);
        addressPanelOne.add(nameTF);
        addressPanelOne.add(streetL);
        addressPanelOne.add(streetTF);
    }

    // This method creates the second part of the address panel.
    public void createAddressTwo()
    {
        // Create the addressPanelTwo and add the city, state, and zip code labels and text fields to it.
        addressPanelTwo = new JPanel();
        cityL = new JLabel("City: ", JLabel.RIGHT);
        cityTF = new JTextField(33);
        stateL = new JLabel("    State: ", JLabel.RIGHT);
        stateTF = new JTextField(30);
        zipCodeL = new JLabel("    Zip Code: ", JLabel.RIGHT);
        zipCodeTF = new JTextField(30);

        // Set the font for the labels and text fields.
        cityL.setFont(fontM);
        stateL.setFont(fontM);
        zipCodeL.setFont(fontM);
        cityTF.setFont(fontM);
        stateTF.setFont(fontM);
        zipCodeTF.setFont(fontM);

        // Add the labels and text fields to the panel.
        addressPanelTwo.add(cityL);
        addressPanelTwo.add(cityTF);
        addressPanelTwo.add(stateL);
        addressPanelTwo.add(stateTF);
        addressPanelTwo.add(zipCodeL);
        addressPanelTwo.add(zipCodeTF);
    }

    // This method creates the button for the address panel.
    public void createAddressButton()
    {
        // Create the addressButtonPanel and add the set address button to it.
        addressButtonPanel = new JPanel();
        setAddressButton = new JButton("Set Address");
        setAddressButton.addActionListener((ActionEvent e) -> {
            // Check if the address has been set.
            if(nameTF.getText().equals("") || streetTF.getText().equals("") || cityTF.getText().equals("") || stateTF.getText().equals("") || zipCodeTF.getText().equals(""))
            {
                // If the address has not been set, display a message.
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            }
            else
            {
                // If the address has been set, create a new address and invoice and set the flag to 0.
                invoiceAddress = new Address(nameTF.getText(), streetTF.getText(), cityTF.getText(), stateTF.getText(), zipCodeTF.getText());
                newInvoice = new Invoice(invoiceAddress);
                invalidA = 0;
            }
        });
        // Add the set address button to the panel.
        addressButtonPanel.add(setAddressButton);
    }

    // This method creates the product panel.
    public void createProductPanel()
    {
        // Create the productPanel and set the layout to a 3x1 grid.
        productPanel = new JPanel();
        productPanel.setLayout(new GridLayout(3,1));
        createItemPanelOne();
        productPanel.add(itemPanelOne);
        createItemButtonPanel();
        productPanel.add(itemButtonPanel);
    }

    // This method creates the first part of the item panel.
    public void createItemPanelOne()
    {
        // Create the itemPanelOne and add the description, quantity, and price labels and text fields to it.
        itemPanelOne = new JPanel();
        descriptionL = new JLabel("Description: ", JLabel.RIGHT);
        descriptionTF = new JTextField(30);
        quantityL = new JLabel("Quantity: ", JLabel.RIGHT);
        quantityTF = new JTextField(30);
        priceL = new JLabel("Price: ", JLabel.RIGHT);
        priceTF = new JTextField(30);

        // Set the font for the labels and text fields.
        descriptionL.setFont(fontM);
        quantityL.setFont(fontM);
        priceL.setFont(fontM);
        descriptionTF.setFont(fontM);
        quantityTF.setFont(fontM);
        priceTF.setFont(fontM);

        // Add the labels and text fields to the panel.
        itemPanelOne.add(descriptionL);
        itemPanelOne.add(descriptionTF);
        itemPanelOne.add(quantityL);
        itemPanelOne.add(quantityTF);
        itemPanelOne.add(priceL);
        itemPanelOne.add(priceTF);
    }

    // This method creates the button for the item panel.
    public void createItemButtonPanel()
    {
        // Create the itemButtonPanel and add the add product, clear, and quit buttons to it.
        itemButtonPanel = new JPanel();
        addProductButton = new JButton("Add Product");
        addProductButton.addActionListener((ActionEvent e) -> {
            // Check if the address has been set.
            if(invalidA == 1)
            {
                // If the address has not been set, display a message.
                JOptionPane.showMessageDialog(null, "Please set the address first.");
            }
            // Check if the description, quantity, or price fields are empty.
            else if(descriptionTF.getText().equals("") || quantityTF.getText().equals("") || priceTF.getText().equals(""))
            {
                // If any of the fields are empty, display a message.
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            }
            else
            {
                // If all the fields are filled in, create a new product and add it to the invoice.
                Product newProduct = new Product(descriptionTF.getText(), Double.parseDouble(priceTF.getText()));
                newInvoice.addProduct(newProduct, Integer.parseInt(quantityTF.getText()));
                invoiceTA.setText(newInvoice.formatInvoice());
            }
        });
        // Add the buttons to the panel.
        clearButton = new JButton("Clear");
        clearButton.addActionListener((ActionEvent e) -> {
            descriptionTF.setText("");
            quantityTF.setText("");
            priceTF.setText("");
        });
        // Add the buttons to the panel.
        quitButton = new JButton("Quit");
        quitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        // Add the buttons to the panel.
        itemButtonPanel.add(addProductButton);
        itemButtonPanel.add(clearButton);
        itemButtonPanel.add(quitButton);
    }

    // This method creates the invoice panel.
    public void createInvoicePanel()
    {
        // Create the invoicePanel and set the layout to a 2x1 grid.
        invoicePanel = new JPanel();
        invoicePanel.setLayout(new GridLayout(2,1));
        createInvoicePanelOne();
        invoicePanel.add(invoicePanelOne);
        createButtonsTwoPanel();
        invoicePanel.add(buttonsTwoPanel);
    }

    // This method creates the first part of the invoice panel.
    public void createInvoicePanelOne()
    {
        invoicePanelOne = new JPanel();
        invoiceTA = new JTextArea(20, 60);
        invoiceTA.setFont(fontM);
        scrollPaneVariable = new JScrollPane(invoiceTA);
        invoicePanelOne.add(scrollPaneVariable);
    }

    // This method creates the second part of the invoice panel.
    public void createButtonsTwoPanel()
    {
        // Create the buttonsTwoPanel and add the clear and quit buttons to it.
        buttonsTwoPanel = new JPanel();
        clearButton = new JButton("Clear");
        clearButton.addActionListener((ActionEvent e) -> {
            descriptionTF.setText("");
            quantityTF.setText("");
            priceTF.setText("");
        });
        quitButton = new JButton("Quit");
        quitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        buttonsTwoPanel.add(clearButton);
        buttonsTwoPanel.add(quitButton);
    }
}