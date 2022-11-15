package lotto.domain;

import lotto.exception.ErrorHandler;
import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        isUnique(numbers);
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ErrorHandler.sizeOverException();
        }
        for (int i = 0; i < 6; i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                ErrorHandler.numberUnCorrectException();
            }
        }
    }
    public void isUnique(List<Integer> numbers) {
        if (numbers.size()!=Arrays.asList(numbers.stream().distinct().toArray()).size()){
            ErrorHandler.mutualInputException();
        }
    }
    public LottoProperties lotteryCheck(Lotto awardLotto, int bonusNumber){
        int correct = numberCheck(awardLotto);
        LottoProperties lottoProperties = LottoProperties.findType(correct);
        if (lottoProperties == LottoProperties.LOTTO_THIRDWINNER && isBonusCorrect(bonusNumber) == true){
            lottoProperties = LottoProperties.LOTTO_SECONDWINNER;
        }
        return lottoProperties;
    }
    public int numberCheck(Lotto awardLotto){
        int correct = 0;
        int i =0;
        int j =0;
        int inputNumber;
        int awardNumber;
        while (i<numbers.size() && j<awardLotto.getNumbers().size()) {
            inputNumber = numbers.get(i);
            awardNumber = awardLotto.getNumbers().get(j);
            if (inputNumber == awardNumber) {
                correct++;
                i++;
                j++;
            }
            if (inputNumber < awardNumber) {
                i++;
            }
            if (awardNumber < inputNumber) {
                j++;
            }
        }
        return correct;
    }
    public Boolean isBonusCorrect(int bonusNumber){
        for(int i =0;i<numbers.size();i++){
            if (bonusNumber==numbers.get(i)){
                return true;
            }
        }
        return false;
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
