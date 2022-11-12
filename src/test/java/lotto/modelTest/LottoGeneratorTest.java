package lotto.modelTest;

import lotto.model.Buyer;
import lotto.model.LottoGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    public void 임의의_6개_로또_번호_생성_확인(){
        int numberOfLottoNumbers=6;
        List<Integer> lotto = new ArrayList<>();
        LottoGenerator lottoGenerator = new LottoGenerator();
        lotto=lottoGenerator.createLotto();
        assertThat(lotto.size()).isEqualTo(numberOfLottoNumbers);
    }
}
