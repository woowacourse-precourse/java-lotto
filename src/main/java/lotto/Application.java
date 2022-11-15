package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UI ui = new UI();

        int amount = ui.buyLotto();

        LottoMachine lottoMachine = new LottoMachine();

        List<List<Integer>> issueLottos = lottoMachine.issueLotto(amount);

        List<Integer> numbersOfWinner = ui.getWinningNumber();

        int bonusNumber = ui.getBonusNumber();

        int[] countOfRank = new int[6];

        for (List<Integer> lottos : issueLottos) {
            Lotto lotto = new Lotto(lottos);
            countOfRank[lotto.compareLotto(numbersOfWinner, bonusNumber)]++;
        }

        ui.outputResult(countOfRank, amount);

    }
}
