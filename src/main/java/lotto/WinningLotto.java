package lotto;

import java.util.List;

public class WinningLotto implements LottoInterface{
    private final List<Integer> numbers;

    public WinningLotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    @Override
    public void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateLottoNumberRange(numbers);
        validateLottoNumberDuplicated(numbers);
    }
    @Override
    public void validateLottoSize(List<Integer> numbers){
        final int winningLottoSize = 7;
        if(numbers.size() != winningLottoSize){
            throw new IllegalArgumentException("[ERROR] 당첨 로또는 당첨 번호 6개와 보너스 번호 1개로 이루어져야 합니다.");
        }
    }

    public void validateLottoNumberRange(List<Integer> numbers){
        final int startRange = 1;
        final int endRange = 45;
        for(int number : numbers){
            if(number < startRange || number > endRange){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public void validateLottoNumberDuplicated(List<Integer> numbers){
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되서는 안됩니다");
        }
    }
    public List<Integer> getNumbers(){
        return numbers;
    }
}
