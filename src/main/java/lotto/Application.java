package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UI ui = new UI();

        int amount = ui.buyLotto();

        LottoMachine lottoMachine = new LottoMachine();

        List<List<Integer>> issueLotto = lottoMachine.issueLotto(amount);

        List<Integer> numbersOfWinner = ui.getWinningNumber();
    }
}
