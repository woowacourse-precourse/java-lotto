package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.BonusNumberDto;
import lotto.dto.MoneyDto;
import lotto.dto.WinningNumbersDto;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";
    private static final String CLASS_CREATE_EXCEPTION_MESSAGE = "생성할 수 없는 클래스입니다.";

    private InputView() {
        throw new IllegalStateException(CLASS_CREATE_EXCEPTION_MESSAGE);
    }

    public static MoneyDto inputMoney() {
        printInputMoneyMessage();
        return new MoneyDto(Console.readLine());
    }

    private static void printInputMoneyMessage() {
        System.out.println(INPUT_MONEY);
    }

    public static WinningNumbersDto inputWinningNumbers() {
        printInputWinningNumbers();
        return new WinningNumbersDto(Console.readLine());
    }

    private static void printInputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
    }

    public static BonusNumberDto inputBonusNumber(WinningNumbersDto winningNumbersDto) {
        printInputBonusNumber();
        return new BonusNumberDto(Console.readLine(), winningNumbersDto);
    }

    private static void printInputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBERS);
    }
}
