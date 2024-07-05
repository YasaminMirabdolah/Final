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
                       //adminService()
                   }else if(x.getRole()==Role.customer){
                       //costumerService()
                   } else if (x.getRole()==Role.Seller) {
                       //sellerService

                   }
               }else {
                   System.out.println("Password is incorrect");
                   menu();
               }
           }
       }if(found==false){
           System.out.println("Account is not found");
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
                System.out.print("Should be complete");
                //adminService();
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
                System.out.println(Shop.getAccounts());
                //customerService();
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
                System.out.println(Shop.getAccounts());
                //sellerService();
                break;
            case 4:
                menu();
            default:
                System.out.println("Invalid Input! \nPlease Try Again:");
                Register();
                break;

        }

    }




    public static void main(String[] args){
       //اولین ادمین
        Role role=Role.Admin;
        String adminname="Admin0";
        String password="Password";
        String email="Email";
        Admin adminno1=new Admin(role , adminname, password , email);
        Shop.addAccont(adminno1);


        System.out.println(Shop.getName()+"\n"+ Shop.getWebURL()+"\n");

        System.out.println(Shop.getAccounts());
        menu();

    }
}