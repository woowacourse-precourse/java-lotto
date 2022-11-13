package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class input {
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

        for (String s : inputNum) {
            numbers.add(Integer.valueOf(s));
        }
        return numbers;
    }

    public static int inputBonus(List<Integer> numbers) {
        int bonusNum = 0;
        try {
            bonusNum = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        validate(numbers,bonusNum);
        return bonusNum;
    }

    private static void validate(List<Integer> numbers, int bonusNum) {
        if ((bonusNum < 1) || (bonusNum > 45)) {
            throw new IllegalArgumentException();
        }
        if (numbers.contains(bonusNum)) {
            throw new IllegalArgumentException();
        }
    }


}
