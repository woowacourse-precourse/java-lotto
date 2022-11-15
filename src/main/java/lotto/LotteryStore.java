package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryStore {
    private int ticketPrice = 1000;

    public List<Lotto> purchaseLotteries(int amount){

        List<Lotto> lotteries = new ArrayList<>();

        while(amount > 0){
            lotteries.add(new Lotto());
            amount -= 1000;
        }

        return lotteries;
    }

}

