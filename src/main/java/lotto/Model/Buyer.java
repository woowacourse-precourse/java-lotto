package lotto.Model;

import java.util.*;
import lotto.Utils.Util;
import lotto.Utils.Validator;

public class Buyer {

    public final int NUMBERS_OF_LOTTO = 6;
    public final int START_NUM = 1;
    public final int END_NUM = 45;

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private int purchaseAmount;
    private int purchaseCount;
    private int winningAmount;
    private double earningRatio;

    public List<List<Integer>> getLottoWallet() {
        return lottoWallet;
    }

    private List<List<Integer>> lottoWallet;


    public Buyer(String purchaseAmount) {
        new Validator(purchaseAmount);
        this.purchaseAmount = Util.getInt(purchaseAmount);
        this.lottoWallet = new ArrayList<>();
    }

    public void addLotto(int count){
        Util util = new Util();
        for(int i = 0; i< count; i++){
            lottoWallet.add(util.generateRandomNum(START_NUM, END_NUM, NUMBERS_OF_LOTTO));
        }
    }
}
