package userregistration;

import org.junit.Assert;
import org.junit.Test;

import user.Name.InvalidUserDetailsException;
import user.Name.UserValidation;

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
            Assert.assertTrue(UserValidation.emailValidationRegex(s));
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
            Assert.assertFalse(UserValidation.emailValidationRegex(s));
        }
    }


    @Test
    public void testValidateUserHappyCase() {
        UserValidation UserValidation = new UserValidation();

        // Happy case: Valid entries
        Assert.assertTrue(UserValidation.validateUser("John", "Doe", "john@example.com", "91 1234567890", "HarshRastogi12$"));
    }

    @Test
    public void testValidateUserSadCases() {
        UserValidation UserValidation = new UserValidation();

        // Sad case: Invalid first name (empty)
        Assert.assertFalse(UserValidation.validateUser("", "Doe", "john@example.com", "91 1234567890", "HarshRastogi12$"));

        // Sad case: Invalid last name (null)
        Assert.assertFalse(UserValidation.validateUser("John", "", "john@example.com", "91 1234567890", "HarshRastogi12$"));

        // Sad case: Invalid email format
        Assert.assertFalse(UserValidation.validateUser("John", "Doe", "invalidEmail", "91 1234567890", "HarshRastogi12$"));

        // Sad case: Invalid mobile number (less than 10 digits)
        Assert.assertFalse(UserValidation.validateUser("John", "Doe", "john@example.com", "123456", "HarshRastogi12$"));

        // Sad case: Invalid password (less than 8 characters)
        Assert.assertFalse(UserValidation.validateUser("John", "Doe", "john@example.com", "91 1234567890", "Weak"));
    }

    @Test
    public void testValidationUserWithCustomException(){
        try{
            UserValidation userValidation = new UserValidation();
            // Sad case: Invalid first name (empty)
            userValidation.validateUserWithException("", "Doe", "john@example.com", "91 1234567890", "HarshRastogi12$");

            // Sad case: Invalid last name (null)
            userValidation.validateUserWithException("John", "", "john@example.com", "91 1234567890", "HarshRastogi12$");

            // Sad case: Invalid email format
            userValidation.validateUserWithException("John", "Doe", "invalidEmail", "91 1234567890", "HarshRastogi12$");

            // Sad case: Invalid mobile number (less than 10 digits)
            userValidation.validateUserWithException("John", "Doe", "john@example.com", "123456", "HarshRastogi12$");

            // Sad case: Invalid password (less than 8 characters)
            userValidation.validateUserWithException("John", "Doe", "john@example.com", "91 1234567890", "Weak");

        }catch (InvalidUserDetailsException e){
            System.out.println(e.getMessage());
        }
    }



}
