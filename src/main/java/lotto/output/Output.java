package lotto.output;

import lotto.domain.Lotto;
import lotto.enums.StringEnum;

import java.util.ArrayList;
import java.util.List;

public class Output {
    public static void askBuyPrice() {
        System.out.println(StringEnum.PRICE.getMessage());
    }

    public static void checkBuyLotto(List<Lotto> buyLottos) {
        int size = buyLottos.size();
        System.out.println(size + StringEnum.CHECK_LOTTO.getMessage());
        for (Lotto tempLotto : buyLottos) {
            System.out.println(tempLotto.getNumbers());
        }
        System.out.println();
    }

    public static void askWinNumber() {
        System.out.println(StringEnum.WIN_NUMBER.getMessage());
    }

    public static void askBonusNumber() {
        System.out.println(StringEnum.BONUS_NUMBER.getMessage());
    }
}
