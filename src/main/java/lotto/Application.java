package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        LottoFactory lottoFactory = new LottoFactory();
        LottoTicket lottoTicket = new LottoTicket();
        InputOutput inputOutput = new InputOutput();

        lottoFactory.setMoney(inputOutput.getMoneyInput());
        lottoFactory.setLottoCount();

        List<Lotto> buyerLottos = lottoTicket.createManyLotto(lottoFactory.getLottoCount());
        inputOutput.printLottoCount(lottoFactory.getLottoCount());
        inputOutput.printLotto(buyerLottos);
        lottoFactory.setLottos(buyerLottos);

        List<Integer> winnigLotto = inputOutput.getWinnigLotto();
        int bonus = inputOutput.getBonusNumber(winnigLotto);

        lottoTicket.setWinnigLotto(winnigLotto);
        lottoTicket.setBonus(bonus);

        Map<LottoRanking, Integer> lottoRanking = lottoTicket.compareLotto(lottoFactory.getLottos());
        inputOutput.printWinningList(lottoRanking);

        lottoFactory.setWinmoney(lottoRanking);
        inputOutput.printWinningRate(lottoFactory.getWinMoney(), lottoFactory.getMoney());

    }
}
