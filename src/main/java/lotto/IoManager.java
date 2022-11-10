package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Input / Output 기능을 담당하는 클래스
 */
public class IoManager {

    public static List<Integer> getNumbersFromUser(String parser) {
        try {

            String line = Console.readLine();
            String pattern = "[0-9]+(" + parser + "[0-9]+)*";

            if (!validateFitInPattern(line, pattern)) {
                throw new Exception();
            }

            return Arrays.stream(line.split(parser)).map((string) -> Integer.parseInt(string))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            System.out.println("[ERROR] 형식에 알맞지 않은 입력입니다. 입력은 숫자[,숫자] 형태로 주어져야 합니다.");
            throw new IllegalArgumentException("입력은 숫자[,숫자]형태여야 합니다.");
        }
    }

    public static Integer getNumberFromUser() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            System.out.println("[ERROR] 형식에 알맞지 않은 입력입니다. 입력은 숫자로 주어져야 합니다.");
            throw new IllegalArgumentException("입력은 숫자형태여야 합니다.");
        }
    }

    private static boolean validateFitInPattern(String string, String patternString) {
        return string.matches(patternString);
    }
}
