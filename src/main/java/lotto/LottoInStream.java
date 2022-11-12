package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LottoInStream {
    private static final String _input_buy_str = "구입금액을 입력해 주세요.\n";
    private static final String _input_numbers_str = "당첨 번호를 입력해 주세요.\n";
    private static final String _input_bonus_number_str = "보너스 번호를 입력해 주세요.\n";

    public static Integer readToBuyLotto(Integer money) {
        System.out.print(_input_buy_str);
        String line = readline();

        if (isNullOrEmptyString(line)) {
            throw new IllegalArgumentException();
        }

        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> readToGetLottoNumbers() {
        System.out.print(_input_numbers_str);
        String line = readline();

        if (isNullOrEmptyString(line)) {
            throw new IllegalArgumentException();
        }
        if (line.length() != 6) {
            throw new IllegalArgumentException();
        }
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < line.length(); ++i) {
            char ch = line.charAt(i);

            if (!isNumber(line.charAt(i))) {
                throw new IllegalArgumentException();
            }
            numbers.add(charToDigit(ch));
        }
        return numbers;
    }

    public static int readToGetLottoBonus() {
        System.out.print(_input_bonus_number_str);

        String line = readline();

        if (isNullOrEmptyString(line)) {
            throw new IllegalArgumentException();
        }
        if (line.length() != 1) {
            throw new IllegalArgumentException();
        }

        char ch = line.charAt(0);

        if (!isNumber(ch)) {
            throw new IllegalArgumentException();
        }
        return (charToDigit(ch));
    }

    private static boolean isNumber(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }

    private static int charToDigit(char ch) {
        return ch - '0';
    }

    private static String readline() {
        try {
            return (Console.readLine());
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    private static boolean isNullOrEmptyString(String line) {
        if (line == null || line.isEmpty()) {
            return true;
        }
        return false;
    }
}
