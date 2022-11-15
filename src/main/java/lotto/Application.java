package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Lotto> buyLottery(int money) {
        List<Lotto> all_lottery = new ArrayList<>();
        int lottery_cnt = money / 1000;

        for (int i = 0; i < lottery_cnt; i++) {
            Lotto lottery = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            all_lottery.add(lottery);
        }
        return all_lottery;
    }

    public enum LOTTERY_MATCHES{
        NONE,
        SIX,
        FIVE_BONUS,
        FIVE,
        FOUR,
        THREE
    }
    public static void printHowManyMatches(List<Lotto> all_lottery, Lotto win_lottery, int bonus) {
        HashMap<Integer,Integer> lottery_ranks = lotteryRanks(all_lottery,win_lottery, bonus);
        lottery_ranks.forEach((key,value)->{
            if(key == LOTTERY_MATCHES.THREE.ordinal())
                System.out.println("3개 일치 (5,000원) - "+ value + "개");
            if(key == LOTTERY_MATCHES.FOUR.ordinal())
                System.out.println("4개 일치 (50,000원) - "+ value + "개");
            if(key == LOTTERY_MATCHES.FIVE.ordinal())
                System.out.println("5개 일치 (1,500,000원) - "+ value + "개");
            if(key == LOTTERY_MATCHES.FIVE_BONUS.ordinal())
                System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ value + "개");
            if(key == LOTTERY_MATCHES.SIX.ordinal())
                System.out.println("6개 일치 (2,000,000,000원) - "+ value + "개");
        });
    }

    public static HashMap<Integer,Integer> lotteryRanks(List<Lotto> all_lottery, Lotto win_lottery, int bonus){
        HashMap<Integer,Integer> lottery_ranks = initLotteryRanks();

        for (Lotto lotto : all_lottery
        ) {
            int rank = lotto.rank(win_lottery, bonus);
            if(rank >0)
                lottery_ranks.put(rank,lottery_ranks.get(rank) + 1);
        }
        return lottery_ranks;
    }

    public static HashMap<Integer,Integer> initLotteryRanks(){
        return new HashMap<>() {{
            put(1,0);
            put(2,0);
            put(3,0);
            put(4,0);
            put(5,0);
        }};
    }
}
