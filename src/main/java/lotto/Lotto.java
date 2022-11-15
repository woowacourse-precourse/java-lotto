package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static int LOTTO_NUMBER_LIMIT = 6;
    private static int NO_MATCH_COUNT = 0;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public int compareWinNum(WinningNumber winningNumber){
        List<Integer> match = new ArrayList<>(numbers);
        match.retainAll(winningNumber.copyWinningNumber());
        return match.size(); //size가 당첨된 갯수
    }

    public boolean containBonusNum(WinningNumber winningNumber) {
        if (numbers.contains(winningNumber.getBonusNumber())) {
            return true;
        }
        return false;
    }

    public boolean contains(int number){
        if(numbers.contains(number)){
            return true;
        }
        return false;
    }
    public List<Integer> copyNumbers(){
        return List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        validLottoFalseRange(numbers);
        validCreateLottoByDuplicatedNumber(numbers);
    }
    private void validLottoFalseRange(List<Integer> numbers){
        if (numbers.size() != LOTTO_NUMBER_LIMIT) {
            throw new IllegalArgumentException();
        }
    }
    private void validCreateLottoByDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
