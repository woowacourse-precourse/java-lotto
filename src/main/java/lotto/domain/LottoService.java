package lotto.domain;

import lotto.console.Input;
import lotto.constant.Score;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoService {

    public Map<Score, Integer> calculateLottoScore(List<Integer> lottoNumbers, List<List<Integer>> randomLottoNumbers,
                                                   int bonusNumber) {

        Map<Score, Integer> scoreStore = LottoScore.setInitialSetting();
        randomLottoNumbers.forEach(randomLottoNumber -> {
            int score = 0;
            score = getScore(lottoNumbers, randomLottoNumber, score);
            LottoScore.update(lottoNumbers, score, bonusNumber);
        });
        return scoreStore;
    }

    public int printAndInputMoney() {
        InputView.setInputMoney();
        return Input.inputMoney();
    }

    private int getScore(List<Integer> lottoNumbers, List<Integer> randomLottoNumber, int score) {
        for (Integer lottoNumber : lottoNumbers) {
            score = existNumber(randomLottoNumber, score, lottoNumber);
        }
        return score;
    }

    private int existNumber(List<Integer> randomLottoNumber, int score, Integer lottoNumber) {
        if (randomLottoNumber.contains(lottoNumber)) {
            score++;
        }
        return score;
    }
}
