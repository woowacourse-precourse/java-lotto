package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.UI.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.enums.Error.ER_STRINGCHECK;
import static lotto.enums.LottoRanking.*;
import static lotto.view.Output.printLotto;
import static lotto.view.Output.rateOfReturnOutput;

public class LottoGame {
    private static final String BUY_LOTTO = "%s개를 구매했습니다.\n";

    public static List<List<Integer>> makeLottos(Integer money) {
        if (money == 0) {
            throw new IllegalArgumentException(ER_STRINGCHECK.getMessage());
        }
        List<List<Integer>> lottos = new ArrayList<>();
        System.out.printf(BUY_LOTTO, (money / 1000));
        for (int ticket = 0; ticket < money / 1000; ticket++) {
            List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lotto);
            lottos.add(lotto);
            lotto = new ArrayList<>();
        }
        return lottos;
    }

    public static void startGame() {
        try {
            String userInput = User.askPurchaseAmount();
            Integer userMoney = User.convertToInteger(userInput);
            List<List<Integer>> randomLottoNumbers = makeLottos(userMoney);
            printLotto(randomLottoNumbers);
            List<Integer> userNumbers = User.lottoNumberReceiveInput();
            Integer userBonusNumber = User.validCheckBonusNumber();
            for (int size = 0; size < randomLottoNumbers.size(); size++) {
                statisticsInput(compareLottoNumber(userNumbers, randomLottoNumbers.get(size), userBonusNumber));
            }
            rateOfReturnOutput(userMoney);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    public static Integer compareLottoNumber(List<Integer> user, List<Integer> computer, Integer bonusNumber) {
        int sameNumber = 0;

        for (int position = 0; position < user.size(); position++) {
            if (computer.contains(user.get(position))) {
                sameNumber++;
            }
        }
        if (sameNumber == 5 && computer.contains(bonusNumber)) {
            sameNumber += 2;
        }
        return sameNumber;
    }

    public static void statisticsInput(Integer sameNumber) {
        if (sameNumber == 3) {
            FIFTH.count++;
        } else if (sameNumber == 4) {
            FOURTH.count++;
        } else if (sameNumber == 5) {
            THIRD.count++;
        } else if (sameNumber == 7) {
            SECOND.count++;
        } else if (sameNumber == 6) {
            FIRST.count++;
        }
    }

}
