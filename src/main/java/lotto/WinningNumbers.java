package lotto;

import java.util.List;
import java.util.Objects;

public class WinningNumbers {
    private final List<Integer> lottos;
    private final Integer bonusNumber;

    public WinningNumbers(List<Integer> lottos, Integer lottoItem) {
        this.lottos = lottos;
        this.bonusNumber = lottoItem;
    }

    private void validate(List<Lotto> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void validateBonusNumberDuplicate(
            List<Lotto> lottoItems,
            Lotto bonusNumber
    ) {
        if (lottoItems.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public boolean hasLottoNumber(Integer lottoItem) {
        return lottos.contains(lottoItem);
    }

    public boolean hasBonusNumber(Integer lottoItem) {
        return lottos.equals(lottoItem);
    }

    @Override
    public String toString() {
        return "WinningNumbers{" +
                "lottoNumbers=" + lottos +
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
        return Objects.equals(lottos, that.lottos) && Objects
                .equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos, bonusNumber);
    }

}
