package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.UserLottos;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OutputView {
    private final String MESSAGE_TO_PRINT_COUNT = "개를 구매했습니다.";
    private final String MESSAGE_TO_PRINT_RESULT = "\n당첨 통계\n---";
    private final String MESSAGE_TO_PRINT_YIELD_A = "총 수익률은 ";
    private final String MESSAGE_TO_PRINT_YIELD_B = "%입니다.";

    public void printUserLottos(UserLottos userLottos) {
        printLottosCount(userLottos);
        printSortedLottos(userLottos);
    }
    public void printLottosCount(UserLottos userLottos) {
        int count = userLottos.getLottoCount();
        System.out.println("\n" + count + MESSAGE_TO_PRINT_COUNT);
    }
    public void printResult(LottoResult lottoResult) {
        System.out.println(MESSAGE_TO_PRINT_RESULT);
        System.out.println(lottoResult.getResultString());
        System.out.println(MESSAGE_TO_PRINT_YIELD_A + lottoResult.getYield() + MESSAGE_TO_PRINT_YIELD_B);
    }
    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
    public void printSortedLottos(UserLottos userLottos) {
        Set<Lotto> lottoSet = userLottos.getUserLottos();

        for (Lotto lotto : lottoSet) {
            List<Integer> copyLotto = new ArrayList<>(lotto.getNumbers());
            copyLotto.sort(Integer::compareTo);
            System.out.println(copyLotto);
        }
    }
}
