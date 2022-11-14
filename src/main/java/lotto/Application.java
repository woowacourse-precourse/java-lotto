package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int paid = Input.buyLotto();
        Lottos lottos = new Lottos(paid);
        Output.showLottos(lottos.getBoughtLottos());
        List<Integer> winNumbers = Input.winningNumbers();
        int bonusNum = Input.bonusNumber(winNumbers);
        Output.showResult(lottos, winNumbers, bonusNum);
    }
}
