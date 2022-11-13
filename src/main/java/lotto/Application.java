package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> numbers = new ArrayList<>(6);

        Lotto.enterPriceOfLotto();
        Lotto.createRandomNumbers();
        Lotto.printPurchasedLotto();

        // 로또 당첨 번호 입력

        System.out.println("당첨 번호를 입력해 주세요.");
        String[] s = Console.readLine().split(",");
        for (int i = 0; i < 6; i++) {
            numbers.add(Integer.valueOf(s[i]));
        }


        // 인스턴스 객체 생성

        Lotto mylotto = new Lotto(numbers);
        mylotto.enterBonusNumber();
        mylotto.calculatePrize();
        mylotto.printStatisticsForLotto();
        mylotto.calculateRateOfEarning();
        mylotto.printRateOfEarning();







    }
}
