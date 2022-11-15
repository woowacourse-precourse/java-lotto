package lotto;

import java.util.*;

public class LottoNumberCheck {
    private static final int PAYMENT = 1000;
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
    private void initPrize(Map<String, Integer> mapTest) {
        for (Prize value : Prize.values()) {
            mapTest.put(value.getPrize(), 0);
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
        for (List<Integer> integers : checkLotto.keySet()) {
            if (checkLotto.get(integers) == 5 && integers.contains(bonusBall)) {
                correctNumber.put(integers.toString(), 7);
            }
        }
    }

    private void countWinningLotto(Map<String, Integer> correctNumber) {
        for (String s : correctNumber.keySet()) {
            if (correctNumber.get(s) >= 3) {
                countPrizeNumber.add(correctNumber.get(s));
            }
        }
    }
    public void comparePrizeMoneyWithMyPrizeLotto() {
        getPrizeMoney(countPrizeNumber);
        calculateYield(myMoney, myPrizeMoney);
    }

    private void getPrizeMoney(List<Integer> countPrizeNumber) {
        for (Integer integer : countPrizeNumber) {
            for (Prize value : Prize.values()) {
                countPrizeMoneyOfMyLotto(integer, value);
            }
        }
        combinePrizeMoney(winningLotto);

        Message.printLottoResult();
        Message.printLine();
        for (String s : winningLotto.keySet()) {
            System.out.print(s);
            System.out.print(" - " + winningLotto.get(s) + "개");
            System.out.println();
        }
    }

    private void combinePrizeMoney(Map<String, Integer> mapTest) {
        for (String s : mapTest.keySet()) {
            myPrizeMoney.add(mapTest.get(s));
        }
    }

    private void countPrizeMoneyOfMyLotto(int integer, Prize value) {
        if (integer == 7 && value.getPrize().substring(1, 6).equals("개 일치,")) {
            winningLotto.put(value.getPrize(), winningLotto.getOrDefault(value.getPrize(), 0) + 1);
        } else if (integer != 7 && value.getPrize().substring(0, 5).equals(integer + "개 일치")){
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
