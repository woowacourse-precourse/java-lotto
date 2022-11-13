package lotto.view;

import static lotto.model.LottoInformation.convertPrizeNumberToLottoInfo;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.Constants;
import lotto.model.Lotto;
import lotto.model.LottoInformation;

public class OutputView {

    public void printPurchaseAmount(int lottoAmount) {
        System.out.println("\n" + lottoAmount + Constants.PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurchaseLottoNumbers(List<Lotto> allLotto) {
        for (Lotto lotto : allLotto) {
            System.out.println(lotto.toString());
        }
    }

    public void printPrize(Map<Integer, Integer> prize) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        System.out.println(Constants.PRIZE_MESSAGE1_HEAD);
        for (int prizeNumber = Constants.END_PRIZE; prizeNumber >= Constants.FIRST_PRIZE; prizeNumber--) {
            LottoInformation lottoInformation = convertPrizeNumberToLottoInfo.get(prizeNumber);
            System.out.printf(Constants.PRIZE_MESSAGE2_MATCH_COUNT, lottoInformation.matchCount);
            if (lottoInformation.prizeNumber == Constants.SECOND_PRIZE) {
                System.out.print(Constants.PRIZE_MESSAGE3_BONUS_EQUAL);
            }
            System.out.printf(Constants.PRIZE_MESSAGE4_PRIZE_MONEY_AND_COUNT,
                    decFormat.format(lottoInformation.prizeMoney),
                    prize.get(lottoInformation.prizeNumber));
        }
    }

    public void printPercentageOfReturn(float percentageOfReturn) {
        System.out.printf(Constants.PERCENTAGE_OF_RETURN_MESSAGE, percentageOfReturn);
    }
}