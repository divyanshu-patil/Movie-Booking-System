import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import javax.swing.*;
import pkg.*;

class Display {
    static Scanner in = new Scanner(System.in);

    static void onAdminLogin(LinkedList<Movies> m, LinkedList<User> list) throws InterruptedException {

        int choice = 0;
        Movies movies = new Movies();
        Admin ad = new Admin();

        do {
            Booking.ClearConsole();
            boolean checkint = false;
            while (!checkint) {

                System.out.println();
                System.out.println();
                System.out.println();
                System.out
                        .println("                                                  " + "============================");
                System.out.println("                                                    " + "- 1. Add Movie");
                System.out.println("                                                    " + "- 2. Remove Movie");
                System.out.println("                                                    " + "- 3. See all Movie");
                System.out.println("                                                    " + "- 4. View Admin Profile");
                System.out.println("                                                    " + "- 5. Edit Profile");
                System.out.println("                                                    " + "- 6. View All Users");
                System.out.println("                                                    " + "- 0. Exit");
                System.out
                        .println("                                                  " + "============================");
                System.out.print("                                          " + "- Enter Your choice  -> ");

                try {
                    choice = in.nextInt();
                    in.nextLine();
                    checkint = true;

                    switch (choice) {
                        case 1:
                            movies.Add_Movies_List(m);
                            break;
                        case 2:
                            Movies.remove_movie(m);
                            break;
                        case 3:
                            Movies.Show_all_Movies(m);
                            System.out.println("Press any Key to Continue");
                            in.nextLine().trim();
                            break;

                        case 4:
                            ad.Admin_Details();
                            break;
                        case 5:
                            Admin.changeAdminDetails();

                            break;
                        case 6:
                            Admin.viewAllUsers(list);
                            break;
                        case 0:

                            break;
                        default:
                            System.out.println("enter correct number");
                            in.nextLine();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\t\t\t\t\t\tEnter a Number !");
                    in.nextLine().trim();
                    in.nextLine();
                    Booking.ClearConsole();
                }
            }
        } while (choice != 0);
    }

    static void onUserLogin(LinkedList<User> list, LinkedList<Movies> m, LinkedList<Ticket> l, User obj)
            throws InterruptedException {
        int choice = 0;
        do {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("                                                  " + "============================");
            System.out.println("                                                    " + "- 1. Book Ticket");
            System.out.println("                                                    " + "- 2. Cancle Ticket");
            System.out.println("                                                    " + "- 3. See Ticket History");
            System.out.println("                                                    " + "- 4. View My Profile");
            System.out.println("                                                    " + "- 5. Edit My Profile");
            System.out.println("                                                    " + "- 0. Exit");
            System.out.println("                                                  " + "============================");
            System.out.print("                                          " + "- Enter Your choice  -> ");
            boolean checkint = false;
            while (!checkint) {
                try {
                    choice = in.nextInt();
                    in.nextLine();
                    checkint = true;

                    switch (choice) {
                        case 1:
                            Booking.ADD(m, l);
                            break;
                        case 2:
                            Booking.remove(list, m, l);
                            Booking.ClearConsole();
                            break;
                        case 3:
                            Booking.ShowAllTicket(list, m, l);
                            Booking.ClearConsole();
                            break;
                        case 4:
                            obj.myDetails();
                            in.nextLine().trim();
                            Booking.ClearConsole();
                            break;
                        case 5:
                            obj.changeUserDetails();
                            Booking.ClearConsole();
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("enter correct number");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\t\t\t\t\t\tEnter a Number !");
                    in.nextLine().trim();
                    in.nextLine();
                    break;
                }
            }
        } while (choice != 0);

    }

    static void loginPanel(LinkedList<User> list, LinkedList<Movies> m) throws InterruptedException {
        Booking.ClearConsole();
        User user = new User();
        int choice = 0;
        do {
            Thread.sleep(200);
            System.out.println();
            System.out.println();
            System.out.println("\t\t\t\t\t==================================== ");
            System.out.println("\t\t\t\t\t\t1. Login ");
            System.out.println("\t\t\t\t\t\t2. New to INOX ? Signup !");
            System.out.println("\t\t\t\t\t\t3. Settings");
            System.out.println("\t\t\t\t\t\t0. exit");
            System.out.println("\t\t\t\t\t==================================== ");
            System.out.println();
            System.out.print("\t\t\t\t\tEnter input Here = ");
            boolean checkint = false;
            while (!checkint) {
                try {
                    choice = in.nextInt();
                    in.nextLine();
                    checkint = true;
                } catch (InputMismatchException e) {
                    System.out.print("\t\t\t\t\tEnter a Number !");
                    in.nextLine().trim();
                    in.nextLine();
                    Booking.ClearConsole();
                    Display.loginPanel(list, m);

                }
            }
            switch (choice) {
                case 0:
                    break;

                case 1:
                    user.userLogin(list, m);
                    break;

                case 2:
                    user.addUser(list);
                    break;

                case 3:
                    Booking.ClearConsole();
                    App2.Settings();
                    break;

                default:
                    System.out.println("enter correct number !");

            }
            Booking.ClearConsole();

        } while (choice != 0);
    }
}// display Class Ended

class Admin {
    static Scanner in = new Scanner(System.in);
    static Console con = System.console();
    static private String Admin_name = "ADMIN";
    static private String Admin_Password = "111";
    static private String Admin_Contact_no = "+91 1234567890";

    static boolean checkAdminLogin(String username, String password) {
        if (username.equals(Admin_name) && password.equals(Admin_Password)) {
            return true;
        } else
            return false;

    }

    static boolean checkAdminLoginUsername(String username) {
        if (username.equals(Admin_name)) {
            return true;
        } else
            return false;

    }

    static void viewAllUsers(LinkedList<User> list) {
        Booking.ClearConsole();
        int counter = 1;
        if (list.size() != 0) {
            for (User u : list) {

                System.out.println("\t\t\t\t\t" + counter + "  " + "========================================");
                System.out.println("\t\t\t\t\t\tUsername     : " + u.Username);
                System.out.println("\t\t\t\t\t\tName         : " + u.First_Name + " " + u.Last_Name);
                System.out.println("\t\t\t\t\t\tMobile Number: " + u.Mobile_No);
                System.out.println("\t\t\t\t\t\tEmail        : " + u.EmailAddress);
                counter++;
            }
        } else {
            System.out.println("\t\t\t\t\t\tNo User Found !");

        }
        System.out.println("\t\t\t\t\t===========================================");
        System.out.print("\t\t\t\t\t\tEnter to Continue: ");

        in.nextLine();

    }

    static void changeAdminDetails() {
        Booking.ClearConsole();
        int choice = 0;
        System.out.println("\t\t\t\t\t===========================================");

        System.out.println("\t\t\t\t\t\t1. Change Password");
        System.out.println("\t\t\t\t\t\t2. Change contact number");
        System.out.println("\t\t\t\t\t\t0. Exit");

        System.out.println("\t\t\t\t\t===========================================\n");
        System.out.print("\n\n\t\t\t\t\t\tChoose an option: ");
        boolean checkint = false;
        while (!checkint) {
            try {
                choice = in.nextInt();
                in.nextLine();
                checkint = true;

                switch (choice) {
                    case 1:
                        System.out.print("\t\t\t\t\t\tEnter new Password: ");
                        char[] temp = con.readPassword();
                        String temp2String = new String(temp);
                        String tempPasssword = temp2String.trim();
                        System.out.print("\t\t\t\t\t\tConfirm new Password: ");
                        temp = con.readPassword();
                        temp2String = new String(temp);
                        String tempPassword2 = temp2String.trim();
                        if (tempPasssword.equals(tempPassword2)) {
                            Admin_Password = tempPassword2;

                        } else {
                            System.out.print("\t\t\t\t\t\tEnter correct Password !");
                            in.nextLine().trim();
                            changeAdminDetails();
                            return;
                        }
                        break;
                    case 2:
                        System.out.print("\t\t\t\t\t\tEnter new Mobile number: ");
                        System.out.print("\t\t\t\t\t\t 91+ ");
                        Admin_Contact_no = "+91 " + in.next().trim();
                        break;
                    case 0:
                        break;

                    default:
                        System.out.println("\t\t\t\t\t\tEnter Valid Details !");
                        in.nextLine().trim();
                        changeAdminDetails();
                }
                System.out.println("\t\t\t\t\t\tChanges Saved Successfully !");

            } catch (InputMismatchException e) {
                System.out.println("\t\t\t\t\t\tEnter a Number !");
                in.nextLine().trim();
                in.nextLine();

            }
            in.nextLine();
        }
    }

    void Admin_Details() {
        Booking.ClearConsole();
        System.out.println("\t\t\t\t\t============================================");

        System.out.println("\t\t\t\t\t\tUsername       : " + Admin_name);

        System.out.print("\t\t\t\t\t\tPasssword      : ");
        for (int i = 0; i < Admin_Password.length(); i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println("\t\t\t\t\t\tMobile Number  : " + Admin_Contact_no);

        System.out.println("\t\t\t\t\t============================================");
        in.nextLine().trim();
    }

    // boolean Admin_Login(LinkedList<Movies> m,LinkedList<User> list) throws
    // InterruptedException {

    // // Admin obj=null ;
    // // int ch;
    // System.out.println("\t\t\t\t\t================================");
    // System.out.println("\t\t\t\t\t\tEnter Username : ");
    // String Test_name = in.next().trim();
    // if (Test_name.equals(Admin_name)) {
    // System.out.print("\t\t\t\t\t\tEnter Password : ");
    // String Test_pass = in.next().trim();

    // if (Test_pass.equals(Admin_Password)) {
    // System.out.println();
    // System.out.println();
    // Booking.ClearConsole();
    // System.out.println();
    // System.out.println();
    // System.out.println();
    // System.out.println("\t\t\t\t\t\t------ welcome " + Admin_name + " ------");
    // Display.onAdminLogin(m,list);
    // return true;
    // } else {
    // System.out.println("\t\t\t\t\t\tinvalid details !");
    // return false;
    // }
    // } else {
    // System.out.println("\t\t\t\t\t\tAdmin not Found!");
    // System.out.println("\t\t\t\t\t\tEnter to Continue");
    // in.nextLine().trim();
    // in.nextLine();
    // return false;

    // }

    // }
}

class User implements Serializable {
    static Scanner in = new Scanner(System.in);
    LinkedList<Ticket> l = new LinkedList<Ticket>();
    static Console con = System.console();
    // fields
    String First_Name;
    String Last_Name;
    String Mobile_No;
    String Username = null;
    String Password = null;
    String EmailAddress = null;
    String check_Password;
    String testusername;
    static String Demi;

    boolean getEmail() {

        System.out.print("\t\t\t\t\t\tEnter Email address: ");

        String s1 = in.next().trim();
        boolean flag = true;
        int count1 = 0;
        int count2 = 0;
        boolean space = false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '@')
                count1++;

            if (s1.charAt(i) == '.')
                count2++;

            if (s1.charAt(i) == ' ')
                space = true;
        }

        if (count1 != 1 || count2 != 1 || space == true)
            flag = false;

        if (flag) {
            EmailAddress = s1;
            return true;
        }

        else if (count1 == 0 || count2 == 0)
            System.out.println("\t\t\t\t\t\tenter correct email address !");
        else if (count1 != 1)
            System.out.println("\t\t\t\t\t\tusername cannot contain '@' !");
        else if (count2 != 1)
            System.out.println("\t\t\t\t\t\tusername cannot contain period '.' !");
        else if (space == true)
            System.out.println("\t\t\t\t\t\temail cannot contain spaces  !");
        else
            System.out.println("\t\t\t\t\t\tenter correct email address !");

        return false;
    }

    void addUser(LinkedList<User> list) throws InterruptedException {
        User user = new User();
        user.signIn(list);
        list.add(user);
        // Thread.sleep(500);
        System.out.println("\t\t\t\t\t\tuser successfully added !");
        System.out.print("\t\t\t\t\t\tEnter to Continue = ");
        in.nextLine().trim();
        in.nextLine().trim();

    }

    void changeUserDetails() {
        Booking.ClearConsole();
        int choice = 0;
        System.out.println("\t\t\t\t\t================================");
        System.out.println("\t\t\t\t\t\t1. Change Name");
        System.out.println("\t\t\t\t\t\t2. Change Password");
        System.out.println("\t\t\t\t\t\t3. Change contact number");
        System.out.println("\t\t\t\t\t================================");
        System.out.println("\n\t\t\t\t\t\tChoose an option: ");
        boolean checkint = false;
        while (!checkint) {
            try {
                choice = in.nextInt();
                in.nextLine();
                checkint = true;

                switch (choice) {
                    case 1:
                        System.out.print("\t\t\t\t\t\tEnter First Name :");
                        First_Name = in.next().trim();
                        System.out.print("\t\t\t\t\t\tEnter Last Name :");
                        Last_Name = in.next().trim();
                        break;

                    case 2:
                        System.out.print("\t\t\t\t\t\tEnter old Password !");
                        char[] temp = con.readPassword();
                        String temp2String = new String(temp);
                        String testPassword = temp2String.trim();
                        if (testPassword.equals(Password)) {

                            System.out.print("\t\t\t\t\t\tEnter new Password: ");
                            temp = con.readPassword();
                            temp2String = new String(temp);
                            String tempPasssword = temp2String.trim();
                            System.out.print("\t\t\t\t\t\tConfirm new Password: ");
                            temp = con.readPassword();
                            temp2String = new String(temp);
                            String tempPassword2 = temp2String.trim();
                            if (tempPasssword.equals(tempPassword2)) {
                                Password = tempPassword2;
                            } else {
                                System.out.print("\t\t\t\t\t\tEnter correct Password !");
                                in.nextLine().trim();
                                changeUserDetails();
                                return;
                            }
                        } else {
                            System.err.print("\t\t\t\t\t\tPassword didn't matched");
                            in.nextLine().trim();
                            return;

                        }
                        break;
                    case 3:
                        System.out.print("\t\t\t\t\t\tEnter new Mobile number: ");
                        System.out.print("\t\t\t\t\t\t91+ ");
                        Mobile_No = "+91 " + in.next().trim();
                        break;

                    default:
                        System.out.print("\t\t\t\t\t\tEnter Valid option !");
                        in.nextLine().trim();
                        changeUserDetails();
                }
                System.out.print("\t\t\t\t\t\tChanges Saved Successfully !");
                in.nextLine().trim();
                in.nextLine();
            } catch (InputMismatchException e) {
                System.out.print("\t\t\t\t\t\tEnter a Number !");
                in.nextLine().trim();
                in.nextLine();
            }
        }
    }

    void signIn(LinkedList<User> list) {
        boolean flag = false;
        String testUsername = null;
        do {
            Booking.ClearConsole();
            System.out.println();
            System.out.println();
            System.out.println("\t\t\t\t------Fill Following Information to Create New Account------");
            System.out.println();
            System.out.println();

            System.out.print("\t\t\t\t\t\tEnter User Name: ");
            testUsername = in.next().trim();
            flag = false;

            for (User test : list) {
                if (test.Username.equals(testUsername)) {
                    System.out.println(
                            "\t\t\t\t\tUser With Username " + testUsername
                                    + " Already Exists\n\t\t\t\t\tChoose Another Username !");
                    in.nextLine().trim();
                    in.nextLine();
                    flag = true;
                    break;

                }
            }
            if (!flag) {
                Username = testUsername;
                flag = false;
                break;
            }

        } while (flag);
        do {

            System.out.print("\t\t\t\t\t\tEnter Password: ");
            char[] temp = con.readPassword();
            String temp2String = new String(temp);
            Password = temp2String.trim();

            System.out.print("\t\t\t\t\t\tConfirm Password: ");
            temp = con.readPassword();
            temp2String = new String(temp);
            check_Password = temp2String.trim();

            if (Password.equals(check_Password) == false) {
                System.out.println("\t\t\t\t\t\tEnter correct password: ");

            }
        } while (Password.equals(check_Password) == false);

        System.out.print("\t\t\t\t\t\tEnter Firstname: ");
        First_Name = in.next().trim();
        First_Name = First_Name.trim();
        System.out.print("\t\t\t\t\t\tEnter LastName: ");
        Last_Name = in.next().trim();
        Last_Name = Last_Name.trim();

        System.out.print("\t\t\t\t\t\tEnter mobile no: ");
        Mobile_No = in.next().trim();

        boolean check_Email = false;
        while (!check_Email) {
            check_Email = getEmail();
        }

    }

    void myDetails() {
        Booking.ClearConsole();
        System.out.println("\t\t\t\t\t========================================");

        System.out.println("\t\t\t\t\t\tUsername       : " + Username);

        System.out.print("\t\t\t\t\t\tPasssword      : ");
        for (int i = 0; i < Password.length(); i++) {
            System.out.print("*");
        }
        System.out.println();

        System.out.println("\t\t\t\t\t\tName           : " + First_Name + " " + Last_Name);
        System.out.println("\t\t\t\t\t\tMobile Number  : " + Mobile_No);
        System.out.println("\t\t\t\t\t\tEmail Address  : " + EmailAddress);

        System.out.println("\t\t\t\t\t========================================");

    }

    boolean userLogin(LinkedList<User> list, LinkedList<Movies> m) throws InterruptedException {
        Booking.ClearConsole();
        System.out.println();
        System.out.println();
        System.out.println("\t\t\t\t\t\t----Login Section-----");
        System.out.println();
        System.out.println();
        boolean flag = false;// use to hold value true if Given user name matches with the list username
        User obj = null;

        System.out.print("\t\t\t\t\t\tEnter Username : ");
        testusername = in.next().trim();
        String testpassword;
        // int choice;
        if (Admin.checkAdminLoginUsername(testusername)) {
            System.out.print("\t\t\t\t\t\tEnter Password : ");
            char[] temp = con.readPassword();
            String temp2String = new String(temp);
            testpassword = temp2String.trim();
            if (Admin.checkAdminLogin(testusername, testpassword)) {
                Booking.ClearConsole();
                Display.onAdminLogin(m, list);
                return true;
            } else {
                System.out.println("\t\t\t\t\t\tWrong Password For ADMIN Login");
                in.nextLine().trim();
                in.nextLine();
            }
            return false;
        } else {
            for (User u : list) {// using User LinkedList
                flag = u.Username != null && u.Username.equals(testusername.trim());
                if (flag) {
                    obj = u;// Storing The user in Obj
                    break;
                }
            }
            if (flag) {
                System.out.print("\t\t\t\t\t\tEnter Password : ");
                char[] temp = con.readPassword();
                String temp2String = new String(temp);
                testpassword = temp2String.trim();
                if (testusername.equals(obj.Username) && testpassword.equals(obj.Password)) {// Checking Password
                    Demi = testusername;
                    Booking.ClearConsole();
                    System.out.println();
                    System.out.println();
                    System.out
                            .println("\t\t\t\t\t\t------  welcome " + obj.First_Name + " " + obj.Last_Name + " ------");
                    Display.onUserLogin(list, m, obj.l, obj);// Showing The Option for Booking
                    return true;
                } else {
                    System.out.println("\t\t\t\t\t\tinvalid details !");
                    in.nextLine().trim();
                    in.nextLine();
                    return false;
                }

            } else {
                System.out.println("\t\t\t\t\t\tUser not Found!");
                System.out.println("\t\t\t\t\t\tEnter to Continue");
                in.nextLine().trim();
                in.nextLine();
                return false;

            }
        }
    }
}// User Class Ended

class Movies implements Serializable {
    static Scanner in = new Scanner(System.in);
    int seats[][] = new int[5][5];

