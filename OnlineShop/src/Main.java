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
        System.out.println("What is your role(Login): \n" + "\t 1)Admin\n"
                + "\t 2)Customer\n"+"\t 3)Seller\n"+"\t 4)Main Menu\n");

        int x=input.nextInt();


            switch (x) {
                case 1:
                    System.out.print("Should be complete");
                    break;
                case 2:
                    System.out.print("Should be complete");
                    break;
                case 3:
                    System.out.print("Should be complete");
                    break;
                case 4:
                    menu();
                default:
                    System.out.println("Invalid Input! \nPlease Try Again:");
                    Login();
                    break;
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
                customer C=new customer(role , name , password , email, number , Address);
                Shop.addAccont(C);
                System.out.println("Your account registred!");


                break;
            case 3:
                System.out.print("Should be complete");
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
        System.out.println(Shop.getName()+"\n"+ Shop.getWebURL()+"\n");
        menu();

    }
}