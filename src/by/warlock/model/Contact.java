package by.warlock.model;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class Contact {
    private int id;
    private String fio;
    private String post;
    private String dateOfBirth;
    private String phone;
    private String email;

    public Contact() {}

    public Contact(int id, String fio, String post, String dateOfBirth, String phone, String email) {
        this.id = id;
        this.fio = fio;
        this.post = post;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        String[] newFio = fio.trim().replaceAll("\\s+", " ").split(" ");
        for (int i = 0; i < newFio.length; i++) {
            char firstChar = newFio[i].charAt(0);
            char capitalFirstChar = Character.toUpperCase(firstChar);

            if (firstChar == capitalFirstChar) {
                continue;
            }
            String tmp = capitalFirstChar + newFio[i].substring(1);
            newFio[i] = tmp;
        }
        this.fio = String.join(" ", newFio);
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return fio.equals(contact.getFio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio) * 56;
    }

    @Override
    public String toString() {
        return  "ID: " + id + "\n" +
                "Ф. И. О.: " + fio + "\n" +
                "Должность: " + post + "\n" +
                "Дата рождения: " + dateOfBirth + "\n" +
                "Номер телефона: " + phone + "\n" +
                "Адрес электронной почты: " + email + "\n \n";
    }
}
