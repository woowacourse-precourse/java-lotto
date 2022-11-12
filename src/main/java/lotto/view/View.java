package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public static String getInput() {
        return Console.readLine();
    }

    public static void printDepositView() {
        System.out.println("구입금액을 입력해 주세요.");
    }
}
