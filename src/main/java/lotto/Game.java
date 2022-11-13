package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.view.InputView.inputMoneyView;
import static lotto.view.InputView.inputWinningView;
import static lotto.view.OutputView.countView;
import static lotto.view.OutputView.lottoView;

public class Game {
    public static List<Lotto> lottos = new ArrayList<>();
    private static String input;

    public static Integer count;

    public static List<Integer> winning = new ArrayList<>();
    public Game(){
    }

    public static void start(){
        input = inputMoneyView();
        countMoney();
        makeLottos();
        countView();
        lottoView();
        makeWinning(inputWinningView());
    }
    private static Lotto getRandoms(){
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
        lotto.sortNumbers();
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
        Arrays.asList(numbers.split(",")).stream().forEach(number->{
            winning.add(Integer.parseInt(number));
        });
    }
}
