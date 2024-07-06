import java.util.*;
public class Main{
    public static void menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose one option please:" + "\n"
                + "\t 1)Login" + "\n"
                + "\t 2)Register" + "\n"
                + "\t 3)Support" + "\n"
                + "\t 4)Exit");
        int x = input.nextInt();

        switch (x) {
            case 1:
                Login();
                break;
            case 2:
                Register();
                break;
            case 3:
                System.out.println("Call\t "+ Shop.getNumber());
                menu();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Invalid Input! \nPlease Try Again:");
                menu();
                break;
        }



    }




    public static void Login(){
        Scanner input=new Scanner(System.in);
       System.out.println("please Enter your name or your Company's name:");
       String name=input.next();
       ArrayList<Users> users=new ArrayList<>();
       users = Shop.getAccounts();
       boolean found =false;
       for(Users x:users){
           if(name.equals(x.getName())){
               found=true;
               System.out.println("Account is found:\n please Enter your password:");
               String password=input.next();
               if(password.equals(x.getPassword())){
                   System.out.println("Login was successful");
                   if(x.getRole()==Role.Admin){
                       adminService(x);
                   }else if(x.getRole()==Role.customer){
                       customerService(x);
                   } else if (x.getRole()==Role.Seller) {
                       sellerService(x);

                   }
               }else {
                   System.out.println("Password is incorrect");
                   menu();
               }
           }
       }if(found==false){
           System.out.println("Account is not found\n Please Register first!");
           menu();
    }
    }




    public static void Register(){
        Scanner input=new Scanner(System.in);
        System.out.println("What is your role(Register): \n" + "\t 1)Admin\n"
                + "\t 2)Customer\n"+"\t 3)Seller\n"+"\t 4)Main Menu\n");

        int x=input.nextInt();

        switch (x) {
            case 1:
                Role roleadmin=Role.Admin;
                System.out.println("Please Enter your name: ");
                String nameadmin=input.next();
                System.out.println("Please Enter your password: ");
                String passwordadmin=input.next();
                System.out.println("Please Enter your email: ");
                String emailadmin=input.next();
                Admin admin=new Admin(roleadmin , nameadmin, passwordadmin, emailadmin);
                Admin.addRequestforAdminAccount(admin);
                System.out.println("Your request has been sent to admins");
                System.out.println(Admin.getRequestforAdminAccount());
                //adminService(admin);
                break;
            case 2:
               Role role=Role.customer;
                System.out.println("Please Enter your name: ");
                String name=input.next();
                System.out.println("Please Enter your password: ");
                String password=input.next();
                System.out.println("Please Enter your email: ");
                String email=input.next();
                System.out.println("Please Enter your number: ");
                String number=input.next();
                System.out.println("Please Enter your Address: ");
                String Address=input.next();
                customer Costumer=new customer(role , name , password , email, number , Address);
                Shop.addAccont(Costumer);
                System.out.println("Your account registered!");
               customerService(Costumer);
                break;
            case 3:
                Role roleseller=Role.Seller;
                System.out.println("Please Enter your company's name: ");
                String companyName=input.next();
                System.out.println("Please Enter your password: ");
                String passwordseller=input.next();
                Seller Seller=new Seller(roleseller , companyName , passwordseller);
                Shop.addAccont(Seller);
                System.out.println("Your account registered!");
               sellerService(Seller);
                break;
            case 4:
                menu();
            default:
                System.out.println("Invalid Input! \nPlease Try Again:");
                Register();
                break;

        }

    }

    public static void customerService(Users Costumer){
        System.out.println("Choose one option: \n\t"+"1)Edit personal info\n\t"+"2)view products\n\t"+"3)search \n\t"+"4)Shopping List\n\t"+"5)Exit");

    }

    public static void sellerService(Users Seller){

    }

    public static void adminService(Users admin){

    }

    public static void viewCustomerInfo(Users user){
        Scanner input=new Scanner(System.in);
        boolean found=false;
        if(user instanceof Admin){
            System.out.println("please enter the customer's name:");
            String name= input.next();
            for(Users s:Shop.getAccounts()){
                if(name.equals(s.getName())){
                    if(s instanceof customer){
                    ((Admin) user).viewInfo(s);

                    found=true;
                    }else {
                        System.out.println("customer not found!");
                    }
                }
            }if(found==false){
                System.out.println("customer not found!");
            }

        }else{
            System.out.println("You do not have access to this method");
        }

    }






























































    //==================================================================================================================

    public static void main(String[] args){
       //اولین ادمین
        Role role=Role.Admin;
        String adminname="Admin0";
        String password="Password";
        String email="Email";
        Admin adminno1=new Admin(role , adminname, password , email);
        Shop.addAccont(adminno1);
         customer customer=new customer(Role.customer , "name" , "Password", "Email", "number", "Address");
         Shop.addAccont(customer);
        viewCustomerInfo(adminno1);
        System.out.println("***"+Shop.getName()+"***"+"\n"+ Shop.getWebURL()+"\n");

        System.out.println(Shop.getAccounts());
        menu();

    }
}
