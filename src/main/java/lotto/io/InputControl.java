package lotto.io;

import static lotto.message.ErrorMessage.INVALID_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputControl {

    public static int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    public static List<Integer> readInts(String delim) {
        return new InputNums(delim, readLine()).splitToInts();
    }


    public static String readLine() {
        return Console.readLine();
    }
}
