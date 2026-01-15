package by.warlock.service;

import by.warlock.model.Contact;

public class AddressBook {
    private int contactNumber;
    private Contact[] contacts;

    public AddressBook() {
        contacts = new Contact[100];
        contactNumber = 0;
    }

    public void add (Contact contact) {
        contacts[contactNumber] = contact;
        contactNumber++;
    }

    public void delete (int id) {
        contacts[id] = null;
    }

    public Contact [] getContacts (){
          return contacts;
    }

    @Override
    public String toString() {
        StringBuilder contactsList = new StringBuilder();
        for (Contact contact : contacts) {
            contactsList.append(contact.toString());
        }
        return contactsList.toString();
    }
}
