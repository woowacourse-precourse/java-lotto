package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    @DisplayName("생성된 로또 번호 갯수는 6개")
    @Test
    void checkLottoNumberCountTest() {
        List<Integer> lottoNumbers = LottoGenerator.makeLottoNumber();
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(Lotto.WIN_NUMBER_SIZE);
    }

    @DisplayName("생성된 로또 번호에는 겹치는 숫자 없음")
    @Test
    void checkDuplicateLottoNumberTest() {
        List<Integer> lottoNumbers = LottoGenerator.makeLottoNumber();
        Set<Integer> distinctLottoNumbers = new HashSet<>(lottoNumbers);
        Assertions.assertThat(distinctLottoNumbers.size()).isEqualTo(lottoNumbers.size());
    }

}