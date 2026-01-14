package by.warlock.service;

public class MenuNavigator {

    public void start(){

    }

    private void printMenu(){
        System.out.println("Адресная книга\n");
        System.out.println("1 – новый контакт");
        System.out.println("2 – удаление существующего контакта");
        System.out.println("3 – вывод всех контактов");
        System.out.println("4 – завершение работы\n");
        System.out.println("Введите нужную опцию и нажмите Enter [1..4]: ");
    }

}
