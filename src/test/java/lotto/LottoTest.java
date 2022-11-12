package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Application.validateWinningNums(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> Application.validateWinningNums(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1 미만 45 초과인 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> Application.validateWinningNums(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 로또 번호인 경우 Lotto 객체를 생성한 후 numbers 필드에 저장한다.")
    @Test
    void createLotto() {
        Lotto test = Application.validateWinningNums(List.of(1, 2, 3, 4, 5, 6));
        assertThat(test.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("입력된 로또 구입 금액이 정수 형태이면 int 타입으로 변환하여 반환한다.")
    @Test
    public void stringToIntTest() {
        assertThat(Application.stringToInt("34")).isEqualTo(34);
    }

    @DisplayName("입력된 로또 구입 금액이 정수가 아니면 예외가 발생한다.")
    @Test
    public void priceFormatExceptionTest() {
        assertThatThrownBy(() -> Application.stringToInt("testString"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("적절하지 않은 로또 구입 금액이 입력될 경우 예외가 발생한다.")
    @Test
    public void validatePrice() {
        // 금액이 0보다 작은 경우
        assertThatThrownBy(() -> Application.validatePrice(-5))
                .isInstanceOf(IllegalArgumentException.class);
        // 1회 구매 수량 제한을 초과하는 금액인 경우
        assertThatThrownBy(() -> Application.validatePrice(20000000))
                .isInstanceOf(IllegalArgumentException.class);
        // 금액이 1000원 단위가 아닌 경우
        assertThatThrownBy(() -> Application.validatePrice(1234))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("주어진 금액으로 구매해야 할 로또 장수를 반환한다.")
    @Test
    public void getNumberOfIssuesTest() {
        assertThat(lotto.Application.getNumberOfIssues(34000)).isEqualTo(34);
    }

    @DisplayName("파라미터로 주어진 장수만큼의 Lotto 객체를 생성해 반환한다.+오름차순 정렬 확인, 출력 확인")
    @Test
    public void issueLottoTest() {
        List<Lotto> testLottos = Application.issueLotto(3);
        assertThat(testLottos.size()).isEqualTo(3);

        for (Lotto lotto : testLottos) {
            assertThat(lotto).isInstanceOf(Lotto.class);
        }
        Application.printLottoNumbers(3, testLottos);
    }

    @DisplayName("파라미터로 주어진 input에 쉼표가 포함되어 있을 경우 쉼표 기준으로 split한다. 내부에 포함되어 있는 공백은 삭제된다.")
    @Test
    public void splitInputTest() {
        assertThat(Application.splitInput(" 3, 14,11, 43,36")).isEqualTo(new String[] {"3", "14", "11", "43", "36"});
    }

    @DisplayName("파라미터로 주어진 input에 쉼표가 포함되어 있지 않으면 예외가 발생한다.")
    @Test
    public void notIncludingRegexTest() {
        assertThatThrownBy(() -> Application.splitInput("3 14 11 43 36"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 저장되어 있는 String 타입의 배열을 List<Integer>로 변환한다.")
    @Test
    public void stringArrToIntegerListTest() {
        String[] testArr = new String[] {"3", "24", "1", "29", "15", "40"};
        List<Integer> testList = Application.stringArrToIntegerList(testArr);

        for (int idx = 0; idx < testList.size() ; idx++) {
            assertThat(testList.get(idx)).isEqualTo(Integer.parseInt(testArr[idx]));
        }
    }

    @DisplayName("String 타입 배열 내에 정수가 아닌 데이터가 포함되어 있으면 예외가 발생한다.")
    @Test
    public void includingNotIntTest() {
        String[] testArr = new String[] {"3", "이십사", "1", "29", "15", "40"};
        assertThatThrownBy(() -> Application.stringArrToIntegerList(testArr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("각 로또 번호들에 대한 당첨 여부, 당첨된 등수를 저장한다.")
    @Test
    public void getAllResultsTest() {
        List<Lotto> testLottos = new ArrayList<>();
        Lotto test1 = new Lotto(List.of(1, 4, 14, 23, 24, 35)); // 1등
        testLottos.add(test1);
        Lotto test11 = new Lotto(List.of(1, 4, 14, 23, 24, 35)); // 1등
        testLottos.add(test11);
        Lotto test111 = new Lotto(List.of(1, 4, 14, 23, 24, 35)); // 1등
        testLottos.add(test111);

        Lotto test2 = new Lotto(List.of(1, 4, 19, 23, 24, 35)); // 2등
        testLottos.add(test2);

        Lotto test3 = new Lotto(List.of(1, 4, 15, 23, 24, 35)); // 3등
        testLottos.add(test3);
        Lotto test33 = new Lotto(List.of(1, 4, 15, 23, 24, 35)); // 3등
        testLottos.add(test33);

        Lotto test4 = new Lotto(List.of(2, 5, 14, 23, 24, 35)); // 4등
        testLottos.add(test4);
        Lotto test44 = new Lotto(List.of(2, 5, 14, 23, 24, 35)); // 4등
        testLottos.add(test44);
        Lotto test444 = new Lotto(List.of(2, 5, 14, 23, 24, 35)); // 4등
        testLottos.add(test444);
        Lotto test4444 = new Lotto(List.of(2, 5, 14, 23, 24, 35)); // 4등
        testLottos.add(test4444);
        Lotto test44444 = new Lotto(List.of(2, 5, 14, 23, 24, 35)); // 4등
        testLottos.add(test44444);

        Lotto test5 = new Lotto(List.of(2, 5, 15, 23, 24, 35)); // 5등
        testLottos.add(test5);

        Lotto testBlank = new Lotto(List.of(2, 5, 13, 25, 26, 35)); // 꽝

        List<Integer> winningNumbers = List.of(1, 4, 14, 23, 24, 35);
        int bonusNumber = 19;

        Map<Result, Integer> allResults = Application.getAllResults(testLottos, winningNumbers, bonusNumber);
        System.out.println(allResults.entrySet());

    }

}
