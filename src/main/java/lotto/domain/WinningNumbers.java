package lotto.domain;

import java.util.Objects;

public class WinningNumbers {
    private static final String DUPLICATE_ERROR = "보너스 번호는 당첨 번호와 중복될 수 없습니다";

    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        validateDuplicateNumber(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Ranking calculateRanking(LottoNumbers otherLottoNumbers) {
        int cnt = lottoNumbers.calculateSameCount(otherLottoNumbers);
        return Ranking.findRanking(cnt, otherLottoNumbers.contains(bonusNumber));
    }

    private void validateDuplicateNumber(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WinningNumbers)) {
            return false;
        }

        WinningNumbers that = (WinningNumbers) o;

        if (!Objects.equals(lottoNumbers, that.lottoNumbers)) {
            return false;
        }
        return Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        int result = lottoNumbers != null ? lottoNumbers.hashCode() : 0;
        result = 31 * result + (bonusNumber != null ? bonusNumber.hashCode() : 0);
        return result;
    }
}