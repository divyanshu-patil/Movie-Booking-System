import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

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
                    break;

                case 2:

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
    // LinkedList<Ticket> l = new LinkedList<Ticket>();
    static Console con = System.console();
    // fields
    String First_Name;
    String Last_Name;
    String Mobile_No;
    String Username = null;
    String Password = null;
    String EmailAddress = null;

    String testusername;

    User() {

    }

    User(LinkedList<User> user, String username, String pass, String FName) {
        this.Username = username;
        this.Password = pass;
        this.First_Name = FName;
    }

    static boolean isEmail(String email) {

        String s1 = email.trim();
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

        return flag;
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

    static boolean userLogin(LinkedList<User> list, LinkedList<Movies> m, String username,
            String password) throws InterruptedException {
        boolean flag = false;// use to hold value true if Given user name matches with the list username
        User obj = null;

        if (Admin.checkAdminLoginUsername(username)) {

            if (Admin.checkAdminLogin(username, password)) {

                return true;
            } else {
                System.out.println("\t\t\t\t\t\tWrong Password For ADMIN Login");
            }
            return false;
        } else {
            for (User u : list) {// using User LinkedList
                flag = u.Username != null && u.Username.equals(username);
                if (flag) {
                    obj = u;// Storing The user in Obj
                    break;
                }
            }
            if (flag) {

                if (username.equals(obj.Username) && password.equals(obj.Password)) {// Checking Password
                    return true;
                } else {
                    System.out.println("\t\t\t\t\t\tinvalid details !");

                    return false;
                }

            } else {
                System.out.println("\t\t\t\t\t\tUser not Found!");
                System.out.println("\t\t\t\t\t\tEnter to Continue");
                return false;

            }
        }
    }

    static boolean isUserExists(LinkedList<User> list, String username) {
        for (User u : list) {// using User LinkedList
            if (u.Username != null && u.Username.equals(username)) {
                return true;
            }
        }
        return false;
    }
}// User Class Ended

class Movies implements Serializable {
    static Scanner in = new Scanner(System.in);
    int seats[][] = new int[5][5];

    String movie_code;
    String movie_name;
    String Movie_date;
    String Time;
    String img;
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

