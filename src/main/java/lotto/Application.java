package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.view.LottoView;
import lotto.view.MoneyView;
import lotto.view.NumberView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoGenerator generator = new LottoGenerator();
        List<Lotto> lottoList = generator.generate(MoneyView.get());
        LottoView.print(lottoList);
        NumberView.getWinNumbers();
        NumberView.getBonusNumber();
    }
}
