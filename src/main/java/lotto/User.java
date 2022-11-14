package lotto;

import java.util.*;

public class User {
    private int purchaseAmount;
    private int lottoPurchaseCount;
    private ErrorPrint errorPrint;
    private List<Lotto> lottos;

    public User(int purchaseAmount){
        amountValidate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.lottoPurchaseCount = purchaseAmount / 1000;
        lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto){
        lottos.add(lotto);
    }

    public void amountValidate(int purchaseAmount){
        if (purchaseAmount % 10000 == 0) {
            throw new IllegalArgumentException(this.errorPrint.AmountErrorNumberError.getErrorMessage());
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getLottoPurchaseCount() {
        return lottoPurchaseCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
