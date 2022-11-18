package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.service.Validation.*;


public class Input {

    public static int inputNumber() {
        String tmp = Console.readLine();
        isNumber(tmp);

        return Integer.parseInt(tmp);
    }

    public static List<Integer> inputSixNumber() {
        List<Integer> answer;

        answer = Arrays.stream(Console.readLine().split(","))
                .distinct()
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList());

        isLotto(answer);
        isSixNumber(answer);

        return answer;
    }
}