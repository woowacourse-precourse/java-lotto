package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (int i=0;i<numbers.size();i++){
            int number=numbers.get(i);
            if (number<1 || number>45){
                throw new IllegalArgumentException();
            }
        }
    }

    private WinningStatistic produceWinningStatistic(Lotto answer, int bonusNum){
        Set<Integer> answerNumSet=new HashSet<>(answer.numbers);
        int numOfCorrectLottoNum=0;
        boolean bonusNumCorrect=false;
        for (int number :numbers){
            if(answerNumSet.contains(number)){
                numOfCorrectLottoNum+=1;
                answerNumSet.remove(number);
            }
            if(number==bonusNum){
                bonusNumCorrect=true;
            }
        }
        return WinningStatistic.getInstance(numOfCorrectLottoNum,bonusNumCorrect);
    }


    // TODO: 추가 기능 구현
}
