package lotto.Model;

import java.util.*;
import lotto.Utils.Util;
import lotto.Utils.Validator;

public class Buyer {

    public final int NUMBERS_OF_LOTTO = 6;
    public final int START_NUM = 1;
    public final int END_NUM = 45;
    public final int UNIT_OF_MONEY = 1000;

    private int purchaseAmount;
    private int purchaseCount;
    private int winningAmount;
    private double earningRatio;

    public List<List<Integer>> getLottoWallet() {
        return lottoWallet;
    }

    private List<List<Integer>> lottoWallet;


    public Buyer() {
        this.lottoWallet = new ArrayList<>();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(String purchaseAmount) {
        new Validator(purchaseAmount);
        this.purchaseAmount = Util.getInt(purchaseAmount);
    }
    public int getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount() {
        this.purchaseCount = this.purchaseAmount / UNIT_OF_MONEY;
    }

    public void addLotto(int count){
        Util util = new Util();
        for(int i = 0; i< count; i++){
            lottoWallet.add(util.generateRandomNum(START_NUM, END_NUM, NUMBERS_OF_LOTTO));
        }
    }
}
