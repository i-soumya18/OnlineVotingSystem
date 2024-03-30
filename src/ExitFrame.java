

import javax.swing.JOptionPane;

public class ExitFrame extends javax.swing.JFrame {

    public ExitFrame() {
        initComponents();
    }

    private void initComponents() {

        exit_label = new javax.swing.JLabel();
        exit_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        exit_label.setText("Thank you for voting!");

        exit_button.setText("Exit");
        exit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(exit_label))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(exit_button)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(exit_label)
                .addGap(39, 39, 39)
                .addComponent(exit_button)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        pack();
    }

    private void exit_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Thank you for using our voting system!");
        System.exit(0); // Exit the application
    }

    private javax.swing.JButton exit_button;
    private javax.swing.JLabel exit_label;
}
