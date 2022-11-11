package view;

import java.util.List;
import model.Lotto;
import model.Purchase;
import model.User;
import util.message.ConsoleMessage;
import util.message.ErrorMessage;

public class PrintView {

    public static void purchaseLotto() {
        System.out.println(ConsoleMessage.MESSAGE_PURCHASE_LOTTO);
    }

    public static void error(String message){
        System.out.println(ErrorMessage.PREFIX_ERROR + message);
    }

    public static void infoBoughtLotto(User user) {
        Purchase usersPurchase = user.getPurchase();
        int purchaseCount = usersPurchase.getMoney() / Lotto.PER_PRICE_LOTTO;
        List<Lotto> boughtLottos = user.getBoughtLottos();

        System.out.println("\n"+purchaseCount + "개를 구매했습니다.");
        for (Lotto lotto : boughtLottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers.toString());
        }
    }

    public static void winNum() {
        System.out.println(ConsoleMessage.WIN_LOTTO_NUMBER);
    }

    public static void bonusNum() {
        System.out.println(ConsoleMessage.WIN_LOTTO_NUMBER);
    }

}
