import java.util.*;

public class PhoneBook {
    static Scanner console = new Scanner(System.in);
    static Map<String, List<String>> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    Введите одну из комманд:
                    "add" - добавление контакта
                    "find" - найти контакт
                    "list" - вывести книгу
                    "e" - выйти из программы
                    """);

            if (console.hasNext("e")) {
                return;
            } else {
                String key = console.nextLine();
                switch (key) {
                    case "add" -> addContact();
                    case "find" -> findContact();
                    case "list" -> getPhoneBook();
                }
            }
        }
    }

    private static void addContact() {
        while (true) {
            System.out.println("\"q\" - выйти из режима добавления.");
            System.out.println("Введите имя: ");
            if (console.hasNext("q")) {
                break;
            } else {
                String name = console.nextLine();
                if (!phoneBook.containsKey(name)) {
                    System.out.println("Введите номер: ");
                    String phone = console.nextLine();

                    List<String> namePhones = new ArrayList<>();
                    namePhones.add(phone);

                    phoneBook.put(name, namePhones);
                } else {
                    System.out.println("Такое имя уже есть. Добавте номер: ");
                    String phone = console.nextLine();
                    phoneBook.get(name).add(phone);
                }
            }
        }
    }

    private static void getPhoneBook() {
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            System.out.println(entry);
        }
        System.out.println();
    }

    private static void findContact() {
        System.out.println("Введите имя: ");
        String name = console.nextLine();
        if (phoneBook.containsKey(name)) {
            System.out.printf("%s %s\n", name, phoneBook.get(name));
            System.out.println();
        }
    }
}
