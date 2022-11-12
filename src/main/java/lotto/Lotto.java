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
            throw new IllegalArgumentException
                    ("[ERROR]: 로또 당첨 숫자에는 6개를 입력해주세요");
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (int number: numbers){
            if (number < 1 || number > 45) throw new IllegalArgumentException
                    ("[ERROR]: 로또 당첨 숫자에는 1이상 45이하의 숫자를 입력해주세요.");
        }
    }

    private void validateLottoNumberDuplicated(List<Integer> numbers) {
        HashSet<Integer> DuplicatedNumber = new HashSet<>(numbers);

        if (DuplicatedNumber.size() < 6){
            throw new IllegalArgumentException
                    ("[ERROR]: 로또 당첨 숫자에는 중복된 숫자를 입력하면 안됩니다.");
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
                throw new IllegalArgumentException
                        ("[ERROR]: 로또 번호는 숫자만 입력할 수 있습니다.");
            }
        }
    }
}
