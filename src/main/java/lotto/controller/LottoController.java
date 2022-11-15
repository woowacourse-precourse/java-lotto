package lotto.controller;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoList;

public class LottoController {
    private List<Lotto> lottoList = new ArrayList<>();

    public LottoController(int publicians) {
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
        }
    }
}
