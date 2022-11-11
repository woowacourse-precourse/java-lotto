package lotto.Domain;

public class LottoPublisher {
    public int calculateNumberOfLotto(int purchasingAmount) {
        int NumberOfLotto = purchasingAmount / 1000;

        return NumberOfLotto;
    }
}
