package lotto.domain;

import lotto.exception.LottoInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6), new LottoNumber(7));

        assertThrows(LottoInputException.class, () -> new Lotto(lottoNumbers));
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(6), new LottoNumber(6));

        assertThrows(LottoInputException.class, () -> new Lotto(lottoNumbers));
    }

    @DisplayName("당첨 숫자를 받아 일치하는 개수를 센다.")
    @Test
    void matchCountLotto() {
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(23), new LottoNumber(24), new LottoNumber(25));
        Lotto winningLotto = new Lotto(lottoNumbers);
        List<LottoNumber> tempLottoNumber = new ConstantCreateStrategy().createTempLottoNumber();
        Lotto purchaseLotto = new Lotto(tempLottoNumber);

        assertThat(purchaseLotto.countMatchNumber(winningLotto)).isEqualTo(Rank.FIFTH.getMatchNumber());
    }
}
