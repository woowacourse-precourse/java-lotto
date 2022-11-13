package lotto;

import java.util.List;
import lotto.domain.LottoNumbers;
import lotto.domain.PlayerLottoAmount;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
//        PlayerLottoAmount playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerAmount());
//        int result = playerLottoAmount.calculateLottoCount();
//        System.out.println(result);
        LottoNumbers lottoNumbers = new LottoNumbers();
        List<Integer> list = lottoNumbers.setRandomNumbers();
        System.out.println(list);
    }
}
