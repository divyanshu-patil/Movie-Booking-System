import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import pkg.*;
import java.util.*;
import java.util.List;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import pkg.*;

class Pass implements Serializable {
    private String password;

    Pass(String Pass) {
        setPassword(Pass);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Pass) {
        this.password = Pass;
    }
}

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
                            // movies.Add_Movies_List(m);
                            break;
                        case 2:
                            // Movies.remove_movie(m);
                            break;
                        case 3:
                            // Movies.Show_all_Movies(m);
                            System.out.println("Press any Key to Continue");
                            in.nextLine().trim();
                            break;

                        case 4:
                            ad.Admin_Details();
                            break;
                        case 5:

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
    static private String Admin_Password = null;
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

    static void initialize(String pass) {
        System.out.println(Admin_Password);
        if (Admin.Admin_Password == null) {
            Admin.Admin_Password = pass;
        } else {
            System.out.println("cant change password");
        }
    }

    static boolean setPassword(String currentPass, String newPass) {
        if (currentPass.equals(Admin.Admin_Password)) {
            Admin_Password = newPass;
            AppData.StoreAdminPass(newPass);
            return true;
        }
        return false;
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

}

class User implements Serializable {
    static Scanner in = new Scanner(System.in);
    // LinkedList<Ticket> l = new LinkedList<Ticket>();
    static Console con = System.console();
    LinkedList<Ticket> l = new LinkedList<Ticket>();
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

