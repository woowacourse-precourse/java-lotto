package lotto.Model;

import java.util.*;
import lotto.Utils.Util;
import lotto.Utils.Validator;

public class Buyer {

    public final int NUMBERS_OF_LOTTO = 6;
    public final int START_NUM = 1;
    public final int END_NUM = 45;

    private int purchaseAmount;
    private int purchaseCount;
    private int winningAmount;
    private double earningRatio;
    private List<List<Integer>> lottoWallet;

    public Buyer(String purchaseAmount) {
        new Validator(purchaseAmount);
        this.purchaseAmount = Util.getInt(purchaseAmount);
        this.purchaseCount = Calculator.divide1000(this.purchaseAmount);
        this.lottoWallet = new ArrayList<>();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
    public int getPurchaseCount() {
        return purchaseCount;
    }
    public List<List<Integer>> getLottoWallet() {
        return lottoWallet;
    }

    public void addLotto(){
        int count = getPurchaseCount();
        Util util = new Util();
        for(int i = 0; i< count; i++){
            lottoWallet.add(util.generateRandomNum(START_NUM, END_NUM, NUMBERS_OF_LOTTO));
        }
    }
}
