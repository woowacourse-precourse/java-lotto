package lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoRating;
import lotto.domain.Price;
import lotto.domain.WinningLotto;
import lotto.domain.YieldCalculator;
import lotto.resource.message.ExceptionMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private static final Map<String, Integer> WINNING_COUNT_REPOSITORY = new HashMap<>();
    private static final List<Lotto> LOTTO_TICKET = new ArrayList<>();
    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();

    public static void main(String[] args) {
        try {
            Price price = new Price(INPUT_VIEW.askPrice());
            LottoGenerator lottoGenerator = new LottoGenerator(price);
            LOTTO_TICKET.addAll(lottoGenerator.generateLotto());
            OUTPUT_VIEW.printLottoTicketInformation(LOTTO_TICKET);
            WinningLotto winningLotto = new WinningLotto(INPUT_VIEW.askWinningNumbers(), INPUT_VIEW.askBonusNumber());
            LottoRating lottoRating = new LottoRating(LOTTO_TICKET, winningLotto);
            WINNING_COUNT_REPOSITORY.putAll(lottoRating.rate());
            YieldCalculator yieldCalculator = new YieldCalculator(WINNING_COUNT_REPOSITORY, price.getPurchasePrice());
            BigDecimal yield = yieldCalculator.calculate();
            OUTPUT_VIEW.printWinningStatistics(WINNING_COUNT_REPOSITORY, yield);
        } catch (IllegalArgumentException ignored) {
            System.out.println(ExceptionMessage.APPLICATION_EXIT.getMessage());
        }
    }
}
