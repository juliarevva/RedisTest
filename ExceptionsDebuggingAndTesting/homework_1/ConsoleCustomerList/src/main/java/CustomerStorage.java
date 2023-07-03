import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private static Logger logger = LogManager.getLogger(CustomerStorage.class);
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public boolean isPhone(String phone) {
        String regexPhone = "[+]7[0-9]{10}";
        return phone.matches(regexPhone);
    }

    public boolean isEmail(String phone) {
        String regexPhone = "[a-zA-Z0-9-_.]+@[a-z]+[.][a-z]+";
        return phone.matches(regexPhone);
    }

    public void addCustomer(String data) {

        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];

        if (components.length != 4) {
            logger.log(Level.ERROR, "Неверное количество элементов");
            throw new IllegalArgumentException("Введите: add Имя(Василий) Фамилию(Петров) " +
                    "Эл.почту(vasily.petrov@gmail.com) Телефон(+79215637722)");
        }
        if (!isEmail(components[INDEX_EMAIL])) {
            logger.log(Level.ERROR, "Неверный формат Эл.почты");
            throw new IllegalArgumentException("Формат Эл.почты: vasily.petrov@gmail.com");
        }
        if (!isPhone(components[INDEX_PHONE])) {
            logger.log(Level.ERROR, "Неверный формат номера телефона");
            throw new IllegalArgumentException("Формат номера: +79175555555");
        }
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}
