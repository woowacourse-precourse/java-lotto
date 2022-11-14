package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        LottoCore lottoCore = new LottoCore();
        LottoInputOutput lottoIO = new LottoInputOutput();

        moneyInput(buyer, lottoIO);

        buyLottos(buyer, lottoCore, lottoIO);

        setWinningLottoNums(lottoCore, lottoIO);

        compareLottos(buyer, lottoCore, lottoIO);
    }

    private static void compareLottos(Buyer buyer, LottoCore lottoCore, LottoInputOutput lottoIO) {
        Map<LottoPrize, Integer> prizeList = lottoCore.compareLotto(buyer.getLottos());
        lottoIO.printWinningList(prizeList);
        buyer.setWinmoney(prizeList);
        lottoIO.printWinningRate(buyer.getWinMoney(), buyer.getMoney());
    }

    private static void setWinningLottoNums(LottoCore lottoCore, LottoInputOutput lottoIO) {
        List<Integer> winnigLotto = lottoIO.getWinnigLottoAndCheck();
        int bonus = lottoIO.getBonusNumberAndCheck(winnigLotto);
        lottoCore.setWinnigLotto(winnigLotto);
        lottoCore.setBonus(bonus);
    }

    private static void moneyInput(Buyer buyer, LottoInputOutput lottoIO) {
        buyer.setMoney(lottoIO.getMoneyInput());
        buyer.setLottoCount();
    }

    private static void buyLottos(Buyer buyer, LottoCore lottoCore, LottoInputOutput lottoIO) {
        List<Lotto> buyerLottos = lottoCore.createManyLotto(buyer.getLottoCount());
        lottoIO.printLottoCount(buyer.getLottoCount());
        lottoIO.printLotto(buyerLottos);
        buyer.setLottos(buyerLottos);
    }
}
