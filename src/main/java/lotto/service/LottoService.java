package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static lotto.domain.Lotto.issueLotto;
import static lotto.domain.Statistic.findStatistic;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.printLottoNumber;

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

    }

    public static List<Integer> stringToIntList(String input) {
        String[] splitInput = input.split(",");
        List<Integer> output = new ArrayList<>();

        for (String e : splitInput) {
            output.add(Integer.parseInt(e));
        }
        return output;
    }

    // 일치하는 로또 번호 개수와 보너스 번호를 기준으로 Statistic을 선정하고 조건을 만족하면 StatisticAndCount의 value에 1을 추가한다.
    private static void countStatistic(Lotto inputLotto, int bonus, List<Lotto> issuedLotteries,
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
}
