package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.WinningLogic.calculateRate;
import static lotto.exception.Exception.*;
import static lotto.option.IntegerOption.*;

public class Game extends View {
    public static List<Lotto> lottos = new ArrayList<>();
    public static String input;
    public static Integer count;
    public static Lotto winningNumbers;
    public static Integer bonusNumber;
    public static Double rate;
    public Game(){
    }

    public static void start(){
        inputMoney();
        inputWinning();
        result();
    }
    private static void inputMoney(){
        input = inputMoneyView();
        catchInputException();
        countMoney();
        makeLottos();
        countView();
        lottoView();
        makeWinning(inputWinningView());
    }
    private static void catchInputException(){
        catchNotNumericalInputException(input);
        catchNotBuyLottoException(input);
        catchZeroStartInputException(input);
        catchBaseMoneyException(input);

    }
    private static void inputWinning(){
        String bonusString =inputBonusView();
        catchNotNumericalInputException(bonusString);
        bonusNumber = Integer.parseInt(bonusString);
        catchBonusInWinningException(bonusNumber);
        catchOutOfRangeException(bonusNumber);
    }
    private static void result(){
        WinningLogic.addScore();
        ResultView();
        calculateRate();
        rateView(rate);
    }
    private static Lotto getRandoms(){
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(MIN.option, MAX.option,COUNT.option));
        return lotto;
    }

    private static void countMoney(){
        count = Integer.parseInt(input)/BASE_MONEY.option;
    }

    private static void makeLottos(){
        for(int i=0;i<count;i++){
            lottos.add(getRandoms());
        }
    }

    public static void makeWinning(String numbers){
        catchNotNumericalInputException(numbers);
        List<Integer> newList = new ArrayList<>();
        Arrays.asList(numbers.split(",")).stream().forEach(number->{
            catchZeroStartInputException(number);
            int num = Integer.parseInt(number);
            catchOutOfRangeException(num);
            newList.add(num);
        });
        winningNumbers = new Lotto(newList);
    }

    public static void ResultView(){
        resultTitleView();
        for(Winning winning: Winning.values()){
            chooseResult(winning);
            changeLine();
        }
    }

    private static void chooseResult(Winning winning){
        if(winning.bonus){
            printFifthView(winning);
            return;
        }
        printResultView(winning);
    }
}
