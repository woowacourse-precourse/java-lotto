package lotto.function;

import lotto.*;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MakeLotto {

    List<Lotto> lottoList = new ArrayList<Lotto>();

    public List<Lotto> lottoCreate(int number) {
        for (int i=0;i<number;i++) {
            List<Integer> tempList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto tempLotto = new Lotto(tempList);
            this.lottoList.add(tempLotto);
        }
        return this.lottoList;
    }

    public void printLottoList(){
        for ( Lotto data : this.lottoList) {
            List<Integer> number = new ArrayList<>(data.getNumber());
            Collections.sort(number);
            System.out.println(number);
        }
    }
}
