package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Statistic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static lotto.domain.Lotto.issueLotto;
import static lotto.domain.Statistic.*;
import static lotto.exception.InputException.lottoNumberException;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.printLottoNumber;
import static lotto.view.OutputView.printLottoResult;

public class LottoService {
    static final int LOTTO_SIZE = 6;

    public static void lottoService() {
        int count, bonus;
        Lotto inputLottoNumber;
        try {
            count = inputMoney() / 1000;
            inputLottoNumber = inputLottoNumber();
            bonus = inputBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return;
        }
        List<Lotto> issuedLotteries = issueLotto(count);
        printLottoNumber(count, issuedLotteries);
        printLottoResult(count, generateCountStatistic(inputLottoNumber, bonus, issuedLotteries));
    }

    public static List<Integer> stringToIntList(String input) {
        String[] splitInput = input.split(",");
        List<Integer> output = new ArrayList<>();

        for (String e : splitInput) {
            lottoNumberException(e);
            output.add(Integer.parseInt(e));
        }
        return output;
    }

    // countStatistic을 초기화하고 발행된 로또 수만큼 당첨 결과를 적용하여 반환한다.
    public static HashMap<Statistic, Integer> generateCountStatistic(Lotto inputLottoNumber,
                                                                     int bonus, List<Lotto> issuedLotteries) {
        HashMap<Statistic, Integer> countStatistic = new HashMap<>();
        initializeCountStatistic(countStatistic);

        for (int i = 0; i < issuedLotteries.size(); i++) {
            calculateStatistic(inputLottoNumber, bonus, issuedLotteries, countStatistic, i);
        }
        return countStatistic;
    }

    // 일치하는 로또 번호 개수와 보너스 번호를 기준으로 Statistic을 선정하고 조건을 만족하면 countStatistic의 value에 1을 추가한다.
    public static void calculateStatistic(Lotto inputLotto, int bonus, List<Lotto> issuedLotteries,
                                          HashMap<Statistic, Integer> countStatistic, int index) {
        int matchingNumber = countMatchingNumber(issuedLotteries.get(index), inputLotto);
        boolean bonusFlag = compareBonus(issuedLotteries.get(index), bonus);
        Statistic statistic = findStatistic(matchingNumber, bonusFlag);
        if (statistic != null) {
            countStatistic.replace(statistic, countStatistic.get(statistic) + 1);
        }
    }

    public static Integer countMatchingNumber(Lotto issuedLotto, Lotto inputLotto) {
        int cnt = 0;
        for (int i = 0; i < LOTTO_SIZE; i++) {
            if (issuedLotto.getNumbers().contains(inputLotto.getNumbers().get(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    public static boolean compareBonus(Lotto issuedLotto, int bonus) {
        if (issuedLotto.getNumbers().contains(bonus)) {
            return true;
        }
        return false;
    }

    public static double calculateProfit(int count, HashMap<Statistic, Integer> countStatistic) {
        double profit = 0;
        for (Statistic e : countStatistic.keySet()) {
            profit += countStatistic.get(e) * e.getPrize();
        }
        double profitRate = (profit / (count * 1000)) * 100;

        return Math.round(profitRate * 10) / 10.0;
    }
}
