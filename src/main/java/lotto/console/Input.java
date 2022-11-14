package lotto.console;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.service.Validation.*;


public class Input {

    public static int inputNumber() {
        String tmp = Console.readLine();
        if(isNumber(tmp)) {
            return Integer.parseInt(tmp);
        }
        System.out.println("[ERROR] 숫자 형식이 아닙니다.");
        return 0;
    }

    public static List<Integer> inputSixNumber() {
        List<Integer> answer;

        try {
            answer = Arrays.stream(Console.readLine().split(","))
                    .distinct()
                    .mapToInt(Integer::parseInt).boxed()
                    .collect(Collectors.toList());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자형식이 아닙니다.");
        }

        if( answer.size()!=6 || !isLotto(answer) ) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 잘못입력했습니다.");
        }

        return answer;
    }
}