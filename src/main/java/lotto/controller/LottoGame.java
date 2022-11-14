package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.UI.User;
import lotto.enums.LottoRanking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.Lotto.printLotto;
import static lotto.enums.LottoRanking.*;

public class LottoGame {
    private static final String BUY_LOTTO = "%s개를 구매했습니다.\n";
    private static final String END_GAME = "당첨 통계\n---";
    private static final String RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";
    public static List<List<Integer>> makeLottos(Integer money) {
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
        User user = new User();
        String userInput = user.askPurchaseAmount();
        user.numberCheck(userInput);
        Integer userMoney = user.convertToInteger(userInput);
        List<List<Integer>> randomLottoNumbers = makeLottos(userMoney);
        printLotto(randomLottoNumbers);
        List<Integer> userNumbers = user.lottoNumberReceiveInput();
        Integer userBonusNumber = user.validCheckBonusNumber();
        for (int size = 0; size < randomLottoNumbers.size(); size++) {
            statisticsInput(compareLottoNumber(userNumbers, randomLottoNumbers.get(size), userBonusNumber));
        }
        System.out.println(END_GAME);
        statisticalOutput();
        rateOfReturnOutput(userMoney);
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
        switch (sameNumber) {
            case 3:
                FIFTH.count++;
                break;
            case 4:
                FOURTH.count++;
                break;
            case 5:
                THIRD.count++;
                break;
            case 7:
                SECOND.count++;
                break;
            case 6:
                FIRST.count++;
                break;
        }

    }
    public static void statisticalOutput() {
        LottoRanking[] grades = LottoRanking.values();
        for (LottoRanking grade : grades) {
            System.out.println(grade.getValue());
        }
    }
    public static void rateOfReturnOutput(Integer userMoney) {
        Integer sum = 0;
        LottoRanking[] grades = LottoRanking.values();
        for (LottoRanking grade : grades) {
            if (grade.count != 0) {
                sum += grade.prizeMoney;
            }
        }
        System.out.println(String.format(RATE_OF_RETURN,Math.round(((sum * 100.0) / userMoney) * 10) / 10.0));

    }


}
