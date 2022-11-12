package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputPrice = Console.readLine();
        return inputPrice;
    }

    public static String inputWinningNum() {
        System.out.println("당첨 번호를 입력해주세요.");
        String winningNum = Console.readLine();
        return winningNum;
    }

}
