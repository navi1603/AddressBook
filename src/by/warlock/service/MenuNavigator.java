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
            String key = null;
            printMenu();
            key = br.readLine();

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

        System.out.println("Должность: ");
        contact.setPost(br.readLine());

        System.out.println("Дата рождения: ");
        contact.setPhone(br.readLine());

        System.out.println("Номер телефона: ");
        contact.setPhone(br.readLine());

        System.out.println("Адрес электронной почты: ");
        contact.setEmail(br.readLine());

        addressBook.add(contact);
        System.out.println("Новый контакт добавлен\n" + "или\n" + "Контакт был обновлён");
    }

    private void deleteContact() throws IOException {
        System.out.print("Удаление существующего контакта\n" + "Введите ID контакта: ");
        int id = Integer.parseInt(br.readLine());

        addressBook.delete(id);
    }

    private void listContacts() {

    }

    private void exit() {
        System.out.println("Работа программы завершена, ждём вас снова!");
        System.exit(0);
    }

}
