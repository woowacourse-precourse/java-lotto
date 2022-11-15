package lottoMachine;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BanknoteSlotTest {

    private static BanknoteSlot banknoteSlot;

    @BeforeEach
    void beforeEach() {
        banknoteSlot = new BanknoteSlot();
    }

    @Test
    void 입력받은_금액은_숫자가_아니면_에러입니다() {
        String testInput = "1000a";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> banknoteSlot.receiveMoney()).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 입력받은_금액은_1000_이상이어야_합니다() {
        String testInput = "500";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> banknoteSlot.receiveMoney()).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 입력받은_금액은_2147483000_이하이어야_합니다() {
        String testInput = "2147484000";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> banknoteSlot.receiveMoney()).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 입력받은_금액은_1000단위_이어야_합니다() {
        String testInput = "34500";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> banknoteSlot.receiveMoney()).isInstanceOf(
                IllegalArgumentException.class);
    }
}
