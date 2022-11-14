package lotto;

import lotto.IO.InputManager;
import lotto.IO.OutputManager;
import lotto.config.LottoConfig;
import lotto.IO.message.ErrorCode;

import java.util.ArrayList;
import java.util.List;

public class LottoProgramManager {
    private Lotto answer;
    private int bonus;
    private List<Lotto> lottoBought;

    public void runProgram() {
        try {
            int lottoNum = buyLotto();
            generateLotto(lottoNum);
            getAnswerAndBonus();
            rankLotto();
        } catch(Exception e) {
            OutputManager.printError(e.getMessage());
        }
    }

    private int buyLotto() throws IllegalArgumentException {
        int price = InputManager.scanMoney();

        if(LottoConfig.LOTTO_PRICE == 0)
            throw new IllegalArgumentException(ErrorCode.LOTTO_PRICE_ZERO.getValue());
        if(price <= 0)
            throw new IllegalArgumentException(ErrorCode.WRONG_PURCHASE_TYPE.getValue());
        if(price % LottoConfig.LOTTO_PRICE != 0)
            throw new IllegalArgumentException(ErrorCode.WRONG_PURCHASE_PRICE.getValue());

        OutputManager.printLottoBought(price / LottoConfig.LOTTO_PRICE);
        return price / LottoConfig.LOTTO_PRICE;
    }

    private void generateLotto(int lottoNum) {
        lottoBought = new ArrayList<Lotto>();

        for(int lottoIdx = 0; lottoIdx < lottoNum; lottoIdx++) {
            lottoBought.add(new Lotto(Lotto.generateRandomLottoNumbers()));
        }

        OutputManager.printLottoList(lottoBought);
    }

    private void getAnswerAndBonus() {
        answer = new Lotto(InputManager.scanAnswer());
        bonus = InputManager.scanBonus();
    }

    private int rankLotto() {
        for(Lotto lotto : lottoBought) {
            lotto.compareWithAnswer(answer, bonus);
        }
        return 0;
    }
}
