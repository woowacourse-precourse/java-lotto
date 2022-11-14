package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CountingLottoTest {

    @Test
    void hasCheckNumber() {

        CountingLotto countingLotto = new CountingLotto();
        //GIVEN WHEN
        List<Integer> count = countingLotto.hasCheckNumber(
                List.of(List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 7),
                        List.of(1, 2, 3, 4, 10, 7),
                        List.of(11,12,13,14,15,16)
                ),List.of(1, 2, 3, 4, 5, 6),7);
        //THEN
        assertEquals(count.get(0),6); //모두 정답
        assertEquals(count.get(1),7); //5개와 보너스일경우
        assertEquals(count.get(2),4); //보너스를 맞췄지만 4개일경우
        assertEquals(count.get(3),0); //모두틀렸을경우
    }
}