package lotto.domain;


import lotto.View.InputMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Purchase {
    private static List<List<Integer>> purchasedNumbers = new ArrayList<>();

    private Purchase(int numberOfGame) {
        for (int i = 0; i < numberOfGame; i++) {
            List<Integer> game=Lotto.generateRandomLotto();
            Collections.sort(game);
            purchasedNumbers.add(game);
        }
        System.out.println("\n" + numberOfGame + InputMessage.PURCHASE_NUMBER_OF_GAME.getValue());
        printPurchasedNumbers();
    }

    public static Purchase getInstance(int numberOfGame) {
        return new Purchase(numberOfGame);
    }
    public static List<List<Integer>> getPurchasedNumbers(){
        return purchasedNumbers;
    }
    public void printPurchasedNumbers(){
        for(List obj:purchasedNumbers){
            System.out.println(obj);
        }
    }
}
