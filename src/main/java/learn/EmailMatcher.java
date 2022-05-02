package learn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMatcher {

    public boolean isEmail(String email) {
        Pattern p = Pattern.compile("[a-zA-Z]\\w*@[a-zA-Z]\\w*\\.[a-zA-Z]\\w*");
        Matcher m = p.matcher(email);
        System.out.println(m.results().toString());
        return m.matches();
    }
}
