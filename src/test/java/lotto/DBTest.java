package lotto;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class DBTest {
    @Test
    void testDB(){
        Lotto WangJunYoung = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        DB.init();
        DB.insert(WangJunYoung);
        assertThat(DB.selectAt(0).getNumbers().get(3)).isEqualTo(4);
        DB.init();

    }
}
