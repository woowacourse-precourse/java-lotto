package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.Rank.*;

public class LottoController {
    public static final int PRICE_OF_LOTTO = 1000;
    public static final int QUANTITY_OF_LOTTO_DIGITS = 6;

    public static final int QUANTITY_OF_RANK = 5;
    public static final int IDX_FOR_PREDICTION_MATCH_CNT = 0;
    public static final int IDX_FOR_BONUS_MATCH_CNT = 1;

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    private List<Lotto> lottos = new ArrayList<>();
    private int predictionMatchCnt = 0;
    private int bonusMatchCnt = 0;
    private int[] winningLog = new int[QUANTITY_OF_RANK];

    public void playLottoGame() {
        int purchasePrice = inputView.userInputPurchasePrice();
        int amountOfLotto = computeAmountOfLotto(purchasePrice);
        outputView.printAmountOfLottoMessage(amountOfLotto);

        generateLotto(amountOfLotto);
        List<Integer> predictionNumbers = inputView.userInputPredictionNumbers();
        int bonusNumber = inputView.userInputBonusNumber();

        List<List<Integer>> matchCounts = computeMatchCounts(predictionNumbers, bonusNumber);
        recordWinningLog(matchCounts);
    }

    public int computeAmountOfLotto(int purchasePrice) {
        return purchasePrice / PRICE_OF_LOTTO;
    }

    public void generateLotto(int amountOfLotto) {
        LottoMachine lottoMachine = new LottoMachine();

        for (int repeatCnt = 0; repeatCnt < amountOfLotto; repeatCnt++) {
            Lotto lotto = lottoMachine.generateLotto();
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<List<Integer>> computeMatchCounts(List<Integer> predictionNumbers, int bonusNumber) {
        List<List<Integer>> ret = new ArrayList<>();

        for (Lotto lotto : lottos) {
            predictionMatchCnt = 0;
            bonusMatchCnt = 0;

            List<Integer> lottoNumbers = lotto.getNumbers();

            increasePredictionMatchCnt(lottoNumbers, predictionNumbers);
            increaseBonusMatchCnt(lottoNumbers, bonusNumber);
            ret.add(Arrays.asList(predictionMatchCnt, bonusMatchCnt));
        }

        return ret;
    }

    public void increasePredictionMatchCnt(List<Integer> lottoNumbers, List<Integer> predictionNumbers) {
        for (int idx = 0; idx < QUANTITY_OF_LOTTO_DIGITS; idx++) {
            if (lottoNumbers.contains(predictionNumbers.get(idx))) {
                predictionMatchCnt++;
            }
        }
    }

    public void increaseBonusMatchCnt(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            bonusMatchCnt++;
        }
    }

    public void recordWinningLog(List<List<Integer>> matchCounts) {
        for (List<Integer> matchCnt : matchCounts) {
            int predictionMatchCnt = matchCnt.get(IDX_FOR_PREDICTION_MATCH_CNT);
            int bonusMatchCnt = matchCnt.get(IDX_FOR_BONUS_MATCH_CNT);

            increaseWinningLogForRank(predictionMatchCnt, bonusMatchCnt);
        }
    }

    private void increaseWinningLogForRank(int predictionMatchCnt, int bonusMatchCnt) {
        if (predictionMatchCnt == FIFTH.getPredictionMatchCnt()) winningLog[FIFTH.getWinningLogIdx()]++;

        if (predictionMatchCnt == FOURTH.getPredictionMatchCnt()) winningLog[FOURTH.getWinningLogIdx()]++;

        if (predictionMatchCnt == THIRD.getPredictionMatchCnt()) winningLog[THIRD.getWinningLogIdx()]++;

        if (predictionMatchCnt == SECOND.getPredictionMatchCnt())
            if (bonusMatchCnt == SECOND.getBonusMatchCnt()) winningLog[SECOND.getWinningLogIdx()]++;

        if (predictionMatchCnt == FIRST.getPredictionMatchCnt()) winningLog[FIRST.getWinningLogIdx()]++;
    }
}
