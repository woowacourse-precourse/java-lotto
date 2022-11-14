package lotto.validation;
import java.util.regex.Pattern;
public class InputValidation {

    public void validatePrice(String price) {
        if (!Pattern.matches("^[1-9][0-9]*0{3}$", price)) {
            throw new IllegalArgumentException();
        }
    }
}
