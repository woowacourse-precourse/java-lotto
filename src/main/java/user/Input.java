package user;

import java.util.Arrays;
import java.util.List;

import static message.ErrorMessage.*;

public class Input {
    public List<String> userLotto(String str) {
        if (!(str.contains(","))) throw new IllegalArgumentException(USER_INPUT_ERROR.getStatus());

        String[] arr = str.split(",");
        List<String> userInput = Arrays.asList(arr);

        if (userInput.size() != 6) throw new IllegalArgumentException(INPUT_COUNT_ERROR.getStatus());
        return userInput;
    }
}
