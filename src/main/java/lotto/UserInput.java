package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    public static int inputMoney() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        for(int i=0; i<money.length(); i++) {
            int n = money.charAt(i);
            if(money.charAt(i)<48 || money.charAt(i)>57) {
                throw new IllegalArgumentException("[ERROR] 구입금액을 다시 입력하세요.");
            }
        }
        return Integer.parseInt(money);
    }

    public static String inputWinNumber() {
        System.out.println("당첨 번호를 입력해주세요.");

        return Console.readLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");

        return Integer.parseInt(Console.readLine());
    }
}
