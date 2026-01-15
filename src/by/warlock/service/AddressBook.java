package by.warlock.service;

import by.warlock.model.Contact;

public class AddressBook {
    private int contactNumber;
    private Contact[] contacts;

    public AddressBook() {
        contacts = new Contact[100];
        contactNumber = 0;

        contacts[0] = new Contact(0, "Иванов Иван Иванович", "тестировщик", "17.07.1997", "+37529 444 44 44", "lkjasdf@gmail.com");
        contacts[1] = new Contact(1, "Иванов Петр Иванович", "мебельщик", "19.07.1987", "+37529 556 44 33", "lkjasdf@gmail.com");
        contacts[2] = new Contact(2, "Иванов Иван Петрович", "разработчик", "10.08.1977", "+37529 555 55 55", "lkjasdf@gmail.com");
        contacts[3] = new Contact(3, "Васильев Иван Иванович", "менеджер", "15.07.1967", "+37529 666 55 55", "lkjasdf@gmail.com");
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
