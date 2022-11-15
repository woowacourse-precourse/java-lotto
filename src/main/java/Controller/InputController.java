package Controller;

import Service.CreateRandomLotto;
import UI.Input;
import UI.Output;

import java.util.List;

public class InputController {

    private static Input input = new Input();
    private static int purchaseAmount;
    private static List<List<Integer>> randomLottos;
    private static List<Integer> winningLotto;
    private static int bonusNumber;

    public InputController() {
        Output output = new Output();
        try {
            this.purchaseAmount = input.purchaseAmount();
            this.randomLottos = CreateRandomLotto.createRandomLottoNumber(purchaseAmount);
            output.printRandomLottoNumbers(randomLottos);
            this.winningLotto = input.winningNumbers();
            this.bonusNumber = input.bonusNumber();
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public int getpurchaseAmount() {
        return purchaseAmount;
    }

    public List<List<Integer>> getRandomLottos() {
        return randomLottos;
    }

    public List<Integer> getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
