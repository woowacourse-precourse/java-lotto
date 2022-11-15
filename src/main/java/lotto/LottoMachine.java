package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

//로또 번호 발행 기계
public class LottoMachine {
    public Lotto autoGenerate(){
        List<Integer> numbers=new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45,6));
        return new Lotto(numbers);
    }
    public Lotto manualGenerate(List<Integer> numbers){
        return new Lotto(numbers);
    }
}