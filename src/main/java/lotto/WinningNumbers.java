package lotto;

import java.util.List;
import java.util.Objects;

public class WinningNumbers {
    private final List<LottoItem> lottoItems;
    private final LottoItem bonusNumber;

    public WinningNumbers(List<LottoItem> lottoItems, LottoItem lottoItem) {
        this.lottoItems = lottoItems;
        this.bonusNumber = lottoItem;
    }

    private void validate(List<LottoItem> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void validateBonusNumberDuplicate(
            List<LottoItem> lottoItems,
            LottoItem bonusNumber
    ) {
        if (lottoItems.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public boolean hasLottoNumber(Integer lottoItem) {
        return lottoItem.equals(lottoItem);
    }

    public boolean hasBonusNumber(Integer lottoItem) {
        return lottoItem.equals(lottoItem);
    }

    @Override
    public String toString() {
        return "WinningNumbers{" +
                "lottoNumbers=" + lottoItems +
                ", bonusNumber=" + bonusNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(lottoItems, that.lottoItems) && Objects
                .equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoItems, bonusNumber);
    }

}
