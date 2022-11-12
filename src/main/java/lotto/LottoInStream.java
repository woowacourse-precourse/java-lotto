package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LottoInStream {
    private static final int _lotto_number_length = 6;
    private static final int _lotto_bonus_length = 1;
    private static final int _bonus_index = 0;
    private static final String _error_default_msg = "[ERROR]";

    public static int readToBuyLotto() {
        LottoOutStream.askPurchaseAmount();
        String line = readline();

        if (isNullOrEmptyString(line)) {
            throw new IllegalArgumentException(_error_default_msg + " 빈 문자열은 입력할 수 없습니다.");
        }

        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> readToGetLottoNumbers() {
        LottoOutStream.askWinningNumber();
        String line = readline();

        if (isNullOrEmptyString(line)) {
            throw new IllegalArgumentException(_error_default_msg + " 빈 문자열은 입력할 수 없습니다.");
        }
        return convStrArrayToIntList(line.split(","));
    }

    public static int readToGetLottoBonus(Lotto lotto) {
        LottoOutStream.askBonusNumber();
        String line = readline();

        if (isNullOrEmptyString(line)) {
            throw new IllegalArgumentException(_error_default_msg + " 빈 문자열은 입력할 수 없습니다.");
        }

        int number = convStringToInt(line);
        if (lotto.hasNumber(number)) {
            throw new IllegalArgumentException(_error_default_msg + " 보너스 번호는 당첨 번호와 중복되는 번호를 가질 수 없습니다.");
        }
        return (number);
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

    private static List<Integer> convStrArrayToIntList(String[] splitedLine) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < splitedLine.length; ++i) {
            numbers.add(convStringToInt(splitedLine[i]));
        }
        return numbers;
    }

    private static int convStringToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(_error_default_msg + " 숫자가 아닌 문자는 처리할 수 없습니다.");
        }
    }
}
