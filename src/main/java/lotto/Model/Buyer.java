package lotto.Model;

import java.util.*;
import lotto.Utils.Util;
import lotto.Utils.Validator.BuyerValidator;

public class Buyer {
    public final int NUMBERS_OF_LOTTO = 6;
    public final int ZERO = 0;
    public final int START_NUM = 1;
    public final int END_NUM = 45;
    private int purchaseAmount;
    private int purchaseCount;
    private int winningAmount;
    private double earningRatio;
    private List<Lotto> lottoWallet;

    public Buyer(String purchaseAmount) {
        new BuyerValidator(purchaseAmount);
        this.purchaseAmount = Util.getInt(purchaseAmount);
        this.purchaseCount = Calculator.divide1000(this.purchaseAmount);
        this.lottoWallet = new ArrayList<>();
    }
    public int getPurchaseCount() {
        return purchaseCount;
    }
    public List<Lotto> getLottoWallet() {
        return lottoWallet;
    }

    public void addLotto(){
        for(int i = ZERO; i< purchaseCount; i++){
            Lotto lotto = new Lotto(Util.generateRandomNum(START_NUM, END_NUM, NUMBERS_OF_LOTTO));
            lottoWallet.add(lotto);
        }
    }
}
