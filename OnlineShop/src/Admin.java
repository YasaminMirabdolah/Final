import java.util.*;

public class Admin  extends Users{
    public Role role=Role.Admin;
    private String email;
    public Admin(Role role , String name , String password, String email){
        super(role, name , password);
        this.email=email;
    }

}