    int movie_code;
    String movie_name;
    String Movie_date;
    String Time;
    int movie_price;

    void resetSeat(char ch) {
        char seat = 'A';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (seat == ch) {
                    seats[i][j] = 0;
                    return;
                } else {
                    seat++;
                }
            }
        }

    }

    void Add_Movies_List(LinkedList<Movies> m) throws InterruptedException {
        Movies Movie = new Movies();
        Movie.getDetails(m);
        m.add(Movie);
        System.out.println("Adding Movie");
        Thread.sleep(1000);
        System.out.println("Movie successfully added !");
        System.out.print("Enter to Continue = ");
        in.nextLine().trim();

        Booking.ClearConsole();

    }

    public static void Show_all_Movies(LinkedList<Movies> m) {

        Booking.ClearConsole();
        for (Movies ch : m) {
            System.out.println("\t\t\t\t\t==================================");
            System.out.println("\t\t\t\t\t\tmovie code: " + ch.movie_code);
            System.out.println("\t\t\t\t\t\tname      : " + ch.movie_name);
            System.out.println("\t\t\t\t\t\tdate      : " + ch.Movie_date);
            System.out.println("\t\t\t\t\t\ttime      : " + ch.Time);
            System.out.println("\t\t\t\t\t\tprice     : " + ch.movie_price);
            System.out.println("\t\t\t\t\t====================================");

        }

    }

    public static void remove_movie(LinkedList<Movies> m) {
        int remove_code = 0;
        boolean flag = false;
        Show_all_Movies(m);
        System.out.print("\t\t\t\t enter the  Movie code to remove movie = ");
        boolean checkint = false;
        while (!checkint) {
            try {
                remove_code = in.nextInt();
                in.nextLine();
                checkint = true;

                for (Movies a : m) {
                    if (remove_code == a.movie_code) {
                        m.remove(m.indexOf(a));
                        System.out.println("\t\t\t\t\t\tMovie has been Removed Successfully! ");

                        flag = true;
                        break;

                    }

                }
                if (!flag) {
                    System.out.println("\t\t\t\t\t\t movie not exists");
                }
                System.out.print("\t\t\t\t\t\tEnter to Continue = ");
                in.nextLine().trim();
                Booking.ClearConsole();
            } catch (InputMismatchException e) {
                System.out.println("\t\t\t\t\t\tEnter a Number !");
                in.nextLine().trim();
                in.nextLine();
                break;

            }
        }
    }

    void getDetails(LinkedList<Movies> m) {
        boolean flag = false;
        int testMovie_code;
        testMovie_code = 0;
        do {
            Booking.ClearConsole();
            System.out.println("\t\t\t\t------Fill Following Information to Create New Movie------\n\n");
            boolean checkint = false;
            while (!checkint) {
                System.out.print("\t\t\t\t\t\tEnter movie code: ");
                checkint = false;
                try {
                    testMovie_code = in.nextInt();
                    in.nextLine();
                    checkint = true;

                    flag = false;
                    for (Movies test : m) {
                        if (test.movie_code == testMovie_code) { // if movie code exists
                            System.out.println(
                                    "\t\t\t\t\t\tMovie with Moviecode " + testMovie_code
                                            + " Already exists\n\t\t\t\t\t\tEnter Unique Movie Code");
                            flag = true;
                            in.nextLine().trim();
                            break;
                        }
                    }

                    if (!flag) {
                        movie_code = testMovie_code;
                        flag = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\t\t\t\t\t\tEnter a Number !");
                    in.nextLine().trim();
                    in.nextLine();

                }

            }
        } while (flag);

        System.out.print("\t\t\t\t\t\tEnter movie name: ");
        movie_name = in.next().trim();

        System.out.print("\t\t\t\t\t\tEnter movie date(DD/MM/YYYY): ");
        Movie_date = in.next().trim();

        System.out.print("\t\t\t\t\t\tEnter movie Time(HH:MM): ");
        Time = in.next().trim();

        System.out.print("\t\t\t\t\t\tEnter price: ");
        boolean checkint = false;
        while (!checkint) {
            try {
                movie_price = in.nextInt();
                in.nextLine();
                checkint = true;
            } catch (InputMismatchException e) {
                System.out.println("\t\t\t\t\t\tEnter a Number !");
                in.nextLine().trim();
                in.nextLine();

            }
        }
    }

}

