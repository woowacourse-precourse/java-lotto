package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        LottoFactory lottoFactory = new LottoFactory();
        LottoTicket lottoTicket = new LottoTicket();
        InputOutput inputOutput = new InputOutput();

        moneyInput(lottoFactory, inputOutput);

        buyLottos(lottoFactory, lottoTicket, inputOutput);

        setWinningLottoNums(lottoTicket, inputOutput);

        compareLottos(lottoFactory, lottoTicket, inputOutput);
    }

    private static void compareLottos(LottoFactory lottoFactory, LottoTicket lottoTicket, InputOutput inputOutput) {
        Map<LottoRanking, Integer> lottoRanking = lottoTicket.compareLotto(lottoFactory.getLottos());
        inputOutput.printWinningList(lottoRanking);

        lottoFactory.setWinmoney(lottoRanking);
        inputOutput.printWinningRate(lottoFactory.getWinMoney(), lottoFactory.getMoney());
    }

    private static void setWinningLottoNums(LottoTicket lottoTicket, InputOutput inputOutput) {
        List<Integer> winnigLotto = inputOutput.getWinnigLotto();
        int bonus = inputOutput.getBonusNumber(winnigLotto);
        lottoTicket.setWinnigLotto(winnigLotto);
        lottoTicket.setBonus(bonus);
    }

    private static void moneyInput(LottoFactory lottoFactory, InputOutput inputOutput) {
        lottoFactory.setMoney(inputOutput.getMoneyInput());
        lottoFactory.setLottoCount();
    }

    private static void buyLottos(LottoFactory lottoFactory, LottoTicket lottoTicket, InputOutput inputOutput) {
        List<Lotto> buyerLottos = lottoTicket.createManyLotto(lottoFactory.getLottoCount());
        inputOutput.printLottoCount(lottoFactory.getLottoCount());
        inputOutput.printLotto(buyerLottos);
        lottoFactory.setLottos(buyerLottos);

    }
}
