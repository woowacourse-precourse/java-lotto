package lotto.UI;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.stream.Stream;

public class UIScanner {
    public static int scanInt() {
        return Integer.parseInt(Console.readLine());
    }

    public static Stream<Integer> scanIntStream() {
        return Arrays.stream(Console.readLine().split(",")).map(Integer::parseInt);
    }
}
