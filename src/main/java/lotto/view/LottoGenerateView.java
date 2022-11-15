package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class LottoGenerateView {
    public void printGeneratedLottos(List<Lotto> lottos) {
        System.out.println(String.format(GuideMessage.LOTTO_GENERATE_SUCCESS, lottos.size()));

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

}
