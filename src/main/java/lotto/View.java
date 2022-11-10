package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        return Integer.parseInt(money);
    }

    public static void printLottoList(List<Lotto> lottoList) {
        System.out.print("%d개를 구매했습니다.\n");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        return numbers;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }
}
