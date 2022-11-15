package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.OutputView.printPriceInputMessage;

public class InputView {
    private static final String COMMA = ",";
    private static final String REGEX = "[0-9]+";
    private static final String MONEY_INPUT_ERROR = "[ERROR] 로또를 구매하시려면 천원 단위의 금액만 가능합니다.";
    private static final String MONEY_INPUT_CONTAIN_STRING_ERROR = "[ERROR] 로또 구입 금액 입력이 잘못되었습니다.";


    public static int inputLottoPurchaseMoney() {
        printPriceInputMessage();
        String lottoPurchaseMoney = Console.readLine();
        validateContainWord(lottoPurchaseMoney);
        validateThousandUnit(lottoPurchaseMoney);
        return Integer.parseInt(lottoPurchaseMoney);
    }

    public static List<Integer> inputWinningNumber() {
        String inputNumbers = Console.readLine();
        List<Integer> winningNumbers = new ArrayList<>();
        for (String value : inputNumbers.split(COMMA)) {
            winningNumbers.add(Integer.parseInt(value));
        }
        return winningNumbers;
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    private static void validateContainWord(String lottoMoney) {
        if(!lottoMoney.matches(REGEX)) {
            throw new IllegalArgumentException(MONEY_INPUT_CONTAIN_STRING_ERROR);
        }
    }

    private static void validateThousandUnit(String lottoMoney) {
        int money = Integer.parseInt(lottoMoney);
        if(money % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_INPUT_ERROR);
        }
    }

}
