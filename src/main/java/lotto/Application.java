package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Referee;
import lotto.domain.Winnings;
import lotto.view.LottoView;
import lotto.view.MoneyView;
import lotto.view.NumberView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoGenerator generator = new LottoGenerator();
        Winnings.setWinnings();
        try {
            List<Lotto> lottoList = generator.generate(MoneyView.get());
            LottoView.print(lottoList);
            Referee referee = new Referee(lottoList, NumberView.getWinNumbers(), NumberView.getBonusNumber());
            LottoView.printResult(referee.compare());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
