package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            LottoService lottoService = new LottoService();
            int buyinglottoNumber = IOController.readBuyingMoney();
            lottoService.makeRandomLottos(buyinglottoNumber);
            IOController.printLottos(lottoService.getLottos());
            List<Integer> winningNumbers = IOController.readWinningNumbers();
            int bonusNumber = IOController.readBonusNumber();
            WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
            lottoService.setWinningLotto(winningLotto);
            List<Integer> allRankings = lottoService.caculateAllRankings();
            IOController.printPrizeResult(allRankings, buyinglottoNumber);
        } catch (IllegalArgumentException e) {
            IOController.printExceptionMessage(e);
        }
    }
}