class Seat_Check {
    static Scanner in = new Scanner(System.in);

    void showSeats(char ch, int seats[][]) {
        char seat = 'A';
        int x, y = 0;

        System.out.println("\t\t\t\t\t     ____________________________       ");
        System.out.println("\t\t\t\t\t    |          SCREEN            |      ");
        System.out.println("\t\t\t\t\t    ------------------------------      ");
        System.out.println();
        System.out.println();
        for (int j = 0; j < 5; j++) {
            System.out.print("\t\t\t\t\t");

            x = 0;
            for (int i = 0; i < 5; i++) {
                char display = (seats[y][x] == 1 && seat == ch) ? '*' : (seats[y][x] == 1 ? '*' : ' ');
                System.out.print(seat + "| " + display + " |" + "\t");
                x++;
                seat++;
            }
            y++;
            System.out.println();
        }
    }

    void showSeats(int seats[][]) {
        char seat = 'A';
        int x, y = 0;
        Booking.ClearConsole();
        System.out.println("\t\t\t\t\t     ____________________________       ");
        System.out.println("\t\t\t\t\t    |          SCREEN            |      ");
        System.out.println("\t\t\t\t\t    ------------------------------      ");
        System.out.println();
        System.out.println();

        for (int j = 0; j < 5; j++) {
            System.out.print("\t\t\t\t\t");

            x = 0;
            for (int i = 0; i < 5; i++) {
                char display = (seats[y][x] == 1) ? '*' : ' ';
                System.out.print(seat + "| " + display + " |" + "\t");
                x++;
                seat++;
            }
            y++;
            System.out.println();
        }
    }

