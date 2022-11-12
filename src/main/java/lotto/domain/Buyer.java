package lotto.domain;

import java.util.*;

public class Buyer {

    public final int NUMBERS_OF_LOTTO = 6;
    public final int START_NUM = 1;
    public final int END_NUM = 45;

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

    public void addLotto(int count){
        NumberGenerator generator = new NumberGenerator();
        for(int i = 0; i< count; i++){
            lottoWallet.add(generator.generateRandomNum(START_NUM, END_NUM, NUMBERS_OF_LOTTO));
        }
    }
}
