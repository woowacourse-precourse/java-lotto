package lotto;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public static final int minimumMoney = 1000;
    public static final int pricePerPiece = 1000;
    private int numberOfPurchase;
    private int money;
    private double yield;
    private final List<List<Integer>> lottoNumbers;
    private final Manager manager;
    private int[] result;

    public Player() {
        manager = new Manager();
        lottoNumbers = new ArrayList<>();
    }

    public int purchaseLotto() throws IllegalArgumentException {
        manager.requestMoneyStatementPrint();
        int money = manager.inputMoney();
        if (money < minimumMoney) {
            throw new IllegalArgumentException(ErrorMessage.IS_LACK.toString());
        }
        if (money % pricePerPiece != 0) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_DIVISIBLE_BY_1000.toString());
        }
        numberOfPurchase = money / pricePerPiece;
        this.money = money;
        return numberOfPurchase;
    }

    public void getLottoNumbers() {
        for (int i = 0; i < numberOfPurchase; i++) {
            lottoNumbers.add(manager.generator());
        }
    }

    public void checkGetLottoNumbers() {
        System.out.println();
        System.out.println(numberOfPurchase + "개를 구매했습니다.");
        manager.printAllPurchaseLottoNumbers(lottoNumbers);
        System.out.println();
    }

    public void makeGenerate() {
        manager.generateLotto();
    }

    public void calculateResult() {
        result = manager.compareNumber(lottoNumbers);
        yield = manager.calculateYield(money, result);
    }

    public void showResult() {
        System.out.println("\n" + "당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + result[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result[4] + "개");
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
