package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class MakeLotto {
    public static List<Integer> makelotto(){
        List<Integer> numbers = new ArrayList<>();
        //서로 다른 수 세자리 만들기
        while (numbers.size() < 6) {
            //요구사항에 맞게 수정
            int value = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(value)) {
                numbers.add(value);
            }
        }

        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
        return numbers;
    }
    public static List<List<Integer>> totallotto(int cnt){
        System.out.println(cnt);
        List<List<Integer>> total = new ArrayList<>();
        for(int i=0;i<cnt;i++){
            List<Integer> numbers = new ArrayList<>();
            //서로 다른 수 세자리 만들기
            while (numbers.size() < 6) {
                //요구사항에 맞게 수정
                int value = Randoms.pickNumberInRange(1, 45);
                if (!numbers.contains(value)) {
                    numbers.add(value);
                }
            }

            numbers.sort(Comparator.naturalOrder());
            System.out.println(numbers);
            total.add(numbers);

        }
        return total;
    }
}
