package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserInterface {

    private static final String MONEY_UI = "구입금액을 입력해주세요.";
    private static final String PURCHASE_UI = "개를 구매했습니다.";
    private static final String WIN_NUMBERS_UI = "당첨 번호를 입력해주세요.";
    private static final String BONUS_NUMBER_UI = "보너스 번호를 입력해주세요";

    public static String readMoney() {
        System.out.println(MONEY_UI);
        return Console.readLine();
    }

    public static String readWinNumbers() {
        System.out.println(WIN_NUMBERS_UI);
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println(BONUS_NUMBER_UI);
        return Console.readLine();
    }

    public static void printLottoNumbers(List<Lotto> numbers) {
        System.out.println(numbers.size() + PURCHASE_UI);
        for (Lotto num : numbers) {
            System.out.println(num);
        }
    }
}
