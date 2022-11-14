package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.domain.LottoRanking;
import lotto.domain.OutputMessage;
import lotto.domain.UserLotto;

public class OutputView {
    public void printQuantity(int quantity) {
        System.out.println(quantity + OutputMessage.PRINT_LOTTO_QUANTITY.toString());
    }
    public void printLottoNumber(UserLotto userLotto) {
        System.out.println(userLotto.toString());
    }

    public void printLottoResult(List<LottoRanking> lottoResult) {
        StringBuilder sb = new StringBuilder();
        for(LottoRanking ranking : lottoResult) {
            sb.append(ranking.getMessage()).append(Collections.frequency(lottoResult, ranking)).append(OutputMessage.PRINT_UNIT).append("\n");
            System.out.println(sb);
        }
    }
    public void printYield(double yield) {
        System.out.format("%.1f%%%n", yield);
    }
}
