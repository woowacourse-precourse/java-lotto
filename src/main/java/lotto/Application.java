package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {

        List<Integer> numbers = new ArrayList<>(6);
        try {
            Lotto.enterPriceOfLotto();                          // 구입한 로또 가격 입력
            Lotto.createRandomNumbers();                        // 랜덤 로또 번호 생성
            Lotto.printPurchasedLotto();                        // 로또 번호를 오름차순으로 출력
            inputNumbers(numbers);                              // 로또 당첨 번호 입력
            Lotto mylotto = new Lotto(numbers);                 // 인스턴스 생성
            mylotto.enterBonusNumber();                         // 보너스 번호 입력
            mylotto.calculatePrize();                           // 구입한 로또 순위 결정
            mylotto.printStatisticsForLotto();                  // 로또 통계 출력
            mylotto.calculateRateOfEarning();                   // 수익률 계산, 출력
        } catch (IllegalArgumentException e){}                  // IllegalArgumentException 예외 정상 종료
    }

    private static void inputNumbers(List<Integer> numbers) {
        System.out.println("당첨 번호를 입력해 주세요.");
        determineNumbers(numbers, Console.readLine().split(","));
    }

    private static void determineNumbers(List<Integer> numbers, String[] s) {
        if (s.length != 6) {
            System.out.println("[ERROR] 6개의 숫자를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 6; i++) {
            numbers.add(Integer.valueOf(s[i]));                   // 로또 당첨 번호 리스트 생성
        }
    }
}
