package lotto;

import java.util.List;

public class LottoView {
    public void printLottoList(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto i : lottos) {
            i.printLotto();
        }
    }
}
