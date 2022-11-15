package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final int purchasePrice;
    private final List<Lotto> lottoList;

    public User(String input) {
        validatePurchasePrice(input);
        this.purchasePrice = Integer.parseInt(input);
        this.lottoList = createLottoList(purchasePrice);
    }

    public void validatePurchasePrice(String input) {
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(lotto.Error.INVALID_PRICE.getMessage());
        }
        if (inputNumber % 1000 != 0) {
            throw new IllegalArgumentException(lotto.Error.INVALID_PRICE.getMessage());
        }
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void printLottoList() {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            lotto.printNumbers();
        }
    }

    public List<Lotto> createLottoList(int purchasePrice) {
        int range = purchasePrice / 1000;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < range; i++) {
            lottoList.add(Lotto.createPurchaseLotto());
        }
        return lottoList;
    }
}
