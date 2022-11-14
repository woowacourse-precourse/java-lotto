package lotto;

import lotto.config.LottoConfig;
import lotto.message.ErrorCode;
import lotto.message.IOMessage;

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
            System.out.println(e.getMessage());
        }
    }

    private int buyLotto() throws IllegalArgumentException {
        int price = IOManager.scanMoney();

        if(LottoConfig.LOTTO_PRICE == 0)
            throw new IllegalArgumentException(ErrorCode.LOTTO_PRICE_ZERO.getErrorMessage());
        if(price <= 0)
            throw new IllegalArgumentException(ErrorCode.WRONG_PURCHASE_TYPE.getErrorMessage());
        if(price % LottoConfig.LOTTO_PRICE != 0)
            throw new IllegalArgumentException(ErrorCode.WRONG_PURCHASE_PRICE.getErrorMessage());

        IOManager.printLottoBought(price / LottoConfig.LOTTO_PRICE);
        return price / LottoConfig.LOTTO_PRICE;
    }

    private void generateLotto(int lottoNum) {
        lottoBought = new ArrayList<Lotto>();

        for(int lottoIdx = 0; lottoIdx < lottoNum; lottoIdx++) {
            lottoBought.add(new Lotto(Lotto.generateRandomLottoNumbers()));
        }

        IOManager.printLottoList(lottoBought);
    }

    private void getAnswerAndBonus() {
        answer = new Lotto(IOManager.scanAnswer());
        bonus = IOManager.scanBonus();
    }

    private int rankLotto() {
        for(Lotto lotto : lottoBought) {
            lotto.compareWithAnswer(answer, bonus);
        }
        return 0;
    }
}
