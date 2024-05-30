import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegistrationForm extends JFrame implements ActionListener {
    // Components of the Form
    private Container container;
    private JLabel titleLabel;
    private JLabel userLabel;
    private JTextField userTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel phoneLabel;
    private JTextField phoneTextField;
    private JButton registerButton;
    private JLabel resultLabelL1;
    private JLabel resultLabelL2;

    // Constructor to setup the GUI components and event handling
    public UserRegistrationForm() {
        setTitle("APLSEM2 30 May 2024");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container = getContentPane();
        container.setLayout(null);

        // Title label
        titleLabel = new JLabel("Register");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setBounds(15, 10, 200, 45);
        container.add(titleLabel);

        // Username label and text field
        userLabel = new JLabel("Username:");
        userLabel.setBounds(15, 60, 100, 30);
        container.add(userLabel);

        userTextField = new JTextField();
        userTextField.setBounds(85, 60, 285, 30);
        container.add(userTextField);

        // Password label and password field
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(15, 100, 100, 30);
        container.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(85, 100, 285, 30);
        container.add(passwordField);

        // Email label and text field
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(15, 140, 100, 30);
        container.add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setBounds(85, 140, 285, 30);
        container.add(emailTextField);

        // Phone label and text field
        phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(15, 180, 100, 30);
        container.add(phoneLabel);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(85, 180, 285, 30);
        container.add(phoneTextField);

        // Register button
        registerButton = new JButton("Register");
        registerButton.setBounds(15, 220, 355, 30);
        registerButton.addActionListener(this);
        container.add(registerButton);

        // Result label
        resultLabelL1 = new JLabel("");
        resultLabelL1.setBounds(15, 260, 345, 70);
        resultLabelL1.setHorizontalAlignment(SwingConstants.CENTER); // Center the text
        container.add(resultLabelL1);

        resultLabelL2 = new JLabel("");
        resultLabelL2.setBounds(15, 275, 345, 70);
        resultLabelL2.setHorizontalAlignment(SwingConstants.CENTER); // Center the text
        container.add(resultLabelL2);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method to handle register button click event
    @Override
    public void actionPerformed(ActionEvent e) {

        if (userTextField.getText().isEmpty() ||
                new String(passwordField.getPassword()).isEmpty() ||
                emailTextField.getText().isEmpty() ||
                phoneTextField.getText().isEmpty()) {

            resultLabelL1.setText("Not enough information for registration.");
            resultLabelL2.setText("Please complete all fields.");
            resultLabelL1.setForeground(Color.RED); // Set text color to red
            resultLabelL2.setForeground(Color.RED); // Set text color to red

            // Additional red alert for user
            userLabel.setForeground(Color.RED);
            emailLabel.setForeground(Color.RED);
            passwordLabel.setForeground(Color.RED);
            phoneLabel.setForeground(Color.RED);

        } else {
            String username = userTextField.getText();
            String password = new String(passwordField.getPassword());
            String email = emailTextField.getText();
            String phone = phoneTextField.getText();

            // Display entered information
            resultLabelL1
                    .setText("<html>Registered:<br>" + username + "<br>" + email + "<br>" + phone + "</html>");
            resultLabelL2.setText(null);
            resultLabelL1.setForeground(Color.BLACK); // Set text color to green

            userLabel.setForeground(Color.BLACK);
            emailLabel.setForeground(Color.BLACK);
            passwordLabel.setForeground(Color.BLACK);
            phoneLabel.setForeground(Color.BLACK);

        }
    }

    public static void main(String[] args) {
        new UserRegistrationForm();
    }
}
