package lotto.domain.lotto;

import lotto.exception.NullException;
import java.util.List;
import java.util.Objects;

public class LottoGroup {
    private final List<Lotto> value;

    public LottoGroup(List<Lotto> rawValue) {
        validate(rawValue);
        this.value = rawValue;
    }

    public static LottoGroup of(final List<Lotto> rawValue) {
        return new LottoGroup(rawValue);
    }

    private void validate(List<Lotto> rawValue) {
        if (rawValue.size() == 0) {
            throw new NullException();
        }
    }

    public List<Lotto> get() {
        return List.copyOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoGroup that = (LottoGroup) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
