package Service;

import camp.nextstep.edu.missionutils.Console;
import domain.Game;

public class View {
    private static final String MESSAGE_WINNINGNUMBERS_INPUT_FORMAT="당첨번호를 입력해주세요.";
    public static final String MESSAGE_BUYINGAMOUNT_INPUT_FORMAT="구입 금액을 입력해주세요";
    public static final String MESSAGE_BONUSNUMBER_INPUT_FORMAT="보너스 번호를 입력해주세요";

    public static String read_WinningNumbers() {
        System.out.print(MESSAGE_WINNINGNUMBERS_INPUT_FORMAT);
        Game.winningNumbers_Input = Console.readLine();
        return Game.winningNumbers_Input;
    }

    public static void read_buyingLottoAmount() {
        System.out.print(MESSAGE_BUYINGAMOUNT_INPUT_FORMAT + "\n");
        Game.paymentAmount = Integer.parseInt(Console.readLine());
        if (Game.paymentAmount % Game.LottoPrice != 0) throw new IllegalArgumentException();
    }

    public static void read_bonusNumber() {
        System.out.print(MESSAGE_BONUSNUMBER_INPUT_FORMAT + "\n");
        Game.bonusNumber = Integer.parseInt(Console.readLine());
    }

}
