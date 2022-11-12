package lotto.controller;

import lotto.UI.User;
import lotto.enums.LottoRanking;

import java.util.List;

import static lotto.domain.Lotto.makeLottos;
import static lotto.domain.Lotto.printLotto;
import static lotto.enums.LottoRanking.*;

public class LottoGame {

    public static void startGame() {
        User user = new User();

        Integer userMoney = user.checkMonetaryUnit(user.askPurchaseAmount());
        List<List<Integer>> randomLottoNumbers = makeLottos(userMoney);
        printLotto(randomLottoNumbers);
        List<Integer> userNumbers = user.lottoNumberReceiveInput();
        Integer userBonusNumber = user.bonusNumberRangeCheck(user.inputBonusNumber());

        for (int size = 0; size < randomLottoNumbers.size(); size++) {
            statisticsInput(compareLottoNumber(userNumbers, randomLottoNumbers.get(size), userBonusNumber));
        }
        System.out.println("당첨 통계\n---");
        statisticalOutput();
        rateOfReturn(userMoney);
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

    public static void rateOfReturn(Integer userMoney) {
        Integer sum = 0;
        LottoRanking[] grades = LottoRanking.values();
        for (LottoRanking grade : grades) {
            if (grade.count != 0) {
                sum += grade.prizeMoney;
            }
        }
        System.out.println("총 수익률은 " + Math.round(((sum * 100.0) / userMoney) * 10) / 10.0 + "%입니다.");
    }

}
