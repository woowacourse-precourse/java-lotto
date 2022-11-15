package lotto;

import java.util.*;

public class LottoNumberCheck {
    private static final int PAYMENT = 1000;
    private static final int WIN = 3;
    private static final int FIVE = 5;
    private static final int SEVEN = 7;
    private static Map<String, Integer> correctNumber;
    private static Map<List<Integer>, Integer> checkLotto;
    private static List<Integer> countPrizeNumber;
    private static Map<String, Integer> winningLotto;

    private static List<Integer> myPrizeMoney;
    private int myMoney = 0;

    public LottoNumberCheck() {
        correctNumber = new LinkedHashMap<>();
        checkLotto = new LinkedHashMap<>();
        countPrizeNumber = new ArrayList<>();
        winningLotto = new LinkedHashMap<>();
        myPrizeMoney = new ArrayList<>();
    }
    private void initPrize(Map<String, Integer> winningLotto) {
        for (Prize value : Prize.values()) {
            winningLotto.put(value.getPrize(), 0);
        }
    }


    public void compareWinNumberWithMyLotto(List<List<Integer>> lottoNumbers, List<Integer> winNumber, int bonusBall) {
        initPrize(winningLotto);

        myMoney = lottoNumbers.size();
        System.out.println(myMoney);
        saveOneOrMoreMatchLotto(lottoNumbers, winNumber, bonusBall);
        countWinningLotto(correctNumber);
    }


    private void saveOneOrMoreMatchLotto(List<List<Integer>> randomLottoNumbers, List<Integer> winNumber, int bonusBall) {
        for (int i = 0; i < randomLottoNumbers.size(); i++) {
            for (int j = 0; j < randomLottoNumbers.get(i).size(); j++) {
                compareMyLottoNumberWithWinNumber(randomLottoNumbers, i, j, winNumber);
            }
        }
        compareMyLottoNumberWithBonusNumber(checkLotto, correctNumber, bonusBall);
    }

    private void compareMyLottoNumberWithWinNumber(List<List<Integer>> randomLottoNumbers, int i, int j, List<Integer> winNumber) {
        if (randomLottoNumbers.get(i).contains(winNumber.get(j))) {
            checkLotto.put(randomLottoNumbers.get(i), checkLotto.getOrDefault(randomLottoNumbers.get(i), 0) + 1);
            correctNumber.put(randomLottoNumbers.get(i).toString(), correctNumber.getOrDefault(randomLottoNumbers.get(i).toString(), 0) + 1);
        }
    }

    private void compareMyLottoNumberWithBonusNumber(Map<List<Integer>, Integer> checkLotto, Map<String, Integer> correctNumber, int bonusBall) {
        for (List<Integer> lotto : checkLotto.keySet()) {
            if (checkLotto.get(lotto) == FIVE && lotto.contains(bonusBall)) {
                correctNumber.put(lotto.toString(), SEVEN);
            }
        }
    }

    private void countWinningLotto(Map<String, Integer> correctNumber) {
        for (String lotto : correctNumber.keySet()) {
            if (correctNumber.get(lotto) >= WIN) {
                countPrizeNumber.add(correctNumber.get(lotto));
            }
        }
    }
    public void comparePrizeMoneyWithMyPrizeLotto() {
        getPrizeMoney(countPrizeNumber);
        calculateYield(myMoney, myPrizeMoney);
    }

    private void getPrizeMoney(List<Integer> countPrizeNumber) {
        for (Integer prizeNumber : countPrizeNumber) {
            for (Prize value : Prize.values()) {
                countPrizeMoneyOfMyLotto(prizeNumber, value);
            }
        }
        combinePrizeMoney(winningLotto);

        Message.printLottoResult();
        Message.printLine();
        for (String lotto : winningLotto.keySet()) {
            System.out.print(lotto);
            System.out.print(" - " + winningLotto.get(lotto) + "개");
            System.out.println();
        }
    }

    private void combinePrizeMoney(Map<String, Integer> winningLotto) {
        for (String lotto : winningLotto.keySet()) {
            myPrizeMoney.add(winningLotto.get(lotto));
        }
    }

    private void countPrizeMoneyOfMyLotto(int totalWinNumber, Prize value) {
        if (totalWinNumber == SEVEN && value.getPrize().substring(1, 6).equals("개 일치,")) {
            winningLotto.put(value.getPrize(), winningLotto.getOrDefault(value.getPrize(), 0) + 1);
        } else if (totalWinNumber != SEVEN && value.getPrize().substring(0, 5).equals(totalWinNumber + "개 일치")){
            winningLotto.put(value.getPrize(), winningLotto.getOrDefault(value.getPrize(), 0) + 1);
        }
    }
    private void calculateYield(int myMoney, List<Integer> myPrizeMoney) {
        myMoney = myMoney * PAYMENT;

        int count = 0;
        int total = 0;
        for (PrizeMoney value : PrizeMoney.values()) {
            total += value.getPrizeMoney() * myPrizeMoney.get(count);
            count++;
        }
        double yield = ((double) total / myMoney) * 100;
        yield = Math.round(yield*10)/10.0;
        Message.printYield(yield);
    }
}
