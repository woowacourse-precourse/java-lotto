package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.domain.Lotto;

public class LottoInStream {
    private static final String _input_purchase_amount_msg = "구입금액을 입력해 주세요.\n";
    private static final String _input_winning_lotto_msg = "\n당첨 번호를 입력해 주세요.\n";
    private static final String _input_bonus_number_msg = "\n보너스 번호를 입력해 주세요.\n";

    public static int readAmount() {
        System.out.print(_input_purchase_amount_msg);

        String line = readline();
        
        return convStrToInt(line);
    }

    public static List<Integer> readLottoNumbers() {
        System.out.print(_input_winning_lotto_msg);

        String line = readline();
        
        return convStrArrayToIntList(line.split(","));
    }

    public static int readBonusNumber(Lotto lotto) {
        System.out.print(_input_bonus_number_msg);

        String line = readline();
        int number = convStrToInt(line);

        validateReadBonusNumber(lotto, number);
        return (number);
    }

    private static void validateReadBonusNumber(Lotto lotto, int number) {
        if (lotto.hasNumber(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되는 번호를 가질 수 없습니다.");
        }
        if (!Lotto.checkRange(number)) {
            throw new IllegalArgumentException("[ERROR] 범위를 벗어난 보너스 번호는 허용하지 않습니다.");
        }
    }

    private static String readline() {
        try {
            return (Console.readLine());
        } catch (NoSuchElementException ex) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 값 입니다.");
        }
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
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 값 입니다." + "-> \"" + number + "\"");
        }
    }
}
