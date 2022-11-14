package lotto;

import lotto.UI.InputManager;
import lotto.UI.OutputManager;
import lotto.UI.UIPrinter;
import lotto.config.LottoConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoProgramManager {
    private int lottoNum;
    private List<Lotto> lottoBought;
    private Lotto answer;
    private int bonus;
    private Map<Integer, Integer> lottoResult;

    public void runProgram() {
        try {
            LottoConfig.validate();

            lottoNum = buyLotto();
            generateLotto(lottoNum);
            getAnswerAndBonus();
            rankLotto();

        } catch(Exception e) {
            UIPrinter.printError(e.getMessage());
        }
    }

    private int buyLotto() {
        int price = InputManager.scanMoney();

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
        int totalProfit = 0;
        lottoResult = new HashMap<Integer, Integer>();

        for(Lotto lotto : lottoBought) {
            int rank = lotto.compareWithAnswer(answer, bonus);

            lottoResult.putIfAbsent(rank, 0);
            lottoResult.put(rank, lottoResult.get(rank) + 1);

            if(rank != -1)
                totalProfit += LottoConfig.awards.get(rank);
        }

        OutputManager.printRanks(lottoResult, totalProfit, lottoNum * LottoConfig.LOTTO_PRICE);
    }
}
