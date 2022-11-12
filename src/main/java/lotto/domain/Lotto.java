package lotto.domain;

import lotto.constant.Rank;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkNumbersDuplication(numbers);
        this.numbers = numbers;
        sortInAscendingOrder();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumbersDuplication(List<Integer> numbers) {
        Set<Integer> validator = new HashSet<>();
        for (int number : numbers){
            if(validator.contains(number)){
                throw new IllegalArgumentException();
            }
            validator.add(number);
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void sortInAscendingOrder(){
        Collections.sort(numbers);
    }

    public Rank compareNumbersWith(List<Integer> winningNumbers, int bonusNumber){
        final String MATCHING_STATEMENT = "개 일치";
        final String BONUS_NUMBER_MATCHING_STATEMENT = ", 보너스 볼 일치";

        int count = calculateCountOfMatchingNumbers(winningNumbers);
        String winningData = count + MATCHING_STATEMENT;
        if(count == 5 && contains(bonusNumber)){
            winningData += BONUS_NUMBER_MATCHING_STATEMENT;
        }

        return convertToRankFrom(winningData);
    }

    private Rank convertToRankFrom(String winningData){
        for(int i =  0; i < Rank.size(); i++) {
            Rank winningRank = Rank.get(i);
            if (winningData.equals(winningRank.condition())) {
                return winningRank;
            }
        }
        return Rank.NOTHING;
    }

    private int calculateCountOfMatchingNumbers(List<Integer> winningNumbers){
        int count = 0;
        for(int winningNumber : winningNumbers){
            if(numbers.contains(winningNumber)){
                count++;
            }
        }
        return count;
    }

    private boolean contains(int number){
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.contains(number)){
                return true;
            }
        }
        return false;
    }
}
