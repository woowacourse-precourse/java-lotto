package lotto;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    // 아래에 추가 테스트 작성 가능
    CreateLotto createLotto = new CreateLotto();

    @Test
    void CreateLottoTestByOverSize() {
        assertThat(createLotto.numbers.size()).isEqualTo(6);
    }

    @DisplayName("1000원으로 나누어지지 않으면 에러가 발생한다.")
    @Test
    void ValidateUserPayDivide1000() {
        assertThatThrownBy(() -> new User(9800))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 당첨번호를 넣었을 때 숫자 리스트로 리턴된다.")
    @Test
    void InputWinningNumberTest() {
        /*given*/
        List<Integer> winningNumberTest = List.of(1, 2, 3, 4, 5, 6);
        /*when*/
        List<Integer> winningNumber = createLotto.winningNumber("1,2,3,4,5,6");
        /*then*/
        assertThat(winningNumberTest).isEqualTo(winningNumber);
    }

    @DisplayName("금액을 입력하면 티켓 갯수를 출력한다.")
    @Test
    void countTicket() {
        User user = new User(8000);
        /*given*/
        int countTicketTest = 8;
        /*when*/
        int countTicket = user.countTicket();
        /*then*/
        assertThat(countTicketTest).isEqualTo(countTicket);
    }

    @DisplayName("티켓 갯수와 문자열을 출력한다.")
    @Test
    void textTicketcountTest() {
        /*given*/
//        String textTicketTest = "8개를 구매했습니다.";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        User user = new User(8000);
        /*when*/
        user.textTicketcount();

        /*then*/
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo("8개를 구매했습니다.");
    }

    PlayLotto playLotto = new PlayLotto();

    @DisplayName("티켓 갯수만큼 로또번호 생성한다.")
    @Test
    void playLottoTicketCountTest() {
        /*given*/
        Integer playLottoTicketCountSizeTest = 8;
        /*when*/
        Integer playLottoTicketCountSize = playLotto.allTicket(8).size();
        /*then*/
        assertThat(playLottoTicketCountSizeTest).isEqualTo(playLottoTicketCountSize);
    }

    @DisplayName("티켓은 오름차순 정렬하여 보여준다.")
    @Test
    void playLottoTicketASCTest() {
        List<List<Integer>> ASCTest = playLotto.allTicket(6);
        for (List<Integer> ASCTestMinimum : ASCTest) {
            for (int i = 0; i < 5; i++) {
                assertThat(ASCTestMinimum.get(i)).isLessThan(ASCTestMinimum.get(i + 1));
            }
        }
    }

    @DisplayName("티켓과 당첨번호가 일치하는 번호의 개수를 찾는다.")
    @Test
    void compareTicketAndWinningNumberTest() {
        /*given*/
        int compareTicketAndWinningTest = 6;
        /*when*/
        int compareTicketAndWinning = playLotto.compareTicketAndWinningNumber(List.of(1, 2, 3, 4, 5, 6), "1,2,3,4,5,6");
        /*then*/
        assertThat(compareTicketAndWinningTest).isEqualTo(compareTicketAndWinning);
    }

    @DisplayName("티켓에 보너스넘버와 일치하는 값이 있는지 찾는다.")
    @Test
    void compareTicketAndBonusNumberTest() {
        /*given*/
        boolean compareTicketAndBonusTest = true;
        /*when*/
        boolean compareTicketAndBonus = playLotto.compareTicketAndBonusNumber(List.of(1, 2, 3, 4, 5, 6), "1");
        /*then*/
        assertThat(compareTicketAndBonusTest).isEqualTo(compareTicketAndBonus);
    }

    @DisplayName("티켓이 몇개 일치하는지 찾는다.")
    @ParameterizedTest
    @CsvSource({"3,true,0", "4,false,1", "5,false,2", "5,true,3", "6,false,4", "0,true,9"})
    void compareReward(int number1, boolean bonusCheck, int expected) {
        /*when*/
        int actual = playLotto.compareReward(number1, bonusCheck);
        /*then*/
        assertThat(expected).isEqualTo(actual);
    }

    @DisplayName("등수 별 티켓이 몇장인지 찾는다.")
    @Test
    void allTicketCheckCorrectNumberTest() {
        /*given*/
        List<Integer> seprateTicketTest = new ArrayList<>(List.of(2, 1, 1, 1, 1));

        /*when*/
        List<List<Integer>> randomLottoTest = new ArrayList<>(List.of(List.of(8, 21, 23, 41, 42, 43), /*1등*/
                List.of(3, 8, 21, 23, 41, 42), /*3등*/
                List.of(1, 8, 21, 23, 41, 42), /*2등*/
                List.of(2, 20, 23, 41, 42, 43), /*4등*/
                List.of(2, 20, 25, 41, 42, 43), /*5등*/
                List.of(8, 21, 23, 41, 42, 43), /*1등*/
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)));
        List<Integer> seprateTicket = playLotto.allTicketCheckCorrectNumber(randomLottoTest, "8,21,23,41,42,43", "1");

        /*then*/
        assertThat(seprateTicketTest).isEqualTo(seprateTicket);
    }

    @DisplayName("수익률을 출력한다.")
    @Test
    void yieldTest() {
        /*given*/
        double yieldExtend = 62.5;
        /*when*/
        double yieldActual = playLotto.yield(8000,List.of(0,0,0,0,1));
        /*then*/
        assertThat(yieldExtend).isEqualTo(yieldActual);
    }
}
