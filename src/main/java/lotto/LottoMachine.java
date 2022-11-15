package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

//로또 번호 발행 기계
public class LottoMachine {
    public Lotto autoGenerate(){
        List<Integer> numbers=new ArrayList<>();
        while(numbers.size()<6){
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return new Lotto(numbers);
    }
    public Lotto manualGenerate(List<Integer> numbers){
        return new Lotto(numbers);
    }
}