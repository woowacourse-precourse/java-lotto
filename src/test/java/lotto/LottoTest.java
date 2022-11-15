package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @DisplayName("구입 금액이 로또 금액인 1000으로 나누어지지 않으면 예외 발생.")
    @Test
    void validateTheEnteredAmount(){
        final String INVALID_NUMBER = "1234";
        InputStream in = new ByteArrayInputStream(INVALID_NUMBER.getBytes());
        System.setIn(in);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Lotto.setInitialNumber();
            Lotto.setNumberOfPurchasedLotto();
        });
    }

    @DisplayName("플레이어가 입력한 6개의 숫자가 1~45범위밖이라면 IllegalArgumentException 발생.")
    @Test
    void validateTheRangeOfEnteredNumbers(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Assertions.assertThrows(IllegalArgumentException.class, () -> {
                        run("8000", "1,2,0,4,5,50", "10");
                    });
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }
    @DisplayName("보너스 숫자가 1~45범위밖이라면 IllegalArgumentException 발생.")
    @Test
    void validateBonusNumber(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Assertions.assertThrows(IllegalArgumentException.class, () -> {
                        run("8000", "1,2,3,4,5,6", "55");
                    });
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }
    @DisplayName("플레이어가 입력한 6개의 숫자가 1~45범위밖이라면 에러메시지 프린트.")
    @Test
    void printErrorMessageIfNotInRange(){
        assertSimpleTest(() -> {
            try{
                run("3000", "1,2,3,4,5,50", "10");
            } catch(IllegalArgumentException e){
                assertThat(output().contains(ERROR_MESSAGE));
            }
        });
    }

    @DisplayName("보너스 숫자가 1~45범위밖이라면 에러메시지 프린트.")
    @Test
    void bonusNumberNotInRange(){
        assertSimpleTest(() -> {
            try{
                run("3000", "1,2,3,4,5,6", "52");
            } catch(IllegalArgumentException e){
                assertThat(output().contains(ERROR_MESSAGE));
            }
        });
    }

    @Override
    protected void runMain() {Lotto.main(new String[]{});}
}
