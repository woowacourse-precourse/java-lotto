package lotto.domain;

public class LottoMachine {

    private final int purchasePrice;

    public LottoMachine(String inputPrice) {
        this.purchasePrice = Integer.parseInt(inputPrice);
    }

}
