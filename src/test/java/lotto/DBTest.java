package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class DBTest {
    @DisplayName("DB에 정상적으로 Lotto가 저장되고 조회되는지 확인")
    @Test
    void testDB(){
        //저 뽑으면 우테코가 로또 당첨이라 로또 이름은 제 이름으로 넣었습니다.
        Lotto WangJunYoung = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        DB.insert(WangJunYoung);
        assertThat(DB.selectAt(0).getNumbers().get(3)).isEqualTo(4);
    }
}
