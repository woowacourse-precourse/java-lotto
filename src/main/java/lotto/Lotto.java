package lotto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers,int range) {
        validate(numbers,range);
        redundancy(numbers,range);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers,int range) {
        if (numbers.size() != range) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력하셔야합니다.");
        }
    }
    private void redundancy(List<Integer> numbers,int range){
        Set<Integer> numbersFilter = new HashSet<>(numbers);
        if(numbersFilter.size() != range){
            throw new IllegalArgumentException("[ERROR] 입력하신 값에 중복이 존재합니다.");
        }
    }
    public List<Integer> getWinningNumber(){
        return numbers;
    }
    public int[] lottoResults(List<List<Integer>> lottoBundle,int bonusNumber){
        int[] resultStatistics={0,0,0,0,0};
        int count;
        List<Integer> currentLotto;
        for (List<Integer> lotto:lottoBundle) {
            currentLotto=new ArrayList<>(lotto);
            currentLotto.retainAll(numbers);
            count=currentLotto.size();
            if(count>=3&&count<=5&&!lotto.contains(bonusNumber))  resultStatistics[count-3]+=1;
            else if((count==5&&lotto.contains(bonusNumber)) || count==6)  resultStatistics[count-2]+=1;
        }
        return resultStatistics;
    }
}
