package lotto.view;

import lotto.domain.PurchasedLottos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.OutputView;

public class OutputViewTest {

    @Test
    void 자동_생성_로또_번호_출력_테스트() {
        OutputView outputView = new OutputView();
        PurchasedLottos lottos = new PurchasedLottos(3);


        outputView.printPurchasedLottos(3, lottos);
    }
}
