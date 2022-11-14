package lotto;

import lotto.ui.Input;

public class Application {
    public static void main(String[] args) {
        try {
            RandomLottos randomLottos = new RandomLottos(Input.scanMoney());
            randomLottos.printRandomLottos();

            Lotto majorNumbers = new Lotto(Input.scanWinningLotto());

            WinningLotto winningLotto = new WinningLotto(majorNumbers, Input.scanBonusNumber());

            LottoStatistic lottoStatistic = new LottoStatistic(randomLottos, winningLotto);
            lottoStatistic.printStatistic();
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
