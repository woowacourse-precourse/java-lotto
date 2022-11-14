package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;


public class outputView {
    private enum Message {
        NUMBER_OF_LOTTO("개를 구매했습니다.");
        private final String value;

        Message(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public static void printLottoGroup(LottoGroup lottos) {
        lottos.getLottoGroup().stream()
                .forEach(lotto -> System.out.println(lotto.getLotto().toString()));
        System.out.println();
    }
}
