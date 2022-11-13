package lotto.domain;

public class CompareLotto {
    private final static int LOTTO_COUNT = 6;

    public int getMatchingLottoNumberCount(Lotto purchaseLotto, Lotto lottoNumbers) {
        int matchingNumber = 0;
        for (int i = 0; i < LOTTO_COUNT; i++) {
            if (lottoNumbers.contains(purchaseLotto.get(i))) {
                matchingNumber++;
            }
        }
        return matchingNumber;
    }

    public boolean checkMatchingBonusNumber(Lotto purchaseLotto, int bonus) {
        return purchaseLotto.contains(bonus);
    }
}
