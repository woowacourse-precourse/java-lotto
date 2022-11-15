package lotto.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ConsoleLottoReaderTest {
    LottoReader reader = new ConsoleLottoReader();

    @DisplayName("로또 구입 금액을 입력 받는다")
    @Nested
    class ReadAmount {
        @DisplayName("1000원 단위의 값을 입력받으면 값을 반환한다")
        @Test
        void success1() {
            //given
            String price = "15000";

            //when
            InputStream in = new ByteArrayInputStream(price.getBytes());
            System.setIn(in);
            int i = reader.readAmount();

            //then
            Assertions.assertThat(i).isEqualTo(15000);
        }

        @DisplayName("입력 받은 값이 1000원 단위가 아닐 경우 예외가 발생한다")
        @Test
        void except1() {
            //given
            String price = "15500";

            //when
            InputStream in = new ByteArrayInputStream(price.getBytes());
            System.setIn(in);

            //then
            assertThatThrownBy(() -> reader.readAmount()).isInstanceOf(IllegalArgumentException.class);
        }
    }

}