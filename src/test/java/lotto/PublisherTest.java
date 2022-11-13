package lotto;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Publisher;
import lotto.ui.UI;

public class PublisherTest {
    @DisplayName("금액 만큼의 로또를 발행 합니다.")
    @Test
    void publishLottos() {
        UI ui = new UI();
        String input = "1000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Publisher pb = new Publisher(ui.inputPurchasePrice());
        ui.outputPurchaseLotto(pb.getLottos());
    }
}