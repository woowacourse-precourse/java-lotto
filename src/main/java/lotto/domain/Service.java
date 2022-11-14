package lotto.domain;

import static lotto.util.Constant.FIFTHPLACE;
import static lotto.util.Constant.FIRSTPLACE;
import static lotto.util.Constant.FOURTHPLACE;
import static lotto.util.Constant.NUMBEROFWINS;
import static lotto.util.Constant.SECONDPLACE;
import static lotto.util.Constant.THIDPLACE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Validator;
import lotto.view.Input;

public class Service {

    public static Integer inputMoney() {
        String payMoney = Input.input();
        Validator.validatePayMoney(payMoney);
        return Check.countBuyLotto(payMoney);
    }

    public static List<List<Integer>> firstCompareLottoNumber (List<List<Integer>> purchasedLotteries, List<Integer> winningNumbers) {
        List<List<Integer>> firstResultList = new ArrayList<>();
        for (List<Integer> purchasedLottery : purchasedLotteries) {
            List<Integer> comparedNumber = new ArrayList<>();
            comparedNumber = (purchasedLottery.stream()
                    .filter(x -> !winningNumbers.contains(x))
                    .collect(Collectors.toList()));
            firstResultList.add(comparedNumber);
        }
        System.out.println(firstResultList);
        return firstResultList;
    }

    public static void scoreLotteries (List<List<Integer>> firstResultList, int bonusNumber) {
        System.out.println(firstResultList);
        for (List<Integer> integers : firstResultList) {
            if (integers.size() == 0) {
                FIRSTPLACE++;
            }
            if (integers.size() == 1 && integers.get(0) == bonusNumber) {
                SECONDPLACE++;
            }
            if (integers.size() == 1) {
                THIDPLACE++;
            }
            if (integers.size() == 2) {
                FOURTHPLACE++;
            }
            if (integers.size() == 3) {
                FIFTHPLACE++;
            }
        }
    }
}
