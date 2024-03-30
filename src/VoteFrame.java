import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VoteFrame extends javax.swing.JFrame {

    private final Logger logger = Logger.getLogger(VoteFrame.class.getName());
    private int vote; // Variable to store the selected vote option

    public VoteFrame() {
        initComponents();
    }

    private void initComponents() {

        vote_label = new javax.swing.JLabel();
        vote1_button = new javax.swing.JRadioButton();
        vote2_button = new javax.swing.JRadioButton();
        vote3_button = new javax.swing.JRadioButton();
        vote4_button = new javax.swing.JRadioButton();
        vote5_button = new javax.swing.JRadioButton();
        vote6_button = new javax.swing.JRadioButton();
        submitvote_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        vote_label.setText("Choose from the given Options: ");

        vote1_button.setText("Option 1");
        vote1_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vote1_buttonActionPerformed(evt);
            }
        });

        vote2_button.setText("Option 2");
        vote2_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vote2_buttonActionPerformed(evt);
            }
        });

        vote3_button.setText("Option 3");
        vote3_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vote3_buttonActionPerformed(evt);
            }
        });

        vote4_button.setText("Option 4");
        vote4_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vote4_buttonActionPerformed(evt);
            }
        });

        vote5_button.setText("Option 5");
        vote5_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vote5_buttonActionPerformed(evt);
            }
        });

        vote6_button.setText("None of the above");
        vote6_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vote6_buttonActionPerformed(evt);
            }
        });

        submitvote_button.setText("Submit");
        submitvote_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitvote_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vote6_button)
                    .addComponent(vote5_button)
                    .addComponent(vote4_button)
                    .addComponent(vote3_button)
                    .addComponent(vote2_button)
                    .addComponent(vote1_button)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submitvote_button)
                            .addComponent(vote_label))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(vote_label)
                .addGap(18, 18, 18)
                .addComponent(vote1_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vote2_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vote3_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vote4_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vote5_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vote6_button)
                .addGap(18, 18, 18)
                .addComponent(submitvote_button)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }

    private void vote1_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        // Set the vote variable according to the selected option
        vote = 1;
    }

    private void vote2_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        // Set the vote variable according to the selected option
        vote = 2;
    }

    private void vote3_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        // Set the vote variable according to the selected option
        vote = 3;
    }

    private void vote4_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        // Set the vote variable according to the selected option
        vote = 4;
    }

    private void vote5_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        // Set the vote variable according to the selected option
        vote = 5;
    }

    private void vote6_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        // Set the vote variable according to the selected option
        vote = 6;
    }

    private void submitvote_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (vote == 0) {
            JOptionPane.showMessageDialog(this, "Please select an option before submitting.");
            return;
        }

        try {
            new VoteService().addVote(vote);

            // Display a message to inform the user that their vote has been successfully submitted
            JOptionPane.showMessageDialog(this, "Your vote has been submitted successfully!");

            // Close the current frame and show the exit frame
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ExitFrame().setVisible(true);
                }
            });
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error during vote submission: " + ex.getMessage(), ex);
            JOptionPane.showMessageDialog(this, "An error occurred during vote submission. Please try again later.");
        }
    }

    // Variables declaration
    private javax.swing.JButton submitvote_button;
    private javax.swing.JRadioButton vote1_button;
    private javax.swing.JRadioButton vote2_button;
    private javax.swing.JRadioButton vote3_button;
    private javax.swing.JRadioButton vote4_button;
    private javax.swing.JRadioButton vote5_button;
    private javax.swing.JRadioButton vote6_button;
    private javax.swing.JLabel vote_label;
}
