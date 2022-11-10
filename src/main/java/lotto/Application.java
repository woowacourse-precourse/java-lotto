package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.LottoException;
import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        LottoException exception = new LottoException();
        OutputView outputView = new OutputView();
//        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//        for (Integer number : numbers) {
//            System.out.println("number = " + number);
//        }

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos = lottoGenerator.createLottoNumbers(14);
        outputView.printLottoAmount(14);
        outputView.printLottoNumbers(lottos);
    }
}
