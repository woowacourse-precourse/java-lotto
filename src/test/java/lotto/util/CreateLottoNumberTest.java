package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateLottoNumberTest {
    @DisplayName("랜덤한 로또 번호가 정렬되게 잘 나오는지 테스트")
    @Test
    void sortLottoNumberTest() {
        //given
        CreateLottoNumber createLottoNumber = new CreateLottoNumber();

        //when
        List<Integer> actualNumbers = createLottoNumber.createLottoNumber();

        //then
        assertThat(actualNumbers).isSorted();
    }
}
