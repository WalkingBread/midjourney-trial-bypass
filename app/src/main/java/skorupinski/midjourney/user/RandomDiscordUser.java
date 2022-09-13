package skorupinski.midjourney.user;

import skorupinski.midjourney.utils.Date;
import skorupinski.midjourney.utils.FileReader;

import java.util.List;
import java.util.Random;

public class RandomDiscordUser extends DiscordUser {

    private static final Random random = new Random();

    private static final String USERNAMES_PATH = "userdata/usernames.txt";

    private static final String PASSWORDS_PATH = "userdata/passwords.txt";

    private static final List<String> usernames = new FileReader(USERNAMES_PATH).getLines();

    private static final List<String> passwords = new FileReader(PASSWORDS_PATH).getLines();

    public RandomDiscordUser(String email) {
        super(getUsername(), email, getPassword(), getDate());
    }

    private static String getUsername() {
        return usernames.get(random.nextInt(usernames.size()));
    }

    private static String getPassword() {
        return passwords.get(random.nextInt(passwords.size()));
    }

    private static Date getDate() {
        int day = random.nextInt(27) + 1;
        int month = random.nextInt(11) + 1;
        int year = random.nextInt(30) + 1975;

        return new Date(day, month, year);
    }
}
