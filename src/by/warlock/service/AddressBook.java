package by.warlock.service;

import by.warlock.model.Contact;

public class AddressBook {
    private Contact[] contacts;

    public AddressBook() {
        contacts = new Contact[100];
    }

    public Contact[] getContacts() {
        return contacts;
    }
    public void setContacts(Contact[] contacts) {
        this.contacts = contacts;
    }
}
