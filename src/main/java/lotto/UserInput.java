package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class UserInput {

    // 구입 금액 입력
    public static String getLottoMoney () {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        System.out.println();
        return inputMoney;
    }
    // 당첨 번호 입력
    public static String getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    // 보너스 번호 입력
    public static String getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
