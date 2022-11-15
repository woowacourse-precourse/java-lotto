package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoCalculator {
    private static final int TICKET_PRICE = 1000;
    private static final int NUMBER_AMOUNT = 6;
    private static final List<Integer> PRIZE = Arrays.asList(5000, 50000, 1500000, 30000000, 2000000000);

    private final int budget;

    public LottoCalculator(int budget){
        this.budget = budget;
    }

    public int getTicketSize(){
        return Integer.valueOf(budget / TICKET_PRICE);
    }

    public double getProfit(List<Integer> winnings){
        int total_income = 0;

        for (int i=0; i<winnings.size()-1; i++){
            total_income += winnings.get(i) * PRIZE.get(i);
        }

        return (double) total_income / budget * 100;
    }
}
