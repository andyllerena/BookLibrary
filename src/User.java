import java.util.ArrayList;
import java.util.List;

public class User {


    private static List<User> userList = new ArrayList<>();

    public static void addUser(String username, String password) {
        User newUser = new User(username, password);
        userList.add(newUser);
    }

    public static boolean authenticate(String username, String password) {
        for (User user : userList) {
            if (user.getEmail().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }


    String email;
    String password;

    public User(String email, String password){
        this.email = email;
        this.password = password;

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
