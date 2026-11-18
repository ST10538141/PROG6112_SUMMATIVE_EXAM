package com.mycompany.mattresssalesapp;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductApp extends JFrame {

    private JTextField txtCustomerName;
    private JTextField txtPrice;
    private JComboBox<String> cmbProduct;

    public ProductApp() {
        setTitle("Mattress Sales Application");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        processItem.addActionListener(e -> processSale());
        clearItem.addActionListener(e -> clearForm());

        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        panel.add(txtCustomerName);

        panel.add(new JLabel("Select Product:"));
        cmbProduct = new JComboBox<>(new String[]{
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        });
        panel.add(cmbProduct);

        panel.add(new JLabel("Product Price (R):"));
        txtPrice = new JTextField();
        panel.add(txtPrice);

        JButton processButton = new JButton("Process");
        processButton.addActionListener(e -> processSale());

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> clearForm());

        panel.add(processButton);
        panel.add(clearButton);

        add(panel);
    }

    private void processSale() {
        try {
            String customer = txtCustomerName.getText().trim();
            String product = (String) cmbProduct.getSelectedItem();

            if (customer.isEmpty() || txtPrice.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Please enter customer name and price.");
                return;
            }

            double price = Double.parseDouble(txtPrice.getText());

            if (price < 0) {
                JOptionPane.showMessageDialog(this,
                    "Price cannot be negative.");
                return;
            }

            double vat = price * 0.15;
            double commission = price * 0.05;
            double total = price + vat + commission;

            String report =
                "Customer: " + customer +
                "\nProduct: " + product +
                "\nPrice: R" + String.format("%.2f", price) +
                "\nVAT: R" + String.format("%.2f", vat) +
                "\nCommission: R" + String.format("%.2f", commission) +
                "\nTotal: R" + String.format("%.2f", total);

            JOptionPane.showMessageDialog(this, report);

            try (PrintWriter writer =
                new PrintWriter(new FileWriter("data.txt", true))) {
                writer.println(report);
                writer.println("-------------------------");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Please enter a valid price.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                "Error saving data: " + ex.getMessage());
        }
    }

    private void clearForm() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductApp().setVisible(true);
        });
    }
}