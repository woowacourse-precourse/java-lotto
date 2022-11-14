package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import lotto.domain.JackpotBonus;
import lotto.valid.InputValidator;
import lotto.valid.LottoValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum InputView {
    INSTANCE;
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_JACKPOT_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String JACKPOT_NUMBER_SEPARATOR = ",";

    public static String inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String money = Console.readLine();

        return money;
    }

    public static JackpotBonus inputJackpotBonus(){
        List<Integer> jackpotNumbers = inputJackpotNumbers();
        int bonusNumber = inputBonusNumber();

        return new JackpotBonus(jackpotNumbers, bonusNumber);
    }

    private static List<Integer> inputJackpotNumbers() {
        System.out.println(INPUT_JACKPOT_NUMBERS_MESSAGE);
        String jackpotNumberInput = Console.readLine();

        InputValidator.validateJackpotNumberFormat(jackpotNumberInput);

        List<Integer> jackpotNumbers =
                Arrays.stream(jackpotNumberInput.split(JACKPOT_NUMBER_SEPARATOR))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        LottoValidator.validate(jackpotNumbers);

        return jackpotNumbers;
    }
    private static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();

        InputValidator.validateBonusNumber(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }
}
