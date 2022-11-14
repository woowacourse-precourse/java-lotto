package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ClientTest {

    @DisplayName("로또 구입시 문자열 5000을 입력받으면 숫자 5000이 반환된다")
    @Test
    void buyLottoString5000ThenReturnInt5000() {
        Assertions.assertThat(new Client(()->"5000").buy()).isEqualTo(5000);
    }

    @DisplayName("로또 구입시 숫자 입력이 아니라면 IllegalArgumentException을 발생시킨다")
    @Test
    void buyLotto오천원ThenIllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> new Client(()->"오천원").buy())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입시 1000원 단위가 아니라면 IllegalArgumentException을 발생시킨다")
    @Test
    void buyLottoString5123ThenIllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> new Client(()->"5123").buy())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1,2,3,4,5,6을 마킹한다면 List형 {1, 2, 3, 4, 5, 6}을 반환한다")
    @Test
    void mark123456SplitWithCommaThenReturnIntegerList() {
        Assertions.assertThat(new Client(()->"1,2,3,4,5,6").mark()).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @DisplayName("123456을 마킹하면 IllegalArgumentException을 발생시킨다")
    @Test
    void mark123456ThenIllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> new Client(()->"123456").mark())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("일이삼사오육을 마킹하면 IllegalArgumentException을 발생시킨다")
    @Test
    void markOneTwoThreeFourFiveSixSplitWithCommaThenIllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> new Client(()->"일이삼사오육").mark())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자를 7 입력받는다")
    @Test
    void markBonusSeven() {
        Assertions.assertThat(new Client(() -> "7").bonusMark())
                .isEqualTo(7);
    }

    @DisplayName("보너스 숫자 칠을 입력받으면 IllegalArgumentException을 발생시킨다")
    @Test
    void markBonusSevenAsStringThenIllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> new Client(()->"칠").bonusMark())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자 46을 입력받으면 IllegalArgumentException을 발생시킨다")
    @Test
    void markBonusFortySixAsStringThenIllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> new Client(()->"46").bonusMark())
                .isInstanceOf(IllegalArgumentException.class);
    }


}
