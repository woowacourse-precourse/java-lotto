package lotto.domain;

import static java.lang.Double.parseDouble;
import static lotto.util.Constant.FIFTH_PLACE;
import static lotto.util.Constant.FOURTH_PLACE;
import static lotto.util.Constant.THIRD_PLACE;
import static lotto.util.Constant.SECOND_PLACE;
import static lotto.util.Constant.FIRST_PLACE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Constant;
import lotto.util.Validator;
import lotto.view.Input;

public class Service {

    public static double inputMoney() {
        String payMoney = Input.input();
        Validator.validateInputMoneyNumber(payMoney);
        Validator.validateInputMoneyUnit(payMoney);
        return parseDouble(payMoney);
    }

    public static int countBuyLotto(double payMoney) {
        return (int) (payMoney / (Constant.MONEY_UNIT));
    }

    public static List<List<Integer>> firstCompareLottoNumber (List<List<Integer>> purchasedLotteries, List<Integer> winningNumbers) {
        List<List<Integer>> firstResultList = new ArrayList<>();
        for (List<Integer> purchasedLottery : purchasedLotteries) {
            List<Integer> comparedNumber;
            comparedNumber = (purchasedLottery.stream()
                    .filter(x -> !winningNumbers.contains(x))
                    .collect(Collectors.toList()));
            firstResultList.add(comparedNumber);
        }
        return firstResultList;
    }

    public static void scoreLotteries (List<List<Integer>> firstResultList, int bonusNumber) {
        for (List<Integer> integers : firstResultList) {
            if (integers.size() == 0) {
                FIRST_PLACE++;
            }
            if (integers.size() == 1 && integers.get(0) == bonusNumber) {
                System.out.println(integers.get(0));
                SECOND_PLACE++;
            }
            if (integers.size() == 1) {
                THIRD_PLACE++;
            }
            if (integers.size() == 2) {
                FOURTH_PLACE++;
            }
            if (integers.size() == 3) {
                FIFTH_PLACE++;
            }
        }
    }

    public static String getYield (double payMoney) {
        double yield = ((FIRST_PLACE * 200000000 + SECOND_PLACE * 30000000 + THIRD_PLACE * 1500000 + FOURTH_PLACE * 50000
                + FIFTH_PLACE * 50000) /payMoney)*10;
        return (String.format("%.1f", yield));
    }
}