    char accept_data(int seats[][]) {
        char ch;
        int x, y;
        showSeats(seats);
        char seat = 'A';
        System.out.println("\t\t\t\t\t\tEnter the seat no (A/B/C...etc): ");
        ch = Character.toUpperCase(in.next().charAt(0)); // Convert input to uppercase
        do {
            if ((ch >= 'A' && ch <= 'Y')) {
                y = 0;
                for (int j = 0; j < 5; j++) {
                    x = 0;
                    for (int i = 0; i < 5; i++) {
                        if (Character.toUpperCase(seat) == ch) { // Compare uppercase seat
                            if (seats[y][x] == 1) {
                                System.out.println("\t\t\t\t\t\tSeat already booked!");
                                System.out.println("\t\t\t\t\t\tSelect another seat.");
                                System.out.println();
                                return 0;
                            } else {
                                seats[y][x] = 1; // Mark the seat as booked
                                System.out.println("\t\t\t\t\t\tSeat accepted!");
                                in.nextLine();
                                return ch; // Exit the method after Booking the seat
                            }
                        }
                        x++;
                        seat++;
                    }
                    y++;
                }
            } else {
                System.out.println("\t\t\t\t\t\tEnter the correct seat no.");
                return ' ';
            }
        } while (seat != 'Y');

        return ch;
    }

}

