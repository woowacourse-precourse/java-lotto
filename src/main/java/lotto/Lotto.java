package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int bonus;

    public Lotto(List<Integer> numbers,int bonus) {
        validate(numbers);
        this.numbers = numbers;
        this.bonus=bonus;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
    public int ranking(List<Integer> lottoNum){
        int rank=0;
        if(compareMatchNumber(lottoNum)==6){

        }
        return rank;
    }
    public int compareMatchNumber(List<Integer> lottoNum)
    {
        lottoNum.retainAll(numbers);
        return lottoNum.size();
    }
    public int checkBounusNumber(List<Integer> lottoNum){

        if (lottoNum.contains(bonus)) {
            return 2;
        }else{
            return 3;
        }

    }
}
