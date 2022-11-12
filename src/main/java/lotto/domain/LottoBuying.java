package lotto.domain;

import static lotto.view.InputView.inputMoney;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.RandomNumbersGenerator;

public class LottoBuying {
    private int money;
    private int lottoCount;

    LottoBuying() {
        this.money = getMoney();
        this.lottoCount = countBuyingLotto(this.money);
    }

    public static LottoTicket issueLottoTicket(int lottoCount) {
        List<Lotto> lottoTicket = new ArrayList<>();

        for(int issued=0; issued<lottoCount; issued++){
            List<Integer> numbers = issueLotto();
            lottoTicket.add(new Lotto(numbers));
        }
        return new LottoTicket(lottoTicket);
    }

    private static List<Integer> issueLotto() {
        List<Integer> lotto = RandomNumbersGenerator.randomNumbers();
        return lotto;
    }

    private int getMoney() {
        return inputMoney();
    }

    private int countBuyingLotto(int money) {
        return money / 1000;
    }
}
