package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        LottoCore lottoCore = new LottoCore();
        LottoInputOutput lottoIO = new LottoInputOutput();

        buyer.setMoney(lottoIO.getMoneyInput());
        buyer.setLottoCount();

        List<Lotto> buyerLottos = lottoCore.createManyLotto(buyer.getLottoCount());
        lottoIO.printLottoCount(buyer.getLottoCount());
        lottoIO.printLotto(buyerLottos);
        buyer.setLottos(buyerLottos);

        List<Integer> winnigLotto = lottoIO.getWinnigLottoAndCheck();
        int bonus = lottoIO.getBonusNumberAndCheck(winnigLotto);

        lottoCore.setWinnigLotto(winnigLotto);
        lottoCore.setBonus(bonus);

        Map<LottoPrize, Integer> prizeList = lottoCore.compareLotto(buyer.getLottos());
        lottoIO.printWinningList(prizeList);

        buyer.setWinmoney(prizeList);
        lottoIO.printWinningRate(buyer.getWinMoney(), buyer.getMoney());

    }
}
