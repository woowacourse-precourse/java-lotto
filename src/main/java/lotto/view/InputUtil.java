package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtil {

    public static int readNumber() {
        return toNumber(Console.readLine());
    }

    public static List<Integer> readNumbersByDelimiter(String delimiter) {
        return toNumbers(removeBlanks(splitByDelimiter(Console.readLine(), delimiter)));
    }

    private static int toNumber(String line) {
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자가 입력되었습니다.");
        }
    }

    private static List<String> splitByDelimiter(String line, String delimiter) {
        return Arrays.asList(line.split(delimiter));
    }

    private static List<String> removeBlanks(List<String> lines) {
        return lines.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static List<Integer> toNumbers(List<String> lines) {
        return lines.stream()
                .map(InputUtil::toNumber)
                .collect(Collectors.toList());
    }
}