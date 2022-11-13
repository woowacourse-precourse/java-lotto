package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            createNum();
            User.buyLotto();
            Lotto.lottoMaking(User.lottoAmount);
            User.guessLotto();
            User.guessBonus();
            Raffle.statistics();
        }catch(IllegalArgumentException e){
            System.err.println("[ERROR] "+e);
        }

    }

    // create success numbers
    public static void createNum(){
        List<Integer> winningLotto = Randoms.pickUniqueNumbersInRange(1,45,6);
        System.out.println(winningLotto);
    }

}