class Ticket implements Serializable {
    // long Mobile_no = 1234567899;
    static int base_ticketno = 100;
    // // int MOvie_code = 192398;
    char Movie_Seat;
    // int seat_Booked_count = 16;
    int Theater_Contact_no = 111111111;

    String Theater_Name = "Heloooo";
    static Scanner in = new Scanner(System.in);
    // fields
    int tkt_no;
    long mobile_no;
    int MovieCode;

    // String name = "user1";
    // String password = "111";
    // String Time = "11:00";

    void resetSeat(Movies m) {
        m.resetSeat(Movie_Seat);

    }

    boolean getDetails(LinkedList<Movies> movies) throws InterruptedException {
        Seat_Check s = new Seat_Check();
        // int choice =1;

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("                                " + "--------Fill Following Information--------");
        System.out.println();
        System.out.println();
        boolean flag = false;
        // Automatic Generation
        System.out.print("|->|\t\t\t\tEnter movie code: ");
        boolean checkint = false;
        while (!checkint) {
            try {
                MovieCode = in.nextInt();
                in.nextLine();
                checkint = true;
            } catch (InputMismatchException e) {
                System.out.println("\t\t\t\t\t\tEnter a Number !");
                in.nextLine().trim();
                in.nextLine();

            }
        }
        Movies obj2 = null;
        for (Movies obj : movies) {
            if (MovieCode == obj.movie_code) {
                obj2 = obj;
                Booking.ClearConsole();
                flag = true;
                break;
            }
        }

        // We have to Show the Movie code on Screen
        if (flag) {
            char cha;
            // while (choice != 0) {
            cha = s.accept_data(obj2.seats);

            if (cha != 0) {
                Booking.ClearConsole();
                s.showSeats(cha, obj2.seats);
                Movie_Seat = cha;
                tkt_no = base_ticketno + 1;
                base_ticketno++;
                return true;

            }
            return false;
            // System.out.println("Enter 0 to exit, 1 to continue: ");
            // choice = in.nextInt();
            // }
        } else {
            System.out.println("\t\t\t\t\t\t Enter Valid Movie Code");

            in.nextLine().trim();

            return false;
        }
        // Then user give input of movie code, date, time.
        // User input
    }

