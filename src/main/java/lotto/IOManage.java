package lotto;

import lotto.ControlLottoGame;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class IOManage {
    private int inputPrice;
    private List<List<Integer>> generatedLotto;

    public void IOManage() {
    }

    public void inputPayment() {
        System.out.println(Message.INPUT_PAYMENT.get());
        String input = Console.readLine();
        int inputPrice = Integer.parseInt(input);

        this.inputPrice = inputPrice;
    }

    public void outputLottoGeneration(int inputPrice) {
        ControlLottoGame control = new ControlLottoGame();
        int quantity = control.priceToQuantity(inputPrice);
        GenerateLotto generation = new GenerateLotto(quantity);
        List<List<Integer>> lottoNumbers = generation.getLottoNumbers();
        this.generatedLotto = lottoNumbers;

        System.out.println(quantity + Message.OUTPUT_BUYING.get());
        for (int i = 0; i < lottoNumbers.size(); i++) {
            System.out.println(lottoNumbers.get(i));
        }
    }

    public void inputWinningNumbers() {
        ControlLottoGame control = new ControlLottoGame();
        System.out.println(Message.INPUT_WINNING_NUMBER.get());
        String inputString = Console.readLine();
        List<Integer> winningNumbers = control.inputToWinningNumbers(inputString);
    }
}
