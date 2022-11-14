package lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
    private static List<Lotto> lottoTicket = new ArrayList<>();
    private static WinningLotto winningLotto;
    private static LottoRating lottoRating;
    private static BigDecimal yield;

    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            Price price = new Price(inputView.askPrice());
            LottoGenerator lottoGenerator = new LottoGenerator(price);
            lottoTicket.addAll(lottoGenerator.generateLotto());
            outputView.printLottoTicketInformation(lottoTicket);
            winningLotto = new WinningLotto(inputView.askWinningNumbers(), inputView.askBonusNumber());
            lottoRating = new LottoRating(lottoTicket, winningLotto);
            lottoRating.rate();
            YieldCalculator yieldCalculator = new YieldCalculator(lottoRating.getWinningCountRepository(),
                    price.getPurchasePrice());
            yield = yieldCalculator.calculate();
        } catch (IllegalArgumentException ignored) {
            System.out.println(ExceptionMessage.APPLICATION_EXIT.getMessage());
        }
    }
}
