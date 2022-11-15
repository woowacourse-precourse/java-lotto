package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.GameOutput.getLottoNum;

public class Lottos{
    public static int money ;
    private final List<Lotto> Lottos = new ArrayList<Lotto>();

    public Lottos(int num){
        makeLottos(num/1000);
    }

    public void makeLottos(int num){
        for (int i=0; i<num; i++){
            Lottos.add(make_lotto());
        }
    }

    public Lotto make_lotto(){
        List<Integer> RandomNumbers = new Random().getRandomNumbers();
        System.out.println(RandomNumbers);
        return new Lotto(RandomNumbers);
    }

    public Lotto get_lotto(int index){
        return Lottos.get(index);
    }

    public static int getMoney() {
        money = Integer.parseInt(Console.readLine());
        getLottoNum(money/1000);
        return money;
    }
}
