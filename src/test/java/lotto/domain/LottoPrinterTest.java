package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPrinterTest {
    @Test
    @DisplayName("로또 5장 정상 발급")
    void printAmount5() {
        LottoPrinter printer = new LottoPrinter();
        List<Lotto> lottos = printer.printLottos(5);
        assertThat(lottos.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 0장 정상 발급")
    void printAmount0() {
        LottoPrinter printer = new LottoPrinter();
        List<Lotto> lottos = printer.printLottos(0);
        assertThat(lottos.size()).isEqualTo(0);
    }
}