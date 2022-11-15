package lotto.view;
import lotto.strings.Strings;
public class InputView {
    public InputView() {
    }

    static public void purchaseLotto() {
        System.out.println(Strings.purchaseMessage);
    }
    static public void winnigNumber() {
        System.out.println(Strings.winningLottoMessage);
    }
    static public void bonusNumber() {
        System.out.println(Strings.winnigBonusMessage);
        
    }
}
