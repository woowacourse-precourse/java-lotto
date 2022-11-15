package lotto.view;

import lotto.model.Lotto;
import java.util.List;

public interface View {
    String requestMoney();
    void printLottoCount(int count);
    void printLotto(List<Lotto> boughtLottoes);
    String requestWinningNumbers();
    String requestBonusNumber();
    void printResult(double ratio);
}
