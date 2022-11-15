package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.Exceptions.isNumber;
import static lotto.utils.Exceptions.checkPay;

import static lotto.view.GameOutput.getLottoNum;

public class Lottos{
    public static int money ;

    private final List<Lotto> Lottos = new ArrayList<>();

    public Lottos(int num){
        makeLottos(num/1000);
    }

    public void makeLottos(int num){
        for (int i=0; i<num; i++){
            Lottos.add(makeLotto());
        }
    }

    public Lotto makeLotto(){
        List<Integer> RandomNumbers = new Random().getRandomNumbers();
        System.out.println(RandomNumbers);
        return new Lotto(RandomNumbers);
    }

    public Lotto getLotto(int index){
        return Lottos.get(index);
    }

    public static int getMoney() {
        String str = Console.readLine();
        isNumber(str);
        money = Integer.parseInt(str);
        checkPay(money);
        getLottoNum(money/1000);
        return money;
    }
}
