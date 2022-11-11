package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.LottoException;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        LottoException exception = new LottoException();
        OutputView outputView = new OutputView();
        Winner winner = new Winner("45,2,3,4,5,6");
        List<Integer> lottoWinningNumber = winner.getLottoWinningNumber();
        ProfitCalculator profitCalculator = new ProfitCalculator();
        BigDecimal bigDecimal = new BigDecimal(10);
        bigDecimal = bigDecimal.add(BigDecimal.valueOf(10));
        bigDecimal = bigDecimal.add(BigDecimal.valueOf(10));
//        System.out.println(bigDecimal);
        Map<LottoRank, Integer> lottoResultCount;
        Referee referee = new Referee();
        outputView.printLottoResult(referee.getLottoResultCount());
//        profitCalculator.
    }
}
