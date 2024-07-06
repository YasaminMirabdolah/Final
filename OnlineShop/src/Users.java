import java.util.*;

public class Users {

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
    public Role getRole(){
        return role;
    }
    public String getName(){
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return role + " :  " + name;
    }


}
