package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class input {
    final static String NoticeInputMoney = "구입금액을 입력해 주세요.";
    final static String NoticeInputWin = "당첨 번호를 입력해 주세요.";
    final static String NoticeInputBonus = "보너스 번호를 입력해 주세요.";
    final static String NoticeWinStats = "당첨 통계";

    public static int inputMoney() {
        System.out.println(NoticeInputMoney);
        int getMoney = 0;
        try {
            getMoney = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]");
        }
        return countLotto(getMoney);
    }

    public static int countLotto(int money) {
        int count =  money / 1000;
        if((money % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
        return count;
    }
}
