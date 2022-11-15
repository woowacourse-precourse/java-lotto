package lotto.message;

import static lotto.message.PrintMessage.PURCHASE_QUANTITY;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.PurchaseLottos;

public class PurchaseLottosMessage {

    private final PurchaseLottos purchaseLottos;

    public PurchaseLottosMessage(PurchaseLottos purchaseLottos) {
        this.purchaseLottos = purchaseLottos;
    }

    public static PurchaseLottosMessage makePurchaseLottoMessage(PurchaseLottos purchaseLottos) {
        return new PurchaseLottosMessage(purchaseLottos);
    }

    public String getMessage() {
        StringBuffer stringBuffer = new StringBuffer();

        appendPurchaseQuantity(stringBuffer);
        appendLottos(stringBuffer);

        return stringBuffer.toString();
    }

    private String createPurchaseQuantityMsg(int quantity) {
        return String.format("%d%s", quantity, PURCHASE_QUANTITY.getMessage());
    }

    private void appendPurchaseQuantity(StringBuffer stringBuffer) {
        stringBuffer.append(createPurchaseQuantityMsg(purchaseLottos.quantity()));
        stringBuffer.append(System.lineSeparator());
    }

    private void appendLottos(StringBuffer stringBuffer) {
        purchaseLottos.list().forEach(lotto -> appendLotto(stringBuffer, lotto));
    }

    private void appendLotto(StringBuffer stringBuffer, Lotto lotto) {
        stringBuffer.append(lotto.toString());
        stringBuffer.append(System.lineSeparator());
    }

}
