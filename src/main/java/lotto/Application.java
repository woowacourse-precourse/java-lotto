package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        LottoRepository lottoRepository = new LottoRepository();
        int lottoNumber = IOController.readBuyingMoney();
        lottoRepository.makeRandomLottos(lottoNumber);
        List<Integer> winningNumbers = IOController.readWinningNumbers();
        int bonusNumber = IOController.readBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }
}
