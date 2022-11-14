package lotto.domain.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    // 인스턴스 변수는 추가하면 안되지만 클래스 변수는 추가 가능함
    public final static String ERROR_LOTTO_NUMBER_SIZE = "[ERROR] 입력 받을 수 있는 로또의 크기는 6입니다.";
    public static final String ERROR_LOTTO_NUMBER_DUPLICATED = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private final static Integer FIX_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.validateNumbersSizeIsFixSize(numbers.size());

        var generatedLotto = generateLotto(numbers);

        this.validateLottoNumbersDuplicated(generatedLotto);
        this.numbers = this.convertListLottoNumberToListInteger(generatedLotto);
    }

    public Lotto(final String input) {
        var generatedLotto = generateLotto(input);

        this.validateNumbersSizeIsFixSize(generatedLotto.size());
        this.validateLottoNumbersDuplicated(generatedLotto);
        this.numbers = convertListLottoNumberToListInteger(generatedLotto);
    }

    private List<LottoNumber> generateLotto(String input) {
        return Arrays.stream(input.split(","))
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private List<LottoNumber> generateLotto(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private List<Integer> convertListLottoNumberToListInteger(final List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .sorted()
                .map(LottoNumber::number)
                .collect(Collectors.toList());
    }

    private void validateLottoNumbersDuplicated(List<LottoNumber> generatedLotto) {
        var size = generatedLotto.size();
        var removeDuplicatedSize = (int) generatedLotto.stream().distinct().count();

        if (size != removeDuplicatedSize) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_DUPLICATED);
        }

    }

    private void validateNumbersSizeIsFixSize(final Integer size) {
        if (!Objects.equals(size, FIX_SIZE)) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_SIZE);
        }
    }

    public List<Integer> numbers() {
        return this.numbers;
    }

    public String print() {
        return String.valueOf(this.numbers);
    }

    public Integer getCountByCompareLotto(Lotto lotto) {
        var count = numbers.stream()
                .filter(lotto::hasLottoNumber)
                .count();

        return Math.toIntExact(count);
    }

    private boolean hasLottoNumber(Integer lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public boolean hasLottoNumber(LottoNumber lottoNumber) {
        return hasLottoNumber(lottoNumber.number());
    }
    // TODO: 추가 기능 구현
}
