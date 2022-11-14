package lotto;

import static lotto.Constant.*;

public class LottoResult {

    public int sum = 0;
    public int returnRate;


    public void printResult(int numberOfLottos) {
        System.out.println(MESSAGE_RESULT_IS);

        for (PrizeEnum rank : PrizeEnum.values()) {
            System.out.println(rank.getMessage() + rank.getCount() + "개");
        }

        System.out.println(MESSAGE_RESULT_OF_RETURN_RATE + getReturn(numberOfLottos) + "%입니다.");
    }

    //수익률 계산
    public double getReturn(int numberOfLottos) {
        for (PrizeEnum rank : PrizeEnum.values()) {
            sum += rank.getCount() * rank.getPrize();
        }
        if (sum == 0) {
            return 0;
        }
        returnRate = (sum / numberOfLottos) * 100;

        return returnRate;
    }
}