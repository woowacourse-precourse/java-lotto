package lotto.domain;

import java.util.*;

public class Buyer {

    public final int NUMBERS_OF_LOTTO = 6;
    public final int START_LOTTO_NUMBER = 1;
    public final int END_LOTTO_NUMBER = 45;

    private int purchaseAmount;
    private int purchaseCount;
    private int winningAmount;
    private double earningRatio;
    private List<List<Integer>> lottoWallet;


    public Buyer() {
    }
}
