package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        List<Integer> numbers = new ArrayList<>(6);
        try {
            Lotto.enterPriceOfLotto();
            Lotto.createRandomNumbers();
            Lotto.printPurchasedLotto();

            inputNumbers(numbers);                              // 로또 당첨 번호 입력
            Lotto mylotto = new Lotto(numbers);
            mylotto.enterBonusNumber();
            mylotto.calculatePrize();
            mylotto.printStatisticsForLotto();
            mylotto.calculateRateOfEarning();
            mylotto.printRateOfEarning();
        } catch (IllegalArgumentException e){}
    }

    private static void inputNumbers(List<Integer> numbers) {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] s = Console.readLine().split(",");
        determineNumbers(numbers, s);
    }

    private static void determineNumbers(List<Integer> numbers, String[] s) {
        if (s.length!=6) {
            System.out.println("[ERROR] 6개의 숫자를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 6; i++) {
            numbers.add(Integer.valueOf(s[i]));
        }
    }
}
