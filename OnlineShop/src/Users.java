import java.util.*;

public class Users {
    enum Role{
        customer,
        Admin,
        Seller
    }
    private Role role;
    private String name;
    private String password;
    public Users(Role role ,String name, String password){
        setRole(role);
        setName(name);
        setPassword(password);
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setRole(Role role){
        this.role=role;

    }
}
