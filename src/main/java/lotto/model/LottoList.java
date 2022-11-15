package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private List<Lotto> lottoList = new ArrayList<>();

    public LottoList(int publicians) {
        System.out.println("\n" + publicians + "개를 구매했습니다.");
        for (int i = 0; i < publicians; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }
    }
    public void printLottoList(){
        for(int i=0;i<lottoList.size();i++){
            lottoList.get(i).printLotto();
            System.out.println('\n');
        }
    }


}
