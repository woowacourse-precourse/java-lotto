package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private Application application;
    private LottoMachine lottoMachine;


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

    @DisplayName("입력이 1000 단위로 받고 로또개수 출력")
    @Test
    void testLottoCount() {
        lottoMachine = new LottoMachine();
        assertThat(8).isEqualTo(lottoMachine.makeLottoCount(8000));
    }

    @DisplayName("입력이 1000 단위 아니면 true반환")
    @Test
    void inputNotThousandsNumber() {
        application = new Application();
        String testData = "500";
        InputStream in = new ByteArrayInputStream(testData.getBytes());
        System.setIn(in);
        application.inputMoney();
        assertThat(true).isEqualTo(application.getSystemError());
    }

    @DisplayName("구입 입력만큼 나오는지 확인")
    @Test
    void checkSix() {
        lottoMachine=new LottoMachine();
        lottoMachine.makeLottoCount(6000);
        lottoMachine.makeLottoReceipt();
        assertThat(6).isEqualTo(lottoMachine.getLottoReceipt().size());
    }

    @DisplayName("정답 제대로 입력 안했을 시 메인 시스템 에러 체크")
    @Test
    void checkBadAnswer() {
        String testData = "500sfmoieroivajsfioisa";
        InputStream in = new ByteArrayInputStream(testData.getBytes());
        System.setIn(in);
        application = new Application();
        application.answerLotto();
        assertThat(true).isEqualTo(application.getSystemError());
    }

    @DisplayName("보너스 제대로 입력 안했을 시 메인 시스템 에러 체크")
    @Test
    void checkBadBonus() {
        String testData = "0";
        InputStream in = new ByteArrayInputStream(testData.getBytes());
        System.setIn(in);
        application = new Application();
        application.bonusLotto();
        assertThat(true).isEqualTo(application.getSystemError());
    }


}
