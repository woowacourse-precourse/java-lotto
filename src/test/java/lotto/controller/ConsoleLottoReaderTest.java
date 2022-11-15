package lotto.controller;

import lotto.controller.io.ConsoleLottoReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ConsoleLottoReaderTest {
    ConsoleLottoReader reader = new ConsoleLottoReader();

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
            assertThat(i).isEqualTo(15000);
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

        @DisplayName("입력 받은 값에 숫자가 아닌 문자가 있을 경우")
        @Test
        void except2() {
            //given
            String price = "15500a";

            //when
            InputStream in = new ByteArrayInputStream(price.getBytes());
            System.setIn(in);

            //then
            assertThatThrownBy(() -> reader.readAmount()).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("로또 번호를 입력받는다.")
    @Nested
    class ReadLotto {
        @DisplayName("기능 테스트")
        @Nested
        class feat {
            @DisplayName("쉼표를 기준으로 번호를 나누어 저장한다")
            @Test
            void split1() {
                //given
                String number = "1,23,3,4,5,6";

                //when
                Set<Integer> lottoNumber = reader.splitNumber(number);

                //then
                assertThat(lottoNumber.size()).isEqualTo(6);
                assertThat(lottoNumber.contains(1)).isTrue();
                assertThat(lottoNumber.contains(6)).isTrue();
            }

            @DisplayName("콘솔에서 6자리 로또 번호를 입력받으면 Set을 반환한다.")
            @Test
            void read() {
                //given
                String number = "11,23,4,45,8,6";

                //when
                InputStream in = new ByteArrayInputStream(number.getBytes());
                System.setIn(in);
                Set<Integer> lottoNumber = reader.readLottoNumber();

                //then
                assertThat(lottoNumber.size()).isEqualTo(6);
                assertThat(lottoNumber.contains(11)).isTrue();
                assertThat(lottoNumber.contains(45)).isTrue();
            }
        }

        @DisplayName("예외 처리 테스트")
        @Nested
        class except {
            @DisplayName("쉼표와 숫자가 아닌 문자가 넘겨질 경우")
            @Test
            void exceptSplit1() {
                //then
                assertThatThrownBy(() -> reader.splitNumber("12,21,34,4a,5,18")).isInstanceOf(IllegalArgumentException.class);
            }

            @DisplayName("입력받은 번호에 쉼표와 숫자를 제외한 다른 문자가 있을 경우")
            @Test
            void except1() {
                //given
                String number = "11,23,4,45b,8,6";

                //when
                InputStream in = new ByteArrayInputStream(number.getBytes());
                System.setIn(in);

                //then
                assertThatThrownBy(() -> reader.readLottoNumber()).isInstanceOf(IllegalArgumentException.class);
            }

            @DisplayName("입력받은 번호 숫자가 1~45 사이의 값이 아닐 경우 - 1")
            @Test
            void except2() {
                //given
                String number = "11,23,38,46,8,6";

                //when
                InputStream in = new ByteArrayInputStream(number.getBytes());
                System.setIn(in);

                //then
                assertThatThrownBy(() -> reader.readLottoNumber()).isInstanceOf(IllegalArgumentException.class);
            }

            @DisplayName("입력받은 번호 숫자가 1~45 사이의 값이 아닐 경우 - 2")
            @Test
            void except3() {
                //given
                String number = "0,23,38,46,8,6";

                //when
                InputStream in = new ByteArrayInputStream(number.getBytes());
                System.setIn(in);

                //then
                assertThatThrownBy(() -> reader.readLottoNumber()).isInstanceOf(IllegalArgumentException.class);
            }

            @DisplayName("입력받은 번호에 중복된 값이 있을 경우")
            @Test
            void except4() {
                //given
                String number = "11,23,23,46,1,6";

                //when
                InputStream in = new ByteArrayInputStream(number.getBytes());
                System.setIn(in);

                //then
                assertThatThrownBy(() -> reader.readLottoNumber()).isInstanceOf(IllegalArgumentException.class);
            }

            @DisplayName("입력받은 번호가 6개가 아닐 경우")
            @Test
            void except5() {
                //given
                String number = "11,23,38,46,6";

                //when
                InputStream in = new ByteArrayInputStream(number.getBytes());
                System.setIn(in);

                //then
                assertThatThrownBy(() -> reader.readLottoNumber()).isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @DisplayName("보너스 번호를 입력받는다.")
    @Nested
    class ReadBonus {
        @DisplayName("1~45 사이의 보너스 번호를 입력받을 경우 값을 반환한다.")
        @Test
        void read() {
            //given
            String number = "41";

            //when
            InputStream in = new ByteArrayInputStream(number.getBytes());
            System.setIn(in);
            int bonus = reader.readBonus();

            //then
            assertThat(bonus).isEqualTo(41);
        }

        @DisplayName("입력받은 보너스 번호가 숫자가 아닐 경우 예외가 발생한다.")
        @Test
        void except1() {
            //given
            String number = "4a";

            //when
            InputStream in = new ByteArrayInputStream(number.getBytes());
            System.setIn(in);

            //then
            assertThatThrownBy(() ->reader.readBonus()).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("입력받은 보너스 번호가 1~45 사이의 숫자가 아닐 경우 예외가 발생한다. - 1")
        @Test
        void except3() {
            //given
            String number = "46";

            //when
            InputStream in = new ByteArrayInputStream(number.getBytes());
            System.setIn(in);

            //then
            assertThatThrownBy(() ->reader.readBonus()).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("입력받은 보너스 번호가 1~45 사이의 숫자가 아닐 경우 예외가 발생한다. - 2")
        @Test
        void except4() {
            //given
            String number = "0";

            //when
            InputStream in = new ByteArrayInputStream(number.getBytes());
            System.setIn(in);

            //then
            assertThatThrownBy(() ->reader.readBonus()).isInstanceOf(IllegalArgumentException.class);
        }
    }
}