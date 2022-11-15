package lotto;

import model.Server;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.Client;
import view.PrintResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    Server server;
    Client client;
    @BeforeEach
    void setClass(){
        server = new Server();
        client = new Client();
    }

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
    @DisplayName("로또 구입 금액에 따른 로또 장수 테스트")
    @Test
    void decideToBuyLottoTest() {
        assertThat(server.decideToBuyLotto(8000)).isEqualTo(8);
    }

    @DisplayName("로또 당첨 번호와 사용자 로또 번호를 비교 후, 일치 개수 테스트")
    @Test
    void compareLottoNumberAfterCommonNumber() {
        List<Integer> winLottoNumber = List.of(1, 5, 15, 27, 35, 44);
        List<Integer> lottoNumber = List.of(1, 6, 14, 27, 39, 42);
        Set matchNumber = server.compareLottoNumber(winLottoNumber, lottoNumber);
        assertThat(server.countMatchNumber(matchNumber)).isEqualTo(2);
    }
}
