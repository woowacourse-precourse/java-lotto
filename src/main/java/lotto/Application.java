package lotto;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        LottoTicket lottoTicket = new LottoTicket();
        Judgement judgement = new Judgement();
        Statistics statistics = new Statistics();

        int money = userInput.getMoneyInput();
        List<Integer> userLotto = userInput.getLottoInput();
        int bonus = userInput.getBonusInput();

        List<Integer> result = new ArrayList<>();

        int moneyCount = money / 1000;
        System.out.println(moneyCount + "개를 구매했습니다.");
        while (moneyCount > 0) {
            List<Integer> lotto = lottoTicket.makeLotto();
            Lotto lottos = new Lotto(lotto);
            result.add(judgement.compare(lotto, userLotto, bonus));
            moneyCount--;
        }
        statistics.printStatistics(result);
        double totalProfit =  statistics.findProfit() / Double.parseDouble(String.valueOf(money));
        System.out.println("총 수익률은 " + totalProfit * 100 + "%입니다.");
    }
}
