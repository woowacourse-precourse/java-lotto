package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Result {
    private int count;
    private List<Integer> winningNumber;
    private int bonusNumber;
    HashMap<Integer, Integer> winningHistory = new HashMap<>();
    List<Lotto> purchasedLotteries = new ArrayList<Lotto>();

    public Result(){
    }

    public void purchaseLotteries(int count){
        for(int i=0; i<count; i++){
            List<Integer> purchasedLottery = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchasedLottery.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(purchasedLottery);
            purchasedLotteries.add(lotto);
        }
    }

    public void printPurchasedLotteries(){
        for (Lotto purchasedLottery:purchasedLotteries){
            System.out.println(purchasedLottery.getNumbers());
        }
    }

    public void printWinningHistory(){

    }
}
