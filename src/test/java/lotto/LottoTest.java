package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    private final Service service = new Service();

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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOverNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 60)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void moneyInputIsNotNumber() {
        assertThatThrownBy(() -> service.getLottoCount("122gfgg"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 입력값이 1000 단위가 아니면 예외가 발생한다.")
    @Test
    void moneyInputIsNotRightFormat() {
        assertThatThrownBy(() -> service.getLottoCount("1230"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액에 맞는 로또 개수를 반환한다.")
    @Test
    void getLottoCount() {
        assertThat(service.getLottoCount("5000")).isEqualTo(5);
        assertThat(service.getLottoCount("23000")).isEqualTo(23);
        assertThat(service.getLottoCount("2000")).isEqualTo(2);
    }

    @DisplayName("로또 개수에 맞는 로또 배열을 반환한다.")
    @Test
    void buyLotto() {
        assertThat(service.buyLotto(3).size()).isEqualTo(3);
        assertThat(service.buyLotto(5).size()).isEqualTo(5);
    }

    @DisplayName("로또 리스트, 당첨 리스트와 보너스 번호로 당첨 개수 연산하여 반환한다.")
    @Test
    void getMatches() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        lottos.add(new Lotto(Arrays.asList(5,6,2,8,9,10)));
        lottos.add(new Lotto(Arrays.asList(23,25,27,29,31,33)));

        assertThat(service.getMatches(lottos, new ArrayList<>(Arrays.asList(30,32,34,36,37,38)), 12))
                .isEqualTo(new ArrayList<>(Arrays.asList(0,0,0,0,0)));
        assertThat(service.getMatches(lottos, new ArrayList<>(Arrays.asList(1,2,3,4,5,6)), 10))
                .isEqualTo(new ArrayList<>(Arrays.asList(1,0,0,0,1)));
    }

    @DisplayName("당첨 내역을 활용하여 수익률을 연산하여 반환한다.")
    @Test
    void getRate() {
        assertThat(service.getRate(2, new ArrayList<>(Arrays.asList(1,0,0,0,1)))).isEqualTo(1.0000025E8);
        assertThat(service.getRate(5, new ArrayList<>(Arrays.asList(0,1,0,0,0)))).isEqualTo(1000.0);
    }

    @DisplayName("입력 값이 쉼표로 구분된 숫자 문자열이 6개의 숫자가 아니면 예외가 발생한다.")
    @Test
    void getWinNumbersByNotRightCount() {
        assertThatThrownBy(() -> service.getWinNumbers("5,6,8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값이 쉼표로 구분된 숫자 문자열이 아니면 예외가 발생한다.")
    @Test
    void getWinNumbersByNotRightRange() {
        assertThatThrownBy(() -> service.getWinNumbers("5,68,812,12,82,93"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값이 쉼표로 구분된 숫자 문자열로 당첨 번호 리스트를 반환한다.")
    @Test
    void getWinNumbers() {
        assertThat(service.getWinNumbers("1,2,3,4,5,6")).isEqualTo(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        assertThat(service.getWinNumbers("10,25,36,34,15,26")).isEqualTo(new ArrayList<>(Arrays.asList(10,25,36,34,15,26)));
    }
}
