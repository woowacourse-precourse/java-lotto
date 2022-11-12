package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LottoInStream {

    public static int readAmount() {
        LottoOutStream.askPurchaseAmount();
        String line = readlineWithoutException();

        if (isNullOrEmptyString(line)) {
            throw new IllegalArgumentException(Application._err_msg + " 빈 문자열은 입력할 수 없습니다.");
        }
        return convStrToInt(line);
    }

    public static List<Integer> readLottoNumbers() {
        LottoOutStream.askWinningNumber();
        String line = readlineWithoutException();

        if (isNullOrEmptyString(line)) {
            throw new IllegalArgumentException(Application._err_msg + " 빈 문자열은 입력할 수 없습니다.");
        }
        return convStrArrayToIntList(line.split(","));
    }

    public static int readBonusNumber(Lotto lotto) {
        LottoOutStream.askBonusNumber();
        String line = readlineWithoutException();

        if (isNullOrEmptyString(line)) {
            throw new IllegalArgumentException(Application._err_msg + " 빈 문자열은 입력할 수 없습니다.");
        }

        int number = convStrToInt(line);
        if (lotto.hasNumber(number)) {
            throw new IllegalArgumentException(Application._err_msg + " 보너스 번호는 당첨 번호와 중복되는 번호를 가질 수 없습니다.");
        }
        return (number);
    }

    private static String readlineWithoutException() {
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
            numbers.add(convStrToInt(splitedLine[i]));
        }
        return numbers;
    }

    private static int convStrToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(Application._err_msg + " 숫자가 아닌 문자는 처리할 수 없습니다.");
        }
    }
}
