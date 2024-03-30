

public class ResultService {

    public int retVotes(int opt_id) {
        try {
            int novotes = new DAO().getVotes(opt_id);
            return novotes;
        } catch (VoteException ex) {
            // Handle the exception or rethrow if needed
            ex.printStackTrace(); // Example of handling by printing the stack trace
            return -1; // Return a default value or handle the error appropriately
        }
    }

    public String retWinner() {
        try {
            String w_opt = new DAO().getWinner();
            return w_opt;
        } catch (VoteException ex) {
            // Handle the exception or rethrow if needed
            ex.printStackTrace(); // Example of handling by printing the stack trace
            return null; // Return a default value or handle the error appropriately
        }
    }
}