    static User getUserObj(LinkedList<User> user, String username) {
        for (User u : user) {
            if (u.Username.equals(username)) {
                return u;
            }
        }
        return null;

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
    double movie_price;

    public JButton[] SEATS = new JButton[25];

    public boolean[] seatStates = new boolean[25]; 

    public Movies() {
        Arrays.fill(seatStates, false);
    }

    public Movies(String Name, String code , String Date, String time, double Price, String Url) {
        movie_name = Name;
        Movie_date = Date;
        movie_code = code;
        Time = time;
        movie_price = Price;
        img = Url;

        Arrays.fill(seatStates, false);
        initializeSeats(); 
    }

    private void initializeSeats() {
        for (int i = 0; i < SEATS.length; i++) {
            SEATS[i] = new JButton(String.valueOf(i + 1));  // Seat number starts from 1
            SEATS[i].setEnabled(true);  // Initially, all seats are enabled
            SEATS[i].setBackground(Color.WHITE);  // Set default background color
        }
    }



    public static boolean isCodeExists(LinkedList<Movies> movies, String code) {
        for (Movies m : movies) {
            if (m.movie_code.equals(code))
                return true;
        }
        return false;
    }

    public static Movies getMovieObj(LinkedList<Movies> movies, String code) {
        for (Movies m : movies) {
            if (m.movie_code.equals(code))
                return m;
        }
        return null;
    }

    public static void resetSeats(List<Integer> seatNumbers , JButton[] SEATS , boolean[] seatStates) {
        for (Integer seatNumber : seatNumbers) {
          
            int seatIndex = seatNumber - 1;
            if (seatIndex >= 0 && seatIndex < SEATS.length) {
                SEATS[seatIndex].setEnabled(true);  
                SEATS[seatIndex].setBackground(Color.WHITE); 
                seatStates[seatIndex] = false; 
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


        public String movieName;
        public String movieCode;
        public String theaterName;
        List<Integer> seatNumbers;
        public String dateTime;
        public double price;
    
        // Constructor
        public Ticket(String movieName, String movieCode, String theaterName,   List<Integer> seatNumbers, String dateTime, double price) {
            this.movieName = movieName;
            this.movieCode = movieCode;
            this.theaterName = theaterName;
            this.seatNumbers = seatNumbers;
            this.dateTime = dateTime;
            this.price = price;
        }
    
        public static void addTicketToUser(User user, Ticket ticket) {
            user.l.add(ticket);

            for ( Ticket tp : user.l) {
                System.out.println(tp.movieCode);
            }
        
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
        // Movies.Show_all_Movies(movies);

        // t = new Ticket();
        // flag = t.getDetails(movies);
        // ticket.add(t);

        // // Call Ticket_Generation() only once after all tickets are added
        // if (flag) {

        //     t.Ticket_Generation(movies);
        // }
        // for (Ticket c : ticket) {
        //     if (c.tkt_no == 0) {
        //         ticket.remove(c);
        //     }
        // }
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

        // for (Ticket a : ticket) {
        //     if (remove_code == a.tkt_no) {
        //         for (Movies m : movies) {
        //             if (m.movie_code == a.MovieCode)
        //                 a.resetSeat(m);

        //         }
        //         ticket.remove(ticket.indexOf(a));
        //         flag = true;

        //         System.out.println("\t\t\t\t\t\tTICKET has been Removed Successfully! ");

        //         in.nextLine().trim();
        //         Booking.ClearConsole();
        //         break;

        //     }
        // }
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
            // c.printDetails(movies);
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
    public static User loggedInUser;

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

    static void StoreAdminPass(String pass) {
        try {
            ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream("Admin.dat"));
            fout.writeObject(new Pass(pass));
            fout.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static Pass fetchAdminPass() {

        try {

            ObjectInputStream fin = new ObjectInputStream(new FileInputStream("Admin.dat"));

            Pass pass = (Pass) fin.readObject();
            fin.close();
            return pass;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
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
    
    private static JLabel MovieNameLabel = new JLabel();
    private static JLabel MovieOtherparameters = new JLabel();
    public static double selectedMoviePrice; // Store the selected movie price here


    public static CardLayout cardLayout = new CardLayout();
    private static HashMap<String, JPanel> componentsMap = new HashMap<>();

    public static void updateHashMap(HashMap<String, JPanel> newcomponentsMap) {
        componentsMap = newcomponentsMap;
    }

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
        // User Obj = null;
        
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

                        User Obj = null;
                        for (User u : list) {
                           
                            if ( u.Username != null && u.Username.equals(usernamefield.getText().trim())) {
                                Obj = u;// Storing The user in Obj
                                break;
                            }
                        }

                        usernamefield.setText("");
                        pass.setText("");
                        AppData.page_history.push(thisPanelName);
                       
                        APP.add("Home Page",  Panels.HomePanel(APP, list, m, Obj));
                        componentsMap.put("Home Page", Panels.HomePanel(APP, list, m, Obj));
                
                       cardLayout.show(APP, "Home Page");
              
                
                        

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

                        // Remove the old panel
                        JPanel oldPanel = componentsMap.get("AdminViewAllUsers");
                        APP.remove(oldPanel);
                        componentsMap.remove("AdminViewAllUsers");

                        APP.add("AdminViewAllUsers", Panels.AdminViewAllUsersPanel(APP, list));
                        componentsMap.put("AdminViewAllUsers", Panels.AdminViewAllUsersPanel(APP, list));

                        // Update the layout
                        APP.revalidate();
                        APP.repaint();

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
        JButton ChangePasswordbtn = Style.createButton("Change Password");
        JButton ViewAllUsersbtn = Style.createButton("View All Users");

        JPanel AdminHomePanel = new JPanel();
        AdminHomePanel.setLayout(new BorderLayout());

        JPanel InnerPanel = new JPanel();
        InnerPanel.setLayout(new GridLayout(5, 1, 0, 20));

        JApp.add(InnerPanel, AddMoviebtn, RemoveMoviebtn, SeeAllMoviesbtn, ChangePasswordbtn, ViewAllUsersbtn);

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
        RemoveMoviebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppData.page_history.push(thisPanelName);
                cardLayout.show(APP, "RemoveMovie");

            }
        });

        SeeAllMoviesbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppData.page_history.push(thisPanelName);
                cardLayout.show(APP, "AdminShowAllMovie");
            }
        });
        ChangePasswordbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppData.page_history.push(thisPanelName);
                cardLayout.show(APP, "AdminChangePassword");
            }
        });
        ViewAllUsersbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppData.page_history.push(thisPanelName);
                cardLayout.show(APP, "AdminViewAllUsers");
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
                        MoviePrice.getText().trim().isEmpty() || imagePath.length() == 0) {
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
                        ImageIcon ico = JApp.fitImage("assets/emptyimage.png", 600, 600);
                        image.setIcon(ico);
                        AppData.StoreMovieLinkedList(m);
                        error.setVisible(false);

                        Iterator<String> iterator = componentsMap.keySet().iterator();
                        while (iterator.hasNext()) {
                            String s = iterator.next();
                            // Remove the old panel
                            JPanel oldPanel = componentsMap.get(s);
                            APP.remove(oldPanel);
                            iterator.remove(); // Remove the key from the map
                        }

                        // Create a new panel
                        JPanel RemovePanel = Panels.RemoveMoviePanel(APP, m);
                        JPanel AdminMovieAdd = Panels.AdminMovieAdd(APP, m);
                        JPanel AdminShowAllMovie = Panels.AdminShowAllMoviePanel(APP, m);

                        // Add the new panel to the mainPanel
                        APP.add("RemoveMovie", RemovePanel);
                        componentsMap.put("RemoveMovie", RemovePanel);

                        APP.add("AdminMovieADDPage", AdminMovieAdd);
                        componentsMap.put("AdminMovieADDPage", AdminMovieAdd);

                        APP.add("AdminShowAllMovie", AdminShowAllMovie);
                        componentsMap.put("AdminShowAllMovie", AdminShowAllMovie);

                        // Update the layout
                        APP.revalidate();
                        APP.repaint();

                        cardLayout.show(APP, "AdminHomePage");

                    } catch (Exception exp) {
                        error.setText("enter valid number");
                        System.out.println(exp);
                        error.setVisible(true);
                    }
                }
            }
        });

        return AddMoviePanel;
    }

    public static JPanel RemoveMoviePanel(JPanel APP, LinkedList<Movies> m) {

        String thisPanelName = "RemoveMovie";
        JPanel RemovePanel = new JPanel(new BorderLayout());
        JPanel InnerPanel = new JPanel(new JApp.WrapLayout(FlowLayout.LEFT, 10, 20));
        JPanel MoviePanel = new JPanel(new BorderLayout());
        JScrollPane ScrollPane = new JScrollPane(InnerPanel);
        JLabel title = new JLabel("Remove Movie");
        RemovePanel.add(title, BorderLayout.NORTH);

        ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        Style.applyPercentageMargins(RemovePanel, MoviePanel, 0.20, 0.20);
        Style.applyPercentageSize(RemovePanel, title, 0.20, 0.03);
        title.setFont(new Font("Arial", Font.PLAIN, 35));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBackground(Style.ColorConstants.BGCOLOR);
        title.setForeground(Color.WHITE);
        InnerPanel.setBackground(Style.ColorConstants.LIGHTBG_COLOR);
        MoviePanel.setBackground(Style.ColorConstants.BGCOLOR);
        RemovePanel.setBackground(Style.ColorConstants.BGCOLOR);
        MoviePanel.add(ScrollPane);
        RemovePanel.add(MoviePanel);

        JButton Removebtn = Style.createButton("Remove Selected Movies", Color.RED);
        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Style.ColorConstants.BGCOLOR);
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(Removebtn);
        RemovePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        // btnPanel.setBackground(Color.CYAN);
        Removebtn.setPreferredSize(new Dimension(500, 60));
        RemovePanel.add(btnPanel, BorderLayout.SOUTH);
        // Style.applyPercentageSize(btnPanel, Removebtn, 0.60, 1);
        Vector<String> SelectedMovies = new Vector<>();
        for (Movies s : m) {
            JPanel b = new JPanel();
            b.setLayout(new BorderLayout());
            ImageIcon ico = JApp.fitImage(s.img, 300, 600);
            JButton imagePanel = new JButton(ico);
            imagePanel.setBackground(Style.ColorConstants.LIGHTBG_COLOR);

            b.setBorder(BorderFactory.createLineBorder(Style.ColorConstants.LIGHTBG_COLOR, 10));
            b.add(imagePanel);
            InnerPanel.add(b);
            b.setPreferredSize(new Dimension(300, 400));

            imagePanel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(s.movie_name);
                    Color c = ((LineBorder) b.getBorder()).getLineColor();
                    if (c != Color.RED) {
                        SelectedMovies.add(s.movie_code);
                        b.setBorder(BorderFactory.createLineBorder(Color.RED, 10));
                    } else {
                        SelectedMovies.remove(s.movie_code);
                        b.setBorder(BorderFactory.createLineBorder(Style.ColorConstants.LIGHTBG_COLOR, 10));
                    }

                }
            });

        }
        Removebtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (String s : SelectedMovies) {
                    m.remove(Movies.getMovieObj(m, s));

                }

                Iterator<String> iterator = componentsMap.keySet().iterator();
                while (iterator.hasNext()) {
                    String s = iterator.next();
                    // Remove the old panel
                    JPanel oldPanel = componentsMap.get(s);
                    APP.remove(oldPanel);
                    iterator.remove(); // Remove the key from the map
                }

                // Create a new panel
                JPanel RemovePanel = Panels.RemoveMoviePanel(APP, m);
                JPanel AdminMovieAdd = Panels.AdminMovieAdd(APP, m);
                JPanel AdminShowAllMovie = Panels.AdminShowAllMoviePanel(APP, m);

                // Add the new panel to the mainPanel
                APP.add("RemoveMovie", RemovePanel);
                componentsMap.put("RemoveMovie", RemovePanel);

                APP.add("AdminMovieADDPage", AdminMovieAdd);
                componentsMap.put("AdminMovieADDPage", AdminMovieAdd);

                APP.add("AdminShowAllMovie", AdminShowAllMovie);
                componentsMap.put("AdminShowAllMovie", AdminShowAllMovie);

                // Update the layout
                APP.revalidate();
                APP.repaint();

                cardLayout.show(APP, thisPanelName);
            }

        });

        RemovePanel.addComponentListener(new java.awt.event.ComponentAdapter() {

            public void componentResized(ComponentEvent e) {
                Style.applyPercentageMargins(RemovePanel, MoviePanel, 0.05, 0.05); // 10% margins
                Style.applyPercentageSize(RemovePanel, title, 0.20, 0.05);

            }
        });
        return RemovePanel;
    }

    public static JPanel AdminViewAllUsersPanel(JPanel APP, LinkedList<User> u) {
        // String thisPanelName = "AdminViewAllUsers";
        JPanel UserPanel = new JPanel(new BorderLayout());
        JPanel InnerPanel = new JPanel(new BorderLayout());
        JPanel MoviePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Users");
        UserPanel.add(title, BorderLayout.NORTH);

        Style.applyPercentageMargins(UserPanel, MoviePanel, 0.20, 0.20);
        Style.applyPercentageSize(UserPanel, title, 0.20, 0.03);
        title.setFont(new Font("Arial", Font.PLAIN, 35));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBackground(Style.ColorConstants.BGCOLOR);
        title.setForeground(Color.WHITE);
        InnerPanel.setBackground(Style.ColorConstants.LIGHTBG_COLOR);
        MoviePanel.setBackground(Style.ColorConstants.BGCOLOR);
        UserPanel.setBackground(Style.ColorConstants.BGCOLOR);
        MoviePanel.add(InnerPanel);
        UserPanel.add(MoviePanel);

        // Column headers for the table
        String[] columnHeaders = { "Username", "Password", "First Name", "Last Name", "Email" };

        // Create the DefaultTableModel with the column headers
        DefaultTableModel model = new DefaultTableModel(columnHeaders, 0);

        // Populate the table model with data from the LinkedList<User>
        for (User user : u) {
            Object[] rowData = {
                    user.Username,
                    user.Password,
                    user.First_Name,
                    user.Last_Name,
                    user.EmailAddress
            };
            model.addRow(rowData);
        }

        // Create the JTable with the model
        JTable table = new JTable(model);
        // Add the table to a JScrollPane to enable scrolling
        JScrollPane scrollPane = new JScrollPane(table);

        InnerPanel.add(scrollPane);
        UserPanel.addComponentListener(new java.awt.event.ComponentAdapter() {

            public void componentResized(ComponentEvent e) {
                Style.applyPercentageMargins(UserPanel, MoviePanel, 0.05, 0.05); // 10% margins
                Style.applyPercentageSize(UserPanel, title, 0.20, 0.05);

            }
        });
        return UserPanel;

    }

    public static JPanel AdminChangePasswordPanel(JPanel APP) {
        // String thisPanelName = "AdminChangePassword";
        JPanel currentPassPanel = new JPanel(new GridLayout(2, 1, 0, 5));
        JLabel currentPassLabel = new JLabel("Current Password");
        JPasswordField currentPass = new JPasswordField();
        JApp.add(currentPassPanel, currentPassLabel, currentPass);

        JPanel newPassPanel = new JPanel(new GridLayout(2, 1, 0, 5));
        JLabel newPassLabel = new JLabel("new Password");
        JPasswordField newPass = new JPasswordField();
        JApp.add(newPassPanel, newPassLabel, newPass);

        JPanel confirmPassPanel = new JPanel(new GridLayout(2, 1, 0, 5));
        JLabel confirmPassLabel = new JLabel("Confirm Password");
        JPasswordField ConfirmPass = new JPasswordField();
        JApp.add(confirmPassPanel, confirmPassLabel, ConfirmPass);

        JButton Submit = Style.createButton("Change Password");
        JLabel error = new JLabel();
        error.setFont(new Font("Arial", Font.PLAIN, 24));
        error.setForeground(Color.RED);
        error.setHorizontalAlignment(SwingConstants.CENTER);
        error.setVisible(false);

        JPanel ChangePasswordPanel = new JPanel();
        ChangePasswordPanel.setLayout(new BorderLayout());

        JPanel InnerPanel = new JPanel();
        InnerPanel.setLayout(new GridLayout(5, 1, 0, 20));

        JApp.add(InnerPanel, currentPassPanel, newPassPanel, confirmPassPanel, Submit, error);

        JPanel panels[] = { currentPassPanel, newPassPanel, confirmPassPanel };
        JLabel labels[] = { currentPassLabel, newPassLabel, confirmPassLabel };
        JTextComponent inputs[] = { currentPass, newPass, ConfirmPass };
        for (JLabel l : labels) {
            l.setForeground(Color.WHITE);
            l.setFont(new Font("Arial", Font.PLAIN, 24));
        }
        for (JPanel p : panels) {
            p.setBackground(Style.ColorConstants.BGCOLOR);
        }
        for (JTextComponent p : inputs) {
            p.setFont(new Font("Arial", Font.PLAIN, 28));
            p.setPreferredSize(new Dimension(50, 100));
        }

        // sidePanel.add(settings);

        InnerPanel.setPreferredSize(new Dimension(300, 10));
        Style.applyPercentageMargins(ChangePasswordPanel, InnerPanel, 0.30, 0.05); // 10% margins

        // add(sidePanel, BorderLayout.WEST);
        ChangePasswordPanel.add(InnerPanel, BorderLayout.CENTER);

        InnerPanel.setBackground(Style.ColorConstants.BGCOLOR);

        Label title = new Label("Change Password");
        Style.applyPercentageSize(ChangePasswordPanel, title, 0.10, 0.20);
        title.setAlignment(Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setBackground(Style.ColorConstants.BGCOLOR);
        title.setForeground(Color.WHITE);
        ChangePasswordPanel.add(title, BorderLayout.NORTH);
        // Add a ComponentListener to handle resizing and adjust margins dynamically
        ChangePasswordPanel.addComponentListener(new java.awt.event.ComponentAdapter() {

            public void componentResized(ComponentEvent e) {
                Style.applyPercentageMargins(ChangePasswordPanel, InnerPanel, 0.30, 0.05); // 10% margins
                Style.applyPercentageSize(ChangePasswordPanel, title, 0.10, 0.20);
            }
        });

        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((new String(currentPass.getPassword()).trim().isEmpty() ||
                        new String(newPass.getPassword()).trim().isEmpty() ||
                        new String(ConfirmPass.getPassword()).trim().isEmpty())) {

                    error.setText("fill all fields");
                    error.setVisible(true);
                }

                else if (Admin.checkAdminLogin("ADMIN", new String(currentPass.getPassword()))) {
                    if (!(new String(newPass.getPassword()).trim().equals(
                            new String(ConfirmPass.getPassword()).trim()))) {
                        error.setText("new pass does'nt match");
                        error.setVisible(true);
                    } else {
                        Admin.setPassword(new String(currentPass.getPassword()).trim(),
                                new String(newPass.getPassword()).trim());
                        System.out.println("password setted");
                        currentPass.setText("");
                        newPass.setText("");
                        ConfirmPass.setText("");
                        error.setVisible(false);
                        cardLayout.show(APP, "AdminHomePage");
                    }
                } else {
                    error.setText("incorrect password");
                    error.setVisible(true);
                }
            }
        });

        return ChangePasswordPanel;

    }

    public static JPanel AdminShowMoviePanel(JPanel APP, Movies m) {
        JPanel showPanel = new JPanel(new BorderLayout());
        JPanel InnerPanel = new JPanel(new BorderLayout());
        JPanel MoviePanel = new JPanel(new BorderLayout());
        JPanel DetailsPanelWrapper = new JPanel(new BorderLayout());
        JPanel DetailsPanel = new JPanel(new GridLayout(5, 1));
        JPanel ImagePanel = new JPanel();
        JLabel title = new JLabel(m.movie_name);
        JLabel imagelabel = new JLabel();
        ImagePanel.add(imagelabel);

        ImagePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        ImagePanel.add(imagelabel, gbc);
        InnerPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        // Set the preferred size for the ImagePanel
        ImagePanel.setPreferredSize(new Dimension(200, 200));
        showPanel.add(title, BorderLayout.NORTH);
        DetailsPanelWrapper.setBackground(Style.ColorConstants.LIGHTBG_COLOR);
        DetailsPanel.setBackground(Style.ColorConstants.LIGHTBG_COLOR);
        ImagePanel.setBackground(Style.ColorConstants.BGCOLOR);
        InnerPanel.add(ImagePanel, BorderLayout.WEST);
        DetailsPanelWrapper.add(DetailsPanel);
        InnerPanel.add(DetailsPanelWrapper);
        Style.applyPercentageMargins(showPanel, MoviePanel, 0.20, 0.20);
        Style.applyPercentageMargins(InnerPanel, DetailsPanelWrapper, 0.15, 0.05);
        Style.applyPercentageSize(InnerPanel, ImagePanel, 0.30, 1);
        Style.applyPercentageSize(showPanel, title, 0.20, 0.03);
        title.setFont(new Font("Arial", Font.PLAIN, 35));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBackground(Style.ColorConstants.BGCOLOR);
        title.setForeground(Color.WHITE);
        InnerPanel.setBackground(Style.ColorConstants.LIGHTBG_COLOR);
        MoviePanel.setBackground(Style.ColorConstants.BGCOLOR);
        showPanel.setBackground(Style.ColorConstants.BGCOLOR);
        MoviePanel.add(InnerPanel);
        showPanel.add(MoviePanel);

        JPanel MovieCodePanel = new JPanel(new GridLayout(2, 1, 0, 5));
        JLabel MovieCodeLabel = new JLabel("Movie Code");
        JLabel MovieCode = new JLabel(m.movie_code);
        MovieCodePanel.add(MovieCodeLabel);
        MovieCodePanel.add(MovieCode);

        JPanel MovieNamePanel = new JPanel(new GridLayout(2, 1, 0, 5));
        JLabel MovieNameLabel = new JLabel("Movie Name");
        JLabel MovieName = new JLabel(m.movie_name);
        MovieNamePanel.add(MovieNameLabel);
        MovieNamePanel.add(MovieName);

        JPanel MovieDatePanel = new JPanel(new GridLayout(2, 1, 0, 5));
        JLabel MovieDateLabel = new JLabel("Movie Date");
        JLabel MovieDate = new JLabel(m.Movie_date);
        MovieDatePanel.add(MovieDateLabel);
        MovieDatePanel.add(MovieDate);

        JPanel MovieTimePanel = new JPanel(new GridLayout(2, 1, 0, 5));
        JLabel MovieTimeLabel = new JLabel("Movie Time");
        JLabel MovieTime = new JLabel(m.Time);
        MovieTimePanel.add(MovieTimeLabel);
        MovieTimePanel.add(MovieTime);

        JPanel MoviePricePanel = new JPanel(new GridLayout(2, 1, 0, 5));
        JLabel MoviePriceLabel = new JLabel("Movie Price");
        JLabel MoviePrice = new JLabel(m.movie_price + "");
        MoviePricePanel.add(MoviePriceLabel);
        MoviePricePanel.add(MoviePrice);

        JPanel panels[] = { MovieCodePanel, MovieNamePanel, MovieDatePanel, MovieTimePanel, MoviePricePanel };
        JLabel labels[] = { MovieCodeLabel, MovieNameLabel, MovieDateLabel, MovieTimeLabel, MoviePriceLabel };
        JLabel inputs[] = { MovieCode, MovieName, MovieDate, MovieTime, MoviePrice };
        for (JLabel l : labels) {
            l.setForeground(Color.WHITE); // Keep this white
            l.setFont(new Font("Arial", Font.BOLD, 36));
        }
        for (JPanel p : panels) {
            p.setBackground(Style.ColorConstants.LIGHTBG_COLOR);
        }
        for (JLabel p : inputs) {
            p.setForeground(Color.GRAY); // Keep this white
            p.setFont(new Font("Arial", Font.PLAIN, 32));
        }

        JApp.add(DetailsPanel, MovieCodePanel, MovieNamePanel, MovieDatePanel, MovieTimePanel,
                MoviePricePanel);

        showPanel.addComponentListener(new java.awt.event.ComponentAdapter() {

            public void componentResized(ComponentEvent e) {
                Style.applyPercentageMargins(showPanel, MoviePanel, 0.05, 0.05); // 10% margins
                Style.applyPercentageSize(showPanel, title, 0.20, 0.05);
                Style.applyPercentageSize(InnerPanel, ImagePanel, 0.30, 1);
                Style.applyPercentageMargins(InnerPanel, DetailsPanelWrapper, 0.15, 0.05);
                Style.applyPercentageSize(ImagePanel, imagelabel, 1, 1);

                ImageIcon ico = JApp.fitImage(m.img, 600, 600);
                imagelabel.setIcon(ico);
                APP.revalidate();
                APP.repaint();
            }
        });
        return showPanel;

    }

    public static JPanel AdminShowAllMoviePanel(JPanel APP, LinkedList<Movies> m) {

        String thisPanelName = "AdminShowAllMovie";
        JPanel RemovePanel = new JPanel(new BorderLayout());
        JPanel InnerPanel = new JPanel(new JApp.WrapLayout(FlowLayout.LEFT, 10, 20));
        JPanel MoviePanel = new JPanel(new BorderLayout());
        JScrollPane ScrollPane = new JScrollPane(InnerPanel);
        JLabel title = new JLabel("Now Streaming");
        RemovePanel.add(title, BorderLayout.NORTH);

        ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        Style.applyPercentageMargins(RemovePanel, MoviePanel, 0.20, 0.20);
        Style.applyPercentageSize(RemovePanel, title, 0.20, 0.03);
        title.setFont(new Font("Arial", Font.PLAIN, 35));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBackground(Style.ColorConstants.BGCOLOR);
        title.setForeground(Color.WHITE);
        InnerPanel.setBackground(Style.ColorConstants.LIGHTBG_COLOR);
        MoviePanel.setBackground(Style.ColorConstants.BGCOLOR);
        RemovePanel.setBackground(Style.ColorConstants.BGCOLOR);
        MoviePanel.add(ScrollPane);
        RemovePanel.add(MoviePanel);

        for (Movies s : m) {
            JPanel b = new JPanel();
            b.setLayout(new BorderLayout());
            ImageIcon ico = JApp.fitImage(s.img, 300, 600);
            JButton imagePanel = new JButton(ico);
            imagePanel.setBackground(Style.ColorConstants.LIGHTBG_COLOR);

            b.setBorder(BorderFactory.createLineBorder(Style.ColorConstants.LIGHTBG_COLOR, 10));
            b.add(imagePanel);
            InnerPanel.add(b);
            b.setPreferredSize(new Dimension(300, 400));

            imagePanel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JPanel p = componentsMap.get("AdminShowMovie");
                    if (p != null)
                        APP.remove(p);
                    componentsMap.remove("AdminShowMovie");

                    JPanel newPanel = Panels.AdminShowMoviePanel(APP, s);
                    APP.add("AdminShowMovie", newPanel);
                    componentsMap.put("AdminShowMovie", newPanel);
                    // Update the layout
                    APP.revalidate();
                    APP.repaint();
                    AppData.page_history.push(thisPanelName);
                    cardLayout.show(APP, "AdminShowMovie");
                }
            });

        }

        RemovePanel.addComponentListener(new java.awt.event.ComponentAdapter() {

            public void componentResized(ComponentEvent e) {
                Style.applyPercentageMargins(RemovePanel, MoviePanel, 0.05, 0.05); // 10% margins
                Style.applyPercentageSize(RemovePanel, title, 0.20, 0.05);
            }

        });
        return RemovePanel;
    }

    public static JPanel HomePanel(
            JPanel APP, LinkedList<User> list, LinkedList<Movies> m, User OBJ) {

                String thisPanelName = "Home Page";
        JPanel Home = new JPanel();
        Home.setLayout(new BorderLayout());
        Home.setBackground(Style.ColorConstants.BGCOLOR);
        Home.setBorder(new EmptyBorder(10, 20, 0, 20));

        JPanel NorthPanel = new JPanel();
    
        NorthPanel.setLayout(new GridBagLayout());
        NorthPanel.setBackground(Style.ColorConstants.BGCOLOR);

        GridBagConstraints g = new GridBagConstraints();
        NorthPanel.setPreferredSize(new Dimension(0, 300));

        Home.add(NorthPanel, "North");

        g.gridx = 0;
        g.gridy =0;
        g.fill = GridBagConstraints.HORIZONTAL;
        JLabel userName = new JLabel("Welcome " + " " + OBJ.First_Name);
        userName.setHorizontalAlignment(JLabel.CENTER);
        userName.setFont(new Font("Arial", Font.BOLD, 50));
        userName.setBackground(Style.ColorConstants.BGCOLOR);
        userName.setForeground(Color.WHITE);
        NorthPanel.add(userName,g);


        g.gridx = 0;
        g.gridy =1;
        g.fill = GridBagConstraints.HORIZONTAL;
        JButton ProfileLogo = new JButton();
        ProfileLogo.setBackground(Style.ColorConstants.BGCOLOR);
        ProfileLogo.setIcon(JApp.fitImage("Movie-Booking-System/Img/profile.png", 200, 200));
        ProfileLogo.setFocusPainted(false);
        ProfileLogo.setBorder(null);
        ProfileLogo.setContentAreaFilled(false);
        ProfileLogo.setToolTipText("Click Here to See Profile ");
        Style.applyPercentageMargins(ProfileLogo, NorthPanel, 0.30, 0.70); // 10% margins

        NorthPanel.add(ProfileLogo , g);

        JPanel CenterPanel = new JPanel();
        CenterPanel.setBackground(Style.ColorConstants.BGCOLOR);
        CenterPanel.setLayout(new GridBagLayout());

        JButton addTicket = Style.createButton("Movies");
        JButton cancleTicket = Style.createButton("Cancle Ticket");
        JButton showTicket = Style.createButton("Show History");

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
            AppData.page_history.push(thisPanelName);
                       
                        APP.add("Profile Page",  Panels.UserProfilePanel(APP, list ,OBJ));
                        componentsMap.put("Profile Page",  Panels.UserProfilePanel(APP, list ,OBJ));
                
                       cardLayout.show(APP, "Profile Page");

        });
        JApp.addListener("ActionListener", addTicket, "List", () -> {
            AppData.page_history.push(thisPanelName);
                       
                        APP.add("Movie Page",  Panels.MoviePanel(APP, m, OBJ, cardLayout));
                        componentsMap.put("Movie Page", Panels.MoviePanel(APP, m, OBJ, cardLayout));
                
                       cardLayout.show(APP, "Movie Page");



        });
        JApp.addListener("ActionListener", cancleTicket, "cancleTicket", () -> {
            AppData.page_history.push(thisPanelName);
                       
            APP.add("Cancle ticket Page",  Panels.removeTicket(APP,  OBJ, m , cardLayout));
            componentsMap.put("Cancle ticket Page", Panels.removeTicket(APP,  OBJ, m , cardLayout));
    
           cardLayout.show(APP, "Cancle ticket Page");
        });
        JApp.addListener("ActionListener", showTicket, "showTicket", () -> {
            AppData.page_history.push(thisPanelName);
                       
            APP.add("Show all ticket Page",  Panels.ShowAllTicketforUser(APP,  OBJ, m , cardLayout));
            componentsMap.put("Show all ticket Page", Panels.ShowAllTicketforUser(APP,  OBJ, m , cardLayout));
    
           cardLayout.show(APP, "Show all ticket Page");
        });

        return Home;
    }


    public static JPanel MoviePanel(JPanel APP, LinkedList<Movies> movieList,User obj, /*  LinkedList<Ticket> l */ CardLayout Layout ) {
        String thisPanelName = "Movie Page";

        JPanel MoviePanel = new JPanel(new BorderLayout());
        int col= 7;
    
   
        
        int rows = (int) Math.ceil((double) movieList.size() / col);

        JPanel section = new JPanel(new GridLayout(rows, col, 15, 70)); 

        section.setBorder(new EmptyBorder(100, 100, 100, 100));
        section.setBackground(Style.ColorConstants.BGCOLOR);
    
        for (Movies movie : movieList) {
            JPanel movieCard = new JPanel();
            movieCard.setLayout(new GridBagLayout());
            GridBagConstraints g = new GridBagConstraints();
            // movieCard.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            movieCard.setBackground(Style.ColorConstants.BGCOLOR);
    
            g.gridx = 0;
            g.gridy = 0;
            g.gridheight = 1;
            g.fill = GridBagConstraints.HORIZONTAL;
            g.insets = new Insets(4, 10, 4, 10);
            JLabel imgLabel = new JLabel(new ImageIcon(movie.img));
            imgLabel.setBackground(Style.ColorConstants.BGCOLOR);
            imgLabel.setForeground(Color.WHITE);
            movieCard.add(imgLabel, g);
    
            // Add movie name
            g.gridy = 1;
            JLabel nameLabel = new JLabel(movie.movie_name);
            nameLabel.setBackground(Style.ColorConstants.BGCOLOR);
            nameLabel.setForeground(Color.WHITE);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
            movieCard.add(nameLabel, g);
    
            // Add movie date
            g.gridy = 2;
            JLabel dateLabel = new JLabel("Date: " + movie.Movie_date);
            dateLabel.setBackground(Style.ColorConstants.BGCOLOR);
            dateLabel.setForeground(Color.WHITE);
            dateLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            movieCard.add(dateLabel, g);
    
            // Add movie time
            g.gridy = 3;
            JLabel timeLabel = new JLabel("Time: " + movie.Time);
            timeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            timeLabel.setBackground(Style.ColorConstants.BGCOLOR);
            timeLabel.setForeground(Color.WHITE);
            movieCard.add(timeLabel, g);
    
            // Add movie price
            g.gridy = 4;
            JLabel priceLabel = new JLabel("Price: $" + movie.movie_price);
            priceLabel.setBackground(Style.ColorConstants.BGCOLOR);
            priceLabel.setForeground(Color.WHITE);
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            movieCard.add(priceLabel, g);

            JApp.addListener("MouseListener", movieCard, movie.movie_name, () -> {
                Panels.selectedMoviePrice = movie.movie_price;
            
                AppData.page_history.push(thisPanelName);
                MovieNameLabel.setText(movie.movie_name);
                MovieOtherparameters.setText("movie code - " + movie.movie_code + " || Time - " + movie.Time + " || Date - " + movie.Movie_date + " || price - " + movie.movie_price);
         

                APP.add("Seat Page",  Panels.SeatPanel(APP, movieList,  movie.SEATS , movie ,obj, Layout));
                componentsMap.put("Seat Page",  Panels.SeatPanel(APP, movieList,  movie.SEATS , movie, obj , Layout));
        
               cardLayout.show(APP, "Seat Page");
            });
            
    
            // Add the movie card to the section panel
            section.add(movieCard);
        }
    
        // Add section to a scroll pane for scrolling support
        MoviePanel.add(new JScrollPane(section), BorderLayout.CENTER);
    
        return MoviePanel;
    }

    static List<JButton> selectedSeats = new ArrayList<>();  // Track selected seats

    public static JPanel SeatPanel(JPanel APP, LinkedList<Movies> movieList, JButton[] SEATS, Movies movie, User obj, CardLayout Layout) {
        int i = 0;
    
        JButton proceed = Style.createButton(String.format("Pay Rs %.2f", Panels.selectedMoviePrice));
        String thisPanelName = "Seat Page";
        JPanel seatsPanel = new JPanel();
        seatsPanel.setLayout(new BorderLayout());
        seatsPanel.setBackground(Style.ColorConstants.BGCOLOR);
    
        JPanel NorthPanel = new JPanel();
        NorthPanel.setLayout(new BorderLayout());
        NorthPanel.setBackground(Style.ColorConstants.BGCOLOR);
        NorthPanel.setBorder(new EmptyBorder(10, 60, 0, 0));
    
        JPanel coverpanel = new JPanel();
        coverpanel.setLayout(new GridLayout(2, 1));
        coverpanel.setBackground(Style.ColorConstants.BGCOLOR);
    
        MovieNameLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        MovieNameLabel.setBackground(Style.ColorConstants.BGCOLOR);
        MovieNameLabel.setForeground(Color.WHITE);
    
        MovieOtherparameters.setFont(new Font("Arial", Font.PLAIN, 15));
        MovieOtherparameters.setBackground(Style.ColorConstants.BGCOLOR);
        MovieOtherparameters.setForeground(Color.WHITE);
    
        JApp.add(coverpanel, MovieNameLabel, MovieOtherparameters);
        NorthPanel.add(coverpanel, "West");
        seatsPanel.add(NorthPanel, BorderLayout.NORTH);
    
        JPanel bottom = new JPanel();
        JPanel selectedseat = new JPanel();
    
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(Style.ColorConstants.BGCOLOR);
    
        GridBagConstraints g = new GridBagConstraints();
        g.gridx = 0;
        g.gridy = 0;
        g.gridheight = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(4, 10, 100, 10);
        JPanel seatarrangment = new JPanel();
        centerPanel.add(seatarrangment, g);
    
        g.gridx = 0;
        g.gridy = 2;
        g.gridheight = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(4, 10, 4, 10);
        JPanel Display = new JPanel();
        Display.setBackground(Style.ColorConstants.BGCOLOR);
        JLabel l = new JLabel(new ImageIcon("Movie-Booking-System/Img/display.png"));
        Display.add(l);
        centerPanel.add(Display, g);
    
        seatarrangment.setBackground(Style.ColorConstants.BGCOLOR);
        seatarrangment.setLayout(new GridLayout(5, 5, 20, 20));
    
        // Initialize the seat buttons array before using it
        JButton[] seats = movie.SEATS;
    
        for (i = seats.length; i >= 1; i--) {
            seats[i - 1] = new JButton(String.valueOf(i)); // Initialize the button here
    
            if (movie.seatStates[i - 1]) {
                // Seat is taken (already selected)
                seats[i - 1].setEnabled(false);
                seats[i - 1].setBackground(Color.GRAY);
            } else {
                // Seat is available
                seats[i - 1].setBackground(Color.WHITE);
            }
    
            seats[i - 1].setPreferredSize(new Dimension(60, 60));
    
            seats[i - 1].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    bottom.setVisible(false);
                    seatsPanel.remove(bottom);
                    seatsPanel.add(selectedseat, "South");
    
                    JButton selectedButton = (JButton) e.getSource();
    
                    if (selectedButton.getBackground() == Color.GREEN) {
                      
                        selectedButton.setBackground(Color.WHITE);
                        double PRICE = Double.parseDouble(proceed.getText().replaceAll("[^\\d.]", ""));
                        PRICE -= Panels.selectedMoviePrice; 
                        proceed.setText(String.format("Pay Rs %.2f", PRICE));
    
                        selectedSeats.remove(selectedButton);  
                        movie.seatStates[Integer.parseInt(selectedButton.getText()) - 1] = false;  // Mark seat as available
                    } else {
                        // Check if 3 seats are selected
                        if (selectedSeats.size() < 3) {
                            selectedButton.setBackground(Color.GREEN);
                            double PRICE = Double.parseDouble(proceed.getText().replaceAll("[^\\d.]", ""));
                            PRICE += Panels.selectedMoviePrice;  
                            proceed.setText(String.format("Pay Rs %.2f", PRICE));
    
                            selectedSeats.add(selectedButton);
                        } else {
                          
                            JOptionPane.showMessageDialog(seatsPanel, "You can only select up to 3 seats.");
                        }
                    }
                }
            });
    
            seatarrangment.add(seats[i - 1]);
        }
    
        seatsPanel.add(centerPanel);
    
        selectedseat.add(proceed);
    
        seatsPanel.add(selectedseat, "South");
    
        JApp.addListener("ActionListener", proceed, "click", () -> {
            AppData.page_history.push(thisPanelName);
            APP.add("ticket Page", Panels.TicketGenerationPanel(APP, movie, obj, selectedSeats, cardLayout));
            componentsMap.put("ticket Page", Panels.TicketGenerationPanel(APP, movie, obj, selectedSeats, cardLayout));
            cardLayout.show(APP, "ticket Page");
        });
    
        JLabel Available = new JLabel("Available");
        JLabel Disable = new JLabel("Disabled");
        JLabel selected = new JLabel("Selected");
    
        JApp.add(bottom, Available, Disable, selected);
        seatsPanel.add(bottom, "South");
    
        return seatsPanel;
    }
    
    public static JPanel TicketGenerationPanel(JPanel APP, Movies movie , User obj ,  List<JButton> selectedSeats  , CardLayout Layout ){

        JPanel TicektPanel = new JPanel(new BorderLayout());

        TicektPanel.setBackground(Style.ColorConstants.BGCOLOR);
        List<Integer> selectedSeatNumbers = new ArrayList<>();
        for (JButton seat : selectedSeats) {
            
            selectedSeatNumbers.add(Integer.parseInt(seat.getText()));
        }
        Collections.sort(selectedSeatNumbers);
        String seatText = selectedSeatNumbers.toString().replace("[", "").replace("]", ""); // Remove brackets


        JLabel TheaterName = new JLabel("INOX",JApp.fitImage("Movie-Booking-System/Img/inox logo.png", 70, 70),JLabel.CENTER);
       
        TheaterName.setFont(new Font("Arial", Font.BOLD, 50));
        TheaterName.setBackground(Style.ColorConstants.BGCOLOR);
        TheaterName.setForeground(Color.WHITE);

        TicektPanel.add(TheaterName,"North");

        JPanel outerPanel = new JPanel(new GridBagLayout());
        outerPanel.setBackground(Style.ColorConstants.BGCOLOR);


        GridBagConstraints g = new GridBagConstraints();

        g.gridx = 0;
        g.gridy = 0;
        g.gridheight = 1;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(4, 10, 4, 10);
        JPanel innerPanel = new JPanel(new GridBagLayout());
        innerPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 7, 0, Color.RED));
        

        outerPanel.add(innerPanel,g);
        // innerPanel.setPreferredSize(new Dimension(700,800));



        g.gridx = 0;
        g.gridy = 0;
        g.gridheight = 1;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(4, 10, 4, 10);
        JLabel movieImg = new JLabel(new ImageIcon("Movie-Booking-System/Img/Avengers.jpeg"));
        innerPanel.add(movieImg,g);

        
        g.gridx = 1;
        g.gridy = 0;
        g.gridheight = 1;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(4, 10, 4, 10);
        JPanel MovieDetails = new JPanel(new GridBagLayout());
        innerPanel.add(MovieDetails,g);

                    g.gridx = 0;
                    g.gridy = 0;
                    g.gridheight = 1;
                    g.gridwidth = 1;
                    g.fill = GridBagConstraints.HORIZONTAL;
                    g.insets = new Insets(0, 10, 20, 10);
                    JLabel MovieName = new JLabel("Movie name - " + movie.movie_name);
                    MovieName.setFont(new Font("Arial", Font.BOLD, 20));
                    MovieDetails.add(MovieName,g);

        
                    g.gridx = 0;
                    g.gridy = 1;
                    g.gridheight = 1;
                    g.gridwidth = 1;
                    g.fill = GridBagConstraints.HORIZONTAL;
                    g.insets = new Insets(7, 10, 7, 10);
                    JLabel MovieCode = new JLabel("Movie Code - " + movie.movie_code);
                    MovieCode.setFont(new Font("Arial", Font.PLAIN, 20));
                    MovieDetails.add(MovieCode,g);

        
                    g.gridx = 0;
                    g.gridy = 3;
                    g.gridheight = 1;
                    g.gridwidth = 1;
                    g.fill = GridBagConstraints.HORIZONTAL;
                    g.insets = new Insets(7, 10, 7, 10);
                    JLabel MovieDate = new JLabel("Date - " + movie.Movie_date + " || Time - " + movie.Time);
                    MovieDate.setFont(new Font("Arial", Font.PLAIN, 20));
                    MovieDetails.add(MovieDate,g);

                    g.gridx = 0;
                    g.gridy = 4;
                    g.gridheight = 1;
                    g.gridwidth = 1;
                    g.fill = GridBagConstraints.HORIZONTAL;
                    g.insets = new Insets(7, 10, 7, 10);
                    JLabel MoviePrice = new JLabel("Price - " + movie.movie_price);
                    MoviePrice.setFont(new Font("Arial", Font.PLAIN, 20));
                    MovieDetails.add(MoviePrice,g);

        


        g.gridx = 0;
        g.gridy = 1;
        g.gridheight = 1;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(4, 10, 4, 10);
        JPanel innerPanel2 = new JPanel(new GridLayout(1,2));
        outerPanel.add(innerPanel2,g);

        JPanel left = new JPanel(new GridLayout(2,1));
        left.setBorder(BorderFactory.createMatteBorder(0, 0,0 , 7, Style.ColorConstants.BGCOLOR));
        innerPanel2.add(left);


                 
                   JLabel screen = new JLabel("Screen",JLabel.CENTER);
                   screen.setFont(new Font("Arial", Font.PLAIN, 20));
                   
                left.add(screen);

                 
                   JLabel screenName = new JLabel("AUDI 1",JLabel.CENTER);
                   screenName.setFont(new Font("Arial", Font.BOLD, 30));
                     left.add(screenName);


       
         JPanel right = new JPanel(new GridLayout(2,1));
         right.setBorder(BorderFactory.createMatteBorder(0, 7,0 , 0, Style.ColorConstants.BGCOLOR));
         innerPanel2.add(right);


                    JLabel Seates = new JLabel("SEATS",JLabel.CENTER);
                    Seates.setFont(new Font("Arial", Font.PLAIN, 15));
                    right.add(Seates);

                 
                    JLabel SeatsName = new JLabel(seatText,JLabel.CENTER);
                    SeatsName.setFont(new Font("Arial", Font.BOLD, 30));
                    right.add(SeatsName);



        g.gridx = 0;
        g.gridy = 2;
        g.gridheight = 1;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(4, 10, 4, 10);
        JPanel innerPanel3 = new JPanel(new GridBagLayout());
        innerPanel3.setPreferredSize(new Dimension(350,350));
        innerPanel3.setBackground(Color.WHITE);
        outerPanel.add(innerPanel3,g);


                g.gridx = 0;
                g.gridy = 0;
                g.gridheight = 1;
                g.gridwidth = 1;
                g.fill = GridBagConstraints.HORIZONTAL;
                g.insets = new Insets(4, 10, 4, 10);
                JLabel qr = new JLabel(JApp.fitImage("Movie-Booking-System/Img/QR.png", 300, 300));
                innerPanel3.add(qr,g);


        TicektPanel.add(outerPanel);



        JButton confirm = Style.createButton("CONFIRM", Color.RED);
        JButton cancel = Style.createButton("CANCLE");

        JPanel bottom = new JPanel();

        bottom.add(confirm);
        bottom.add(cancel);

        TicektPanel.add(bottom,"South");


        JApp.addListener("ActionListener", confirm, "confirm ticket", () -> {
             List<Integer> seatNumbers = new ArrayList<>(); 
            for (JButton selectedSeat : selectedSeats) {
                selectedSeat.setEnabled(false);
                selectedSeat.setBackground(Color.GRAY);
                selectedSeat.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); 
        
              
                int seatIndex = Integer.parseInt(selectedSeat.getText()) - 1;
                movie.seatStates[seatIndex] = true;
        
               seatNumbers.add(seatIndex + 1);
            }
        
            // Clear selected seats after booking
            selectedSeats.clear();
        
         
            Ticket ticket = new Ticket(movie.movie_name, movie.movie_code, "INOX", seatNumbers,
                                       movie.Movie_date + " " + movie.Time, movie.movie_price);
        
    
            Ticket.addTicketToUser(obj, ticket);

            cardLayout.show(APP,"Home Page");

        });
        


        JApp.addListener("ActionListener", cancel, "Cancle ticket", ()->{
            
            for (JButton selectedSeat : selectedSeats) {  
                selectedSeat.setBackground(Color.white);
            }
            selectedSeats.clear();
            cardLayout.show(APP, "Seat Page");
          
        });


        return TicektPanel;
    }


    public static JPanel ShowAllTicketforUser(JPanel APP, User obj , LinkedList<Movies> movieList  , CardLayout Layout ){

        JPanel main = new JPanel(new BorderLayout());

        JPanel center = Panels.ShowAllTicket(APP , movieList ,obj.l,false);

        main.add(center);

        return main;
    }


    public static JPanel removeTicket(JPanel APP, User obj , LinkedList<Movies> movieList  , CardLayout Layout ){

        JPanel centerPanel = new JPanel(new BorderLayout());

        JPanel section = Panels.ShowAllTicket(APP , movieList ,obj.l,true);

        centerPanel.add(section);

        return centerPanel;
    }
    


    public static JPanel ShowAllTicket(JPanel APP, LinkedList<Movies> movieList  ,LinkedList<Ticket> l , Boolean setMouseListernerOn) {
       
        JPanel centerPanel = new JPanel(new BorderLayout());
    
     
        JPanel section = new JPanel(new GridBagLayout());
        section.setBorder(new EmptyBorder(100, 100, 100, 100));
        section.setBackground(Style.ColorConstants.BGCOLOR);
    
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(20, 20, 20, 20); 
    
        int colCount = 3; 
        int currentRow = 0; 
        int currentCol = 0; 
    
        for (Ticket clickedTicket : l) {
         
            JPanel innerPanel = new JPanel(new GridBagLayout());
            innerPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 7, 0, Color.RED));
    
          
            g.gridx = 0;
            g.gridy = 0;
            g.gridwidth = 1;
            g.gridheight = 1;
            g.fill = GridBagConstraints.HORIZONTAL;
            JLabel movieImg = new JLabel(new ImageIcon("Movie-Booking-System/Img/Avengers.jpeg"));
            innerPanel.add(movieImg, g);
    
       
            g.gridx = 1;
            g.gridy = 0;
            g.gridwidth = 1;
            g.gridheight = 1;
            g.fill = GridBagConstraints.HORIZONTAL;
            JPanel movieDetails = new JPanel(new GridBagLayout());
            innerPanel.add(movieDetails, g);
    
          
            g.gridx = 0;
            g.gridy = 0;
            g.gridwidth = 1;
            g.gridheight = 1;
            g.fill = GridBagConstraints.HORIZONTAL;
            JLabel movieName = new JLabel("Movie name - " + clickedTicket.movieName);
            movieName.setFont(new Font("Arial", Font.BOLD, 20));
            movieDetails.add(movieName, g);
    
            g.gridy = 1;
            JLabel movieCode = new JLabel("Movie Code - "+ clickedTicket.movieCode);
            movieCode.setFont(new Font("Arial", Font.PLAIN, 20));
            movieDetails.add(movieCode, g);
    
            g.gridy = 2;
            JLabel movieDate = new JLabel("Date - " + clickedTicket.dateTime );
            movieDate.setFont(new Font("Arial", Font.PLAIN, 20));
            movieDetails.add(movieDate, g);
    
            g.gridy = 3;
            JLabel moviePrice = new JLabel("Price - "+ clickedTicket.price);
            moviePrice.setFont(new Font("Arial", Font.PLAIN, 20));
            movieDetails.add(moviePrice, g);
    
       
            GridBagConstraints gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = currentCol;
            gridConstraints.gridy = currentRow;
            gridConstraints.insets = new Insets(15, 15, 15, 15);
            gridConstraints.anchor = GridBagConstraints.CENTER;
            section.add(innerPanel, gridConstraints);
    
          
            currentCol++;
            if (currentCol == colCount) {
                currentCol = 0; 
                currentRow++;
            }

           if(setMouseListernerOn){JApp.addListener("MouseListener", innerPanel, "CurrentTicket", () -> {
                int valueSelected = JOptionPane.showConfirmDialog(section, "Click OK to cancel the ticket.", "Ticket Cancellation", JOptionPane.YES_NO_OPTION);
    
                        if (valueSelected == JOptionPane.YES_OPTION) {
                            Iterator<Ticket> iterator = l.iterator();
                            while (iterator.hasNext()) {
                                Ticket t = iterator.next();
                                if (t.equals(clickedTicket)) {
                                 
                                    for (Movies m : movieList) {
                                        if (m.movie_code.equals(t.movieCode)) {
                                            Movies.resetSeats(t.seatNumbers, m.SEATS, m.seatStates);
                                            t.seatNumbers.clear();
                                        }
                                    }
                                    
                                
                                 
                                    iterator.remove();  
                                    section.remove(innerPanel);
                                   
                                    
    
                                    section.revalidate();
                                    section.repaint();
                                    break;
                                }
                            }
                        } else if (valueSelected == JOptionPane.NO_OPTION) {
            
                        }
            });
}
        }
    
      
        JScrollPane scrollPane = new JScrollPane(section, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
    
        centerPanel.add(scrollPane, BorderLayout.CENTER);
    
        return centerPanel;
    }
    


    public static JPanel ShowAllTicket(JPanel APP) {

        JPanel main = new JPanel();




        return main;


    }

    public static JPanel UserProfilePanel(JPanel APP, LinkedList<User> list, User obj) {
        JPanel profilePanel = new JPanel(new BorderLayout());
        profilePanel.setBackground(Style.ColorConstants.BGCOLOR);
    
        JLabel title = new JLabel("User Profile");
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        profilePanel.add(title, BorderLayout.NORTH);
    
        JPanel infoPanel = new JPanel(new GridLayout(7, 2, 30, 30));
        infoPanel.setBorder(new EmptyBorder(200, 0, 200, 200));
        infoPanel.setBackground(Style.ColorConstants.BGCOLOR);
    
        JLabel firstNameLabel = new JLabel("First Name:", JLabel.CENTER);
        firstNameLabel.setFont(new Font("Arial", Font.BOLD, 50));
        firstNameLabel.setForeground(Color.WHITE);
        infoPanel.add(firstNameLabel);
    
        JTextField firstNameField = new JTextField(obj.First_Name);
        firstNameField.setFont(new Font("Arial", Font.PLAIN, 40));
        firstNameField.setEditable(false);
        infoPanel.add(firstNameField);
    
        JLabel lastNameLabel = new JLabel("Last Name:", JLabel.CENTER);
        lastNameLabel.setFont(new Font("Arial", Font.BOLD, 50));
        lastNameLabel.setForeground(Color.WHITE);
        infoPanel.add(lastNameLabel);
    
        JTextField lastNameField = new JTextField(obj.Last_Name);
        lastNameField.setFont(new Font("Arial", Font.PLAIN, 40));
        lastNameField.setEditable(false);
        infoPanel.add(lastNameField);
    
        JLabel mobileNoLabel = new JLabel("Mobile No:", JLabel.CENTER);
        mobileNoLabel.setFont(new Font("Arial", Font.BOLD, 50));
        mobileNoLabel.setForeground(Color.WHITE);
        infoPanel.add(mobileNoLabel);
    
        JTextField mobileNoField = new JTextField(obj.Mobile_No);
        mobileNoField.setFont(new Font("Arial", Font.PLAIN, 40));
        mobileNoField.setEditable(false);
        infoPanel.add(mobileNoField);
    
        JLabel usernameLabel = new JLabel("Username:", JLabel.CENTER);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 50));
        usernameLabel.setForeground(Color.WHITE);
        infoPanel.add(usernameLabel);
    
        JTextField usernameField = new JTextField(obj.Username);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 40));
        usernameField.setEditable(false);
        infoPanel.add(usernameField);
    
        JLabel emailLabel = new JLabel("Email Address:", JLabel.CENTER);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 50));
        emailLabel.setForeground(Color.WHITE);
        infoPanel.add(emailLabel);
    
        JTextField emailField = new JTextField(obj.EmailAddress);
        emailField.setFont(new Font("Arial", Font.PLAIN, 40));
        emailField.setEditable(false);
        infoPanel.add(emailField);

        JLabel error = new JLabel("Fill all fields");
        error.setFont(new Font("Arial", Font.PLAIN, 24));
        error.setForeground(Color.RED);
        error.setHorizontalAlignment(SwingConstants.CENTER);
        infoPanel.add(error);
        error.setVisible(false);

    
        // Add the info panel to the main profile panel
        profilePanel.add(infoPanel, BorderLayout.CENTER);
    
        // Add Edit and Save buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Style.ColorConstants.BGCOLOR);
        
        JButton editButton = Style.createButton("Edit Profile");
        editButton.setFont(new Font("Arial", Font.PLAIN, 24));
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNameField.setEditable(true);
                lastNameField.setEditable(true);
                mobileNoField.setEditable(true);
                usernameField.setEditable(true);
                emailField.setEditable(true);
                editButton.setEnabled(false); // Disable edit button
            }
        });
    
        JButton saveButton = Style.createButton("Save");
        saveButton.setFont(new Font("Arial", Font.PLAIN, 24));
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                    if (!(usernameField.getText().trim().isEmpty() ||
                    firstNameField.getText().isEmpty() ||
                    lastNameField.getText().isEmpty() ||
                    emailField.getText().isEmpty()|| mobileNoField.getText().isEmpty() )) {
                        if (User.isUserExists(list, usernameField.getText())) {
                            error.setText("Username already exists");
                            error.setVisible(true);
                        } else if (usernameField.getText().trim().equals("ADMIN") || usernameField.getText().trim().equals("Admin")
                                || usernameField.getText().equals("admin")) {
                            error.setText("cant set username to " + usernameField.getText().trim());
                            error.setVisible(true);
                        }else if (JApp.containsDigit(firstNameField.getText().trim()) || JApp
                                .containsDigit(lastNameField.getText().trim())) {
                            error.setText("can't enter numbers in the name field");
                            error.setVisible(true);
    
                        } else if (!User.isEmail(emailField.getText())) {
                            error.setText("Enter valid email address");
                            error.setVisible(true);
                        } else if (mobileNoField.getText().length() != 10 || !mobileNoField.getText().matches("\\d{10}")) {
                            error.setText("Enter a valid mobile number (e.g., 9665743902)");
                            error.setVisible(true);
                        }else {
                          
                            obj.Username = usernameField.getText().trim();
                            obj.First_Name = firstNameField.getText();
                            obj.Last_Name = lastNameField.getText();
                            obj.EmailAddress = emailField.getText();
                            obj.Mobile_No = mobileNoField.getText();
    

                            error.setVisible(false);

                            
                     
                            firstNameField.setEditable(false);
                            lastNameField.setEditable(false);
                            mobileNoField.setEditable(false);
                            usernameField.setEditable(false);
                            emailField.setEditable(false);
                            
                            editButton.setEnabled(true);

                            JOptionPane.showMessageDialog(APP, "Profile Updated successfully", "Profile Updation", JOptionPane.INFORMATION_MESSAGE);
                        }
    
                    } else {
                        error.setVisible(true);
                    }
                
                


            }
        });
    
        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);
        
        profilePanel.add(buttonPanel, BorderLayout.SOUTH);
    
        return profilePanel;
    }
    

}







