package mockito;

public class UserSystem {
    private String username;
    private String password;
    private boolean locked = false;

    public UserSystem(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String password) {
        if (this.locked) {
            return false;
        }
        return this.password.equals(password);
    }

    public boolean is_locked() {
        return this.locked;
    }

    public void reset_password(String newPassword) {
        this.password = newPassword;
        this.locked = false;
    }

    public void lock_user() {
        this.locked = true;
    }

    public void unlock_user() {
        this.locked = false;
    }
}
