package lotto.model;

public class LottoData {
    int lottoAmount;

    LottoData(int money) {
        this.lottoAmount = money / 1000;
    }
}
