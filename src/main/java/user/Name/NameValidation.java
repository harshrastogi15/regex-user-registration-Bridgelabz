package user.Name;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidation {
    public static void main(String[] args){
        System.out.println("Function for Validation");
        boolean flag = nameValidationRegex("Abb");
        System.out.println(flag);
    }

    public static boolean nameValidationRegex(String st){
        String regex = "^[A-Z][a-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(st);
        return matcher.matches();
    }
}
