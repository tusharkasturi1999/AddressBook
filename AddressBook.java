package com.bridgelabz.addressbook;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    private List<Contact> contacts = new ArrayList<Contact>();

    private static Scanner sc = new Scanner(System.in);

    /**
     * This method is used to read contacts
     * @return returnscontact
     */
    public Contact readContactDetails() {
        Contact contact = new Contact();
        System.out.println("Enter FN");
        contact.setFirstName(sc.nextLine());
        System.out.println("Enter LN");
        contact.setLastName(sc.nextLine());
        System.out.println("Enter Add");
        contact.setAddress(sc.nextLine());
        System.out.println("Enter City");
        contact.setCity(sc.nextLine());
        System.out.println("Enter STate");
        contact.setState(sc.nextLine());
        System.out.println("Enter zp");
        contact.setZip(sc.nextLine());
        System.out.println("Enter PN");
        contact.setPhoneNumber(sc.nextLine());
        System.out.println("Enter EM");
        contact.setEmailId(sc.nextLine());
        return contact;
    }

    /**
     * This method prints all contacts
     */

    public void printContacts() {
        for (Contact contact : this.contacts) {
            System.out.println(contact);
        }
        if (this.contacts.size() == 0) {
            System.out.println("No contacts");
        }
    }

    /**
     * this method is used to add contacts
     */

    public void addContact() {
        Contact contact = this.readContactDetails();
        this.contacts.add(contact);
    }

    /**
     * This method is used to edit contacts
     */

    public void editContact() {
        System.out.println("Enter FN");
        String firstName = sc.nextLine();
        System.out.println("Enter LN");
        String lastName = sc.nextLine();
        int index = search(firstName, lastName);
        if (index == -1) {
            System.out.println("Contact Not Found");
        } else {
            System.out.println("Enter new Values");
            Contact contact = this.readContactDetails();
            this.contacts.set(index, contact);
        }
    }

    /**
     * This method is to delete contacts
     */
    public void deleteContact() {
        System.out.println("Enter FN");
        String firstName = sc.nextLine();
        System.out.println("Enter LN");
        String lastName = sc.nextLine();
        int index = search(firstName, lastName);
        if (index == -1) {
            System.out.println("Contact Not Found");
        } else {
            this.contacts.remove(index);
            System.out.println("Contact Deleted");
        }
    }

    /**
     * Method to search for a contact in the contact list
     * @param firstName first name of the contact
     * @param lastName last name of the contact
     * @return index of the contact to be searched, -1 if not found
     */

    public int search(String firstName, String lastName) {
        int i = 0;
        int len = this.contacts.size();
        for (i = 0; i < len; ++i) {
            if (this.contacts.get(i).getFirstName().equals(firstName) &&
                    this.contacts.get(i).getLastName().equals(lastName)) {
                break;
            }
        }
        if (i >= len) {
            return -1;
        } else {
            return i;
        }
    }



    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("Welcome to Address Book");
            System.out.println("1 Add\n2 Edit \n3 Delete\n4 Print\n5 Exit");
            System.out.println("Enter option");
            int option = sc.nextInt();
            sc.nextLine();

            if (option == 5)
                break;
/**
 * This is used to choose option
 */

            switch (option) {
                case 1:
                    addressBook.addContact();
                    break;
                case 2:
                    addressBook.editContact();
                    break;
                case 3:
                     addressBook.deleteContact();
                    break;
                case 4:
                     addressBook.printContacts();
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}

/**
 * This is model class
 */
class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String emailId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Contact() {
        super();
    }

    public Contact(String firstName, String lastName, String address, String city, String state, String zip,
                   String phoneNumber, String emailId) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Address [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city=" + city
                + ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + "]";
    }

}
