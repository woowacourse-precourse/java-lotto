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
        List<LottoNumber> lottoNumbers = List.of(LottoNumber.lottoNumber(1), LottoNumber.lottoNumber(2), LottoNumber.lottoNumber(3)
                , LottoNumber.lottoNumber(4), LottoNumber.lottoNumber(5), LottoNumber.lottoNumber(6), LottoNumber.lottoNumber(7));

        assertThrows(LottoInputException.class, () -> new Lotto(lottoNumbers));
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        List<LottoNumber> lottoNumbers = List.of(LottoNumber.lottoNumber(1), LottoNumber.lottoNumber(2), LottoNumber.lottoNumber(3)
                , LottoNumber.lottoNumber(4), LottoNumber.lottoNumber(6), LottoNumber.lottoNumber(6));

        assertThrows(LottoInputException.class, () -> new Lotto(lottoNumbers));
    }

    @DisplayName("당첨 숫자를 받아 일치하는 개수를 센다.")
    @Test
    void matchCountLotto() {
        List<LottoNumber> lottoNumbers = List.of(LottoNumber.lottoNumber(1), LottoNumber.lottoNumber(2), LottoNumber.lottoNumber(3)
                ,LottoNumber.lottoNumber(23), LottoNumber.lottoNumber(24), LottoNumber.lottoNumber(25));
        Lotto winningLotto = new Lotto(lottoNumbers);
        List<LottoNumber> tempLottoNumber = new ConstantCreateStrategy().createTempLottoNumber();
        Lotto purchaseLotto = new Lotto(tempLottoNumber);

        assertThat(purchaseLotto.countMatchNumber(winningLotto)).isEqualTo(Rank.FIFTH.getMatchNumber());
    }
}
