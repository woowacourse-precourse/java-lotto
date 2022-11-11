package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class InputView {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String INPUT_PRICE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";
    private static final String DATA_TYPE_ERR_MESSAGE = "[ERROR] 숫자가 아닙니다.";
    private static final String LOTTO_RANGE_ERR_MESSAGE = "[ERROR] 로또의 범위가 올바르지 않습니다.";

    public InputView() {
    }

    public static int getPriceAmount() {
        System.out.println(INPUT_PRICE_AMOUNT);
        return convertStringtoInt(Console.readLine());
    }

    private static int convertStringtoInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DATA_TYPE_ERR_MESSAGE);
        }
    }

    public static List<Integer> getLottoNumbers() {
        System.out.println(INPUT_LOTTO_NUMBERS);
        return convertStringtoList(Console.readLine());
    }

    private static List<Integer> convertStringtoList(String numbers) {
        try {
            return Arrays.stream(numbers.split(",")).map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DATA_TYPE_ERR_MESSAGE);
        }
    }

    public static int getBonusNumbers() {
        System.out.println(INPUT_BONUS_NUMBERS);
        int bonus = convertStringtoInt(Console.readLine());
        validateRange(bonus);
        return bonus;
    }

    private static void validateRange(int bonus) {
        if (!(bonus >= MIN_NUMBER && bonus <= MAX_NUMBER)) {
            throw new IllegalArgumentException(LOTTO_RANGE_ERR_MESSAGE);
        }
    }
}