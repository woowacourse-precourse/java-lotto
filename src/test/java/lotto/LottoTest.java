package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Lotto.createLottoNumber;
import static lotto.constant.Constants.*;
import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외메시지와 함께 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumberThenThrowException() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_NUMBER_ERROR_MESSAGE);
    }

    @DisplayName("중복된 숫자가 있을 시에 오류 반환 - validatedForDuplicatedNumber 메서드 테스트")
    @Test
    void testForValidateForDuplicatedNumber() {
        List<Integer> lotto = List.of(1, 20, 32, 14, 25, 25);
        assertThatIllegalArgumentException().isThrownBy(() -> validateForDuplicatedNumber(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 랜덤 생성 100개 테스트 - 로또 생성 오류 없는 경우")
    @Test
    void testForCreateLottoNumber1() {
        Throwable t = catchThrowable(() -> {
            for (int i = 0; i < 100; i++) {
                Lotto lotto = new Lotto(createLottoNumber());
                System.out.println(lotto.toString());
            }
        });
        assertThat(t).doesNotThrowAnyException();
    }

    @DisplayName("로또 번호 랜덤 생성 100개 테스트 - 로또 생성 오류 있는 경우")
    @Test
    void testForCreateLottoNumber2() {
        Throwable t = catchThrowable(() -> {
            for (int i = 0; i < 100; i++) {
                Lotto lotto = new Lotto(createLottoNumber());
                if (i == 99) {
                    lotto = new Lotto(List.of(1, 2, 3, 4, 5, 5));
                }
            }
        });
        assertThat(t)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_NUMBER_ERROR_MESSAGE);
    }

    private void validateForDuplicatedNumber(List<Integer> lotto) {
        Set<Integer> lottoSet = new HashSet<>(lotto);
        if (lottoSet.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }

}
