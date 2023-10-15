/*I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
Any code taken from other sources is referenced within my code solution.
Student Name: Krishnaanantham Samahithan
Student ID:  IIT :20210863,  westminster :- w1953875
Date: 23/03/2023*/
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class Theater {
    static String name;
    static String surName;
    static String email;
    static int rowNo;
    static int seatNo;

    public static  ArrayList<Ticket> tickets = new ArrayList<>(); //create a array list to add details from ticket class contructor.
    private static final int[] rows = {1, 2, 3}; // create a array rows with the row values
    private static final int[] seatCountPerRow = {12, 16, 20}; // create a arry seatCoutPerRow to indent the seat count per row
    private static int[][] seat = new int[3][]; // create a 2d array to handle row and seats with their index
    private static final int seatCountInROW_1 = 12;
    private static final int seatCountInROW_2 = 16;
    private static final int seatCountInROW_3 = 20;

    public static void StartProgram() //Method to print welcome message
    {
        Print();
        System.out.println("*** WELCOME TO NEW THEATERS ***");
        Print_seating_area();
        System.out.println("Check the Seating plan and Book your Seat.");
    }

    public static void Print() // Method to print 50 "-" in vertical
    {
        String dash = "-";
        System.out.println(dash.repeat(50));
    }

// Method for validate and resuse the row and seat input selection and use it for buy mutiple ticket with the same person
public static void Buy_more_ticket(){
    Scanner input = new Scanner(System.in);
    while (true) {
        // loop until valid row number is entered
        while (true) {
            System.out.print("Enter the row number from (1-3): ");
            // loop until integer input is received
            while (!input.hasNextInt()) {
                System.out.println("Input Invalid Please Check the row number and try again.");
                System.out.print("Enter the row number from (1-3): ");
                input.next();
            }
            // assign the input to rowNo variable
            rowNo = input.nextInt();
            // check if row number is between 1 and 3 inclusive
            if (rowNo < 1 || rowNo > 3) {
                System.out.println("Input Invalid Please Check the row number and try again.");
            } else {
                break;
            }
        }
        // loop until valid seat number is entered
        while (true) {
            // display seat number range based on selected row
            System.out.print("Enter seat number (1-" + Row_per_seat(rowNo) + "): ");
            // loop until integer input is received
            while (!input.hasNextInt()) {
                System.out.println("Input Invalid Please Check the seat number and try again.");
                System.out.print("Enter seat number (1-" + Row_per_seat(rowNo) + "): ");
                input.next();
            }
            // assign the input to seatNo variable
            seatNo = input.nextInt();
            // check if seat number is between 1 and maximum seat number in selected row inclusive
            if (seatNo < 1 || seatNo > Row_per_seat(rowNo)) {
                System.out.println("Input Invalid Please Check the seat number and try again.");
            } else if (seat[rowNo - 1][seatNo - 1] == 1) { // check if the seat is already booked
                System.out.println("Sorry! This seat already booked please try another seat number.");
            } else {
                break;
            }
        }
        double price = 0; // initialize the price// Set the seat at the specified row and seat number as purchased (represented by 1)
        seat[rowNo - 1][seatNo - 1] = 1;

        // Print a success message with the row and seat number that was purchased
        System.out.println("Row No " + rowNo + " and Seat No " + seatNo + " SUCCESSFULLY PURCHASED.");

        // Create a new Person object with the provided name, surname, and email
        Person person = new Person(name, surName, email);

        // Create a new Ticket object with the Person object, row number, seat number, and price
        Ticket ticket = new Ticket(person, rowNo, seatNo, price);

        // Add the newly created Ticket object to the tickets list
        tickets.add(ticket);

        // Print the updated seating chart
        Print();

        // Exit the loop
        break;
        }
    }
    // Define a public static method called Buy_ticket that does not return anything
    public static void Buy_ticket()
    {
        // Create a new Scanner object called input to read user input from the console
        Scanner input = new Scanner(System.in);

        // Use a while loop to repeat the ticket purchase process indefinitely
        while (true) {

            // Use nested while loops to ensure that the user enters valid input for each field
            while (true) {
                // Prompt the user to enter their name
                System.out.print("Enter Your Name: ");

                // Use a while loop to keep asking for input until the user enters a valid name
                while (!input.hasNext("[A-Za-z]+")) {
                    System.out.println("Name invalid format .");
                    System.out.print("Enter Your Name: ");
                    input.next();
                }

                // Assign the user's name to the name variable
                name = input.next();

                // Prompt the user to enter their surname
                System.out.print("Enter Your Sur Name: ");

                // Email validation refer from ("https://mailtrap.io/blog/java-email-validation/")
                // Use a while loop to keep asking for input until the user enters a valid surname
                while (!input.hasNext("[A-Za-z]+")) {
                    System.out.println("Sur Name invalid format .");
                    System.out.print("Enter Your Sur Name: ");
                    input.next();
                }

                // Assign the user's surname to the surName variable
                surName = input.next();

                // Prompt the user to enter their email address
                System.out.print("Enter Your Email: ");

                // Use a while loop to keep asking for input until the user enters a valid email address
                while (!input.hasNext("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                    System.out.println("Name invalid format .");
                    System.out.print("Enter Your Email: ");
                    input.next();
                }

                // Assign the user's email address to the email variable
                email = input.next();

                // Exit the inner while loop once all fields have been successfully entered
                break;
            }
            // Call the Buy_more_ticket method to allow the user to purchase additional tickets
            Buy_more_ticket();

            // Use another while loop to ask the user if they want to buy more tickets or exit
            while (true) {
                System.out.println("Do you want to Book more seats (y/n): ");

                // Read the user's response from the console
                String ask = input.next();

                // If the user wants to buy more tickets, call the Buy_more_ticket method again
                if (ask.equalsIgnoreCase("y")) {
                    Buy_more_ticket();
                }

                // If the user does not want to buy more tickets, exit the outer while loop and end the ticket purchase process
                else if (ask.equalsIgnoreCase("n")) {
                    break;
                }

                // If the user enters invalid input, display an error message and ask again
                else {
                    System.out.println("Invalid input");
                }
            }

            // Exit the outer while loop once the ticket purchase process is complete
            break;
        }
    }

    // Define a public static method called Print_seating_area that does not return anything
    public static void Print_seating_area()
    {
        // Define a string variable called space and assign a space character to it
        String space = " ";

        // Define an integer variable called count and assign the value of 4 to it
        int count = 4;

        // Print a line of 11 asterisks surrounded by spaces
        System.out.println(space.repeat(10) + "*".repeat(11));

        // Print a line of text that says "STAGE" surrounded by spaces
        System.out.println(space.repeat(10) + "*  STAGE  *");

        // Print a line of 11 asterisks surrounded by spaces
        System.out.println(space.repeat(10) + "*".repeat(11));

        // Use a for loop to iterate through each row of the seat array
        for (int i = 0; i < seat.length; i ++)
        {
            // Print 5 spaces at the beginning of each row
            System.out.print(" ".repeat(5));

            // Print a variable number of spaces based on the value of count
            System.out.print(space.repeat(count));

            // Use another for loop to iterate through each seat in the current row
            for (int j = 0; j  < seat[i].length; j ++)
            {
                // If the current seat is in the middle of the row, print a space character
                if (seat[i].length/2 == j)
                {
                    System.out.print(" ");
                }

                // If the current seat is unoccupied, print the letter 'O'
                if (seat[i][j] == 0)
                {
                    System.out.print("O");
                }

                // If the current seat is occupied, print the letter 'X'
                else
                {
                    System.out.print("X");
                }

            }

            // Decrease the value of count by 2 for each subsequent row
            count = count - 2;

            // Print a newline character to move to the next row
            System.out.println("");
        }

        // Call the Print method (presumably defined elsewhere in the code)
        Print();
    }


    // This method allows a user to cancel a ticket by entering the row number of the seat they want to cancel

    public static void Cancel_ticket()
    {
        // Use a while loop to allow the user to enter input until a valid row number is entered
        while (true) {
            Scanner input = new Scanner(System.in);

            // Use another while loop to check that the user input is a valid integer
            while (true) {
                System.out.print("Enter the row number from (1-3): ");

                // If the input is not a valid integer, print an error message and prompt the user again
                while (!input.hasNextInt()) {
                    System.out.println("Input Invalid Please Check the row number and try again.");
                    System.out.print("Enter the row number from (1-3): ");
                    input.next();
                }

                // If the input is a valid integer, assign it to the variable rowNo
                rowNo = input.nextInt();

                // If the row number is not within the valid range of 1 to 3, print an error message and prompt the user again
                if (rowNo < 1 || rowNo > 3) {
                    System.out.println("Input Invalid Please Check the row number and try again.");
                }
                // If the row number is valid, exit the inner while loop
                else {
                    break;
                }
            }
            // This while loop allows the user to enter a seat number until a valid seat number is entered
            while (true) {
                System.out.print("Enter seat number (1-" + Row_per_seat(rowNo) + "): ");

                // This while loop checks that the user input is a valid integer
                while (!input.hasNextInt()) {
                    System.out.println("Input Invalid Please Check the seat number and try again.");
                    System.out.print("Enter seat number (1-" + Row_per_seat(rowNo) + "): ");
                    input.next();
                }

                // If the user input is a valid integer, assign it to the variable seatNo
                seatNo = input.nextInt();

                // If the seat number is not within the valid range for the specified row, print an error message and prompt the user again
                if (seatNo < 1 || seatNo > Row_per_seat(rowNo)) {
                    System.out.println("Input Invalid Please Check the seat number and try again.");
                }
                // If the seat number is valid, check whether the seat is already booked or not
                else if (seat[rowNo - 1][seatNo - 1] == 0) {
                    System.out.println("Sorry! This seat is not yet booked.");
                }
                // If the seat is already booked, exit the loop
                else {
                    break;
                }
            }

            // Set the seat corresponding to the specified row and seat number as available (represented by 0)
            seat[rowNo - 1][seatNo - 1] = 0;

            // Print a success message to confirm that the ticket has been cancelled
            System.out.println("YOUR TICKET Row No " + rowNo + " Seat No " + seatNo + " CANCELLED SUCCESSFULLY.");

            // Use a for-each loop to search through the tickets list for a ticket with the specified row and seat number, and remove it
            for (Ticket x : tickets) {
                if (x.getSeatNo() == seatNo && x.getRowNo() == rowNo) {
                    tickets.remove(x);
                    break;
                }
            }

            // Print the updated seating chart
            Print();

            // Exit the loop
            break;

        }
    }
    public static int Row_per_seat(int rowNo)
    {
        // Initialize a variable to hold the index of the row in the rows array
        int rowIndex = -1;

        // Iterate through the rows array to find the index of the specified row number
        for (int i = 0; i < rows.length; i ++)
        {
            if (rows[i] == rowNo)
            {
                rowIndex = i;
                break;
            }
        }

        // If the specified row number is not found in the rows array, return -1 to indicate an error
        if (rowIndex == -1)
        {
            return -1;
        }
        // If the specified row number is found in the rows array, return the number of seats in that row from the seatCountPerRow array
        else
        {
            return seatCountPerRow[rowIndex];
        }
    }
    /**
     * This method displays all available seats in the theater.
     */
    public static void Show_available()
    {
        // Loop through each row in the seat array
        for (int row = 0; row < seat.length; row++)
        {
            // Print the row number and indicate available seats
            System.out.print("Seats available in Row " + (row + 1) + ": ");

            // Loop through each seat in the current row and check if it's available
            for (int seats = 0; seats < seat[row].length; seats++)
            {
                // If the current seat is available, print its number
                if (seat[row][seats] == 0)
                {
                    System.out.print ((seats + 1) + ", ");
                }
            }

            // Print a new line to separate the rows
            System.out.println();
        }

        // Print the current state of the theater
        Print();
    }

    // This is a Java method that saves the seat structure of a venue to a text file named "seat_structure.txt".
    public static void save()
    {
        try
        {
            // Create a new File object to represent the file to write to.
            File file = new File("seat_structure.txt");

            // Create a FileWriter object to write data to the file.
            FileWriter writer = new FileWriter(file);

            // Iterate through the two-dimensional "seat" array to write the status of each seat to the file.
            for (int i = 0; i < seat.length; i ++) {
                // Iterate through each row of the array.

                // Iterate through each element of the row and write the status of the seat to the file.
                for (int j = 0; j < seat[i].length; j++) {
                    // If the seat is available (indicated by a 0 in the array), write the character 'O' to the file.
                    if (seat[i][j] == 0) {
                        writer.write("O");
                    }
                    // If the seat is taken (indicated by a 1 in the array), write the character '1' to the file.
                    else {
                        writer.write("1");
                    }
                }
                // After writing the status of each seat in a row to the file, write a newline character to start a new line.
                writer.write("\n");
            }

            // Close the FileWriter object to save the changes to the file.
            writer.close();

            // Print a confirmation message to the console to indicate that the seats have been saved to the file.
            System.out.println("Seats saved to the File.");

            // Call the Print() method to display the current status of the seat structure on the console.
            Print();
        }
        catch (IOException e)
        {
            // If an exception occurs during the writing process, catch the exception and print an error message to the console along with the stack trace.
            System.out.println("Oops! an error occurrred while save the details to file.");
            e.printStackTrace();
        }
    }
    // refer bufferedreader method in ("https://www.guru99.com/buffered-reader-in-java.html")
    // This is a Java method that loads the seat structure of a venue from a text file named "seat_structure.txt".
    public static void load()
    {
        try {
            // Create a BufferedReader object to read data from the file.
            BufferedReader reader = new BufferedReader(new FileReader("seat_structure.txt"));

            // Initialize a String variable to hold each line of text read from the file, and an integer variable to track the current row of the seat array.
            String line;
            int row = 0;

            // Read each line of text from the file until the end of the file is reached or three rows have been read.
            while ((line = reader.readLine()) != null && row < 3) {

                // Print the row number to the console to indicate which row of the seat array is being updated.
                System.out.print("Row " + (row+1) + ": ");
                // Iterate through each character of the line read from the file.
                for (int i = 0; i < line.length(); i++) {
                    // Get the character at the current index of the line.
                    char c = line.charAt(i);

                    // If the character is '0', set the corresponding element of the seat array to 0 to indicate that the seat is available.
                    if (c == '0') {
                        seat[row][i] = 0;
                    }
                    // If the character is '1', set the corresponding element of the seat array to 1 to indicate that the seat is taken.
                    else if (c == '1') {
                        seat[row][i] = 1;
                    }
                    // Print the status of the current seat to the console.
                    System.out.print( seat[row][i]);
                }
                // After processing all the characters in a line, print a newline character to start a new line in the console.
                System.out.print("\n");

                // Increment the row counter to move to the next row of the seat array.
                row++;
            }
            // Close the BufferedReader object to release resources.
            reader.close();

            // Print a confirmation message to the console to indicate that the seats have been loaded from the file.
            System.out.println("Seats have been loaded from file.");
        }
        catch (IOException e) {
            // If an exception occurs during the reading process, catch the exception
            System.out.println("Error loading seats from file.");
        }
        Print();
    }
    //Method for print array list
    public static void show_ticket_info()
    {
        // Initialize a variable to keep track of the total price of all tickets
        double total_price = 0;

        // Loop through all tickets in the tickets ArrayList
        for (Ticket i: tickets)
        {
            // Print information about the current ticket
            i.print();

            // Add the price of the current ticket to the total price
            total_price = total_price + i.price;

            // Print the current state of the theater
            Print();
        }

        // Print the total price of all tickets
        System.out.println("Total Price: £" + total_price);
    }
    //Method for short the array list
    public static void sort_ticket() {
        // Create a copy of the original tickets ArrayList
        ArrayList<Ticket> ticket_copy = new ArrayList<>(tickets);

        // Sort the copy of tickets ArrayList according to their price in ascending order
        for (int i = 1; i <= ticket_copy.size(); i++) {
            for (int j = 1; j <= ticket_copy.size() - 1; j++) {
                Ticket max = (Ticket) ticket_copy.get(j - 1);
                Ticket min = (Ticket) ticket_copy.get(j);
                if ((max.price) > min.price) {
                    ticket_copy.set(j - 1, min);
                    ticket_copy.set(j, max);
                }
            }
        }

        // Print the sorted tickets and the total price of all the tickets
        double total_price = 0;
        for (Ticket ticket_new : ticket_copy) {
            ticket_new.print();
            total_price = total_price + ticket_new.price;
            Print();
        }
        System.out.println("Total Price: £" + total_price);
    }

    public static void main(String[] args) {
        // Initialize the seat array with the given seat counts for each row
        seat[0] = new int[seatCountInROW_1];
        seat[1] = new int[seatCountInROW_2];
        seat[2] = new int[seatCountInROW_3];
        Scanner input = new Scanner(System.in);
        // Call the StartProgram method to display the initial menu
        StartProgram();
        // Initialize variables for the user's chosen option and the main loop;
        String option;
        boolean main_loop = true;
        while (main_loop) {
            try {
                System.out.println("Please select an option:");
                System.out.println("1) Buy a ticket");
                System.out.println("2) Print seating area");
                System.out.println("3) Cancel ticket");
                System.out.println("4) List available seats");
                System.out.println("5) Save to file");
                System.out.println("6) Load from file");
                System.out.println("7) Print ticket information and total price");
                System.out.println("8) Sort tickets by price");
                System.out.println("0) Quit");
                Print();
                System.out.print("Enter option: ");
                // Get the user's input
                option = input.next();

                // Use a switch statement to execute different actions based on the user's choice
                switch (option) {
                    case "0":
                        // If the user chooses 0, exit the loop and print a goodbye message
                        main_loop = false;
                        System.out.println("Thank You For Using Our System" + "\n" + "Goodbye!");
                        break;
                    case "1":
                        // If the user chooses 1, call the Buy_ticket method
                        Buy_ticket();
                        break;
                    case "2":
                        // If the user chooses 2, call the Print_seating_area method
                        Print_seating_area();
                        break;
                    case "3":
                        // If the user chooses 3, call the Cancel_ticket method
                        Cancel_ticket();
                        break;
                    case "4":
                        // If the user chooses 4, call the Show_available method
                        Show_available();
                        break;
                    case "5":
                        // If the user chooses 5, call the save method
                        save();
                        break;
                    case "6":
                        // If the user chooses 6, call the load method
                        load();
                        break;
                    case "7":
                        // If the user chooses 7, call the show_ticket_info method
                        show_ticket_info();
                        break;
                    case "8":
                        // If the user chooses 8, call the sort_ticket method
                        sort_ticket();
                        break;
                    default:
                        // If the user enters an invalid option, print an error message
                        System.out.println("Invalid option, please try again.");
                        break;
                }

            // Use a try-catch block to handle any exceptions thrown by the code inside the loop
            } catch (Exception e) {
                System.out.println("Please enter the correct option.");
            }

        }
    }




}
