package userregistration;

import org.junit.Assert;
import org.junit.Test;
import user.Name.NameValidation;

public class UserValidationTest {
    @Test
    public void validEmailcheck(){
        String[] validEmails = {
                "abc@yahoo.com",
                "abc-100@yahoo.com",
                "abc.100@yahoo.com",
                "abc111@abc.com",
                "abc-100@abc.net",
                "abc.100@abc.com.au",
                "abc@1.com",
                "abc@gmail.com.com",
                "abc+100@gmail.com"
        };

        for (String s: validEmails) {
            System.out.println(s);
            Assert.assertTrue(NameValidation.emailValidationRegex(s));
        }

    }


    @Test
    public void invalidEmailcheck(){
        String[] invalidEmails = {
                "abc",                      // must contain "@"
                "abc@.com.my",              // tld cannot start with dot
                "abc123@gmail.a",           // last tld must have at least two characters
                "abc123@.com",              // tld cannot start with dot
                "abc123@.com.com",          // tld cannot start with dot
                ".abc@abc.com",             // first character cannot start with dot
                "abc()*@gmail.com",         // only allow characters, digits, underscore, and dash
                "abc@%*.com",               // tld is only allowed characters and digits
                "abc..2002@gmail.com",      // double dots not allowed
                "abc.@gmail.com",           // last character cannot end with dot
                "abc@abc@gmail.com",        // double "@" not allowed
                "abc@gmail.com.1a",         // tld with two characters cannot contain digits
                "abc@gmail.com.aa.au"       // cannot have multiple email's tld
        };
        for (String s: invalidEmails) {
            System.out.println(s);
            Assert.assertFalse(NameValidation.emailValidationRegex(s));
        }
    }
}
