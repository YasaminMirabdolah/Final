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
        Scanner input=new Scanner(System.in);

            System.out.println("Choose one option: \n\t" + "1)Edit personal info\n\t" + "2)view products\n\t" + "3)search product \n\t" + "4)Shopping Cart\n\t"
                    + "5)Order list\n\t"
                    + "6)List of Products Purchased\n\t" + "7)Wallet\n\t"+"8)Main menu");
            int x = input.nextInt();
            switch (x) {
                case 1:

                        System.out.println("Which personal information you want to change:\n\t"+"1)name\n\t"+
                                "2)Password\n\t"+"3)number\n\t4)Email\n\t5)Address\n\t6)Back");
                        int choose=input.nextInt();
                EditInfo(Costumer, choose);
                    break;
                case 2:
                    //Shop.viewProduct();
                    break;
                case 3:
                    // Shop.searchProduct();
                    break;
                case 4:
                    //Shoping cart
                    break;
                case 5:
                    //Order List
                    break;
                case 6:
                    //List of Products Purchased
                    break;
                case 7:
                    Wallet(Costumer);
                case 8:
                    menu();
                    break;

        }

    }









    public static void Wallet(Users user){
        Scanner input=new Scanner(System.in);
        System.out.println("Please choose one option :\n\t"+"1)Check the balance\n\t"+"2)Request for Money\n\t"+"3)Back");
        int x=input.nextInt();
        switch(x){
            case 1:
                if(user instanceof customer){
                    System.out.println(((customer) user).getWalletBalance());
                    customerService(user);
                }else if(user instanceof Seller){
                    System.out.println(((Seller) user).getWalletBalance());
                    sellerService(user);
                }
                break;
            case 2:
                //Request for money
                break;
            case 3:
                if(user instanceof customer){
                    customerService(user);
                }else if(user instanceof Seller){
                    sellerService(user);
                }
                break;


        }


    }













    public static void sellerService(Users Seller){
        Scanner input=new Scanner(System.in);
        System.out.println("Please Choose one option: \n\t"+"1)request for selling products\n\t"+"2)add the products\n\t"+"3)Wallet\n\t"+"4)Main menu");
        int x=input.nextInt();
        switch (x){
            case 1:
                //request for selling
                break;
            case 2:
                //add the product
                break;
            case 3:
                Wallet(Seller);
                break;
            case 4:
                menu();
                break;
        }

    }












    public static void adminService(Users admin){
        Scanner input=new Scanner(System.in);
        System.out.println("Please choose one option:\n\t"+"1)view Accounts\n\t"+"2)view customer's info\n\t"+"3)view products\n\t"
        +"4)view Request for Admin Accounts\n\t"+"5)view Request for Selling products\n\t"+"6)view Request for buying products\n\t"
        +"7)Main menu");
        int x=input.nextInt();
        switch(x){
            case 1:
                System.out.println(Shop.getAccounts());
                break;
            case 2:
                System.out.println("Please Enter the customer's name");
                String user=input.next();
                viewCustomerInfo(admin);
                break;
            case 3:
                //view products
                break;
            case 4:
                //view request for admin
                break;
            case 5:
                //view request for selling
                break;
            case 6:
                //view request for buying products
                break;
            case 7:
                menu();
                break;

        }

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












    public static void EditInfo(Users Costumer,int x){
        Scanner input=new Scanner(System.in);


            switch (x) {
                case 1:
                    System.out.println("Enter your new name :");
                    String newname = input.next();
                    Costumer.setName(newname);
                    System.out.println("Your name is successfully changed");
                    customerService(Costumer);
                    break;
                case 2:
                    System.out.println("Enter your new Password :");
                    String newPassword = input.next();
                    Costumer.setPassword(newPassword);
                    System.out.println("Your password is successfully changed");
                    customerService(Costumer);
                    break;
                case 3:
                    System.out.println("Enter your new number :");
                    String newnumber = input.next();
                    ((customer) Costumer).setNumber(newnumber);
                    System.out.println("your number is successfully changed");
                    customerService(Costumer);
                    break;
                case 4:
                    System.out.println("Enter your new Email :");
                    String newEmail = input.next();
                    ((customer) Costumer).setEmail(newEmail);
                    System.out.println("Your Email is successfully changed");
                    customerService(Costumer);
                    break;
                case 5:
                    System.out.println("Enter your new Address :");
                    String newAddress = input.next();
                    ((customer) Costumer).setAddress(newAddress);
                    System.out.println("Your Address is successfully changed");
                    customerService(Costumer);
                    break;
                case 6:
                    customerService(Costumer);
                    break;



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
        product Pro=new product("ogh",32.8,5,"hfs");
        Shop.addProduct(Pro);

        System.out.println(Shop.getProduct());
        System.out.println(Shop.getAccounts());

        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("***"+Shop.getName()+"***"+"\n"+ Shop.getWebURL()+"\n");


        menu();

    }
}
