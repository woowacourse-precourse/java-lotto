package lotto.util;

import lotto.validator.parserValidator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class parser {
    public static final String SEPARATOR = ",";

    public static List<Integer> convertStringToIntegerList(String prizeNumber) {
        parserValidator.check(prizeNumber.split(SEPARATOR));

        return Stream.of(prizeNumber.split(SEPARATOR))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
