package lotto;

import lotto.domain.Input;
import lotto.domain.Issue;
import lotto.domain.LottoService;
import lotto.domain.Output;
import lotto.domain.impl.InputImpl;
import lotto.domain.impl.IssueImpl;
import lotto.domain.impl.LottoServiceImpl;
import lotto.domain.impl.OutputImpl;

import java.util.List;
import java.util.Map;

public class Application {

    private static final Issue issue = new IssueImpl();
    private static final LottoService lottoService = new LottoServiceImpl();
    private static final Input input = new InputImpl();
    private static final Output output = new OutputImpl();

    public static void main(String[] args) {
        try {
            int amount = input.amount();
            List<Lotto> issuedLottos = createLottos(amount);
            output.issuedLottos(issuedLottos);
            PrizeNumber prizeNumber = input.prizeNumber();
            Map<Rank, Integer> results = getLottoResults(issuedLottos, prizeNumber);
            output.results(results);
            double rate = getRate(results, amount);
            output.rate(rate);
        } catch (IllegalArgumentException e) {
            output.exceptionMessage(e);
        }
    }

    private static List<Lotto> createLottos(int amount) {
        return issue.createLottos(amount);
    }

    private static Map<Rank, Integer> getLottoResults(List<Lotto> issuedLottos, PrizeNumber prizeNumber) {
        return lottoService.compare(issuedLottos, prizeNumber);
    }

    private static double getRate(Map<Rank, Integer> results, int amount) {
        return lottoService.calculateRate(results, amount);
    }
}
