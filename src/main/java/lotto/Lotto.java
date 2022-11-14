package lotto;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || !isNotDuplicated(numbers)) {
            Exception.of(Exception.LOTTO_NUMBER_07);
        }
    }

    private boolean isNotDuplicated(List<Integer> numbers){
        boolean [] check = new boolean[45];
        for(Integer num : numbers){
            if(check[num-1]) return false;
            check[num-1] = true;
        }
        return true;
    }

    public void print(){
        System.out.print("[");
        for(int j=0; j < 6; j++){
            System.out.print(numbers.get(j));
            if(j != 5) System.out.print(", ");
        }
        System.out.print("]");
    }

    public MatchDto calcMatches(List<Integer> winningNumbers, Integer bonusNumber){
        int matchCount=0,lt=0,rt=0;
        boolean bonusState=false;
        while(lt < 6 && rt < 6){
            if(Objects.equals(numbers.get(lt), bonusNumber)) bonusState = true;
            if(Objects.equals(numbers.get(lt), winningNumbers.get(rt))) matchCount++;
            if(numbers.get(lt) >= winningNumbers.get(rt)) rt++;
            else if(numbers.get(lt) <= winningNumbers.get(rt)) lt++;
        }
        return MatchDto.of(matchCount, bonusState);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
