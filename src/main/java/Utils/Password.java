package Utils;

import org.mindrot.jbcrypt.BCrypt;
public class Password {




    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean verifyHash(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }


}