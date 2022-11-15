package lotto;

import java.util.List;

import static lotto.InputView.inputBonusNumber;
import static lotto.InputView.inputPurchase;
import static lotto.InputView.inputWinLotto;
import static lotto.Lottos.createRandomLottos;
import static lotto.utils.Messages.ERROR_DIGIT_MESSAGE;
import static lotto.utils.Messages.ERROR_DUPLICATION_MESSAGE;

public class LottoController {

    public void run() {
        int purchase = getPurchase();

        List<List<Integer>> randomLottos = getRandomLottos(purchase);
        ResultView.printRandomLottos(randomLottos,purchase / 1000);

        List<Integer> WinLotto = getWinLotto();
        int bonus = getBonusNumber();
        isDuplicate(WinLotto,bonus);

        printResult(WinLotto, randomLottos, bonus, purchase);
    }

    private int getPurchase() {
        int inputPurchase = inputPurchase();
        Purchase purchase = new Purchase(inputPurchase);
        return purchase.getPurchase();
    }

    private List<List<Integer>> getRandomLottos(int purchase) {
        return createRandomLottos(purchase / 1000);
    }

    private List<Integer> getWinLotto() {
        List<Integer> inputWinLotto = inputWinLotto();

        Lotto lotto = new Lotto(inputWinLotto);
        return lotto.getLotto();
    }

    private int getBonusNumber() {
        int inputBonusNumber = inputBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber);
        return bonusNumber.getBonusNumber();
    }

    private void printResult(List<Integer> WinLotto, List<List<Integer>> randomLottos, int bonus, int purchase) {
        Lotto lotto = new Lotto(WinLotto);
        RankResult rankResult = new RankResult();

        rankResult.initEnumMap();
        rankResult.addRankMapCount(lotto.getLotto(), randomLottos, bonus);

        ResultView.printResult(rankResult);
        ResultView.printProfit(rankResult, purchase);
    }

    private void isDuplicate(List<Integer> WinLotto,int bonus) {
        if(WinLotto.contains(bonus))
            System.out.println(ERROR_DUPLICATION_MESSAGE);
            throw new IllegalArgumentException();
    }
}
