package by.warlock.service;

import by.warlock.model.Contact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuNavigator {
    private BufferedReader br;
    private Contact [] contacts;
    private AddressBook addressBook;

    public MenuNavigator() {
        br = new BufferedReader(new InputStreamReader(System.in));
        contacts = new Contact[100];

        contacts[0] = new Contact(0, "Иванов Иван Иванович", "тестировщик", "17.07.1997", "+37529 444 44 44", "lkjasdf@gmail.com");
        contacts[1] = new Contact(1, "Иванов Петр Иванович", "мебельщик", "19.07.1987", "+37529 556 44 33", "lkjasdf@gmail.com");
        contacts[2] = new Contact(2, "Иванов Иван Петрович", "разработчик", "10.08.1977", "+37529 555 55 55", "lkjasdf@gmail.com");
        contacts[3] = new Contact(3, "Васильев Иван Иванович", "менеджер", "15.07.1967", "+37529 666 55 55", "lkjasdf@gmail.com");

        addressBook = new AddressBook(contacts);
    }


    public void start() throws IOException {
        do {
            printMenu();
            String key = br.readLine();
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
