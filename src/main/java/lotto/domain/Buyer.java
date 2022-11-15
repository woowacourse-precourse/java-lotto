package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.enums.BuyerPrint;
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

    Buyer(int lottoAmount) {
        purchaseAmountUnit.validDivisionByThousand(lottoAmount);
        this.lottoAmount = lottoAmount;

    }

    public void printLotto() {
        String lottoCount = String.valueOf(purchaseAmountUnit.purchaseAmount(lottoAmount));

        System.out.println(lottoCount+BuyerPrint.PRINT_LOTTO_DATA);
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
        totalRate = Math.round((double) totalMoney / lottoAmount);
    }

    public void sortAllLottoNumber() {
        for (int i = 0; i < purchaseLotto.size(); i++) {
            purchaseLotto.get(i).sortByNumber();
        }
    }

    static void validConsistByNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    static int LottoAmountConversion(String inputValue) {
        int purchaseAmount;

        validConsistByNumber(inputValue);
        purchaseAmount = Integer.parseInt(inputValue);

        return purchaseAmount;
    }

    public void buyLotto() {
        PurchaseAmountUnit purchaseAmountUnit = PurchaseAmountUnit.LOTTO_PURCHASE_UNIT;
        int lottoCount = purchaseAmountUnit.purchaseAmount(lottoAmount);

        while (purchaseLotto.size() < lottoCount) {
            purchaseLotto.add(Lotto.creatLottoNumbers(lottoCount));
        }
    }
}
