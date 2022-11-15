package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String PURCHASE_LOTTO_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WIN_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REGEX_NUMBER = "^[0-9]+$";
    private static final String NOT_NUMBER_INPUT_ERROR = "[ERROR] 해당 입력은 숫자만 가능합니다.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;
    private static final String LIMIT_CHECK_ERROR = "[ERROR] 입력한 번호 중 1~45 범위를 벗어나는 번호가 있습니다.";


    public static int moneyInput() {
        OutputView.printString(PURCHASE_LOTTO_INPUT_MESSAGE);
        String money = Console.readLine();
        if(!money.matches(REGEX_NUMBER)) {
            throw new IllegalArgumentException(NOT_NUMBER_INPUT_ERROR);
        }
        return Integer.parseInt(money);
    }

    public static Lotto winNumbersInput() {
        OutputView.printString(WIN_NUMBERS_INPUT_MESSAGE);
        String inputWinNumbers = Console.readLine();
        List<String> tempNumbers = Arrays.asList((inputWinNumbers.split(",")));
        List<Integer> winNumbers = new ArrayList<>();
        for (String tempNum : tempNumbers) {
            if(!tempNum.matches(REGEX_NUMBER)) {
                throw new IllegalArgumentException(NOT_NUMBER_INPUT_ERROR);
            }
            winNumbers.add((Integer.parseInt(tempNum)));
        }
        return new Lotto(winNumbers);
    }

    public static int bonusNumberInput() {
        OutputView.printString(BONUS_NUMBER_INPUT_MESSAGE);
        String inputBonusNum = Console.readLine();
        if(!inputBonusNum.matches(REGEX_NUMBER)) {
            throw new IllegalArgumentException(NOT_NUMBER_INPUT_ERROR);
        }
        int bonusNum = Integer.parseInt((inputBonusNum));
        if (bonusNum > LOTTO_END || bonusNum < LOTTO_START ) {
            throw new IllegalArgumentException(LIMIT_CHECK_ERROR);
        }
        return bonusNum;
    }

}