    void Ticket_Generation(LinkedList<Movies> movies) throws InterruptedException {
        // Scanner in = new Scanner(System.in);
        Movies m = new Movies();
        for (Movies obj : movies) {
            if (obj.movie_code == MovieCode) {
                m = obj;
                break;
            }
        }

        in.nextLine().trim();
        System.out.println("                                          Generating Ticket!!                     ");
        Thread.sleep(1500);
        Booking.ClearConsole();
        Booking.ClearConsole();
        System.out.println();
        System.out.println();
        System.out
                .println("                                       Ticket Generated Successfully!!                     ");
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("                                          " + "=========================================");
        System.out.println("                                          "
                + "                                                      ");
        System.out.println("                                          " + "           Theater Name = " + Theater_Name);
        System.out.println("                                          "
                + "                                                      ");
        System.out.println("                                          " + "    Ticket No = " + tkt_no);
        System.out.println("                                          " + "    Movie code = " + MovieCode);
        System.out.println("                                          " + "    Movie Name = " + m.movie_name);
        System.out.println("                                          " + "    Movie Date = " + m.Movie_date);
        System.out.println("                                          " + "    Movie Time = " + m.Time);
        System.out.println("                                          " + "    Movie Price = " + m.movie_price);
        System.out.println("                                          " + "    Your Seats = " + Movie_Seat);
        System.out.println(
                "                                          " + "    Theater Contact No = " + Theater_Contact_no);
        System.out.println("                                          " + "=========================================");

    }

    void printDetails(LinkedList<Movies> movies) throws InterruptedException {
        Movies m = new Movies();
        for (Movies obj : movies) {
            if (obj.movie_code == MovieCode) {
                m = obj;
                break;
            }
        }

        System.out.println("                                          " + "=========================================");
        System.out.println("                                          "
                + "                                                      ");
        System.out.println("                                          " + "           Theater Name = " + Theater_Name);
        System.out.println("                                          "
                + "                                                      ");
        System.out.println("                                          " + "    Ticket no = " + tkt_no);
        System.out.println("                                          " + "    Movie Name = " + m.movie_name);
        System.out.println("                                          " + "    Movie Code = " + m.movie_code);
        System.out.println("                                          " + "    Movie Date = " + m.Movie_date);
        System.out.println("                                          " + "    Movie Time = " + m.Time);
        System.out.println("                                          " + "    Movie Price = " + m.movie_price);
        System.out.println("                                          " + "    Your Seats = " + Movie_Seat);
        System.out.println(
                "                                          " + "    Theater Contact No = " + Theater_Contact_no);
        System.out.println("                                          " + "=========================================");
    }

}

