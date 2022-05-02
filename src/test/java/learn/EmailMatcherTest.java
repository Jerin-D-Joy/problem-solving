package learn;

import org.junit.Assert;
import org.junit.Test;

public class EmailMatcherTest {

    @Test
    public void isEmailTest() {
        EmailMatcher emailMatcher = new EmailMatcher();
        Assert.assertTrue(emailMatcher.isEmail("jerindjoy@gmail.com"));
        Assert.assertFalse(emailMatcher.isEmail("jerindjoy@gmail"));
        Assert.assertFalse(emailMatcher.isEmail("jerindjoygmail.com"));
        Assert.assertFalse(emailMatcher.isEmail("@."));
        Assert.assertFalse(emailMatcher.isEmail("1@2.3"));
    }
}
