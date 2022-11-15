package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        LottoService lottoService = new LottoService();
        int lottoNumber = IOController.readBuyingMoney();
        lottoService.makeRandomLottos(lottoNumber);
        List<Integer> winningNumbers = IOController.readWinningNumbers();
        int bonusNumber = IOController.readBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }
}