    void Add_Movies_List(LinkedList<Movies> m) {
        Movies Movie = new Movies();
        Movie.getDetails(m);
        m.add(Movie);
        System.out.println("Adding Movie");
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
        String remove_code = "";
        boolean flag = false;
        Show_all_Movies(m);
        System.out.print("\t\t\t\t enter the  Movie code to remove movie = ");
        boolean checkint = false;
        while (!checkint) {
            try {
                remove_code = in.nextLine();
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
        String testMovie_code;
        testMovie_code = "";
        do {
            Booking.ClearConsole();
            System.out.println("\t\t\t\t------Fill Following Information to Create New Movie------\n\n");
            boolean checkint = false;
            while (!checkint) {
                System.out.print("\t\t\t\t\t\tEnter movie code: ");
                checkint = false;
                try {
                    testMovie_code = in.nextLine();
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

    public static boolean isCodeExists(LinkedList<Movies> movies, String code) {
        for (Movies m : movies) {
            if (m.movie_code.equals(code))
                return true;
        }
        return false;
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
    String MovieCode;

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
                MovieCode = in.nextLine();
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

class AppData {
    static Scanner in = new Scanner(System.in);
    static LinkedList<User> Userll;
    static LinkedList<Movies> Moviesll;

    static boolean exit = false;

    static ObjectOutputStream MovieOut;
    static ObjectOutputStream UserOut;
    static long SleepTime = 5000;

    public static Stack<String> page_history = new Stack<String>();

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

class Panels {
    public static CardLayout cardLayout = new CardLayout();

    public static void clearInputs(JTextComponent... comp) {
        for (JTextComponent c : comp) {
            c.setText(null);
        }
    }

    public static JPanel welcomePanel(JPanel APP) {
        String thisPanelName = "Welcome";

        JButton loginbtn = Style.createButton("Login");
        JButton signupbtn = Style.createButton("Sign-up");
        JButton settings = Style.createButton("homepage");

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());

        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(3, 1, 0, 20));

        JApp.add(sidePanel, loginbtn, signupbtn, settings);

        // sidePanel.add(settings);

        sidePanel.setPreferredSize(new Dimension(300, 10));
        Style.applyPercentageMargins(loginPanel, sidePanel, 0.30, 0.20); // 10% margins

        // add(sidePanel, BorderLayout.WEST);
        loginPanel.add(sidePanel, BorderLayout.CENTER);

        sidePanel.setBackground(Style.ColorConstants.BGCOLOR);

        Label title = new Label("INOX Theater");
        Style.applyPercentageSize(loginPanel, title, 0.10, 0.20);
        title.setAlignment(Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setBackground(Style.ColorConstants.BGCOLOR);
        title.setForeground(Color.WHITE);
        loginPanel.add(title, BorderLayout.NORTH);
        // Add a ComponentListener to handle resizing and adjust margins dynamically
        loginPanel.addComponentListener(new java.awt.event.ComponentAdapter() {

            public void componentResized(ComponentEvent e) {
                Style.applyPercentageMargins(loginPanel, sidePanel, 0.30, 0.20); // 10% margins
                Style.applyPercentageSize(loginPanel, title, 0.10, 0.20);
            }
        });
        JApp.addListener("ActionListener", loginbtn, "Login", () -> {
            AppData.page_history.push(thisPanelName);
            cardLayout.show(APP, "Login");

        });

        JApp.addListener("ActionListener", signupbtn, "signup", () -> {

            AppData.page_history.push(thisPanelName);
            cardLayout.show(APP, "Signup");
        });

        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppData.page_history.push(thisPanelName);
                cardLayout.show(APP, "Home Page");

            }
        });
        return loginPanel;
    }

    public static JPanel loginPanel(JPanel APP, LinkedList<User> list, LinkedList<Movies> m) {

        String thisPanelName = "Login";

        JPanel login = new JPanel();
        login.setLayout(new BorderLayout());

        // Create components
        JLabel Username = new JLabel("User Name");
        JLabel Password = new JLabel("Password");
        JButton UserLogin = Style.createButton("Login");
        // UserLogin.setEnabled(false);

        JTextField usernamefield = new JTextField(15);
        JPasswordField pass = new JPasswordField(15);

        // Create inner panel with GridBagLayout
        JPanel innerpanel = new JPanel();
        login.add(innerpanel, BorderLayout.CENTER); // Add innerpanel to login, using
                                                    // BorderLayout.CENTER for
        // resizing

        innerpanel.setLayout(new GridBagLayout()); // Use GridBagLayout for flexible component placement
        innerpanel.setBackground(Style.ColorConstants.BGCOLOR); // Example background color

        GridBagLayout layout = new GridBagLayout();

        innerpanel.setLayout(layout);

        GridBagConstraints g = new GridBagConstraints();

        g.gridx = 0;
        g.gridy = 0;
        g.gridheight = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(4, 10, 4, 10);
        Username.setForeground(Color.WHITE);
        Username.setFont(new Font("Arial", Font.PLAIN, 30));
        innerpanel.add(Username, g);

        g.gridx = 0;
        g.gridy = 1;
        g.gridheight = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        usernamefield.setPreferredSize(new Dimension(600, 100));
        usernamefield.setFont(new Font("Arial", Font.PLAIN, 30));
        innerpanel.add(usernamefield, g);

        g.gridx = 0;
        g.gridy = 5;
        g.gridheight = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(30, 10, -20, 10);
        Password.setForeground(Color.WHITE);
        Password.setFont(new Font("Arial", Font.PLAIN, 30));
        innerpanel.add(Password, g);

        g.gridx = 0;
        g.gridy = 6;
        g.gridheight = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        pass.setPreferredSize(new Dimension(600, 100));
        pass.setFont(new Font("Arial", Font.PLAIN, 30));
        innerpanel.add(pass, g);

        g.gridx = 0;
        g.gridy = 8;
        g.gridheight = 1;
        g.fill = GridBagConstraints.BOTH;
        g.insets = new Insets(80, 10, 0, 10);
        UserLogin.setPreferredSize(new Dimension(600, 100));
        innerpanel.add(UserLogin, g);

        JLabel l = new JLabel("fill details first");
        l.setFont(new Font("Arial", Font.PLAIN, 24));
        l.setForeground(Color.red);
        g.gridx = 0;
        g.gridy = 9;
        g.gridheight = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        innerpanel.add(l, g);
        l.setVisible(false);
        JApp.addListener("ActionListener", UserLogin, "Login", () -> {
            if (!(usernamefield.getText().isEmpty()
                    && new String(pass.getPassword()).isEmpty())) {

                try {
                    if (Admin.checkAdminLogin(usernamefield.getText().trim(), new String(pass.getPassword()).trim())) {
                        Panels.clearInputs(usernamefield, pass);
                        AppData.page_history.push(thisPanelName);
                        cardLayout.show(APP, "AdminHomePage");

                    } else if (User.userLogin(list, m, usernamefield.getText().trim(),
                            new String(pass.getPassword()).trim())) {
                        System.out.println("user is present");
                        usernamefield.setText("");
                        pass.setText("");
                        AppData.page_history.push(thisPanelName);
                        cardLayout.show(APP, "Welcome");

                    } else {
                        System.out.println("user is absent");
                        l.setText("User not found");
                        l.setVisible(true);
                    }
                    System.out.println(usernamefield.getText().trim() + "\n" + new String(pass.getPassword()).trim());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // cardLayout.show(APP.getContentPane(), "Welcome");
            } else {

                System.out.println("hello");
                l.setText("fill all details");
                l.setVisible(true);
            }

        });

        return login;
    }

    public static JPanel signUpPanel(JPanel APP, LinkedList<User> list) {
        String thisPanelName = "Signup";

        JPanel userPanel = new JPanel(new GridLayout(2, 1));
        JLabel userLabel = new JLabel("Username");
        JTextField Username = new JTextField(20);
        JApp.add(userPanel, userLabel, Username);

        JPanel PassPanel = new JPanel(new GridLayout(2, 1));
        JLabel PassLabel = new JLabel("Password");
        JPasswordField Password = new JPasswordField(20);
        JApp.add(PassPanel, PassLabel, Password);

        JPanel ConfPassPanel = new JPanel(new GridLayout(2, 1));
        JLabel ConfPassLabel = new JLabel("Confirm Password");
        JPasswordField ConfPassword = new JPasswordField(20);
        JApp.add(ConfPassPanel, ConfPassLabel, ConfPassword);

        JPanel FNamePanel = new JPanel(new GridLayout(2, 1));
        JLabel FNameLabel = new JLabel("First Name");
        JTextField FName = new JTextField(20);
        JApp.add(FNamePanel, FNameLabel, FName);

        JPanel LNamePanel = new JPanel(new GridLayout(2, 1));
        JLabel LNameLabel = new JLabel("Last Name");
        JTextField LName = new JTextField(20);
        JApp.add(LNamePanel, LNameLabel, LName);

        JPanel EmailPanel = new JPanel(new GridLayout(2, 1));
        JLabel EmailLabel = new JLabel("Email");
        JTextField Email = new JTextField(20);
        JApp.add(EmailPanel, EmailLabel, Email);

        JPanel panels[] = { userPanel, PassPanel, ConfPassPanel, FNamePanel, LNamePanel, EmailPanel };
        JLabel labels[] = { userLabel, PassLabel, ConfPassLabel, FNameLabel, LNameLabel, EmailLabel };
        JTextComponent inputs[] = { Username, Password, ConfPassword, FName, LName, Email };
        for (JLabel l : labels) {
            l.setForeground(Color.WHITE);
            l.setFont(new Font("Arial", Font.PLAIN, 24));
        }
        for (JPanel p : panels) {
            p.setBackground(Style.ColorConstants.BGCOLOR);
        }
        for (JTextComponent p : inputs) {
            p.setFont(new Font("Arial", Font.PLAIN, 28));
        }

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());

        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(8, 1, 0, 20));

        JButton submit = Style.createButton("Sign up");
        JApp.add(sidePanel, userPanel, PassPanel, ConfPassPanel, FNamePanel, LNamePanel, EmailPanel, submit);

        // sidePanel.add(settings);
        sidePanel.setPreferredSize(new Dimension(500, 1000));
        Style.applyPercentageMargins(loginPanel, sidePanel, 0.30, 0.05); // 10% margins

        // add(sidePanel, BorderLayout.WEST);
        loginPanel.add(sidePanel, BorderLayout.CENTER);

        sidePanel.setBackground(Style.ColorConstants.BGCOLOR);

        Label title = new Label("Signup");
        Style.applyPercentageSize(loginPanel, title, 0.10, 0.10);
        title.setAlignment(Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setBackground(Style.ColorConstants.BGCOLOR);
        title.setForeground(Color.WHITE);
        loginPanel.add(title, BorderLayout.NORTH);
        // Add a ComponentListener to handle resizing and adjust margins dynamically
        loginPanel.addComponentListener(new java.awt.event.ComponentAdapter() {

            public void componentResized(ComponentEvent e) {
                Style.applyPercentageMargins(loginPanel, sidePanel, 0.30, 0.05); // 10% margins
                Style.applyPercentageSize(loginPanel, title, 0.10, 0.10);
            }
        });
        JLabel error = new JLabel("Fill all fields");
        error.setFont(new Font("Arial", Font.PLAIN, 24));
        error.setForeground(Color.RED);
        error.setHorizontalAlignment(SwingConstants.CENTER);
        sidePanel.add(error);
        error.setVisible(false);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(Username.getText().trim().isEmpty() ||
                        new String(Password.getPassword()).trim().isEmpty() ||
                        new String(ConfPassword.getPassword()).trim().isEmpty() ||
                        FName.getText().isEmpty() ||
                        LName.getText().isEmpty() ||
                        Email.getText().isEmpty())) {
                    if (User.isUserExists(list, Username.getText())) {
                        error.setText("Username already exists");
                        error.setVisible(true);
                    } else if (Username.getText().trim().equals("ADMIN") || Username.getText().trim().equals("Admin")
                            || Username
                                    .getText().equals("admin")) {
                        error.setText("cant set username to " + Username.getText().trim());
                        error.setVisible(true);
                    } else if (!new String(Password.getPassword()).trim()
                            .equals(new String(ConfPassword.getPassword()).trim())) {
                        error.setText("Password and Confirm Password does'nt match");
                        error.setVisible(true);

                    } else if (JApp.containsDigit(FName.getText().trim()) || JApp
                            .containsDigit(LName.getText().trim())) {
                        error.setText("can't enter numbers in the name field");
                        error.setVisible(true);

                    } else if (!User.isEmail(Email.getText())) {
                        error.setText("Enter valid email address");
                        error.setVisible(true);
                    } else {
                        User user = new User();
                        user.Username = Username.getText().trim();
                        user.Password = new String(Password.getPassword()).trim();
                        user.First_Name = FName.getText();
                        user.Last_Name = LName.getText();
                        user.EmailAddress = Email.getText();

                        list.add(user);
                        for (JTextComponent p : inputs) {
                            p.setText("");
                        }
                        AppData.page_history.push(thisPanelName);
                        cardLayout.show(APP, "Welcome");
                        error.setVisible(false);
                    }

                } else {
                    error.setVisible(true);
                }
            }
        });
        return loginPanel;

    }

    public static JPanel AdminHomePanel(JPanel APP, LinkedList<Movies> m, LinkedList<User> list) {

        String thisPanelName = "AdminHomePage";

        JButton AddMoviebtn = Style.createButton("Add Movie");
        JButton RemoveMoviebtn = Style.createButton("Remove Movie");
        JButton SeeAllMoviesbtn = Style.createButton("See all Movies");
        JButton ViewAdminProfilebtn = Style.createButton("Profile");
        // JButton EditProfilebtn = Style.createButton("Edit Profile");
        JButton ViewAllUsersbtn = Style.createButton("View All Users");

        JPanel AdminHomePanel = new JPanel();
        AdminHomePanel.setLayout(new BorderLayout());

        JPanel InnerPanel = new JPanel();
        InnerPanel.setLayout(new GridLayout(5, 1, 0, 20));

        JApp.add(InnerPanel, AddMoviebtn, RemoveMoviebtn, SeeAllMoviesbtn, ViewAdminProfilebtn, ViewAllUsersbtn);

        // sidePanel.add(settings);
        InnerPanel.setPreferredSize(new Dimension(500, 1000));
        Style.applyPercentageMargins(AdminHomePanel, InnerPanel, 0.30, 0.05); // 10% margins

        // add(sidePanel, BorderLayout.WEST);
        AdminHomePanel.add(InnerPanel, BorderLayout.CENTER);

        InnerPanel.setBackground(Style.ColorConstants.BGCOLOR);

        Label title = new Label("Welcome Admin");
        Style.applyPercentageSize(AdminHomePanel, title, 0.10, 0.05);
        title.setAlignment(Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setBackground(Style.ColorConstants.BGCOLOR);
        title.setForeground(Color.WHITE);
        AdminHomePanel.add(title, BorderLayout.NORTH);
        AdminHomePanel.addComponentListener(new java.awt.event.ComponentAdapter() {

            public void componentResized(ComponentEvent e) {
                Style.applyPercentageMargins(AdminHomePanel, InnerPanel, 0.30, 0.05); // 10% margins
                Style.applyPercentageSize(AdminHomePanel, title, 0.10, 0.15);
            }
        });

        AddMoviebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppData.page_history.push(thisPanelName);
                cardLayout.show(APP, "AdminMovieADDPage");
            }
        });
        return AdminHomePanel;
    }

    public static JPanel AdminMovieAdd(JPanel APP, LinkedList<Movies> m) {
        // String thisPanelName = "AdminMovieADDPage";

        JPanel MovieCodePanel = new JPanel(new GridLayout(2, 1, 0, 5));
        JLabel MovieCodeLabel = new JLabel("Movie Code");
        JTextField MovieCode = new JTextField();
        MovieCodePanel.add(MovieCodeLabel);
        MovieCodePanel.add(MovieCode);

        JPanel MovieNamePanel = new JPanel(new GridLayout(2, 1, 0, 5));
        JLabel MovieNameLabel = new JLabel("Movie Name");
        JTextField MovieName = new JTextField();
        MovieNamePanel.add(MovieNameLabel);
        MovieNamePanel.add(MovieName);

        JPanel MovieDatePanel = new JPanel(new GridLayout(2, 1, 0, 5));
        JLabel MovieDateLabel = new JLabel("Movie Date");
        JTextField MovieDate = new JTextField();
        MovieDatePanel.add(MovieDateLabel);
        MovieDatePanel.add(MovieDate);

        JPanel MovieTimePanel = new JPanel(new GridLayout(2, 1, 0, 5));
        JLabel MovieTimeLabel = new JLabel("Movie Time");
        JTextField MovieTime = new JTextField();
        MovieTimePanel.add(MovieTimeLabel);
        MovieTimePanel.add(MovieTime);

        JPanel MoviePricePanel = new JPanel(new GridLayout(2, 1, 0, 5));
        JLabel MoviePriceLabel = new JLabel("Movie Price");
        JTextField MoviePrice = new JTextField();
        MoviePricePanel.add(MoviePriceLabel);
        MoviePricePanel.add(MoviePrice);

        JPanel panels[] = { MovieCodePanel, MovieNamePanel, MovieDatePanel, MovieTimePanel, MoviePricePanel };
        JLabel labels[] = { MovieCodeLabel, MovieNameLabel, MovieDateLabel, MovieTimeLabel, MoviePriceLabel };
        JTextComponent inputs[] = { MovieCode, MovieName, MovieDate, MovieTime, MoviePrice };
        for (JLabel l : labels) {
            l.setForeground(Color.WHITE);
            l.setFont(new Font("Arial", Font.PLAIN, 24));
        }
        for (JPanel p : panels) {
            p.setBackground(Style.ColorConstants.BGCOLOR);
        }
        for (JTextComponent p : inputs) {
            p.setFont(new Font("Arial", Font.PLAIN, 28));
        }

        JPanel movieImagePanel = new JPanel(new BorderLayout());
        movieImagePanel.setBackground(Style.ColorConstants.BGCOLOR);

        // Setting up the GridBagLayout for the container
        JPanel container = new JPanel(new GridBagLayout());
        container.setBackground(Style.ColorConstants.BGCOLOR);
        GridBagConstraints g = new GridBagConstraints();

        // Remove unnecessary insets
        g.insets = new Insets(0, 0, 0, 0);

        // Image panel - occupies 8 blocks
        g.gridx = 0;
        g.gridy = 0;
        g.gridheight = 8; // 8 blocks
        g.weightx = 1.0; // Allow horizontal resizing
        g.weighty = 8.0; // More vertical weight for the image
        g.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically
        g.anchor = GridBagConstraints.NORTH; // Align image to the top
        ImageIcon img = JApp.fitImage("assets/emptyimage.png", 600, 600);
        JLabel image = new JLabel(img);
        container.add(image, g);
        image.setForeground(Color.white);

        image.setBackground(Color.RED);

        // Add Image button - occupies 2 blocks
        g.gridx = 0;
        g.gridy = 8;
        g.gridheight = 2; // 2 blocks for button
        g.weighty = 2.0; // Less vertical weight for button
        g.fill = GridBagConstraints.BOTH; // Fill horizontally and vertically
        g.anchor = GridBagConstraints.SOUTH; // Align button to the bottom
        JButton AddImage = Style.createButton("Add Image");
        container.add(AddImage, g);

        // Adding the container to the movieImagePanel
        movieImagePanel.add(container);

        JPanel AddMoviePanel = new JPanel();
        AddMoviePanel.setBackground(Style.ColorConstants.BGCOLOR);
        Style.applyPercentageSize(AddMoviePanel, movieImagePanel, 0.30, 0.10);
        Style.applyPercentageMargins(AddMoviePanel, container, 0.20, 0.20);
        AddMoviePanel.setLayout(new BorderLayout());
        AddMoviePanel.add(movieImagePanel, BorderLayout.WEST);
        JPanel InnerPanel = new JPanel();
        InnerPanel.setLayout(new GridLayout(7, 1, 0, 20));
        JButton AddMovie = Style.createButton("Add Movie");

        JLabel error = new JLabel();
        error.setFont(new Font("Arial", Font.PLAIN, 24));

        error.setForeground(Color.RED);
        error.setVisible(false);
        JApp.add(InnerPanel, MovieCodePanel, MovieNamePanel, MovieDatePanel, MovieTimePanel, MoviePricePanel, AddMovie,
                error);

        // sidePanel.add(settings);
        InnerPanel.setPreferredSize(new Dimension(500, 1000));
        Style.applyPercentageMargins(AddMoviePanel, InnerPanel, 0.10, 0.10); // 10% margins

        // add(sidePanel, BorderLayout.WEST);
        AddMoviePanel.add(InnerPanel, BorderLayout.CENTER);

        InnerPanel.setBackground(Style.ColorConstants.BGCOLOR);

        Label title = new Label("Add Movie");
        Style.applyPercentageSize(AddMoviePanel, title, 0.10, 0.05);
        title.setAlignment(Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setBackground(Style.ColorConstants.BGCOLOR);
        title.setForeground(Color.WHITE);
        AddMoviePanel.add(title, BorderLayout.NORTH);
        AddMoviePanel.addComponentListener(new java.awt.event.ComponentAdapter() {

            public void componentResized(ComponentEvent e) {
                Style.applyPercentageMargins(AddMoviePanel, InnerPanel, 0.10, 0.10); // 10% margins
                Style.applyPercentageSize(AddMoviePanel, title, 0.10, 0.05);
                Style.applyPercentageSize(AddMoviePanel, movieImagePanel, 0.30, 0.10);
                Style.applyPercentageMargins(movieImagePanel, container, 0.10, 0.10);
                Style.applyPercentageSize(container, image, 1, 1);

            }
        });
        StringBuilder imagePath = new StringBuilder();
        AddImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                chooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "gif"));
                int result = chooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = chooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();
                    ImageIcon img = JApp.fitImage(filePath, 400, 600);
                    image.setIcon(img);
                    imagePath.setLength(0); // Clear the previous path
                    imagePath.append(filePath);
                } else {
                    // User canceled the dialog
                }

            }
        });

        AddMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movies movie = new Movies();
                if (Movies.isCodeExists(m, MovieCode.getText().trim())) {
                    error.setText("enter unique movie code");
                    error.setVisible(true);

                } else if (MovieCode.getText().trim().isEmpty() ||
                        MovieName.getText().trim().isEmpty() ||
                        MovieDate.getText().trim().isEmpty() ||
                        MoviePrice.getText().trim().isEmpty()) {
                    error.setText("fill all fields");
                    error.setVisible(true);
                } else {

                    try {
                        int number = Integer.parseInt(MoviePrice.getText());
                        movie.movie_code = MovieCode.getText().trim();
                        movie.movie_name = MovieName.getText().trim();
                        movie.Movie_date = MovieDate.getText().trim();
                        movie.Time = MovieTime.getText().trim();
                        movie.movie_price = number;

                        movie.img = new String(imagePath);
                        System.out.println(movie.img);
                        m.add(movie);
                        Panels.clearInputs(MovieCode, MovieName, MovieDate, MovieTime, MoviePrice);
                        error.setVisible(false);
                        cardLayout.show(APP, "AdminHomePage");

                    } catch (Exception exp) {
                        error.setText("enter valid number");
                        error.setVisible(true);
                    }
                }
            }
        });

        return AddMoviePanel;
    }

    public static JPanel HomePanel(
            JPanel APP, LinkedList<User> list, LinkedList<Movies> m, LinkedList<Ticket> l,
            String name, User OBJ) {
        JPanel Home = new JPanel();
        Home.setLayout(new BorderLayout());
        Home.setBackground(Style.ColorConstants.BGCOLOR);
        Home.setBorder(new EmptyBorder(10, 20, 0, 20));

        JPanel NorthPanel = new JPanel();
        NorthPanel.setBackground(Style.ColorConstants.BGCOLOR);
        NorthPanel.setLayout(new BorderLayout());
        NorthPanel.setPreferredSize(new Dimension(0, 300));

        Home.add(NorthPanel, "North");

        JLabel userName = new JLabel("Welcome " + " " + OBJ.First_Name);
        userName.setHorizontalAlignment(JLabel.CENTER);
        userName.setFont(new Font("Arial", Font.BOLD, 50));
        userName.setBackground(Style.ColorConstants.BGCOLOR);
        userName.setForeground(Color.WHITE);
        NorthPanel.add(userName);

        JButton ProfileLogo = new JButton();
        ProfileLogo.setBackground(Style.ColorConstants.BGCOLOR);
        ProfileLogo.setIcon(JApp.fitImage("Img/profile.png", 200, 200));
        ProfileLogo.setFocusPainted(false);
        ProfileLogo.setBorder(null);
        ProfileLogo.setContentAreaFilled(false);
        ProfileLogo.setToolTipText("Click Here to See Profile ");
        Style.applyPercentageMargins(ProfileLogo, NorthPanel, 0.30, 0.70); // 10% margins

        NorthPanel.add(ProfileLogo, BorderLayout.SOUTH);

        JPanel CenterPanel = new JPanel();
        CenterPanel.setBackground(Style.ColorConstants.BGCOLOR);
        CenterPanel.setLayout(new GridBagLayout());

        JButton addTicket = Style.createButton("Movies");
        JButton cancleTicket = Style.createButton("Cancle Ticket");
        JButton showTicket = Style.createButton("Show History");

        GridBagConstraints g = new GridBagConstraints();

        g.gridx = 0;
        g.gridy = 0;
        g.gridheight = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(4, 10, 4, 10);
        addTicket.setPreferredSize(new Dimension(500, 100));
        CenterPanel.add(addTicket, g);

        g.gridx = 0;
        g.gridy = 2;
        g.gridheight = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(4, 10, 4, 10);
        cancleTicket.setPreferredSize(new Dimension(500, 100));
        CenterPanel.add(cancleTicket, g);

        g.gridx = 0;
        g.gridy = 3;
        g.gridheight = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(4, 10, 4, 10);
        showTicket.setPreferredSize(new Dimension(500, 100));
        CenterPanel.add(showTicket, g);

        Home.add(CenterPanel);

        JApp.addListener("ActionListener", ProfileLogo, "ProfileLogo", () -> {
            System.out.println("Heloo");
        });
        JApp.addListener("ActionListener", addTicket, "List", () -> {
            System.out.println("Heloo");
        });
        JApp.addListener("ActionListener", cancleTicket, "cancleTicket", () -> {
            System.out.println("Heloo");
        });
        JApp.addListener("ActionListener", showTicket, "showTicket", () -> {
            System.out.println("Heloo");
        });

        return Home;
    }

}

