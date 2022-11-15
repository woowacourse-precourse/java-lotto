package lotto;

import lotto.util.CONSTANTS;
import lotto.util.InputHandler;
import lotto.util.SystemMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private List<Lotto> randomLotto;
    private final LottoGenerator lottoGenerator;
    private List<Integer> resultRank;
    private int bonusNumber;

    public LottoMachine() {
        randomLotto = new ArrayList<>();
        lottoGenerator = new LottoGenerator();
        resultRank = new ArrayList<>(Collections.nCopies(CONSTANTS.RANK.getNumbers(), 0));

    }

    public void run() {
        int lottoAmount = lottoPurchase();
        randomLotto = generateLotto(lottoAmount);
        Lotto winningLottery = getWinningNumbers();
        bonusNumber = getBonusNumber();
        InputHandler.validateBonusNumber(winningLottery, bonusNumber); // 보너스 번호도 중복되면 안됨.
        getResult(randomLotto, winningLottery);
        System.out.println(resultRank);
    }

    private int lottoPurchase() {
        System.out.println(SystemMessage.PURCHASE_INPUT.getMessage());
        return InputHandler.getPurchaseAmount();
    }

    private List<Lotto> generateLotto(int amount) {
        System.out.println("\n" + amount + SystemMessage.PURCHASE_AMOUNT.getMessage());
        List<Lotto> generatedLotto = lottoGenerator.generateLotto(amount);
        generatedLotto.forEach(Lotto::print);
        return generatedLotto;
    }

    private Lotto getWinningNumbers(){
        System.out.println("\n" + SystemMessage.WINNING_NUMBER.getMessage());
        return new Lotto(InputHandler.getWinningNumber());
    }

    private int getBonusNumber(){
        System.out.println("\n" + SystemMessage.BONUS_NUMBER.getMessage());
        return InputHandler.getBonusNumber();
    }

    private void getResult(List<Lotto> inputLotto, Lotto winningLotto){
        for (Lotto input:
             inputLotto) {
            int matches = getMatches(input, winningLotto);
            setResultRank(matches);
        }
    }

    private int getMatches(Lotto inputLotto, Lotto winningLotto){
        int matches = 0;
        for (Integer number:
             inputLotto.getLotto()) {
            if(winningLotto.getLotto().contains(number))
                matches++;
        }
        if(matches == CONSTANTS.SECOND_POSITION.getNumbers())
            return getBonusRank(inputLotto);
        return matches;
    }

    private void setResultRank(int matches){
        System.out.println(matches);
        resultRank.set(matches, resultRank.get(matches) + 1);
    }

    private int getBonusRank(Lotto lotto){
        if(lotto.getLotto().contains(bonusNumber)){
            return CONSTANTS.BONUS_POSITION.getNumbers();
        }
        return CONSTANTS.SECOND_POSITION.getNumbers();
    }
}
