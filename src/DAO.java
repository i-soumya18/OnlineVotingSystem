import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

    private final String url = "jdbc:mysql://localhost:3306/vote_data";
    private final String username = "root";
    private final String password = "soumya";
    private final Logger logger = Logger.getLogger(DAO.class.getName());

    public void insertVoter(String fname, String lname, String gender, String pno, String prn, String password) throws VoteException {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO voters (fname, lname, gender, pno, prn, password) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, fname);
                stmt.setString(2, lname);
                stmt.setString(3, gender);
                stmt.setString(4, pno);
                stmt.setString(5, prn);
                stmt.setString(6, password);
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            String errorMessage = "Error inserting voter: " + ex.getMessage();
            logger.log(Level.SEVERE, errorMessage, ex);
            throw new VoteException(errorMessage);
        }
    }

    // Implement other methods similarly




    public int selectAdmin(String username, String password) throws VoteException {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT COUNT(*) FROM admin WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
            return 0;
        } catch (SQLException ex) {
            throw new VoteException("Error validating admin: " + ex.getMessage());
        }
    }

    public void selectUser(String username, String password) throws VoteException {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (!rs.next() || rs.getInt(1) == 0) {
                        throw new VoteException("Invalid username or password");
                    }
                }
            }
        } catch (SQLException ex) {
            throw new VoteException("Error validating user: " + ex.getMessage());
        }
    }

    public void insertVote(int vote) throws VoteException {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO votes (vote) VALUES (?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, vote);
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new VoteException("Error inserting vote: " + ex.getMessage());
        }
    }

    public int getVotes(int opt_id) throws VoteException {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT COUNT(*) FROM votes WHERE opt_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, opt_id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
            return 0;
        } catch (SQLException ex) {
            throw new VoteException("Error retrieving votes: " + ex.getMessage());
        }
    }

    public String getWinner() throws VoteException {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT opt_name FROM options WHERE opt_id = (SELECT opt_id FROM votes GROUP BY opt_id ORDER BY COUNT(*) DESC LIMIT 1)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getString("opt_name");
                    }
                }
            }
            return null;
        } catch (SQLException ex) {
            throw new VoteException("Error retrieving winner: " + ex.getMessage());
        }
    }
}
