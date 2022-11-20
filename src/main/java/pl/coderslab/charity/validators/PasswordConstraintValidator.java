package pl.coderslab.charity.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword,String> {
    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {


        if(value.length()>=8)
        {
            Pattern upperCaseLetter = Pattern.compile("[A-Z]");
            Pattern lowerCaseLetter = Pattern.compile("[a-z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

            Matcher hasUpperCaseLetter = upperCaseLetter.matcher(value);
            Matcher hasLowerCaseLetter = lowerCaseLetter.matcher(value);
            Matcher hasDigit = digit.matcher(value);
            Matcher hasSpecial = special.matcher(value);

            return hasUpperCaseLetter.find() && hasLowerCaseLetter.find() && hasDigit.find() && hasSpecial.find();

        }
        else
            return false;
    }
}
