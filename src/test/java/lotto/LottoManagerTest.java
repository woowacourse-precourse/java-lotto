package lotto;

import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

class LottoManagerTest {

    LottoManager lottoManager;

    public InputStream getPlayerInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @BeforeEach
    void beforeEach() {
        lottoManager = new LottoManager();
    }

    @ParameterizedTest
    @DisplayName("올바른 값 입력받고 출력하기")
    @ValueSource(strings = {"3000"})
    void printUserLotto(String input) {
        InputStream in = getPlayerInput(input);
        System.setIn(in);

        lottoManager.userWantLotto();
        Assertions.assertThat(lottoManager.userLottoNum.getUserLottoNumbers().size())
                .isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("당첨 로또 입력받고 확인하기")
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void checkWinningLotto(String input) {
        InputStream in = getPlayerInput(input);
        System.setIn(in);

        lottoManager.setWinningLottoNum();

        Assertions.assertThat(lottoManager.targetLottoNum.getLotto())
                .isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)).getLotto());
    }
}