package lotto.service;

import static java.lang.String.format;
import static lotto.constant.LottoConstant.AMOUNT_LIMIT;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

public class LottoService {

    private final Customer customer;
    private final LottoGenerator lottoGenerator;

    public LottoService() {
        this.customer = new Customer();
        this.lottoGenerator = new LottoGenerator();
    }

    public void generateByAmount(int amount) {
        int count = amount / AMOUNT_LIMIT;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = lottoGenerator.generateNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        customer.buyLottos(lottos);
    }

    public String showLottos() {
        List<Lotto> lottos = customer.showLottos();
        StringBuilder sb = new StringBuilder();

        lottos.forEach(lotto -> sb.append(lotto.getNumbers() + "\n"));

        return sb.toString();
    }

    public String checkWinning(List<Integer> winningNumbers, int bonusNumber) {
        customer.checkJackpot(winningNumbers, bonusNumber);
        int[] winnings = customer.getWinningList();
        return "3개 일치 (5,000원) - " + winnings[4] + "개\n"
                + "4개 일치 (50,000원) - " + winnings[3] + "개\n"
                + "5개 일치 (1,500,000원) - " + winnings[2] + "개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - " + winnings[1] + "개\n"
                + "6개 일치 (2,000,000,000원) - " + winnings[0] + "개\n";
    }

    public String calculateRate(int amount) {
        double rate = customer.calculateRate(amount);
        String rateString = format("%.1f", rate);
        return "총 수익률은 " + rateString + "%입니다.\n";
    }
}
