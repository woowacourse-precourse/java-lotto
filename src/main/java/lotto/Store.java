package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import com.sun.java.accessibility.util.AccessibilityListenerList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Const.BILL;
import static lotto.GuidePhrase.*;

public class Store {
    private List<Lotto> lottos;
    private Customer customer;
    private Result result;

    // 이제 해야할 것
    // 가게 입장
    // 1. 사용자에게 멘트 출력
    // 2. 사용자가 buy 해서 돈 내면 매수만큼 발행 (이 때 그만큼 List<Lotto> 로 저장해놓아야함)
    // 3. 매수만큼 발행과 동시에 정렬한 상태로 출력
    // 4. 사용자에게 멘트 출력
    // 5. 사용자가 당첨 번호 입력
    // 6. 사용자에게 멘트 출력
    // 7. 사용자가 보너스 번호 입력
    // 8. 모든 List<Lotto> 와 Customer 와 비교
    // 9. Result 에 쌓인 걸로 당첨 통계 출력
    // 10. 총 수익률 계산
    public Store() {
        lottos = new ArrayList<>();
        customer = new Customer();
        result = new Result();
    }

    public List<Integer> issue() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void entry() {
        System.out.println(BEFORE_PURCHASE);

        int numberOfPurchases = customer.buy(Console.readLine());
        System.out.println("\n" + numberOfPurchases + AFTER_PURCHASE);

        for (int i = 0; i < numberOfPurchases; i++) {
            Lotto lotto = new Lotto(issue());
            System.out.println(sortLotto(lotto));
            lottos.add(lotto);
        }

        System.out.println("\n" + INPUT_WINNING_NUMBER);
        customer.inputWinningNumber(Console.readLine());
        System.out.println("\n" + INPUT_BONUS_NUMBER);
        customer.inputBonusNumber(Console.readLine());

        for (Lotto lotto : lottos) {
            result.compare(customer, lotto);
        }

        System.out.println("\n" + STATISTIC);
        result.printStatistic();
        System.out.println(LEADING_PRICE +
                calculateRateOfReturn(numberOfPurchases, result.getTotalReward()) + TRAILING_PRICE);
    }

    public String calculateRateOfReturn(int numberOfPurchases, long reward) {
        float rateOfReturn = (reward / (float) (numberOfPurchases * BILL.getNumber())) * 100;

        rateOfReturn = Math.round(rateOfReturn * 10) / 10f;
        return String.format("%.1f", rateOfReturn);
    }

    public List<Integer> sortLotto(Lotto lotto) {
        List<Integer> lottoCopy = new ArrayList(lotto.getNumbers());

        Collections.sort(lottoCopy);
        return lottoCopy;
    }
}
