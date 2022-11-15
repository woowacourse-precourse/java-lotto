package lotto;

import lotto.util.CONSTANTS;
import lotto.util.InputHandler;
import lotto.util.SystemMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private List<Lotto> randomLotto;
    private final LottoGenerator lottoGenerator;
    private List<Integer> resultRank;

    public LottoMachine() {
        randomLotto = new ArrayList<>();
        lottoGenerator = new LottoGenerator();
        resultRank = new ArrayList<>(CONSTANTS.RANK.getNumbers());
    }

    public void run() {
        int lottoAmount = lottoPurchase();
        randomLotto = generateLotto(lottoAmount);
        Lotto winningLottery = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        InputHandler.validateBonusNumber(winningLottery, bonusNumber); // 보너스 번호도 중복되면 안됨.


    }

    private int lottoPurchase() {
        System.out.println(SystemMessage.PURCHASE_INPUT.getMessage());
        return InputHandler.getPurchaseAmount();
    }

    private List<Lotto> generateLotto(int amount) {
        System.out.println("\n" + amount + SystemMessage.PURCHASE_AMOUNT.getMessage());
        List<Lotto> generatedLotto = lottoGenerator.generateLotto(amount);
        generatedLotto.forEach(Lotto::print);
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
