package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AboutInputOutput {
    String PLEASE_ENTER_MONEY = "구입금액을 입력해 주세요.";
    String PLEASE_ENTER_NUMBERS = "당첨 번호를 입력해 주세요.";
    String ERROR_ENTER_ONLY_NUMBERS = "[ERROR] 숫자만 입력해주세요";
    String PLEASE_ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    String ERROR_DUPLICATED_NUMBER = "[ERROR] 로또 번호는 중복될 수 없습니다.";

    public Integer inputMoney() {
        String inputMoney = Console.readLine();
        return validateMoney(inputMoney);
    }

    public Integer validateMoney(String inputMoney) {
        int money = 0;

        while(money == 0) {
            try {
                money = Integer.parseInt(inputMoney);
            } catch (NumberFormatException e) {
                System.out.println(ERROR_ENTER_ONLY_NUMBERS);
                inputMoney();
            }
        }

        return money;
    }

    public void outputLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottoSet(List<List<Integer>> lottoSet) {
        for (List<Integer> lotto : lottoSet) {
            System.out.println(lotto);
        }
    }

    public List<Integer> inputNumbers() {
        String[] winningNumbers =  Console.readLine().split(",");
        return orderedNumbers(winningNumbers);
    }

    public List<Integer> orderedNumbers(String[] winningNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String winningNumber : winningNumbers) {
            try {
                numbers.add(Integer.valueOf(winningNumber));
            } catch (NumberFormatException e) {
                System.out.println(ERROR_ENTER_ONLY_NUMBERS);
                throw new IllegalArgumentException();
            }
        }
        Collections.sort(numbers);
        return numbers;
    }

    public void inputBonusNumber(List<Integer>numbers) {
        int bonus = 0;
        try {
            bonus = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println(ERROR_ENTER_ONLY_NUMBERS);
            throw new IllegalArgumentException();
        }

        if (numbers.contains(bonus)) {
            System.out.println(ERROR_DUPLICATED_NUMBER);
            throw new IllegalArgumentException();
        }

        numbers.add(bonus);
    }

    public void printResult(List<Integer> result) {
        System.out.println("당첨 통계\n" + "---");
        System.out.println("3개 일치 (5,000원) - " + result.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.get(0) + "개");
    }

    public void printRateOfReturn(float rateOfReturn) {
        System.out.println("총 수익률은 " + Math.round(rateOfReturn * 100) / 100.00 + "%입니다.");
    }
}
