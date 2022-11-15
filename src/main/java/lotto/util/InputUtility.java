package lotto.util;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputUtility {

    private InputUtility(){}

    public static List<Integer> parseLotto(String input) {
        return Stream.of(input.split(","))
            .mapToInt(Integer::parseInt).sorted()
            .boxed().collect(Collectors.toList());

    }


}
