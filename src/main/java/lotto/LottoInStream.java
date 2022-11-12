package lotto;

import camp.nextstep.edu.missionutils.Console;
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
