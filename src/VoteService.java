

import java.util.logging.Level;
import java.util.logging.Logger;

public class VoteService {

    public void addVote(int vote) {
        try {
            new DAO().insertVote(vote);
        } catch (VoteException ex) {
            Logger.getLogger(VoteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
