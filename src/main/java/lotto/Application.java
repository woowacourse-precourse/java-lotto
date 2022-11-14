package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();

        return amount;
    }

    public static List<Integer> makeRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }

    public static List<List<Integer>> saveRandomNumbers(int count, List<List<Integer>> randomNumbers) {
        for (int i = 1; i <= count; i++) {
            randomNumbers.add(makeRandomNumbers());
        }
        return randomNumbers;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int amount = Integer.parseInt(inputPurchaseAmount());
        int count = amount / 1000;

        System.out.println(count + "개를 구매했습니다.");
        List<List<Integer>> randomNumbers = new ArrayList<List<Integer>>();

        randomNumbers = saveRandomNumbers(count, randomNumbers);

        System.out.println(randomNumbers);
    }
}
