package view;

import domain.Lotto;
import domain.enums.GameMessage;
import java.util.List;

public class BuyerOutputView {
    public static void showLottoCount(int ticketAmount) {
        System.out.println(ticketAmount + GameMessage.BUY_MESSAGE.getGameMessage());
    }

    public static void showLottoNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

}
