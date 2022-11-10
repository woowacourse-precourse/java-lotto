package lotto;

import java.util.List;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;

public class Application {
    public static void main(String[] args) {
        int price = 5000;
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();
        Lottos lottos = lottoGenerator.generateLottos(price);

        List<Integer> mainDraw = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        WinningNumbers winningNumbers = new WinningNumbers(mainDraw, bonus);

    }
}
