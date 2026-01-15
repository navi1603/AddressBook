package by.warlock.service;

import by.warlock.model.Contact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuNavigator {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private AddressBook addressBook = new AddressBook();

    public void start() throws IOException {
        do {
            String key = br.readLine();
            printMenu();

            switch (key) {
                case "1":
                    addContact();
                    break;
                case "2":
                    deleteContact();
                    break;
                case "3":
                    listContacts();
                    break;
                case "4":
                    exit();
                    return;
                default:
                    System.out.println("Выбрана неверная опция! Попробуйте заново.\n");
            }
        } while (true);
    }

    private void printMenu() {
        System.out.println("Адресная книга\n");
        System.out.println("1 – новый контакт");
        System.out.println("2 – удаление существующего контакта");
        System.out.println("3 – вывод всех контактов");
        System.out.println("4 – завершение работы\n");
        System.out.print("Введите нужную опцию и нажмите Enter [1..4]: ");
    }

    private void addContact() throws IOException {
        Contact contact = new Contact();

        System.out.println("Новый контакт:\n");
        System.out.print("Введите Ф. И. О. контакта: ");
        contact.setFio(br.readLine());

        System.out.print("Должность: ");
        contact.setPost(br.readLine());

        System.out.print("Дата рождения: ");
        contact.setDateOfBirth(br.readLine());

        System.out.print("Номер телефона: ");
        contact.setPhone(br.readLine());

        System.out.print("Адрес электронной почты: ");
        contact.setEmail(br.readLine());

        int id = addressBook.findContact(contact);
        if (id == -1) {
            addressBook.addNew(contact);
            System.out.println("Новый контакт добавлен\n" + "или\n" + "Контакт был обновлён");
        } else {
            addressBook.update(contact, id);
            System.out.println("Пользователь " + contact.getFio() + " уже присутствует в списке " +
                    "контактов, он будет обновлён в соответствии с новыми данными.");
        }
    }

    private void deleteContact() throws IOException {
        System.out.print("Удаление существующего контакта\n" + "Введите ID контакта: ");
        int id = Integer.parseInt(br.readLine());

        System.out.println(addressBook.delete(id) ? "Контакт с ID: " + id + " удалён\n" :
                "Пользователь с ID: " + id + " не найден\n");
    }

    private void listContacts() {
        System.out.println(addressBook);
    }

    private void exit() {
        System.out.println("Работа программы завершена, ждём вас снова!");
        System.exit(0);
    }

}
