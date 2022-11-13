package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Referee;
import lotto.domain.WinNumber;
import lotto.view.LottoView;
import lotto.view.MoneyView;
import lotto.view.NumberView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGenerator generator = new LottoGenerator();
            List<Lotto> lottoList = generator.generate(MoneyView.get());
            LottoView.print(lottoList);
            WinNumber winNumber = new WinNumber(NumberView.getWinNumbers(), NumberView.getBonusNumber());
            Referee referee = new Referee(lottoList, winNumber.getWinNumbers(), winNumber.getBonusNumber());
            LottoView.printResult(referee.compare());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
