import java.sql.DriverManager;
import java.util.*;

public class signUp {

    private int userID;
    private String email;
    private int number;
    private String password;

    singUp(int userID, String email, int number, String password) {
        this.userID = userID;
        this.email = email;
        this.number = number;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

public class storeSignUp {
    try
    {
        String url = "jdbc:mysql://localhost:3306/";

        String databaseName = "fitbit";
        String userName = "root";
        String password = "3025";

        Connection conn = DriverManager.getConnection(url, userName, password);

        String query = "INSERT INTO signup(email_id, number, password) VALUES(" + getEmail() + "," + getNumber() + "," + getPassword() + " )";

        
    }
    catch(exception e)
    {
        
    }

}
