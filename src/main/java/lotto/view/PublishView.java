package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class PublishView {
    public static void printPublishInformation(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> {
            System.out.println(lotto.toString());
        });
    }
}
