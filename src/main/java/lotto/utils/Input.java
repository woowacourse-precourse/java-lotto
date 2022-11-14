package lotto.utils;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.enums.LottoCondition.PRICE_UNIT;

public class Input {
    private static final int REMINDER_ZERO = 0;

    public static Integer inputPrice() {
        String price = readLine();
        validateIsNumber(price);
        validatePrice(price);

        return Integer.parseInt(price);
    }

    public static List<Integer> inputWinningLotto() {
        List<Integer> winningLottos = new ArrayList<>();
        String inputLottoNumbers = readLine();
        for (String number : inputLottoNumbers.split(",")) {
            validateIsNumber(number);
            winningLottos.add(Integer.parseInt(number));
        }

        return winningLottos;
    }

    public static Integer inputBonusNumber() {
        String bonusNumber = readLine();
        validateIsNumber(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    private static void validatePrice(String inputPrice) throws IllegalArgumentException {
        int price = Integer.parseInt(inputPrice);
        if (price % PRICE_UNIT.getNumber() != REMINDER_ZERO) {
            throw new IllegalArgumentException("[ERROR] 로또는 1000원단위로 구입해야 합니다.");
        }
    }

    private static void validateIsNumber(String input) throws IllegalArgumentException {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }
}
