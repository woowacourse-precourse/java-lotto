package lotto;

import lotto.IO.InputManager;
import lotto.IO.OutputManager;
import lotto.config.LottoConfig;
import lotto.IO.message.ErrorCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoProgramManager {
    private List<Lotto> lottoBought;
    private Lotto answer;
    private int bonus;
    private Map<Integer, Integer> lottoResult;

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

    private void rankLotto() {
        for(Lotto lotto : lottoBought) {
            int rank = lotto.compareWithAnswer(answer, bonus);

            lottoResult.putIfAbsent(rank, 0);
            lottoResult.put(rank, lottoResult.get(rank) + 1);
        }
    }
}
