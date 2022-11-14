package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.WinningLogic.calculateRate;
import static lotto.exception.Exception.*;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class Game {
    public static List<Lotto> lottos = new ArrayList<>();
    public static String input;
    public static Integer count;
    public static Lotto winning;
    public static Integer bonusNumber;
    public static Float rate;
    public Game(){
    }

    public static void start(){
        input = inputMoneyView();

        catchNotNumericalInputException(input);
        catchInputException(input);

        countMoney();
        makeLottos();
        countView();
        lottoView();
        makeWinning(inputWinningView());

        String bonusString =inputBonusView();
        catchNotNumericalInputException(bonusString);
        bonusNumber = Integer.parseInt(bonusString);
        catchOutOfRangeException(bonusNumber);

        WinningLogic.addScore();
        ResultView();
        calculateRate();
        rateView(rate);
    }
    private static Lotto getRandoms(){
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
        //lotto.sortNumbers();
        return lotto;
    }

    private static void countMoney(){
        count = Integer.parseInt(input)/1000;
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
            int num = Integer.parseInt(number);
            catchOutOfRangeException(num);
            newList.add(num);
        });
        winning = new Lotto(newList);
    }
}
