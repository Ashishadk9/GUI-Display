import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GUI {
    private JTextField nameField;
    private JTextField addressField;
    private JTextField phoneField;
    private JTextArea displayArea;
    public GUI() {
        // Create the frame
        JFrame frame = new JFrame("Simple GUI");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create input fields
        nameField = new JTextField(20);
        addressField = new JTextField(20);
        phoneField = new JTextField(20);

        // Create buttons
        JButton addButton = new JButton("Add");
        JButton displayButton = new JButton("Display");
        JButton clearButton = new JButton("Clear Fields");

        // Create display area
        displayArea = new JTextArea(10, 30);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addData();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayData();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        // Layout the components
        JPanel panel = new JPanel();
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Address:"));
        panel.add(addressField);
        panel.add(new JLabel("Phone:"));
        panel.add(phoneField);
        panel.add(addButton);
        panel.add(displayButton);
        panel.add(clearButton);
        panel.add(new JScrollPane(displayArea));

        frame.add(panel);
        frame.setVisible(true);
    }
private void addData() {
    String name = nameField.getText();
    String address = addressField.getText();
    String phone = phoneField.getText();

    // Validate input
    if (name.isEmpty() || address.isEmpty() || phone.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill all fields.");
        return;
    }

    // Save to file
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true))) {
        writer.write(name + ";" + address + ";" + phone);
        writer.newLine();
        JOptionPane.showMessageDialog(null, "Data added successfully.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    private void displayData() {
        displayArea.setText(""); // Clear previous data
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                displayArea.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
private void clearFields() {
    nameField.setText("");
    addressField.setText("");
    phoneField.setText("");
    displayArea.setText("");
    // Optionally, delete the file
    new File("data.txt").delete();
}
   public static void main(String[] args) {
    new GUI();
  }
}

