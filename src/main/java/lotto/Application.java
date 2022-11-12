package lotto;

import lotto.domain.LottoDomain;
import lotto.ui.Input;
import lotto.ui.Output;

public class Application {
    public static Output output = new Output();
    public static Input input = new Input();
    public static LottoDomain lottoDomain = new LottoDomain();

    public static void main(String[] args) {
        try {
            output.guideInputAmount();
            lottoDomain.setInputAmount(input.getAmount());

            output.showPurchasesQuantity(lottoDomain.getPurchasesQuantity());
            output.showBoughtLotto(lottoDomain.getUserLottoTickets());

            output.guideInputWinningNumbers();
            lottoDomain.setInputWinningNumbers(input.getWinningNumbers());

            output.guideInputBonusNumber();
            lottoDomain.setInputBonusNumber(input.getBonusNumber());

            output.showWinningDetails(lottoDomain.getWinningRanks());

            output.showEarningRate(lottoDomain.getEarningRates());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
