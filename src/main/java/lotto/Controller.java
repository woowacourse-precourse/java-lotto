package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Controller {
    public int getCount(int money) {
        int count = 0;
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 1,000원 단위가 아닙니다.");
            throw new IllegalArgumentException();
        }
        count = money / 1000;
        return count;
    }

    public ArrayList<Lotto> issueLotto(int count) {
        ArrayList<Lotto> issuedList = new ArrayList<Lotto>();
        for (int i = 0; i< count; i++){
            List<Integer> numbers = new ArrayList<>( Randoms.pickUniqueNumbersInRange(1, 45, 6) );
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            issuedList.add(lotto);
        }
        return issuedList;
    }
}
