package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoMakerTest {

    LottoMaker lottoMaker = new LottoMaker();

    @DisplayName("랜덤 로또 리스트가 잘 생성되는지 확인")
    @Test
    void 여러개의_랜덤_로또_출력_확인() {
        List<Lotto> lottos = lottoMaker.getRandomLottos(5);
        assertThat(lottos)
                .hasSize(5)
                .allMatch((lotto) -> lotto instanceof Lotto);
    }

    @DisplayName("수동으로 로또를 만들 수 있는지 테스트")
    @RepeatedTest(5)
    void 수동_로또_생성_테스트() {

        assertThat(lottoMaker.getManualLotto(Randoms.pickUniqueNumbersInRange(1,45,6)))
                .isInstanceOf(Lotto.class);
    }

    @DisplayName("수동으로 로또를 생성시 길이 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,7,8,9})
    void 수동_로또_생성_길이_예외_테스트(int intArg) {

        assertThatThrownBy(()->lottoMaker.getManualLotto(Randoms.pickUniqueNumbersInRange(1,45,intArg)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또는 6자리의 숫자로 입력되야 합니다.");
    }

    @DisplayName("수동으로 로또를 생성시 범위 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1,0,56,100,47})
    void 수동_로또_생성_범위_예외_테스트(int intArg) {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,5);
        lottoNumbers.add(intArg);

        assertThatThrownBy(()->lottoMaker.getManualLotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR]: 로또 숫자는 1에서 45사이의 값이여야 합니다.");
    }

    @DisplayName("수동으로 로또를 생성시 중복 예외 발생 테스트")
    @Test
    void 수동_로또_생성_중복_예외_테스트() {

        assertThatThrownBy(()->lottoMaker.getManualLotto(List.of(1,2,3,4,5,5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또는 중복되지 않은 숫자로 이루어져야 합니다.");
    }
}
