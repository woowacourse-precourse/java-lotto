package lotto.util;


import static lotto.util.ValidationUtility.validationTest;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputUtility {

    private InputUtility(){}

    public static String readLine(int type) {
        String line = Console.readLine();
        validationTest(line, type);
        return line;
    }

    public static List<Integer> parseLotto(String input) {
        return Stream.of(input.split(","))
            .mapToInt(Integer::parseInt).sorted()
            .boxed().collect(Collectors.toList());

    }


}
