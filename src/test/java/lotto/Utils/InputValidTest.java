package lotto.Utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InputValidTest {

    @DisplayName("구입 금액이 1,000원 단위가 아니면 false 리턴")
    @Test
    void CreateUserPriceBy1000Unit(){
        assertThat(InputValid.checkPriceUnit("1400"))
                .isEqualTo(false);

        assertThat(InputValid.checkPriceUnit("400"))
                .isEqualTo(false);
    }

    @DisplayName("구입 금액이 숫자만 있는게 아니라면 false 리턴")
    @Test
    void CreateUserPriceByNumber(){
        assertThat(InputValid.checkPriceUnit("1000j"))
                .isEqualTo(false);

        assertThat(InputValid.checkPriceUnit("non"))
                .isEqualTo(false);
    }

    @DisplayName("구입 금액이 1,000원 단위로 정상적이라면 true 리턴")
    @Test
    void CreateUserPrice(){
        assertThat(InputValid.checkPriceUnit("4000"))
                .isEqualTo(true);
    }

    @DisplayName("로또 번호가 6자리가 아니면 false 리턴")
    @Test
    void CreateLottoNumberLength(){
        assertThat(InputValid.checkLottoNumber("1,2,3,4,5,6,7"))
                .isEqualTo(false);

        assertThat(InputValid.checkLottoNumber("1,2,3,4,5"))
                .isEqualTo(false);
    }

    @DisplayName("로또 번호가 1~45사이가 아니면 false 리턴")
    @Test
    void CreateLottoNumberRight(){
        assertThat(InputValid.checkLottoNumber("12,62,3,4,5,6"))
                .isEqualTo(false);

        assertThat(InputValid.checkLottoNumber("0,2,3,4,5,1"))
                .isEqualTo(false);

        assertThat(InputValid.checkLottoNumber("a,2,3,4,5,1"))
                .isEqualTo(false);
    }

    @DisplayName("로또 번호가 1~45사이가 아니면 false 리턴")
    @Test
    void CreateLottoNumberDistinct(){
        assertThat(InputValid.checkLottoNumber("12,12,3,4,5,6"))
                .isEqualTo(false);
    }

    @DisplayName("로또 번호가 1~45사이로 정상적이면 true 리턴")
    @Test
    void CreateLottoNumber(){
        assertThat(InputValid.checkLottoNumber("12,45,3,4,5,1"))
                .isEqualTo(true);
    }
}