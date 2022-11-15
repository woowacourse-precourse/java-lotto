package lotto.domain;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Purchase {
    private static List<List<Integer>> purchasedLotto = new ArrayList<>();

    private Purchase(int numberOfGame) {
        for (int i = 0; i < numberOfGame; i++) {
            List<Integer> game=Lotto.generateRandomLotto();
            Collections.sort(game);
            purchasedLotto.add(game);
        }
    }

    public static Purchase getInstance(int numberOfGame) {
        return new Purchase(numberOfGame);
    }
    public List<List<Integer>> getPurchasedLotteryNumber(){
        return this.purchasedLotto;
    }
}