class Booking {
    static Scanner in = new Scanner(System.in);

    public static void ClearConsole() {
        try {
            String operatingSystem = System.getProperty("os.name"); // Check the current operating system

            if (operatingSystem.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static Ticket t;

    static void ADD(LinkedList<Movies> movies, LinkedList<Ticket> ticket) throws InterruptedException {
        Ticket t = null;
        boolean flag;

        Booking.ClearConsole();
        Movies.Show_all_Movies(movies);

        t = new Ticket();
        flag = t.getDetails(movies);
        ticket.add(t);

        // Call Ticket_Generation() only once after all tickets are added
        if (flag) {

            t.Ticket_Generation(movies);
        }
        for (Ticket c : ticket) {
            if (c.tkt_no == 0) {
                ticket.remove(c);
            }
        }
        System.out.println("\t\t\t\t\t\tpress any key to Continue");
        in.nextLine().trim();
        Booking.ClearConsole();
        System.out.println();
        System.out.println();
    }

    public static void remove(LinkedList<User> list, LinkedList<Movies> movies, LinkedList<Ticket> ticket)
            throws InterruptedException {
        boolean flag = false;
        // Movies m=new Movies();
        // for( Movies obj : movies){
        // if(obj.movie_code == MovieCode){
        // m = obj;
        // break;
        // }
        // }
        // for (Ticket t : ticket) {
        // Booking.ClearConsole();
        // t.printDetails(movies);

        // }

        Booking.ShowAllTicket(list, movies, ticket);
        int remove_code = 0;
        System.out.print("\t\t\t\t\t\t enter the  ticket code to remove movie = ");
        boolean checkint = false;
        while (!checkint) {
            try {
                remove_code = in.nextInt();
                in.nextLine();
                checkint = true;
            } catch (InputMismatchException e) {
                System.out.println("\t\t\t\t\t\tEnter a Number !");
                in.nextLine().trim();
                in.nextLine();

            }
        }

        for (Ticket a : ticket) {
            if (remove_code == a.tkt_no) {
                for (Movies m : movies) {
                    if (m.movie_code == a.MovieCode)
                        a.resetSeat(m);

                }
                ticket.remove(ticket.indexOf(a));
                flag = true;

                System.out.println("\t\t\t\t\t\tTICKET has been Removed Successfully! ");

                in.nextLine().trim();
                Booking.ClearConsole();
                break;

            }
        }
        if (!flag) {
            System.out.println("\t\t\t\t\t\tBooking not exists");
            in.nextLine().trim();

        }

    }

    static void ShowAllTicket(LinkedList<User> list, LinkedList<Movies> movies, LinkedList<Ticket> ticket)
            throws InterruptedException {

        Booking.ClearConsole();

        for (Ticket c : ticket) {

            System.out.println();
            System.out.println(
                    "\t\t\t------------------------------------------------------------------------------------------");
            c.printDetails(movies);
            System.out.println(
                    "\t\t\t------------------------------------------------------------------------------------------");

        }

        // Add this line to consume the newline character
        System.out.println("\t\t\t\t\t\tPress Enter to Continue");
        in.nextLine().trim();

    }

}

class AppData extends Thread {
    static Scanner in = new Scanner(System.in);
    static LinkedList<User> Userll;
    static LinkedList<Movies> Moviesll;

    static boolean exit = false;

    static ObjectOutputStream MovieOut;
    static ObjectOutputStream UserOut;
    static long SleepTime = 5000;

    public AppData() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                StoreMovieLinkedList(Moviesll);
                StoreUserLinkedList(Userll);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
    }

    static void StoreUserLinkedList(LinkedList<User> User) {

        try {

            ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream("UserData.dat"));

            fout.writeObject(User);
            fout.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("enter to continue....");
            in.nextLine();

        }
    }

    static void StoreMovieLinkedList(LinkedList<Movies> Movies) {

        try {

            ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream("MovieData.dat"));

            fout.writeObject(Movies);
            fout.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("enter to continue....");
            in.nextLine();

        }

    }
    // static void StoreTicketLinkedList(LinkedList<Ticket> Ticket){
    // try {

    // ObjectOutputStream fout = new ObjectOutputStream (new FileOutputStream
    // ("TicketData.dat"));
    // fout.writeObject(Ticket);
    // fout.close();
    // } catch (Exception e) {
    // System.out.println(e);
    // System.out.println("enter to continue....");
    // in.nextLine();

    // }
    // }
    static LinkedList<User> fetchUserLinkedList() {
        try {

            ObjectInputStream fin = new ObjectInputStream(new FileInputStream("UserData.dat"));
            @SuppressWarnings("unchecked")
            LinkedList<User> user = (LinkedList<User>) fin.readObject();
            fin.close();
            return user;
        } catch (Exception e) {
            return new LinkedList<User>();
        }

    }

    static LinkedList<Movies> fetchMovieLinkedList() {
        try {
            ObjectInputStream fin = new ObjectInputStream(new FileInputStream("MovieData.dat"));
            @SuppressWarnings("unchecked")
            LinkedList<Movies> movies = (LinkedList<Movies>) fin.readObject();
            fin.close();
            return movies;
        } catch (Exception e) {
            return new LinkedList<Movies>();
        }

    }
    // static LinkedList <Ticket>fetchTicketLinkedList(){
    // try{
    // ObjectInputStream fin = new ObjectInputStream(new
    // FileInputStream("MovieData.dat"));
    // @SuppressWarnings("unchecked")
    // LinkedList <Ticket> ticket = (LinkedList <Ticket>)fin.readObject();
    // fin.close();
    // return ticket;
    // }
    // catch(Exception e){
    // return new LinkedList<Ticket>();

