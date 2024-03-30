import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistrationFrame extends javax.swing.JFrame {

    private final Logger logger = Logger.getLogger(RegistrationFrame.class.getName());

    public RegistrationFrame() {
        initComponents();
    }

    private void initComponents() {
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        prnLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        genderComboBox = new javax.swing.JComboBox<>();
        phoneTextField = new javax.swing.JTextField();
        prnTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        registerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        firstNameLabel.setText("First Name:");

        lastNameLabel.setText("Last Name:");

        genderLabel.setText("Gender:");

        phoneLabel.setText("Phone Number:");

        prnLabel.setText("PRN:");

        passwordLabel.setText("Password:");

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameLabel)
                            .addComponent(lastNameLabel)
                            .addComponent(genderLabel)
                            .addComponent(phoneLabel)
                            .addComponent(prnLabel)
                            .addComponent(passwordLabel))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(firstNameTextField)
                            .addComponent(lastNameTextField)
                            .addComponent(genderComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(phoneTextField)
                            .addComponent(prnTextField)
                            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLabel)
                    .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prnLabel)
                    .addComponent(prnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(registerButton)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String gender = (String) genderComboBox.getSelectedItem();
        String phone = phoneTextField.getText();
        String prn = prnTextField.getText();
        String password = new String(passwordField.getPassword());

        try {
            boolean isRegistered = new RegisterService().addVoter(firstName, lastName, gender, phone, prn, password);
            if (isRegistered) {
                JOptionPane.showMessageDialog(this, "Registration successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to register. Please try again.");
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error during registration: " + ex.getMessage(), ex);
            JOptionPane.showMessageDialog(this, "An error occurred during registration. Please try again later.");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JLabel prnLabel;
    private javax.swing.JTextField prnTextField;
    private javax.swing.JButton registerButton;
    // End of variables declaration
}
