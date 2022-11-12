package lotto.controller;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.MatchScore;
import lotto.model.Money;
import lotto.model.ScoreResult;

import lotto.util.CountRandomLotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.model.MatchScore.Three;
import static lotto.model.MatchScore.Four;
import static lotto.model.MatchScore.Five;
import static lotto.model.MatchScore.FiveAndBonus;
import static lotto.model.MatchScore.Six;

public class SystemController {
    private static int BonusNumber =0;
    private static String purchaseMoney=new String();
    private static ScoreResult scoreResult=new ScoreResult();
    private static List<Integer> numbers=new ArrayList<>();
    private static List<MatchScore> matchScores=new ArrayList<>();
    private static List<List<Integer>> myLotto = new ArrayList<>();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final CountRandomLotto countRandomLotto = new CountRandomLotto();
    private static final List<MatchScore> saveScores=List.of(Three, Four, Five, FiveAndBonus, Six);

    public SystemController(){
    }

    public void startLotto(){
        purchaseMoney=inputView.startInput();
        Money money=new Money(purchaseMoney);

        myLotto=purchaseLotto(money, purchaseMoney);
        numbers=inputView.winningNumberInput();
        Lotto lotto=new Lotto(numbers);

        BonusNumber = Integer.parseInt(inputView.BonusNumberInput());
        Bonus bonus = new Bonus(BonusNumber);
        outputView.ResultLottoOutput();

        statistics(myLotto, numbers, BonusNumber, purchaseMoney);
    }
}