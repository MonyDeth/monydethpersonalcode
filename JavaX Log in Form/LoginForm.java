import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {
    // Form Components
    private Container container; // container of the form
    private JLabel userLabel; // label for user field
    private JTextField userTextField;
    private JLabel passwordLabel; // label for password field
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel resultLabel; // return result for user authentication

    // Constructor to set up GUI Components and Event Handling
    public LoginForm() {
        setTitle("APLSEM2 30 May 2024");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// when close, program stop

        setLocationRelativeTo(null);

        container = getContentPane();
        container.setLayout(null);

        // username label and text field respectively
        userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 30, 100, 30);
        container.add(userLabel);

        userTextField = new JTextField();
        userTextField.setBounds(150, 30, 150, 30);
        container.add(userTextField);

        // password text field
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 70, 100, 30);
        container.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        container.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 110, 100, 30);
        loginButton.addActionListener(this);
        container.add(loginButton);

        resultLabel = new JLabel("");
        resultLabel.setBounds(50, 150, 300, 30);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the text
        container.add(resultLabel);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userText = userTextField.getText();
        String passwordText = new String(passwordField.getPassword());

        // validation check
        if (userText.equals("admin") && passwordText.equals("123")) {
            resultLabel.setText("Logged in Succesfully!");
            resultLabel.setForeground(Color.GREEN);
        } else {
            resultLabel.setText("Incorrect Username or Password. Try Again");
            resultLabel.setForeground(Color.RED);
        }

    }

    public static void main(String[] args) {
        new LoginForm();
    }

}
