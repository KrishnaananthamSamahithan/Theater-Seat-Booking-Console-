public class Ticket {
    // Define a constructor that takes in a person object, row number, seat number, and ticket price
    private int rowNo;
    private int seatNo;
    double price;
    Person person;

    // Define a constructor that takes in a person object, row number, seat number, and ticket price
    public Ticket(Person person,int rowNo, int seatNo, double price) {
        this.rowNo = rowNo;
        this.seatNo = seatNo;
        this.price = price;
        this.person = person;
    }

    // Define a static method to calculate the ticket price based on the row number
    public static double getTicketPrice(int rowNo ) {
        if (rowNo == 1) {
            return 50;
        }
        else if (rowNo == 2) {
            return 40;
        }
        else {
            return 30;
        }
    }
    // Define a method to return the ticket price
    public double getPrice() {
        return price;
    }
    // Define a method to print the ticket information
    public void print() {
        System.out.printf("Name - %s\nSurName - %s\nEmail_ID - %s\nRow - %d\nSeat - %d\nPrice - £%.2f\n",
                person.getName(), person.getSurName(), person.getEmail(), rowNo, seatNo, price = getTicketPrice(rowNo));
    }
    // Define getter methods for row number and seat number
    public int getRowNo() {
        return rowNo;
    }
    public int getSeatNo() {
        return seatNo;
    }

}
