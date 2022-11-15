package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class NumbersReceiver {
    public NumbersReceiver() {}

    public long insertMoney() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            long money = Long.parseLong(Console.readLine());

            if (money < 0) {
                throw new IllegalArgumentException();
            }
            System.out.println();

            return money;
        } catch (Exception exception) {
            throw new IllegalArgumentException("[ERROR] 0이상의 정수만 입력 가능합니다");
        }
    }

    public List<Integer> setBasicNumbers() throws IllegalArgumentException {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] correctNumbers = Console.readLine().split(",");
        List<Integer> result = new ArrayList<>();
        System.out.println();
        try {
            for (String singleNumber : correctNumbers) {
                result.add(Integer.parseInt(singleNumber));
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 쉼표로 분리된 숫자만 입력 가능합니다.");
        }

        return result;
    }

    public int setBonusNumber() throws IllegalArgumentException{
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int result = Integer.parseInt(Console.readLine());
            System.out.println();
            return result;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능 합니다.");
        }
    }
}
