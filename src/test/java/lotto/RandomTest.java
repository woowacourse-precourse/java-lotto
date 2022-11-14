package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RandomTest {
    @DisplayName("구입한 로또만큼 리스트가 돌아 오는지 확인")
    @Test
    void RandomLottoTest(){
        Random random = new Random();
        assertThat(3).isEqualTo(random.createAllLotto(3).size());
    }
}
