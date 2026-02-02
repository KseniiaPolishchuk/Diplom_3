package api;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomCreatingUser {
    public static String RANDOM_EMAIL = RandomStringUtils.randomAlphabetic(10) + "@bk.ru";
    public static String RANDOM_PASSWORD = RandomStringUtils.randomNumeric(8);
    public static String RANDOM_NAME = RandomStringUtils.randomAlphabetic(7);
}
