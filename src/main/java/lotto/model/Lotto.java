package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(String inputLottoNumber) {
        List<Integer> numbers = convertNumbers(inputLottoNumber);

        validateLottoNumberCount(numbers);
        validateLottoNumberRange(numbers);
        validateLottoNumberDuplicated(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }

    public List<Integer> convertNumbers (String inputLottoNumber) {
        List<Integer> numbers;

        isRealLottoNumber(inputLottoNumber);
        numbers = splitLottoNumber(inputLottoNumber);

        return numbers;
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(PrintError.LOTTO_SIZE);
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (int number: numbers){
            System.out.println(PrintError.LOTTO_RANGE);
            if (number < 1 || number > 45) throw new IllegalArgumentException();
        }
    }

    private void validateLottoNumberDuplicated(List<Integer> numbers) {
        HashSet<Integer> DuplicatedNumber = new HashSet<>(numbers);

        if (DuplicatedNumber.size() < 6){
            System.out.println(PrintError.LOTTO_OVERLAP);
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> splitLottoNumber (String tempLottoNumber) {
        List<Integer> lottoNumber = new ArrayList<>();

        for(String element: tempLottoNumber.split(",")) {
            lottoNumber.add(Integer.parseInt(element));
        }

        return lottoNumber;
    }

    private void isRealLottoNumber (String lottoNumber) {
        String mergedNumber = String.join(lottoNumber);

        for (char element: mergedNumber.toCharArray()) {
            if (element < 48 || element > 57) {
                System.out.println(PrintError.LOTTO_NUMBER);
                throw new IllegalArgumentException();
            }
        }
    }
}
