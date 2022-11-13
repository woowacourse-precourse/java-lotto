package lotto;

import java.util.*;

public class Raffle {
    public static void statistics() {
        System.out.println("당첨 통계\n--");
        result();
    }

    public static void result(){
        System.out.println(Winning.getReward("3"));
    }

}
