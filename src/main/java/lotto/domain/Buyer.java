package lotto.domain;

import lotto.domain.enums.ExceptionMessage;
import lotto.domain.enums.PurchaseAmountUnit;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private final PurchaseAmountUnit purchaseAmountUnit = PurchaseAmountUnit.LOTTO_PURCHASE_UNIT;
    private final List<Lotto> purchaseLotto = new ArrayList<>();
    private int lottoAmount;
    private int[] myWins;
    private int totalMoney;
    private double totalRate;

    public Buyer(int lottoAmount) {
        purchaseAmountUnit.validDivisionByThousand(lottoAmount);
        this.lottoAmount = lottoAmount;

    }

    public double getTotalRate() {
        return totalRate;
    }

    public List<Lotto> getPurchaseLotto() {
        return purchaseLotto;
    }

    public void printLotto() {
        for (int i = 0; i < purchaseLotto.size(); i++) {
            purchaseLotto.get(i).printLottoNumber();
        }
    }


    public void setMyWins(int[] myWins) {
        this.myWins = myWins;
    }

    public void calculateTotalMoney() {
        this.totalMoney = Judgment.calculatePrizeMoney(myWins);
    }

    public void calculateTotalRate() {
        totalRate = Math.round((double) totalMoney / lottoAmount * 1000) / 10.0;
    }


    static void validConsistByNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            System.out.println(ExceptionMessage.NOT_NUMBER_RANGE);
            throw new IllegalArgumentException();
        }
    }

    public static int lottoAmountConversion(String inputValue) {
        int purchaseAmount;

        validConsistByNumber(inputValue);
        purchaseAmount = Integer.parseInt(inputValue);

        return purchaseAmount;
    }

    public void buyLotto() {
        int lottoCount = calculateLottoCount();

        while (purchaseLotto.size() < lottoCount) {
            purchaseLotto.add(Lotto.creatLottoNumbers(lottoCount));
        }
    }

    public int calculateLottoCount() {
        PurchaseAmountUnit purchaseAmountUnit = PurchaseAmountUnit.LOTTO_PURCHASE_UNIT;
        return purchaseAmountUnit.purchaseAmount(lottoAmount);
    }
}