public class App2 extends JFrame {

    // this is changes

    App2() {
        this.setSize(600, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Style.ColorConstants.BGCOLOR);
        this.setTitle("INOX Theater");
        this.setLayout(new BorderLayout());

        LinkedList<Movies> m = AppData.fetchMovieLinkedList();
        LinkedList<User> list = AppData.fetchUserLinkedList();
        LinkedList<Ticket> l = new LinkedList<Ticket>();

        User u = new User(list, "1", "1", "Bhavesh");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(Panels.cardLayout);
        add(mainPanel, BorderLayout.CENTER);
        list.add(u);

        ImageIcon img = JApp.fitImage("assets/arrow-left.png", 50, 50);
        JButton back = new JButton(img);
        back.setPreferredSize(new Dimension(50, 50));
        back.setBackground(Style.ColorConstants.LIGHTBG_COLOR);
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.add(back);

        p.setBackground(Style.ColorConstants.BGCOLOR);
        add(p, BorderLayout.NORTH);

        mainPanel.add("Welcome", Panels.welcomePanel(mainPanel));
        mainPanel.add("Login", Panels.loginPanel(mainPanel, list, m));
        mainPanel.add("Signup", Panels.signUpPanel(mainPanel, list));
        mainPanel.add("AdminHomePage", Panels.AdminHomePanel(mainPanel, m, list));
        mainPanel.add("AdminMovieADDPage", Panels.AdminMovieAdd(mainPanel, m));
        mainPanel.add("Home Page", Panels.HomePanel(mainPanel, list, m, l, "BHAVESH", u));

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!AppData.page_history.isEmpty()) {
                    Panels.cardLayout.show(mainPanel, AppData.page_history.pop());
                }
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