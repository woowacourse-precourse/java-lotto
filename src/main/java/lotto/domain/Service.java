package lotto.domain;

import static java.util.Collections.sort;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Validator;
import lotto.view.Input;

public class Service {

    public final int matchThreeNumbersCount = 0;
    public final int matchFourNumbersCount = 0;
    public final int matchFiveNumbersCount = 0;
    public final int matchFiveNumbersAndBonusCount = 0;
    public final int matchSixNumberCount = 0;


    public static Integer inputMoney() {
        String payMoney = Input.input();
        Validator.validatePayMoney(payMoney);
        return Check.countBuyLotto(payMoney);
    }

    public static void firstCompareLottoNumber (List<List<Integer>> purchasedLotteries, List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> firstComparedResult = new ArrayList<>();

        for (List<Integer> purchasedLottery : purchasedLotteries) {
            List<Integer> comparedNumber = new ArrayList<>();
            comparedNumber = (purchasedLottery.stream()
                    .filter(winningNumbers::contains)
                    .collect(Collectors.toList()));
            firstComparedResult.add(comparedNumber.size());
        }
        System.out.println(firstComparedResult);
    }
}
