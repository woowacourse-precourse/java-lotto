package lotto.console;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.service.Validation.*;


public class Input {

    public static int inputNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 숫자형식이 아닙니다.");
        }
    }

    public static List<Integer> inputSixNumber() {
        List<Integer> answer;

        try {
            answer = Arrays.stream(Console.readLine().split(","))
                    .distinct()
                    .mapToInt(Integer::parseInt).boxed()
                    .collect(Collectors.toList());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 숫자형식이 아닙니다.");
        }

        if( answer.size()!=6 || !isLotto(answer) ) {
            throw new IllegalArgumentException("[Error] 당첨 번호를 잘못입력했습니다.");
        }

        return answer;
    }
}