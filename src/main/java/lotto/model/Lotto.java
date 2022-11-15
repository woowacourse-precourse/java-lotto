package lotto.model;

import lotto.message.PrintError;

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

    // 저장된 로또 번호 리스트를 반환
    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }

    // 입력된 문자열을 숫자로 변환
    public List<Integer> convertNumbers (String inputLottoNumber) {
        List<Integer> numbers;

        isRealLottoNumber(inputLottoNumber);
        numbers = splitLottoNumber(inputLottoNumber);

        return numbers;
    }

    // 입력된 숫자의 갯수가 6개가 맞는지 확인
    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(PrintError.LOTTO_SIZE);
            throw new IllegalArgumentException();
        }
    }

    // 입력된 숫자의 범위가 1~45 이내인지 확인
    private void validateLottoNumberRange(List<Integer> numbers) {
        for (int number: numbers){
            if (number < 1 || number > 45){
                System.out.println(PrintError.LOTTO_RANGE);
                throw new IllegalArgumentException();
            }
        }
    }

    // 입력된 로또 번호가 중복 되는지 확인
    private void validateLottoNumberDuplicated(List<Integer> numbers) {
        HashSet<Integer> DuplicatedNumber = new HashSet<>(numbers);

        if (DuplicatedNumber.size() < 6){
            System.out.println(PrintError.LOTTO_OVERLAP);
            throw new IllegalArgumentException();
        }
    }

    // 입력된 로또 번호에서 ,를 기준으로 번호를 나누는 메서드
    private List<Integer> splitLottoNumber (String tempLottoNumber) {
        List<Integer> lottoNumber = new ArrayList<>();

        for(String element: tempLottoNumber.split(",")) {
            lottoNumber.add(Integer.parseInt(element));
        }

        return lottoNumber;
    }

    // 입력된 문자열이 숫자가 맞는지 확인 하는 메서드
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
