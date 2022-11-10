package lotto;


import lotto.domain.InputView;
import lotto.domain.LottoStore;
import lotto.utils.Validation;

public class Application {
    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();
        lottoStore.sellLotto();
    }
}
