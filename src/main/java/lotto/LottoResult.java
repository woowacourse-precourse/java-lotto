package lotto;

import static constants.Constant.*;
import static constants.Message.*;

public class LottoResult {

    public int sum = 0;
    public double returnRate;


    public void printResult(int numberOfLottos) {
        System.out.println(MESSAGE_RESULT_IS);

        for (PrizeEnum rank : PrizeEnum.values()) {
            System.out.println(rank.getMessage() + rank.getCount() + "개");
        }

        System.out.println(MESSAGE_RESULT_OF_RETURN_RATE + String.format("%.1f", getReturn(numberOfLottos)) + "%입니다.");
    }

    //수익률 계산
    public double getReturn(int numberOfLottos) {
        for (PrizeEnum rank : PrizeEnum.values()) {
            sum += rank.getCount() * rank.getPrize();
        }
        if (sum == 0) {
            return 0;
        }
        returnRate = (double) sum / (numberOfLottos * PRICE_OF_ONE_TICKET) * 100;

        return returnRate;
    }
}