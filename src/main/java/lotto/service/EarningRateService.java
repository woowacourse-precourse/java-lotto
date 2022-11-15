package lotto.service;

import lotto.domain.Prize;

import static lotto.domain.Constants.SECOND_PRIZE;
import static lotto.domain.Score.*;
import static lotto.service.LottoWalletService.*;

public class EarningRateService {

    public double calculate() {

        int sum = 0;

        for (int i = 0; i < Prize.values().length; i++) {
            sum += Prize.values()[i].getPrize() * count.get(i);
        }

        if (bonusCount > 0) {
            sum += SECOND_PRIZE * bonusCount;
        }

        double sumDouble = sum;
        double payedDouble = payment;
        return (sumDouble / payedDouble) * 100;
    }
}
