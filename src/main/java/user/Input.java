package user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static message.ErrorMessage.*;

public class Input {
    public List<Integer> userLotto(String str) {
        if (!(str.contains(","))) throw new IllegalArgumentException(USER_INPUT_ERROR.getStatus());

        String[] arr = str.split(",");
        List<Integer> userInput = Arrays.stream(arr).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        if (userInput.size() != 6) throw new IllegalArgumentException(INPUT_COUNT_ERROR.getStatus());
        return userInput;
    }
}
