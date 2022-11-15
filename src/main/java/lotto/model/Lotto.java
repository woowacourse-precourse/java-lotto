package lotto.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public ArrayList<Integer> getSortedLottoNumbers(){
        ArrayList<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.addAll(numbers);
        Collections.sort(lottoNumbers);
        System.out.println(lottoNumbers);
        return lottoNumbers;
    }

    public List<Integer> getLottoNumbers(){
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        HashSet<Integer> duplicate = new HashSet<>();

        numbers.forEach(number->{
            if(duplicate.contains(number)){
                throw new IllegalArgumentException();
            }
            duplicate.add(number);
        });

    }

    public Ranking checkResult(List<Integer> winningNumbers, int bonusNumber){
        int count=0;
        for(int number:numbers){
            if(winningNumbers.contains(number)){
                count++;
            }
        }
        return Ranking.findRank(count,numbers.contains(bonusNumber));
    }

}
