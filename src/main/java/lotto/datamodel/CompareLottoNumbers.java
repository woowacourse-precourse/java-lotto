package lotto.datamodel;

import java.util.ArrayList;
import java.util.List;

public class CompareLottoNumbers {

    private final List<Integer> numbers;
    private final int bonusNumber;
    public CompareLottoNumbers(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> calculator(int lottoCount, List<List<Integer>> lottoNumbers) {
        Rank score;
        List<Integer> price = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++){
            score = checkSameNumber(lottoNumbers.get(i));
            if(score != Rank.NONE){
                price.add(score.getAmount());
            }
        }
        return price;
    }

    public Rank checkSameNumber(List<Integer> oneNumbers) {
        int count = 0;
        boolean bonusValid = false;

        for(int i = 0; i < 6; i ++){
            if(oneNumbers.contains(numbers.get(i))){
                count++;
            }
            if(oneNumbers.contains(bonusNumber)){
                bonusValid = true;
            }
        }

        if(count == 6) {
            return Rank.FIRST;
        }
        if(count == 5 && bonusValid == true) {
            return Rank.SECOND;
        }
        if(count == 5) {
            return Rank.THIRD;
        }
        if(count == 4){
            return Rank.FOURTH;
        }
        if(count == 3){
            return Rank.FIFTH;
        }
        return Rank.NONE;
    }
}
