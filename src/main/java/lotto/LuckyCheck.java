package lotto;

import static lotto.Money.*;

import java.util.ArrayList;
import java.util.List;

public class LuckyCheck {

    private Integer luckyMoney = 0;
    private List<Integer> luckyLotto = new ArrayList<Integer>(List.of(0,0,0,0,0));

    public void checkLuckyLottos(List<Lotto> lottoList, List<Integer> luckyNumber, Integer bonusNumber) {
        System.out.println("당첨 통계\n---");

        for (Lotto lotto : lottoList) {
            checkLuckyLotto(lotto, luckyNumber, bonusNumber);
        }
    }

    public void checkLuckyLotto(Lotto lotto, List<Integer> luckyNumber, Integer bonusNumber) {
        Integer matchingCount = lotto.countEqualLottoNumber(luckyNumber);
        boolean matchingBonus = lotto.isEqualBonusNumber(bonusNumber);

        checkEqualNumber(matchingCount, matchingBonus);
    }

    public void checkEqualNumber(Integer matchingCount, boolean matchingBonus) {
        if (checkSix(matchingCount)) {
            return;
        }
        if (checkFiveBonus(matchingCount, matchingBonus)) {
            return;
        }
        if (checkFive(matchingCount)) {
            return;
        }
        if (checkFour(matchingCount)) {
            return;
        }
        if (checkThree(matchingCount)) {
            return;
        }
    }

    public boolean checkThree(Integer matchingCount){
        if (matchingCount == 3) {
            luckyLotto.set(0, luckyLotto.get(0) + 1);
            luckyMoney += LUCKY_3.getMoney();

            return true;
        }
        return false;
    }

    public boolean checkFour(Integer matchingCount){
        if (matchingCount == 4) {
            luckyLotto.set(1, luckyLotto.get(1) + 1);
            luckyMoney += LUCKY_4.getMoney();

            return true;
        }
        return false;
    }

    public boolean checkFive(Integer matchingCount){
        if (matchingCount == 5) {
            luckyLotto.set(2, luckyLotto.get(2) + 1);
            luckyMoney += LUCKY_5.getMoney();

            return true;
        }
        return false;
    }

    public boolean checkFiveBonus(Integer matchingCount, boolean isMatchingBonus){
        if (matchingCount == 5 && isMatchingBonus) {
            luckyLotto.set(3, luckyLotto.get(3) + 1);
            luckyMoney += LUCKY_5_BONUS.getMoney();

            return true;
        }
        return false;
    }

    public boolean checkSix(Integer matchingCount){
        if (matchingCount == 6) {
            luckyLotto.set(4, luckyLotto.get(4) + 1);
            luckyMoney += LUCKY_6.getMoney();

            return true;
        }
        return false;
    }

    public void printStatistic(Integer purchaseMoney) {
        System.out.println("3개 일치 (5,000원) - " + luckyLotto.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + luckyLotto.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + luckyLotto.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + luckyLotto.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + luckyLotto.get(4) + "개");

        System.out.println("총 수익률은 " + String.format("%.2f", ((float)luckyMoney - (float)purchaseMoney) / (float)purchaseMoney * 100) + "%입니다.");
    }

    public Integer getLuckyMoney() {
        return luckyMoney;
    }

    public List<Integer> getLuckyLotto() {
        return luckyLotto;
    }
}
