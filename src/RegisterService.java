
import javax.swing.JOptionPane;

public class RegisterService {

    public boolean addVoter(String fname, String lname, String gender, String pno, String prn, String password) {
        fname = fname.toLowerCase();
        lname = lname.toLowerCase();
        try {
            new DAO().insertVoter(fname, lname, gender, pno, prn, password);
            return true;
        } catch (VoteException ex) {
            return false;
        }
    }

    public boolean validateAdmin(String username, String password) {
        try {
            username = username.toLowerCase();
            int a = new DAO().selectAdmin(username, password);
            return a == 1;
        } catch (VoteException ex) {
            return false;
        }
    }

    public boolean validateVoter(String username, String password) {
        try {
            username = username.toLowerCase();
            new DAO().selectUser(username, password);
            return true;
        } catch (VoteException ex) {
            return false;
        }
    }
}
