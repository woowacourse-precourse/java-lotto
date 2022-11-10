package lotto.domain.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoResult {
    private final Map<ResultCase, Integer> lottoResult;

    public LottoResult() {
        this.lottoResult = Arrays.stream(ResultCase.values())
                .collect(Collectors.toMap(value -> value, count -> 0, (a, b) -> b,
                        () -> new EnumMap<>(ResultCase.class)));
    }
    public LottoResult(final Map<ResultCase, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoResult that = (LottoResult) o;
        return Objects.equals(lottoResult, that.lottoResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResult);
    }
}
