package lotto;

import java.util.List;

public class Application {
    static final Integer THREE = 3;
    static final Integer FOUR = 4;
    static final Integer FIVE = 5;
    static final Integer SIX = 6;

    public static void main(String[] args) {
        try {
            Integer money = LottoUI.purchase();
            List<Lotto> lottos = Lotto.purchase(money);
            PrintSortedLottos(lottos);
            List<Integer> winNumbers = LottoUI.receiveWinNumbers();
            Lotto winLotto = new Lotto(winNumbers);
            Integer bonusNumberVal = LottoUI.receiveBonusNumber();
            BonusNumber bonusNumber = new BonusNumber(bonusNumberVal, winLotto);

            Integer moneyEarned = matchLottos(winLotto, lottos, bonusNumber);
            double benefit = Lotto.calculateBenefit(money, moneyEarned);
            LottoUI.printBenefit(benefit);
        } catch (IllegalArgumentException e) {
        }
    }

    private static void PrintSortedLottos(List<Lotto> lottos) {
        LottoUI.numberOfLottoPurchased(lottos.size());

        for (Lotto lotto : lottos) {
            LottoUI.printLotto(lotto);
        }
    }

    private static Integer matchLottos(Lotto winLotto, List<Lotto> lottos, BonusNumber bonusNumber) {
        LottoUI.WinStatisticTitle();
        Integer matchThree = winLotto.matchWithList(lottos, bonusNumber, THREE);
        LottoUI.printWinHistory(THREE, LottoEnum.MATCH_THREE_PRIZE.getValue(), matchThree);
        Integer matchFour = winLotto.matchWithList(lottos, bonusNumber, FOUR);
        LottoUI.printWinHistory(FOUR, LottoEnum.MATCH_FOUR_PRIZE.getValue(), matchFour);
        Integer matchFive = winLotto.matchWithList(lottos, bonusNumber, FIVE);
        LottoUI.printWinHistory(FIVE, LottoEnum.MATCH_FIVE_PRIZE.getValue(), matchFive);
        Integer matchFiveIncludeBonus = winLotto.matchWihListIncludeBonus(lottos, bonusNumber, FIVE);
        LottoUI.printWinHistoryWithBonus(FIVE, LottoEnum.MATCH_FIVE_WITH_BONUS_PRIZE.getValue(), matchFiveIncludeBonus);
        Integer matchSix = winLotto.matchWithList(lottos, bonusNumber, SIX);
        LottoUI.printWinHistory(SIX, LottoEnum.MATCH_SIX_PRIZE.getValue(), matchSix);

        return earnByLottos(matchThree, matchFour, matchFive, matchFiveIncludeBonus, matchSix);
    }

    private static Integer earnByLottos(final Integer matchThree, final Integer matchFour, final Integer matchFive, final Integer matchFiveIncludeBonus, final Integer matchSix) {
        int money = 0;

        money += matchThree * LottoEnum.MATCH_THREE_PRIZE.getValue();
        money += matchFour * LottoEnum.MATCH_FOUR_PRIZE.getValue();
        money += matchFive * LottoEnum.MATCH_FIVE_PRIZE.getValue();
        money += matchFiveIncludeBonus * LottoEnum.MATCH_FIVE_WITH_BONUS_PRIZE.getValue();
        money += matchSix * LottoEnum.MATCH_SIX_PRIZE.getValue();

        return money;
    }
}
