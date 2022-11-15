package lotto;

import lotto.util.MultipleNumericConverter;
import lotto.util.NumericConverter;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoApplication lottoApplication = new LottoApplication(new NumericConverter(),
                new MultipleNumericConverter());
        lottoApplication.play();
    }

}
