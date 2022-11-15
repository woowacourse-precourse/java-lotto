package lotto;

import camp.nextstep.edu.missionutils.Randoms;
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

        Set<Integer> notSameNumbers = new HashSet<>(numbers);
        if(notSameNumbers.size()!=numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private static void forSort(int i, List<Integer>numbers){
        for(int j=i+1; j<numbers.size(); j++) {
            if(numbers.get(i) > numbers.get(j)) {
                numbers.set(numbers.get(i), numbers.get(j));
                numbers.set(numbers.get(j), numbers.get(i));
            }
        }
    }

    public static List<Integer> ascendSorting(List<Integer> numbers){
        for(int i=0; i<numbers.size(); i++){
            forSort(i,numbers);
        }
        return numbers;
    }

    public static Lotto makeLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(ascendSorting(numbers));
        return lotto;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
