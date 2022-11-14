package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Price;
import lotto.domain.WinningLotto;
import lotto.resource.message.ExceptionMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private static List<Lotto> lottoTicket = new ArrayList<>();
    private static WinningLotto winningLotto;

    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            Price price = new Price(inputView.askPrice());
            LottoGenerator lottoGenerator = new LottoGenerator(price);
            lottoTicket.addAll(lottoGenerator.generateLotto());
            outputView.printLottoTicketInformation(lottoTicket);
            winningLotto = new WinningLotto(inputView.askWinningNumbers(), inputView.askBonusNumber());
        } catch (IllegalArgumentException ignored) {
            System.out.println(ExceptionMessage.APPLICATION_EXIT.getMessage());
        }
    }
}
