package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Const.*;

public class Store {
    private List<Lotto> lottos;
    private Customer customer;
    private Result result;

    public Store() {
        lottos = new ArrayList<>();
        customer = new Customer();
        result = new Result();
    }

    public List<Integer> issue() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void entry() {
        int numberOfPurchases = purchase();
        allIssue(numberOfPurchases);
        writeLotto();
        compareLotto();
        printTotalStatistic(numberOfPurchases);
    }

    private int purchase() {
        System.out.println(BEFORE_PURCHASE);
        int numberOfPurchases = customer.buy(Console.readLine());
        System.out.println("\n" + numberOfPurchases + AFTER_PURCHASE);
        return numberOfPurchases;
    }

    private void allIssue(int numberOfPurchases) {
        for (int i = 0; i < numberOfPurchases; i++) {
            Lotto lotto = new Lotto(issue());
            System.out.println(sortLotto(lotto));
            lottos.add(lotto);
        }
    }

    private void writeLotto() {
        System.out.println("\n" + INPUT_WINNING_NUMBER);
        customer.inputWinningNumber(Console.readLine());
        System.out.println("\n" + INPUT_BONUS_NUMBER);
        customer.inputBonusNumber(Console.readLine());
    }

    private void compareLotto() {
        for (Lotto lotto : lottos) {
            result.compare(customer, lotto);
        }
    }

    private void printTotalStatistic(int numberOfPurchases) {
        System.out.println("\n" + STATISTIC);
        result.printStatistic();
        System.out.println(LEADING_PRICE +
                calculateRateOfReturn(numberOfPurchases, result.getTotalReward()) + TRAILING_PRICE);
    }

    private String calculateRateOfReturn(int numberOfPurchases, long reward) {
        float rateOfReturn = (reward / (float) (numberOfPurchases * BILL)) * CONVERT_TO_PERCENTAGE;
        rateOfReturn = Math.round(rateOfReturn * 10) / 10f;
        return String.format("%.1f", rateOfReturn);
    }

    private List<Integer> sortLotto(Lotto lotto) {
        List<Integer> lottoCopy = new ArrayList(lotto.getNumbers());
        Collections.sort(lottoCopy);
        return lottoCopy;
    }
}
