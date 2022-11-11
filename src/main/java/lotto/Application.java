package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.LottoException;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        LottoException exception = new LottoException();
        OutputView outputView = new OutputView();
        Winner winner = new Winner("45,2,3,4,5,6");
        List<Integer> lottoWinningNumber = winner.getLottoWinningNumber();
//        for (Integer integer : lottoWinningNumber) {
//            System.out.println("integer = " + integer);
//        }
//        winner.checkLottoWinningNumber("46,2,3,4,5,6");
    }
}
