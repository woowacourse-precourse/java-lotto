package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    Player player = new Player();

    @Test
    public void 입력검증_숫자가_아닌_값을_입력한_경우() {
        String input = "abc";

        assertThatThrownBy(() -> player.payValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다");
    }

    @Test
    public void 입력검증_1000원_단위_입력이_아닌_경우() {
        String input = "1234";

        assertThatThrownBy(() -> player.payValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000원 단위만 입력 가능합니다");
    }

    @DisplayName("숫자 입력 문자열이 List로 잘 변환 되는지 확인")
    @Test
    public void stringToListTest() {
        //given
        String input = "1,2,3,4,5,6";
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        //when
        List<Integer> integers = player.stringToList(input);

        //then
        assertThat(integers).isEqualTo(numbers);
    }

    @DisplayName("숫자가 아닌 값을 입력한 경우")
    @Test
    public void stringToListErrorTest() {
        String input = "a,b,c,d,e,f";

        assertThatThrownBy(() -> player.stringToList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다");
    }

    @DisplayName("6개의 숫자가 아닌 경우")
    @Test
    public void stringToListError2Test() {
        String input = "1,2,3,4";

        assertThatThrownBy(() -> player.stringToList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개의 숫자를 입력해야합니다");
    }

    @DisplayName("1~45 사이에 숫자가 아닌 경우")
    @Test
    public void stringToListError3Test() {
        String input = "11,24,31,45,78,41";

        assertThatThrownBy(() -> player.stringToList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 사이에 숫자만 입력 가능합니다");
    }

    @DisplayName("1~45 사이 숫자에 중복이 있는 경우")
    @Test
    public void stringToListError4Test() {
        String input = "11,24,12,45,45,2";

        assertThatThrownBy(() -> player.stringToList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
    }

    @DisplayName("보너스 숫자가 아닌 값을 입력한 경우")
    @Test
    public void bonusErrorTest() {
        String input = "abc";

        assertThatThrownBy(() -> player.bonusValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다");
    }

    @DisplayName("보너스 숫자가 1~45 사이에 숫자가 아닌 경우")
    @Test
    public void bonusError2Test() {
        String input = "63";

        assertThatThrownBy(() -> player.bonusValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 사이에 숫자만 입력 가능합니다");
    }
}
