package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LottoInStream {
    private static final int _lotto_number_max_length = 6;
    private static final int _lotto_bonus_max_length = 1;
    private static final int _bonus_index = 0;
    private static final String _input_buy_str = "구입금액을 입력해 주세요.\n";
    private static final String _input_numbers_str = "당첨 번호를 입력해 주세요.\n";
    private static final String _input_bonus_number_str = "보너스 번호를 입력해 주세요.\n";
    private static final String _error_default_msg = "[ERROR]";

    public static Integer readToBuyLotto() {
        System.out.print(_input_buy_str);
        String line = readline();

        if (isNullOrEmptyString(line)) {
            throw new IllegalArgumentException(_error_default_msg + " 잘못된 입력 값 입니다.");
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
            throw new IllegalArgumentException(_error_default_msg + " 잘못된 입력 값 입니다.");
        }
        if (line.length() != _lotto_number_max_length) {
            throw new IllegalArgumentException(
                    _error_default_msg + " 당첨 번호는 " + _lotto_number_max_length + "개를 입력해야 합니다.");
        }
        return convStrToIntList(line);
    }

    public static int readToGetLottoBonus() {
        System.out.print(_input_bonus_number_str);
        String line = readline();

        if (isNullOrEmptyString(line)) {
            throw new IllegalArgumentException(_error_default_msg + " 잘못된 입력 값 입니다.");
        }
        if (line.length() != _lotto_bonus_max_length) {
            throw new IllegalArgumentException(
                    _error_default_msg + " 당첨 번호는 " + _lotto_bonus_max_length + "개를 입력해야 합니다.");
        }
        return (convCharToInt(line.charAt(_bonus_index)));
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

    private static List<Integer> convStrToIntList(String line) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < line.length(); ++i) {
            char ch = line.charAt(i);

            if (!isNumber(line.charAt(i))) {
                throw new IllegalArgumentException(_error_default_msg + " 숫자가 아닌 문자는 처리할 수 없습니다.");
            }
            numbers.add(charToDigit(ch));
        }
        return numbers;
    }

    private static int convCharToInt(char ch) {
        if (!isNumber(ch)) {
            throw new IllegalArgumentException(_error_default_msg + " 숫자가 아닌 문자는 처리할 수 없습니다.");
        }
        return (charToDigit(ch));
    }
}
