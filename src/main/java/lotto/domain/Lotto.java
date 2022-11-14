package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.naturalOrder;
import static lotto.dto.LottoResponseDtos.LottoResponseDto;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidationUtils.validate(numbers);
        this.numbers = mapToLottoNumber(numbers);
    }

    private List<LottoNumber> mapToLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public int countContainsNumber(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::isContains)
                .count();
    }

    public boolean isContains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public LottoResponseDto toResponseDto() {
        sort();
        return new LottoResponseDto(mapToInteger());
    }

    private void sort() {
        numbers.sort(naturalOrder());
    }

    private List<Integer> mapToInteger() {
        return numbers.stream()
                .map(LottoNumber::mapToInt)
                .collect(Collectors.toList());
    }
}
