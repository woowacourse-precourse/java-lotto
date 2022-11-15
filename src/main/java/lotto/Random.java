package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Random {
    public List<List<Integer>> createAllLotto(int buylotto){
        List<List<Integer>> lottonumbers = new ArrayList<>();
        List<Integer> onelotto = new ArrayList<>();

        for(int i=0;i<buylotto;i++){
            onelotto = Randoms.pickUniqueNumbersInRange(1,45, 6);
            Collections.sort(onelotto);
            lottonumbers.add(onelotto);
        }
        return lottonumbers;
    }
}
