package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class input {
    final static String NoticeInputBonus = "보너스 번호를 입력해 주세요.";
    final static String NoticeWinStats = "당첨 통계";

    public static int inputMoney() {
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

    public static List<Integer> inputWinNum() {
        List<Integer> numbers = new ArrayList<>();
        String[] inputNum = Console.readLine().split(",");
        return numbers;
    }


}
