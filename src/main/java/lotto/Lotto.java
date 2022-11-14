package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean hasNumber(int number){
        return numbers.contains(number);
    }

    public LottoRanking findLottoRankingBy(WinningLotto winningLotto){
        int match = (int) numbers.stream()
                .filter(winningLotto::hasMajorNumber)
                .count();
        boolean hasBonusNumber = numbers.stream()
                .anyMatch(winningLotto::hasBonusNumber);
        return LottoRanking.findByMatchingInformation(match, hasBonusNumber);
    }

    public void printLottoNumbers(){
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNumbers);
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateUnique(numbers);
        validateRange(numbers);
    }
    private void validateLength(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
    }
    private void validateUnique(List<Integer> numbers){
        int numOfUniqueNumber = (int)numbers.stream()
                .distinct()
                .count();
        if(numOfUniqueNumber != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 다른 숫자여야 합니다.");
        }
    }
    private void validateRange(List<Integer> numbers){
        int numOfOutOfRangeNumber = (int) numbers.stream()
                .filter(n -> n>45 || n<1)
                .count();
        if(numOfOutOfRangeNumber > 0){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
