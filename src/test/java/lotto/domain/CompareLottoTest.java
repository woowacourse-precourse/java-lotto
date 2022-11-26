package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CompareLottoTest {

    private Lotto purchaseLotto;
    private Lotto lottoNumbers;
    private int bonus;

    @BeforeEach
    void setup() {
        bonus = 8;
        purchaseLotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        lottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("구매한 로또 번호와 당첨 로또 번호의 일치 개수를 반환한다.")
    @Test
    void getMatchingLottoNumberCount() {
        assertThat(purchaseLotto.getMatchingLottoNumberCount(lottoNumbers)).isEqualTo(4);
    }

    @DisplayName("구매한 로또 번호와 보너스 번호의 일치 여부를 확인한다.")
    @Test
    void checkMatchingBonusNumber() {
        assertThat(purchaseLotto.checkMatchingBonusNumber(bonus)).isEqualTo(true);
    }
}