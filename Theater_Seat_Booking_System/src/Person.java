public class Person {
    //The Person class represents a person with a name, surname, and email address.
    private String name;
    private String surName;
    private String email;

    // Create constructor for person class
    public Person(String name, String surName, String email) {
        this.name = name;
        this.surName = surName;
        this.email = email;
    }

    //Create getter for name, surname, email
    public String getName()
    {
        return name;
    }
    public String getSurName()
    {
        return surName;
    }
    public String getEmail() {
        return email;
    }

}
