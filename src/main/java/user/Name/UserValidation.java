package user.Name;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {
    public static void main(String[] args){
        System.out.println("Function for Validation");
        boolean flag = nameValidationRegex("Abb");
        System.out.println(flag);
        boolean flag2 = emailValidationRegex("Abb.xyzm.com");
        System.out.println(flag2);
        boolean flag3 = phoneValidationRegex("9 1410258369");
        System.out.println(flag3);
        boolean flag4 = passwordValidationRegex("abcdabcdA2");
        System.out.println(flag4);
    }




    public static boolean nameValidationRegex(String st){
        String regex = "^[A-Z][a-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(st);
        return matcher.matches();
    }

    /*
    *  UC-3
    *   As a User need to enter a valid email
    *   E.g. abc.xyz@bl.co.in - Email has 3 mandatory
    *   parts (abc, bl & co) and 2 optional (xyz & in) withprecise @ and . positions
    * */

    public static boolean emailValidationRegex(String st){
        String regex = "^[a-zA-Z0-9]+([.+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,}){1,2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(st);
        return matcher.matches();
    }

    /*
     * UC - 4
     * As a User need to follow pre-defined
     * Mobile Format - E.g. 91 9919819801
     * Country code follow by space and 10-digit number
     */
    public static boolean phoneValidationRegex(String number){
        String regex = "^[0-9]+ [0-9]{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    /*
    * UC-5
    * Password Validation
    */

    public static boolean passwordValidationRegex(String pwd){
        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-_+=])[a-zA-Z0-9!@#$%^&*()-_+=]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pwd);
        return matcher.matches();
    }

    public boolean validateUser(String firstname, String lastname, String email, String phone, String password) {
        return nameValidationRegex(firstname) && nameValidationRegex(lastname) && emailValidationRegex(email) && phoneValidationRegex(phone) && passwordValidationRegex(password);
    }
}
