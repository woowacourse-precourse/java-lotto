package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }


    @DisplayName("사용자가 입력 요구사항을 벗어난 값을 입력하는 경우 예외가 발생한다.")
    @Test
    public void checkInputConditionTest() {
        //given
        String input = "1000j";
        //when

        //then
        assertThatThrownBy(() -> Application.checkUserInputCondition(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 금액이 1000단위가 아니면 예외가 발생한다.")
    @Test
    public void convertBuyingPriceIntoLotteriesTest() {
        //given
        int buyingPrice = 14000;
        int expectedValue = 14;

        //when
        int actualValue = Application.convertBuyingPriceIntoTicketAmount(buyingPrice);

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("사용자가 입력한 금액이 1000단위가 아니면 예외가 발생한다.")
    @Test
    public void convertBuyingPriceIntoLotteriesTest_ExceptionCase() {
        //given
        int buyingPrice = 1410;
        //when

        //then
        assertThatThrownBy(() -> Application.convertBuyingPriceIntoTicketAmount(buyingPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }




    /***
     * Application.countCorrespondingNumbers(param1, param2, param3) 테스트
     * param1: 당첨번호 Lotto 객체
     * param2: 사용자 Lotto 객체
     * param3: 보너스 번호(Integer)
     * returns: LottoRank: 입력 인자에 해당하는 순위 반환
     */
    @DisplayName("로또 당첨 번호와 사용자의 로또 번호의 일치 여부에 따른 1위 순위 반환 확인")
    @Test
    public void countCorrespondingNumbersTest_FirstPlace() {
        //given
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> checkTargetNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto winnerLotto = new Lotto(winnerNumber);
        Lotto userLotto = new Lotto(checkTargetNumber);

        //when
        LottoRank expectedValue = LottoRank.FIRST_PLACE;
        LottoRank actualValue = Application.countCorrespondingNumbers(winnerLotto, userLotto, bonusNumber);

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("로또 당첨 번호와 사용자의 로또 번호의 일치 여부에 따른 2위 순위 반환 확인")
    @Test
    public void countCorrespondingNumbersTest_SecondPlace() {
        //given
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> checkTargetNumber = Arrays.asList(1, 2, 3, 4, 5, 7);
        int bonusNumber = 7;
        Lotto winnerLotto = new Lotto(winnerNumber);
        Lotto userLotto = new Lotto(checkTargetNumber);

        //when
        LottoRank expectedValue = LottoRank.SECOND_PLACE;
        LottoRank actualValue = Application.countCorrespondingNumbers(winnerLotto, userLotto, bonusNumber);

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("로또 당첨 번호와 사용자의 로또 번호의 일치 여부에 따른 3위 순위 반환 확인")
    @Test
    public void countCorrespondingNumbersTest_ThirdPlace() {
        //given
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> checkTargetNumber = Arrays.asList(1, 2, 3, 4, 5, 7);
        int bonusNumber = 8;
        Lotto winnerLotto = new Lotto(winnerNumber);
        Lotto userLotto = new Lotto(checkTargetNumber);

        //when
        LottoRank expectedValue = LottoRank.THIRD_PLACE;
        LottoRank actualValue = Application.countCorrespondingNumbers(winnerLotto, userLotto, bonusNumber);

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("보너스 번호 일치로 인한 수 4개 일치는 NOT_IN_LIST를 반환한다.")
    @Test
    public void countCorrespondingNumbersTest_ThirdPlace_BonusNumberException() {
        //given
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> checkTargetNumber = Arrays.asList(1, 2, 3, 4, 7, 8);
        int bonusNumber = 8;
        Lotto winnerLotto = new Lotto(winnerNumber);
        Lotto userLotto = new Lotto(checkTargetNumber);

        //when
        LottoRank expectedValue = LottoRank.NOT_IN_PLACE;
        LottoRank actualValue = Application.countCorrespondingNumbers(winnerLotto, userLotto, bonusNumber);


        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("로또 당첨 번호와 사용자의 로또 번호의 일치 여부에 따른 4위 순위 반환 확인")
    @Test
    public void countCorrespondingNumbersTest_FourthPlace() {
        //given
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> checkTargetNumber = Arrays.asList(1, 2, 3, 4, 7, 8);
        int bonusNumber = 9;
        Lotto winnerLotto = new Lotto(winnerNumber);
        Lotto userLotto = new Lotto(checkTargetNumber);

        //when
        LottoRank expectedValue = LottoRank.FOURTH_PLACE;
        LottoRank actualValue = Application.countCorrespondingNumbers(winnerLotto, userLotto, bonusNumber);

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("보너스 번호 일치로 인한 4위 인정은 예외가 발생한다.")
    @Test
    public void countCorrespondingNumbersTest_FourthPlace_BonusNumberException() throws Exception {
        //given
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> checkTargetNumber = Arrays.asList(1, 2, 3, 7, 8, 9);
        int bonusNumber = 9;
        Lotto winnerLotto = new Lotto(winnerNumber);
        Lotto userLotto = new Lotto(checkTargetNumber);

        //when
        LottoRank expectedValue = LottoRank.NOT_IN_PLACE;
        LottoRank actualValue = Application.countCorrespondingNumbers(winnerLotto, userLotto, bonusNumber);

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("로또 당첨 번호와 사용자의 로또 번호의 일치 여부에 따른 5위 순위 반환 확인")
    @Test
    public void countCorrespondingNumbersTest_FifthPlace() throws Exception {
        //given
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> checkTargetNumber = Arrays.asList(1, 2, 3, 7, 8, 9);
        int bonusNumber = 10;
        Lotto winnerLotto = new Lotto(winnerNumber);
        Lotto userLotto = new Lotto(checkTargetNumber);

        //when
        LottoRank expectedValue = LottoRank.FIFTH_PLACE;
        LottoRank actualValue = Application.countCorrespondingNumbers(winnerLotto, userLotto, bonusNumber);

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("당첨되지 않은 경우에는 NOT_IN_LIST 예외가 발생한다.")
    @Test
    public void countCorrespondingNumbersTest_NotInList() throws Exception{
        //given
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> checkTargetNumber = Arrays.asList(1, 2, 10, 11, 12, 13);
        int bonusNumber = 14;
        Lotto winnerLotto = new Lotto(winnerNumber);
        Lotto userLotto = new Lotto(checkTargetNumber);

        //when
        LottoRank expectedValue = LottoRank.NOT_IN_PLACE;
        LottoRank actualValue = Application.countCorrespondingNumbers(winnerLotto, userLotto, bonusNumber);

        //then
        assertEquals(expectedValue, actualValue);
    }

    /**
     * convertStringWinnerNumberIntoListWinnerNumber(param1)
     * param1: String userInput: 사용자 입력 문자형 당첨금액
     * returns Integer형 List 당첨금액 반환
     */
    @DisplayName("사용자가 입력한 문자형 당첨금액을 리스트형 당첨금액으로 전환후 반환해야 한다.")
    @Test
    public void convertStringWinnerNumberIntoListWinnerNumberTest() {
        //given
        String userInput = "1,2,3,4,5,6";
        List<Integer> expectedValue = Arrays.asList(1, 2, 3, 4, 5, 6);
        //when
        List<Integer> actualValue = Application.convertStringWinnerNumberIntoListWinnerNumber(userInput);

        //then
        assertEquals(expectedValue, actualValue);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
