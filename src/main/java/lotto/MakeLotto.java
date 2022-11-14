package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.ArrayList;

public class MakeLotto {
    public static ArrayList<Integer> makelotto(){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int value;
        //서로 다른 수 세자리 만들기
        while (true) {
            if (numbers.size() == 6) {
                break;
            }
            //요구사항에 맞게 수정
            value = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(value)) {
                numbers.add(value);
            }
        }

        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
        return numbers;
    }
    public static ArrayList<ArrayList<Integer>> totallotto(int cnt){
        ArrayList<ArrayList<Integer>> total = new ArrayList<>();
        for(int i=0;i<cnt;i++){
            total.add(makelotto());

        }
        return total;
    }
}
