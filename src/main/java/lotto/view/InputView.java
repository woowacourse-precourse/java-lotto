package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getLottoPrice() {
        System.out.println("���Աݾ��� �Է��� �ּ���.");
        return Console.readLine();
    }

    public static String getWinningNumberInput() {
        System.out.println("\n��÷ ��ȣ�� �Է��� �ּ���.");
        return Console.readLine();
    }

    public static String getBonusNumberInput() {
        System.out.println("\n���ʽ� ��ȣ�� �Է��� �ּ���.");
        return Console.readLine();
    }
}