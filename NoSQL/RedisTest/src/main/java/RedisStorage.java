import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;
import java.util.Date;
import java.util.Random;
import static java.lang.System.out;

public class RedisStorage {

    //объект для работы с Redis
    private RedissonClient redisson;

    //объект для работы с ключами
    private RKeys rKeys;

    //объект для работы с Sorted Set'ом
    private RScoredSortedSet<String> users;

    private final static String KEY = "ONLINE_USERS";

    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            out.println("Не удалось подключиться к Redis");
            out.println(Exc.getMessage());
        }
        rKeys = redisson.getKeys();
        users = redisson.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }

    void shutdown() {
        redisson.shutdown();
    }

    //регистрация польхователей
    void logPageVisit(double currentDateTime, int user_id)
    {
        //ZADD ONLINE_USERS
        users.add(currentDateTime, String.valueOf(user_id));
    }

    //показ пользователей
    void usersShow(RScoredSortedSet<String> users) {

        for(String str : users) {
            double currentDateTime = new Date().getTime();
            if (Integer.parseInt(str) % 10 == 0) {
                int randomUser = randomNumber(Integer.parseInt(str) - 9, Integer.parseInt(str));
                out.println("> Пользователь " + randomUser + " оплатил платную услугу");
                users.add(currentDateTime + 0.1, String.valueOf(randomUser));
            } else {
                out.println("— На главной странице показываем пользователя " + str);
            }
        }
    }

    private int randomNumber(int start, int end) {
        Random rn = new Random();
        return rn.nextInt(end - start + 1) + start;
    }

    public RScoredSortedSet<String> getUsers() {
        return users;
    }
}