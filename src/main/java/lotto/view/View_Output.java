package lotto.view;

import lotto.Lotto;

import java.util.List;

public class View_Output {
    public void showPieces(int amount) {
        System.out.print(amount + "개를 구매했습니다\n");
    }

    public void showLottos(List<Lotto> lottos) {
        for(int i = 0; i < lottos.size(); ++i) {
            System.out.println(lottos.get(i).getNumbers());
        }
    }
}