public class App2 extends JFrame {
    private static HashMap<String, JPanel> componentsMap = new HashMap<>();

    // this is changes

    App2() {
        this.setSize(600, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Style.ColorConstants.BGCOLOR);
        this.setTitle("INOX Theater");
        this.setLayout(new BorderLayout());
        Panels.updateHashMap(componentsMap);
        LinkedList<Movies> m = AppData.fetchMovieLinkedList();
        LinkedList<User> list = AppData.fetchUserLinkedList();
       
// dummy






        System.out.println(AppData.fetchAdminPass());
        if (AppData.fetchAdminPass() != null)
            Admin.initialize(AppData.fetchAdminPass().getPassword());

        else
            Admin.initialize("111");

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
        componentsMap.put("Welcome", Panels.welcomePanel(mainPanel));
       

        mainPanel.add("Login", Panels.loginPanel(mainPanel, list, m));
        componentsMap.put("Login", Panels.loginPanel(mainPanel, list, m));

        mainPanel.add("Signup", Panels.signUpPanel(mainPanel, list));
        componentsMap.put("Signup", Panels.signUpPanel(mainPanel, list));

        mainPanel.add("AdminHomePage", Panels.AdminHomePanel(mainPanel, m, list));
        componentsMap.put("AdminHomePage", Panels.AdminHomePanel(mainPanel, m, list));

        mainPanel.add("AdminMovieADDPage", Panels.AdminMovieAdd(mainPanel, m));
        componentsMap.put("AdminMovieADDPage", Panels.AdminMovieAdd(mainPanel, m));

        mainPanel.add("AdminChangePassword", Panels.AdminChangePasswordPanel(mainPanel));
        componentsMap.put("AdminChangePassword", Panels.AdminChangePasswordPanel(mainPanel));

        mainPanel.add("AdminViewAllUsers", Panels.AdminViewAllUsersPanel(mainPanel, list));
        componentsMap.put("AdminViewAllUsers", Panels.AdminViewAllUsersPanel(mainPanel, list));

        mainPanel.add("AdminShowAllMovie", Panels.AdminShowAllMoviePanel(mainPanel, m));
        componentsMap.put("AdminShowAllMovie", Panels.AdminShowAllMoviePanel(mainPanel, m));

        mainPanel.add("RemoveMovie", Panels.RemoveMoviePanel(mainPanel, m));
        componentsMap.put("RemoveMovie", Panels.RemoveMoviePanel(mainPanel, m));
        // Panels.cardLayout.show(mainPanel, "AdminViewAllUsers");


        // mainPanel.add("Ticket Generation section", Panels.TicketGenerationPanel(mainPanel, m, l));
        // componentsMap.put("Ticket Generation section", Panels.TicketGenerationPanel(mainPanel, m, l));

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!AppData.page_history.isEmpty()) {

                    String popelement = AppData.page_history.pop();
                    if (popelement == "Seat Page") {
                          
                        for (JButton selectedSeat : Panels.selectedSeats) {  
                            selectedSeat.setBackground(Color.white);
                        }
                        Panels.selectedSeats.clear();
                        Panels.cardLayout.show(mainPanel, "Seat Page");
                      
                    
                    }else{

                        Panels.cardLayout.show(mainPanel, popelement);
                    }

                }
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                AppData.StoreMovieLinkedList(m);
                System.out.println("movies data saved sucessfully");

                AppData.StoreUserLinkedList(list);
                System.out.println("user data saved succesfully");
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

        AppData.StoreMovieLinkedList(m);
        // System.out.println("movies data saved sucessfully");

        AppData.StoreUserLinkedList(list);
        // System.out.println("user data saved succesfully");

        // AutoSave.stopThread();
    }
}
