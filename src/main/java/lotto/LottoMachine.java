package lotto;

import lotto.util.InputHandler;
import lotto.util.SystemMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private List<Lotto> randomLotto;
    private final LottoGenerator lottoGenerator;

    public LottoMachine() {
        randomLotto = new ArrayList<>();
        lottoGenerator = new LottoGenerator();
    }

    public void run() {
        int lottoAmount = lottoPurchase();
        randomLotto = generateLotto(lottoAmount);
        Lotto winningLottery = getWinningNumbers();
        int bonusNumber = getBonusNumber();
    }

    private int lottoPurchase() {
        System.out.println(SystemMessage.PURCHASE_INPUT.getMessage());
        return InputHandler.getPurchaseAmount();
    }

    private List<Lotto> generateLotto(int amount) {
        System.out.println("\n" + amount + SystemMessage.PURCHASE_AMOUNT.getMessage());
        return lottoGenerator.generateLotto(amount);
    }

    private Lotto getWinningNumbers(){
        System.out.println("\n" + SystemMessage.WINNING_NUMBER.getMessage());
        return new Lotto(InputHandler.getWinningNumber());
    }

    private int getBonusNumber(){
        System.out.println("\n" + SystemMessage.BONUS_NUMBER.getMessage());
        return InputHandler.getBonusNumber();
    }

}
