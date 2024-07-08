import java.util.*;
public class Main{



    public static void menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose one option please:" + "\n"
                + "\t 1)Login" + "\n"
                + "\t 2)Register" + "\n"
                + "\t 3)Support" + "\n"
                + "\t 4)Orders list of Shop"+"\n"+"\t 5)Exit");
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
               System.out.println( Shop.getOrders());
               menu();
               break;
            case 5:
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
                       System.out.println("Your request to become an admin was accepted.");
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
                menu();


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
                    Shop.viewProduct(Costumer);
                    break;
                case 3:
                    Shop.searchProduct(Costumer);
                    break;
                case 4:
                    ((customer)Costumer).viewCart(Costumer);
                    break;
                case 5:
                    System.out.println("Request is sent to Admin for buying the orders");
                    System.out.println("Choose one option : 1)view order 2)Back");
                    int option=input.nextInt();
                    if(option==1){
                        ((customer)Costumer).vieworder(Costumer);
                    }
                    if(option==2){
                        customerService(Costumer);
                    }
                    break;
                case 6:
                    ((customer) Costumer).viewBought(Costumer);
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
                    System.out.println(((customer) user).getWallet());
                    customerService(user);
                }else if(user instanceof Seller){
                    System.out.println(((Seller) user).getWallet());
                    sellerService(user);
                }
                break;
            case 2:
                System.out.println("Enter the amount of money you want to add to your wallet : ");
                double requestmoney=input.nextDouble();
                user.setRequestmoney(requestmoney);
                Admin.addRequestformoney(user);
                System.out.println("your request is sended");
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
                Admin.addRequestforsellingProduct((Seller) Seller);
                sellerService(Seller);
                break;
            case 2:
                boolean found=false;
                for(Seller s:Shop.getSellersCanSell()){
                    if(Shop.getSellersCanSell().contains(s)){
                        found=true;
                        sellersaddproduct(Seller);
                    }
                }if(found==false){
                    System.out.println("You can not sell anything");
            }
                break;
            case 3:
                Wallet(Seller);
                break;
            case 4:
                menu();
                break;
        }

    }

    public static void sellersaddproduct(Users seller){
        Scanner input=new Scanner(System.in);
        System.out.println("You can sell product");
        System.out.println("Choose your product's Category\n\t1)Electronics\n\t2)Books\n\t3)Clothing\n\t4)Cosmetics\n\t5)Home and kitchen\n\t6)none of the above\n\t" +
                "7)Back");
        int x=input.nextInt();
        switch (x){
            case 1:
                System.out.println("Enter your product's name: ");
                String name1=input.next();
                System.out.println("Enter your price's name: ");
                double price1= input.nextDouble();
                System.out.println("Enter your Inventory quantity's name: ");
                int iq1= input.nextInt();
                System.out.println("Enter your product's Screen size: ");
                double ss1= input.nextDouble();
                System.out.println("Enter your ExtraDatas: ");
                String ed1=input.next();
                Electronics e1=new Electronics(name1,price1,iq1,((Seller) seller),ed1,ss1);
                break;
            case 2:
                System.out.println("Enter your product's name: ");
                String name2=input.next();
                System.out.println("Enter your price's name: ");
                double price2= input.nextDouble();
                System.out.println("Enter your Inventory quantity's name: ");
                int iq2= input.nextInt();
                System.out.println("Enter your writer's name: ");
                String writer2= input.next();
                System.out.println("Enter your publisher's name");
                String publiser2=input.next();
                System.out.println("Enter your ExtraDatas: ");
                String ed2=input.next();

                Books e2=new Books(name2,price2,iq2,((Seller) seller),writer2,publiser2,ed2);
                break;
            case 3:
                System.out.println("Enter your product's name: ");
                String name3=input.next();
                System.out.println("Enter your price's name: ");
                double price3= input.nextDouble();
                System.out.println("Enter your Inventory quantity's name: ");
                int iq3= input.nextInt();
                System.out.println("Enter your product's color: ");
                String color3= input.next();
                System.out.println("Enter your ExtraDatas: ");
                String ed3=input.next();
                Clothing cloth=new Clothing(name3,price3,iq3,(Seller) seller,color3,ed3);
                break;
            case 4:
                System.out.println("Enter your product's name: ");
                String name4=input.next();
                System.out.println("Enter your price's name: ");
                double price4= input.nextDouble();
                System.out.println("Enter your Inventory quantity's name: ");
                int iq4= input.nextInt();
                System.out.println("Enter your product's application: ");
                String App4= input.next();
                System.out.println("Enter your ExtraDatas: ");
                String ed4=input.next();
                Cosmetics cs=new Cosmetics(name4,price4,iq4,(Seller) seller,App4,ed4);
                break;
            case 5:
                System.out.println("Enter your product's name: ");
                String name5=input.next();
                System.out.println("Enter your price's name: ");
                double price5= input.nextDouble();
                System.out.println("Enter your Inventory quantity's name: ");
                int iq5= input.nextInt();
                System.out.println("Enter your product's applicaiton: ");
                String App5= input.next();
                System.out.println("Enter your ExtraDatas:  ");
                String ed5=input.next();
                HomeandKitchen hak=new HomeandKitchen(name5,price5,iq5,(Seller) seller,App5,ed5);
                break;
            case 6:
                System.out.println("Enter your product's name: ");
                String name6=input.next();
                System.out.println("Enter your price's name: ");
                double price6= input.nextDouble();
                System.out.println("Enter your Inventory quantity's name: ");
                int iq6= input.nextInt();
                product pr=new product(name6,price6,iq6,((Seller) seller));
                break;
            case 7:
                sellerService(seller);
                break;
        }
    }












    public static void adminService(Users admin){
        Scanner input=new Scanner(System.in);
        System.out.println("Please choose one option:\n\t"+"1)view Accounts\n\t"+"2)view customer's info\n\t"+"3)view products\n\t"
        +"4)view Request for Admin Accounts\n\t"+"5)view Request for Selling products\n\t"+"6)view Request for buying products\n\t"
        +"7)Main menu\n\t8)view request for money");
        int x=input.nextInt();
        switch(x){
            case 1:
                System.out.println(Shop.getAccounts());
                break;
            case 2:

                viewCustomerInfo(admin);
                break;
            case 3:
                Shop.viewProduct();
                break;
            case 4:
                Admin.viewRequestforAdminAccount(admin);
                break;
            case 5:
                Admin.viewrequestforsellingProduct(admin);
                break;
            case 6:
                Admin.viewrequestforbuyingProduct(admin);
                break;
            case 7:
                menu();
                break;
            case 8:
                Admin.viewRequestmoney(admin);

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
        

        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("***"+Shop.getName()+"***"+"\n"+ Shop.getWebURL()+"\n\n\n\n\n\n");
        System.out.print("Please do not use space , use \" - \" instead");



        menu();

    }
}
