package by.warlock.service;

import by.warlock.model.Contact;

public class AddressBook {
    private int contactNumber = 0;
    private Contact[] contacts;

    //композиция
    //Контакт составная часть адресной книги.
    //Без контактов адресной книги не существует.
    public AddressBook() {
        contacts = new Contact[100];
    }
    //агрегация
    public AddressBook(Contact [] contacts) {
        this.contacts = contacts;
    }

    public void addNew(Contact contact) {
        contact.setId(contactNumber);
        contacts[contactNumber] = contact;
        contactNumber++;
    }

    public void update(Contact contact, int id) {
        contacts[id] = contact;
    }

    public int findContact(Contact contact) {
        for (Contact c : contacts) {
            if (c != null && c.equals(contact)) {
                return contact.getId();
            }
        }
        return -1;
    }

    public boolean delete(int id) {
        for (Contact c : contacts) {
            if (c != null && c.getId() == id) {
                contacts[id] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder contactsList = new StringBuilder();
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                contactsList.append(contacts[i].toString());
            }
        }
        return contactsList.toString();
    }
}
