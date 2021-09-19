package com.bridgelabz.addressbook;

import java.util.*;

public class AddressBook {
    private static final Scanner sc = new Scanner(System.in);
    private static final Map<String, Addresses> dictionary = new HashMap<>();

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        while (true) {

            System.out.println("1 Print\n2 Create \n3 Select Existing\n4 Delete\n5 Exit");
            int choice = sc.nextInt();
            if (choice == 5)
                break;

            switch (choice) {
                case 1:
                    addressBook.printAddressBooksNames();
                    break;
                case 2:
                    System.out.println("Enter new Bookname");
                    sc.nextLine();
                    String bookName = sc.nextLine();
                    if(dictionary.containsKey(bookName)){
                        System.out.println("Addressbook already exist");
                        break;
                    }
                    addressBook.createAddressBook(bookName);
                    addressBook.printAddressBooksNames();
                    break;
                case 3:
                    addressBook.printAddressBooksNames();
                    System.out.println("Enter Bookname to select");
                    sc.nextLine();
                    bookName = sc.next();
                    Addresses ad1 = addressBook.getAddressBook(bookName);
                    ad1.driver();
                    break;
                case 4:
                    System.out.println("Enter Bookname to delete");
                    sc.nextLine();
                    bookName = sc.next();
                    addressBook.deleteAddressBook(bookName);
                    addressBook.printAddressBooksNames();
                    break;

            }
        }
    }


    public boolean createAddressBook(String name) {
        if (dictionary.containsKey(name)) {
            return true;
        }
        dictionary.put(name, new Addresses());
        return true;
    }

    public void printAddressBooksNames() {
        dictionary.keySet().forEach(System.out::println);
    }

    public Addresses getAddressBook(String name) {
        return dictionary.get(name);
    }

    public boolean deleteAddressBook(String name) {
        if (dictionary.containsKey(name)) {
            dictionary.remove(name);
            return true;
        }
        return false;
    }

    class Addresses {


        private final Scanner sc = new Scanner(System.in);
        private List<Contact> contacts = null;

        public Addresses() {
            this.contacts = new ArrayList<>();
        }

        /**
         * This method is used to read contacts
         *
         * @return returnscontact
         * @param firstName
         * @param lastName
         */
        public Contact readContactDetails(String firstName, String lastName) {
            Contact contact = new Contact();
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
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
         * @param firstName
         * @param lastName
         */

        public void addContact(String firstName, String lastName) {
            Contact contact = this.readContactDetails(firstName, lastName);
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
                Contact contact = this.readContactDetails(firstName, lastName);
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
         *
         * @param firstName first name of the contact
         * @param lastName  last name of the contact
         * @return index of the contact to be searched, -1 if not found
         */

        public int search(String firstName, String lastName) {
            int i;
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


        // Call this to do this
        public void driver() {

            while (true) {
                System.out.println("Welcome to Address Book");
                System.out.println("1 Add\n2 Edit \n3 Delete\n4 Print\n5 Exit");
                System.out.println("Enter option");
                int option = sc.nextInt();
                sc.nextLine();

                if (option == 5)
                    break;

                switch (option) {
                    case 1:
                        System.out.println("Enter FN");
                        String firstName = sc.nextLine();
                        System.out.println("Enter LN");
                        String lastName = sc.nextLine();
                        int index = search(firstName, lastName);
                        if(index == -1){
                            this.addContact(firstName, lastName);
                            break;
                        }
                        else
                        {
                            System.out.println("Entry Already exists");
                            break;
                        }
                    case 2:
                        this.editContact();
                        break;
                    case 3:
                        this.deleteContact();
                        break;
                    case 4:
                        this.printContacts();
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

        public void setAddress(String address) {
            this.address = address;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void setEmailId(String emailId) {
            this.emailId = emailId;
        }

        @Override
        public String toString() {
            return "Address [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city=" + city
                    + ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + "]";
        }

    }
}