    // }
    // }

    void intitialise(LinkedList<User> User, LinkedList<Movies> Movies) {
        Userll = User;
        Moviesll = Movies;
        try {
            MovieOut = new ObjectOutputStream(new FileOutputStream("MovieData.Dat"));
            UserOut = new ObjectOutputStream(new FileOutputStream("UserData.Dat"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void run() {

        try {

            Userll = AppData.fetchUserLinkedList();
            Moviesll = AppData.fetchMovieLinkedList();

        } catch (Exception e) {
            Userll = new LinkedList<User>();
            Moviesll = new LinkedList<Movies>();
        }

        while (!exit) {
            try {
                Thread.sleep(SleepTime);

                AppData.StoreMovieLinkedList(Moviesll);
                AppData.StoreUserLinkedList(Userll);

                // MovieOut.writeObject(Moviesll);
                // UserOut.writeObject(Userll);

            } catch (Exception e) {
                System.out.println(e);

            }

        }
    }

    public void stopThread() {

        exit = true;
        try {
            // MovieOut.close();
            // UserOut.close();

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    static void Settings() {
        int choice;
        do {
            System.out.println("\t\t\t\t\t\tCurrent Time : " + SleepTime);
            System.out.println();
            System.out.println("\t\t\t\t\t\t1. Edit Save After time");
            System.out.println("\t\t\t\t\t\t0. Exit");
            System.out.println();

            System.out.print("\t\t\t\t\t\tEnter choice : ");
            try {
                choice = in.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("\t\t\t\t\t\tEnter a Number !");
                choice = -1;
                in.nextLine();
            }

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println();

                        System.out.print("\t\t\t\t\t\tEnter time in ms : ");
                        try {
                            long temp = in.nextLong();
                            SleepTime = temp;
                            System.out.println("\t\t\t\t\t\tTime updated Successfully !");
                            in.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("\t\t\t\t\t\tEnter a Number !");
                            in.nextLine();
                        }
                    }
                    break;

                case 0:
                    break;
            }
        } while (choice != 0);
    }

}

public class App2 extends JFrame {

    // this is changes

    JButton loginbtn = Style.createButton("Login");
    JButton signupbtn = Style.createButton("Sign-up");
    JButton settings = Style.createButton("Settings");

    App2() {
        this.setSize(600, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Style.ColorConstants.BGCOLOR);
        this.setTitle("INOX Theater");

        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(3, 1, 0, 20));
        JApp.add(sidePanel, loginbtn, signupbtn);
        // sidePanel.add(settings);

        sidePanel.setPreferredSize(new Dimension(300, 10));
        Style.applyPercentageMargins(this, sidePanel, 0.30, 0.20); // 10% margins

        App2 frame = this;

        sidePanel.setBackground(Style.ColorConstants.BGCOLOR);

        // add(sidePanel, BorderLayout.WEST);
        add(sidePanel, BorderLayout.CENTER);

        Label title = new Label("INOX Theater");
        Style.applyPercentageSize(this, title, 0.10, 0.20);
        title.setAlignment(Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setBackground(Style.ColorConstants.BGCOLOR);
        title.setForeground(Color.WHITE);
        add(title, BorderLayout.NORTH);
        // Add a ComponentListener to handle resizing and adjust margins dynamically
        this.addComponentListener(new java.awt.event.ComponentAdapter() {

            public void componentResized(ComponentEvent e) {
                Style.applyPercentageMargins(frame, sidePanel, 0.30, 0.20); // 10% margins
                Style.applyPercentageSize(frame, title, 0.10, 0.20);
            }
        });

    }

    static Scanner in = new Scanner(System.in);

    static void Settings() {
        int choice;
        do {
            System.out.println("\t\t\t\t\t\t1. AutoSave Settings");
            System.out.println("\t\t\t\t\t\t0. Exit");
            System.out.println();

            System.out.print("\t\t\t\t\t\tEnter choice : ");
            try {
                choice = in.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("\t\t\t\t\t\tEnter a Number !");
                choice = -1;
                in.nextLine();
            }

            switch (choice) {
                case 1:
                    AppData.Settings();
                    break;

                case 0:
                    break;
            }

        } while (choice != 0);

    }

    public static void main(String[] args) throws InterruptedException {
        // Booking b = new Booking();
        // b.Show_Ticket();

        App2 a = new App2();
        a.setVisible(true);

        LinkedList<Movies> m = AppData.fetchMovieLinkedList();
        LinkedList<User> list = AppData.fetchUserLinkedList();

        // AppData AutoSave = new AppData();

        // AutoSave.setName("AutoSave Thread");
        // AutoSave.intitialise(list,m);
        // AutoSave.start();

        // Movies movie = new Movies();
        Display.loginPanel(list, m);

        AppData.StoreMovieLinkedList(m);
        // System.out.println("movies data saved sucessfully");

        AppData.StoreUserLinkedList(list);
        // System.out.println("user data saved succesfully");

        // AutoSave.stopThread();
    }
}