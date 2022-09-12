package skorupinski.midjourney.user;

import skorupinski.midjourney.utils.Date;

public class DiscordUser {

    public final String username;

    public final String email;

    public final String password;

    public final Date date;

    public DiscordUser(String username, String email, String password, Date date) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.date = date;
    }
}
