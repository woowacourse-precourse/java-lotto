package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoGenerator;
import lotto.domain.Price;
import lotto.view.InputView;

public class Application {
    private static List<Lotto> lottoTicket = new ArrayList<>();

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Price price = new Price(inputView.askPrice());
        LottoGenerator lottoGenerator = new LottoGenerator(price);
        lottoTicket.addAll(lottoGenerator.generateLotto());
    }
}
