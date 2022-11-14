package lotto.domain;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static lotto.util.Constant.FIFTHPLACE;
import static lotto.util.Constant.FIRSTPLACE;
import static lotto.util.Constant.FOURTHPLACE;
import static lotto.util.Constant.SECONDPLACE;
import static lotto.util.Constant.THIRDPLACE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Validator;
import lotto.view.Input;

public class Service {

    public static double inputMoney() {
        String payMoney = Input.input();
        Validator.validatePayMoney(payMoney);
        return parseDouble(payMoney);
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
                FIRSTPLACE++;
            }
            if (integers.size() == 1 && integers.get(0) == bonusNumber) {
                System.out.println(integers.get(0));
                SECONDPLACE++;
            }
            if (integers.size() == 1) {
                THIRDPLACE++;
            }
            if (integers.size() == 2) {
                FOURTHPLACE++;
            }
            if (integers.size() == 3) {
                FIFTHPLACE++;
            }
        }
    }

    public static String getYield (double payMoney) {
        double yield = (FIRSTPLACE * 200000000 + SECONDPLACE * 30000000 + THIRDPLACE * 1500000 + FOURTHPLACE * 50000
                + FIFTHPLACE * 50000) /payMoney;
        return (String.format("%.1f", yield));
    }
}
