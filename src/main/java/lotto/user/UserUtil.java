package lotto.user;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UserUtil {
    public static List<Integer> convertUserInputToNumbers(String userInput) {
        IntStream userNumbers = Stream.of(userInput.split(",")).mapToInt(Integer::parseInt);
        return userNumbers.boxed().collect(Collectors.toList());
    }
}
