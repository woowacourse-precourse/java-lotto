package lotto;

import lotto.domain.LottoNumCreator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumCreatorTest {

    @Test
    void 번호생성기가_만드는_숫자의_갯수는_6개이다(){
        // given
        LottoNumCreator creator = new LottoNumCreator();
        int expectedLength = 6;

        // when
        creator.createUniqueNumbers();

        // then
        assertThat(creator.getLottoNumbers().size()).isEqualTo(expectedLength);
    }
}
