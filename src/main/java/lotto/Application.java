package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            User.buyLotto();
            Lotto.lottoMaking(User.lottoAmount);
            User.guessLotto();
            User.guessBonus();
            Raffle.statistics();
        }catch(IllegalArgumentException e){
            System.err.println("[ERROR] "+e);
        }
    }
}
