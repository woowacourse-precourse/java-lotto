package lotto;

import lotto.domain.Lotto;
import lotto.model.AutoLottoGenerator;
import lotto.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Lotto> test = AutoLottoGenerator.generateLottos(10000);
        test.forEach(System.out::println);
    }
}
