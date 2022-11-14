package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class input {

    public static int inputMoney() {
        int getMoney = 0;
        try {
            getMoney = Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 금액을 입력하세요.");
        }
        return countLotto(getMoney);
    }

    public static int countLotto(int money) {
        int count =  money / 1000;
        if((money % 1000) != 0) {
            System.out.println("[ERROR] 1000원 단위 금액으로 입력하세요");
            throw new IllegalArgumentException();
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
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자를 입력하세요.");
        }
        validate(numbers,bonusNum);
        return bonusNum;
    }

    private static void validate(List<Integer> numbers, int bonusNum) {
        if ((bonusNum < 1) || (bonusNum > 45)) {
            System.out.println("[ERROR] 1~45 범위의 번호를 입력하세요.");
            throw new IllegalArgumentException();
        }
        if (numbers.contains(bonusNum)) {
            System.out.println("[ERROR] 중복되지 않은 수를 입력하세요.");
            throw new IllegalArgumentException();
        }
    }


}
