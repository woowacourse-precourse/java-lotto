package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String WRITE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WRITE_LOTTO = "\n당첨 번호를 입력해 주세요.";
    private static final String WRITE_BONUS = "\n보너스 번호를 입력해 주세요.";

    public static int getInputMoney() {
        System.out.println(WRITE_PURCHASE_AMOUNT);

        int inputMoney = Integer.parseInt(Console.readLine());
        return inputMoney;
    }

    public static String[] getNumbers() {
        System.out.println(WRITE_LOTTO);

        String[] numbers = Console.readLine().split(",");
        return numbers;
    }

    public static int getBonusNumber() {
        System.out.println(WRITE_BONUS);

        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;

    }
}
