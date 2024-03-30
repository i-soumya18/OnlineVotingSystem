

public class Result extends javax.swing.JFrame {

    // Member variables to store party names and number of votes
    private String[] partyNames = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5", "NOTA"};
    private int[] votes = new int[6];

    // Constructor to initialize the frame components
    public Result() {
        initComponents();
        displayResults();
    }

    // Method to initialize and display frame components
    private void initComponents() {
        // Initialize frame components (labels, buttons, etc.) here
        // This part should contain the layout and design of the result frame
        // Refer to the provided code for the layout and design
    }

    // Method to update the vote counts for each party
    public void updateVotes(int option, int count) {
        if (option >= 1 && option <= 6) {
            votes[option - 1] = count;
            displayResults();
        }
    }

    // Method to display the results on the frame
    private void displayResults() {
        // Update the JLabels with the vote counts for each party
        jLabel12.setText(String.valueOf(votes[0]));
        jLabel13.setText(String.valueOf(votes[1]));
        jLabel14.setText(String.valueOf(votes[2]));
        jLabel15.setText(String.valueOf(votes[3]));
        jLabel16.setText(String.valueOf(votes[4]));
        jLabel17.setText(String.valueOf(votes[5]));

        // Update the maximum votes label with the party name having the maximum votes
        int maxVotes = votes[0];
        int maxIndex = 0;
        for (int i = 1; i < votes.length; i++) {
            if (votes[i] > maxVotes) {
                maxVotes = votes[i];
                maxIndex = i;
            }
        }
        jLabel18.setText(partyNames[maxIndex]);
    }

    // Main method to create and display the Result frame
    public static void main(String args[]) {
        // Set the look and feel of the frame
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Create and display the Result frame
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Result().setVisible(true);
            }
        });
    }

    // Variables declaration
    // These should include JLabels for party names, vote counts, and maximum votes
    // as well as any other components needed for the layout
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration
}
