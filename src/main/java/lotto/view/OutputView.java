package lotto.view;

import lotto.model.Lotto;
import lotto.util.Constants;

import java.util.List;

public class OutputView {
    public static void outputAnnounceMoney(int count) {
        System.out.println(count + Constants.PRINT_OUTPUT_MONEY);
    }

    public static void outputLottoList(List<Lotto> lottoList) {
        for (Lotto numbers : lottoList) {
            System.out.println(numbers);
        }
    }
}
