import java.util.Date;

public class RedisTest {

    //запуск докер-контейнера:
    //docker run --rm --name skill-redis -p 127.0.0.1:6379:6379/tcp -d redis

    //кол-во пользователей
    private static final int usersCount = 20;

    //задержка между итерациями цикла
    private static final int SLEEP = 1000; // 1 секунда

    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        redis.init();

        //регистрирация пользователей
        for(int user_id = 1; user_id <= usersCount; user_id++) {
            double currentDateTime = new Date().getTime();
            redis.logPageVisit(currentDateTime, user_id);
        }

        while (true) {
            redis.usersShow(redis.getUsers());
            Thread.sleep(SLEEP);
        }
//        redis.shutdown();
    }
}