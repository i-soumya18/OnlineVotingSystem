import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.logging.*;

public class Main {

    // Create a logger instance for the Main class
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Load logging configuration
        try {
            LogManager.getLogManager().readConfiguration(
                Main.class.getResourceAsStream("/logging.properties"));
        } catch (Exception e) {
            System.err.println("Error loading logging configuration: " + e.getMessage());
        }

        // Set the look and feel of Swing components to Nimbus
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            logger.log(Level.SEVERE, "Error setting look and feel", ex);
        }

        // Create and display the WelcomeFrame
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    logger.log(Level.INFO, "Starting application...");
                    new WelcomeFrame().setVisible(true);
                } catch (Exception e) {
                    logger.log(Level.SEVERE, "Error starting application", e);
                }
            }
        });
    }
}
