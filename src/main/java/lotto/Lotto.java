package lotto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        redundancy(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력하셔야합니다.");
        }
    }
    private void redundancy(List<Integer> numbers){
        Set<Integer> numbersFilter = new HashSet<>(numbers);
        if(numbersFilter.size() != 6){
            throw new IllegalArgumentException("[ERROR] 입력하신 값에 중복이 존재합니다.");
        }
    }
    public List<Integer> getWinningNumber(){
        return numbers;
    }
    public int[] lotteResults(List<List<Integer>> lottoBundle,int bonusNumber){
        int[] resultStatistics={0,0,0,0,0};
        int count;
        List<Integer> currentLotto;
        for (List<Integer> lotto:lottoBundle) {
            currentLotto=new ArrayList<>(lotto);
            currentLotto.retainAll(numbers);
            count=currentLotto.size();
            if(count==6 || (count==5 && numbers.contains(bonusNumber))) count=count+1;
            count=count-3;
            if(count>=0)
                resultStatistics[count]=resultStatistics[count]+1;
        }
        return resultStatistics;
    }
}
