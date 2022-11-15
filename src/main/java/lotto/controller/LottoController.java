package lotto.controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Price;
import lotto.model.Scores;
import lotto.model.UserLottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Price price;
    private UserLottos userLottos;
    private Lotto winningNum;
    private Bonus bonus;
    private Scores scores;

    public LottoController() {
        scores = new Scores();
    }

    public void doLotto() {
        price = new Price();
        userLottos = new UserLottos(this.price.getPrice());
        setWinningNum();
        bonus = new Bonus();
        scores.compare(userLottos,winningNum,bonus);
        Integer sumOfScores = scores.getSumofScores();
        double yield = sumOfScores.doubleValue() / price.getPrice().doubleValue()*100;
        double roundYield = Math.round(yield*100) / 100.00;
        OutputView.printStatistics(this.scores,roundYield);
    }


    public void setWinningNum() {
        String winningNumString = InputView.inputWinningNum();
        ExceptionHandler.validateWinningNum(winningNumString);
        this.winningNum = new Lotto(Arrays
                .stream(winningNumString.split(","))
                .map(Integer::parseInt).collect(
                Collectors.toList()));
    }


    public Lotto getWinningNum() {
        return winningNum;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public Scores getScores() {
        return scores;
    }
}
