package lotto.service;

import java.text.DecimalFormat;

import static lotto.domain.Policy.*;
import static lotto.service.LottoWalletMaker.*;

public class EarningRate {

    DecimalFormat formatter = new DecimalFormat("###,###.##");

    public void print() {

        int earningRate = calculate();

        System.out.println("총 수익률은 " + formatter.format(earningRate) + "%입니다.");
    }

    private int calculate() {

        int sum = 0;

        for (int i = 0; i < prize.size(); i++) {
            sum += prize.get(i) * count.get(i);
        }

        if (bonusCount > 0) {
            sum += SECOND_PRIZE * bonusCount;
        }
        return (sum / payedMoney) * 100;
    }
}
