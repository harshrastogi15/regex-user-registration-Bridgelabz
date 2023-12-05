package user.Name;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidation {
    public static void main(String[] args){
        System.out.println("Function for Validation");
        boolean flag = nameValidationRegex("Abb");
        System.out.println(flag);
        boolean flag2 = emailValidationRegex("Abb.xyzm.com");
        System.out.println(flag2);
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
        String regex = "^[a-zA-Z0-9]+(.[a-zA-Z0-9]+)*@[a-zA-Z](.[a-zA-Z]+)+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(st);
        return matcher.matches();
    }

}
