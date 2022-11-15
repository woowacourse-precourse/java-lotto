package lotto;
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
    public int tt(List<List<Integer>> lottoBundle,int bonusNumber){
        int[] resultStatistics={0,0,0,0,0};
        int count;
        for (List<Integer> lotto:lottoBundle) {
            lotto.retainAll(numbers);
            count=lotto.size();

            resultStatistics[count]=resultStatistics[count]+1;
        }

        return 1;
    }
    /*
    //당첨 번호 중복되는지 확인할 필요있음
    3개 일치 (5,000원)
    4개 일치 (50,000원)
    5개 일치 (1,500,000원)
    5개 일치, 보너스 볼 일치 (30,000,000원)
    6개 일치 (2,000,000,000원)
     */
}
