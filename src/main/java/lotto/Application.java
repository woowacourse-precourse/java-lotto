package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoGenerator;
import lotto.domain.Price;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.message.ExceptionMessage;

public class Application {
    private static List<Lotto> lottoTicket = new ArrayList<>();

    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            Price price = new Price(inputView.askPrice());
            LottoGenerator lottoGenerator = new LottoGenerator(price);
            lottoTicket.addAll(lottoGenerator.generateLotto());
            outputView.printLottoTicketInformation(lottoTicket);
        } catch (IllegalArgumentException ignored) {
            System.out.println(ExceptionMessage.APPLICATION_EXIT.getMessage());
        }
    }
}
