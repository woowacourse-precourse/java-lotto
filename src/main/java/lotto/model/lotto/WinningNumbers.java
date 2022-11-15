package lotto.model.lotto;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningNumbers(Lotto winningLotto, LottoNumber bonusNumber) {
        validate(winningLotto, bonusNumber);

        this.winningLotto = new Lotto(winningLotto);
        this.bonusNumber = bonusNumber;
    }

    public int checkMatchCount(Lotto lotto) {
        int matchCount = 0;
        for(int i = 0; i < Lotto.LOTTO_NUMBER_LENGTH; i++) {
            LottoNumber lottoNumber = lotto.getNumber(i);
            if(winningLotto.contains(lottoNumber)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public boolean checkBonusMatch(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    private static void validate(Lotto lottoNumbers, LottoNumber bonusNumber) {
        if(isSameNumberOnLotto(bonusNumber, lottoNumbers)) {
            throw new IllegalArgumentException("로또 번호가 중복되어서는 안 됩니다.");
        }
    }

    private static boolean isSameNumberOnLotto(LottoNumber number, Lotto lottoNumbers) {
        return lottoNumbers.contains(number);
    }
}
