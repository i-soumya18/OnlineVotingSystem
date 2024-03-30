

import javax.swing.JOptionPane;

public class AdminFrame extends javax.swing.JFrame {

    public AdminFrame() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        viewResultsButton = new javax.swing.JButton();
        manageVotersButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Admin Dashboard");

        viewResultsButton.setText("View Results");
        viewResultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResultsButtonActionPerformed(evt);
            }
        });

        manageVotersButton.setText("Manage Voters");
        manageVotersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageVotersButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(viewResultsButton)
                    .addComponent(manageVotersButton))
                .addContainerGap(141, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addGap(163, 163, 163))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(viewResultsButton)
                .addGap(18, 18, 18)
                .addComponent(manageVotersButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addGap(46, 46, 46))
        );

        pack();
    }

    private void viewResultsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Implement logic to view results (e.g., open Result Frame)
        new Result().setVisible(true);
    }

    private void manageVotersButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Implement logic to manage voters (e.g., open ManageVoters Frame)
        new ManageVoters().setVisible(true);
    }

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Implement logout functionality (e.g., return to Welcome Frame)
        new WelcomeFrame().setVisible(true);
        this.dispose(); // Close the current Admin Frame
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton viewResultsButton;
    private javax.swing.JButton manageVotersButton;
}
