package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {

    public static int inputMoney() {
        System.out.println(Messages.OUTPUT_START_GAME_MESSAGE);
        String money = Console.readLine();
        return Integer.parseInt(money);
    }

    public static void printLottoList(List<Lotto> lottoList) {
        System.out.printf(Messages.OUTPUT_BUY_MESSAGE, lottoList.size());
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static String inputWinningNumbers() {
        System.out.println(Messages.IMPUT_WINNING_NUMBERS_MESSAGE);
        String numbers = Console.readLine();
        return numbers;
    }

    public static int inputBonusNumber() {
        System.out.println(Messages.INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }
}
