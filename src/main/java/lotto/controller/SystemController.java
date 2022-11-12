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

    private List<List<Integer>> purchaseLotto(Money money, String purchaseMoney){
        System.out.print(money.howMany(purchaseMoney));
        outputView.startInput_Output();
        myLotto=countRandomLotto.calculate(money.howMany(purchaseMoney));
        return myLotto;
    }

    private void statistics(List<List<Integer>> myLotto, List<Integer> numbers, int Bonus, String purchaseMoney){
        for(int i=0; i<myLotto.size(); i++) {
            matchScores.add(scoreResult.getScoreFiveAndBonus(numbers, myLotto.get(i), Bonus));
        }
        for(int i=0; i<saveScores.size(); i++){
            System.out.println(saveScores.get(i).getScore() + " - " + Collections.frequency(matchScores, saveScores.get(i)) +"개");
        }
        System.out.print("총 수익률은 "+calculateYield(Integer.parseInt(purchaseMoney), Collections.frequency(matchScores, Three), Collections.frequency(matchScores, Four),
                Collections.frequency(matchScores, Five), Collections.frequency(matchScores, FiveAndBonus), Collections.frequency(matchScores, Six))+"%입니다.");
    }

    private double calculateYield(int purchaseMoney,int three, int four, int five, int fiveB, int six){
        double yield= (double)(three*5_000+four*50_000+five*1_500_000+fiveB*30_000_000+six*2_000_000_000)*(double)100/(double)purchaseMoney;
        return (Math.round(yield*10)/10.0);
    }
}