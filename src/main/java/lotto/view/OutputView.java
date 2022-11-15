package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.domain.LottoRanking;
import lotto.domain.OutputMessage;
import lotto.domain.UserLotto;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public void printQuantity(int quantity) {
        System.out.println(quantity + OutputMessage.PRINT_LOTTO_QUANTITY.getMessage());
    }
    public void printLottoNumber(UserLotto userLotto) {
        System.out.println(userLotto.toString());
    }

    public void printLottoResult(List<LottoRanking> lottoResult) {
        System.out.println(LottoRanking.THREE_RIGHT.getMessage() + Collections.frequency(lottoResult, LottoRanking.THREE_RIGHT) + OutputMessage.PRINT_UNIT.getMessage());
        System.out.println(LottoRanking.FOUR_RIGHT.getMessage() + Collections.frequency(lottoResult, LottoRanking.FOUR_RIGHT) + OutputMessage.PRINT_UNIT.getMessage());
        System.out.println(LottoRanking.FIVE_RIGHT.getMessage() + Collections.frequency(lottoResult, LottoRanking.FIVE_RIGHT) + OutputMessage.PRINT_UNIT.getMessage());
        System.out.println(LottoRanking.FIVE_AND_BONUS_RIGHT.getMessage() + Collections.frequency(lottoResult, LottoRanking.FIVE_AND_BONUS_RIGHT) + OutputMessage.PRINT_UNIT.getMessage());
        System.out.println(LottoRanking.SIX_RIGHT.getMessage() + Collections.frequency(lottoResult, LottoRanking.SIX_RIGHT) + OutputMessage.PRINT_UNIT.getMessage());
//        StringBuilder sb = new StringBuilder();
//            sb.append(ranking.getMessage()).append(Collections.frequency(lottoResult, ranking)).append(OutputMessage.PRINT_UNIT.getMessage()).append("\n");
//        System.out.println(sb);
    }
    public void printYield(double yield) {
        System.out.format("총 수익률은 %.1f%%입니다.", yield);
    }
}
