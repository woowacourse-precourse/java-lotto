package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static lotto.domain.Rank.*;

public class Lotto {
    protected final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers){
        checkInputNumberIsValid(numbers);
        this.numbers = makeLotto(numbers);
    }

    public List<Integer> makeLotto(String inputLottoNumber){
        checkInputNumberIsValid(inputLottoNumber);
        return convertLottoNumber(inputLottoNumber);
    }

    public void checkInputNumberIsValid(String inputLottoNumber) {
        try {
            isValidShapeOrThrows(splitNumber(inputLottoNumber));
            List<Integer> lottoNumber = convertLottoNumber(inputLottoNumber);
            isNotDuplicatedNumberOrThrows(lottoNumber);
            checkNumberValid(lottoNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new NoSuchElementException();
        }
    }

    private void isValidShapeOrThrows(ArrayList<String> lottoNumber){
        if(lottoNumber.size() != LOTTO_LEN.value()){
            throw new IllegalArgumentException("[ERROR] 숫자 입력이 잘못 되었습니다.");
        }
    }

    private void isNotDuplicatedNumberOrThrows(List<Integer> lottoNumber) {
        List<Integer> collect = lottoNumber.stream().distinct().collect(Collectors.toList());
        if(collect.size() != LOTTO_LEN.value()){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    private void checkNumberValid(List<Integer> lottoNumber){
        for (Integer integer : lottoNumber) {
            checkNumberArea(integer);
        }
    }

    protected void checkNumberArea(int number){
        if(number > LOTTO_MAX_SIZE.value() || number < LOTTO_MIN_SIZE.value()){
            throw new IllegalArgumentException("[ERROR] 숫자는 1이상 45 이하의 숫자로 구성되어야 합니다.");
        }
    }

    public List<Integer> convertLottoNumber(String inputLottoNumber) {
        return splitNumber(inputLottoNumber).stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public ArrayList<String> splitNumber(String inputLottoNumber){
        return new ArrayList<>(List.of(inputLottoNumber.split(",")));
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
