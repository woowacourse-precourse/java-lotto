package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.LottoException;
import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.LottoGenerator;
import lotto.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        LottoException exception = new LottoException();
//        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//        for (Integer number : numbers) {
//            System.out.println("number = " + number);
//        }
//        LottoGenerator lottoGenerator = new LottoGenerator();
//        List<Lotto> lottos = lottoGenerator.createLottoNumbers(14);
//        for (Lotto lotto : lottos) {
//            List<Integer> numbers = lotto.getNumbers();
//            for (Integer number : numbers) {
//                System.out.print(number+", ");
//            }
//            System.out.println();
//        }
    }
}
