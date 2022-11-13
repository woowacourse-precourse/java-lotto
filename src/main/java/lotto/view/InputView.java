package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String priceInput() {
        System.out.println("구입 금액을 입력하세요 : ");
        String userMoney = Console.readLine();

        return userMoney;
    }

    public static String lottoInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String targetInput = Console.readLine();

        return targetInput;
    }

    public static String bonusInput() {
        System.out.println("보너스 번호를 입력해 주세요");
        String bonusInput = Console.readLine();

        return bonusInput;
    }
}
