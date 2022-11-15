package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoException;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static int inputMoney() {
        LottoException lottoException = new LottoException();
        System.out.println(INPUT_MONEY);
        String stringMoney = Console.readLine();
//        lottoException.inputException(stringMoney);
        int money = Integer.parseInt(stringMoney);
        return money;
    }

    public static String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        String winningNumber = Console.readLine();
        System.out.println();
        return winningNumber;
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String StringBonusNumber = Console.readLine();
        System.out.println();
        int bonusNumber = Integer.parseInt(StringBonusNumber);
        return bonusNumber;
    }
}
