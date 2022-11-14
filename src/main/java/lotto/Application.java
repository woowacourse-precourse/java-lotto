package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    final static int MAX_LOTTO_LENGTH = 6;

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

    public static void printRandomNumbers(List<List<Integer>> randomNumbers, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(randomNumbers.get(i));
        }
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
        String winningNumbers = Console.readLine();
        String[] tempWinningNumbers = winningNumbers.split(",");

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < MAX_LOTTO_LENGTH; i++) {
            numbers.add(Integer.parseInt(tempWinningNumbers[i]));
        }

        return numbers;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 로또 구입 금액 입력 기능 구현
        int amount = Integer.parseInt(inputPurchaseAmount());
        int count = amount / 1000;

        // 로또의 수량 및 랜덤 번호 출력 기능 구현
        System.out.println(count + "개를 구매했습니다.");
        List<List<Integer>> randomNumbers = new ArrayList<List<Integer>>();
        randomNumbers = saveRandomNumbers(count, randomNumbers);
        printRandomNumbers(randomNumbers, count);

        // 당첨 번호 입력 기능 구현
        Lotto lotto = new Lotto(inputWinningNumbers());

        // 보너스 번호 입력 기능 구현
        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        lotto.printWinningResult(randomNumbers, count);
    }
}
