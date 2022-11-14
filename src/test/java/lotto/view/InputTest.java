package lotto.view;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class InputTest {

    static Input inputTest;

    @BeforeEach
    public void beforeEach(){
        inputTest = new Input();
    }

    @DisplayName("형식에 맞는 금액을 입력했을 때 int 형 금액을 반환한다.")
    @ParameterizedTest
    @MethodSource("setCorrectMoney")
    public void givenMoney_whenGetMoney_thenReturnMoney(String money){
        // Given
        InputStream inputStream = generateUserInput(money);
        System.setIn(inputStream);

        // When
        int correctMoney = inputTest.getMoney();

        // Then
        assertThat(correctMoney).isEqualTo(Integer.parseInt(money));
    }

    // TODO: 현재 NoSuchElementException 으로 예외처리, 추후에 IllegalArgumentException 으로 바꿔야 한다.[방법 찾는 중]
    @DisplayName("형식에 맞지 않는 금액을 입력했을 때 IllegalArgumentException 이 발생해야 한다.")
    @ParameterizedTest
    @MethodSource("setMoney")
    public void givenMoney_whenGetMoney_thenReturnNoSuchElementException(String money){
        // Given
        InputStream inputStream = generateUserInput(money);
        System.setIn(inputStream);

        // When & Then
        assertThatThrownBy(()->inputTest.getMoney())
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("올바른 형식의 당첨 번호를 입력받았을 때 로또 객체를 리턴한다.")
    @ParameterizedTest
    @MethodSource("setCorrectWinningNumbers")
    public void givenWinningNumbers_whenGetWinningNumbers_thenReturnLotto(String winningNumbers){
        // Given
        InputStream inputStream = generateUserInput(winningNumbers);
        System.setIn(inputStream);

        // When
        Lotto lotto = inputTest.getWinningNumbers();

        // Then
        assertThat(lotto).isNotNull();
    }


    // TODO: 현재 NoSuchElementException 으로 예외처리, 추후에 IllegalArgumentException 으로 바꿔야 한다.[방법 찾는 중]
    @DisplayName("올바르지 않은 당첨 번호를 입력했을 경우 IllegalArgumentException 을 던진다. [추후 수정 예정]")
    @ParameterizedTest
    @MethodSource("setWinningNumbers")
    public void givenWrongWinningNumbers_whenGetWinningNumbers_thenReturnIllegalArgumentException(String winningNumbers){
        // Given
        InputStream inputStream = generateUserInput(winningNumbers);
        System.setIn(inputStream);

        // When & Then
        assertThatThrownBy(()->inputTest.getWinningNumbers())
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("올바른 형식의 보너스 번호를 입력했을 때 하나의 보너스 번호를 리턴받는다.")
    @ParameterizedTest
    @MethodSource("setCorrectBonusNumber")
    public void givenCorrectBonusNumberWinningNumbers_whenGetBonusNumber_thenReturnBonusNumber(String bonusNumber){
        // Given
        InputStream inputStream = generateUserInput(bonusNumber);
        System.setIn(inputStream);
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        // When
        int correctBonusNumber = inputTest.getBonusNumber(winningNumbers);

        // Then
        assertThat(correctBonusNumber).isNotNull();

    }

    // TODO: 현재 NoSuchElementException 으로 예외처리, 추후에 IllegalArgumentException 으로 바꿔야 한다.[방법 찾는 중]
    @DisplayName("올바르지 않은 번호 입력 시 IllegalArgumentException 을 던진다.")
    @ParameterizedTest
    @MethodSource("setBonusNumber")
    public void givenWrongNumberWinningNumbers_whenGetBonusNumber_thenReturnIllegalArgumentException(String bonusNumber)
    {
        // Given
        InputStream inputStream = generateUserInput(bonusNumber);
        System.setIn(inputStream);
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        // When & Then
        assertThatThrownBy(()->inputTest.getBonusNumber(winningNumbers))
                .isInstanceOf(NoSuchElementException.class);
    }


    private static Stream<Arguments> setCorrectMoney(){
        return Stream.of(
                Arguments.of("1000"),
                Arguments.of("66000"),
                Arguments.of("2000"),
                Arguments.of("55000")
        );
    }


    private static Stream<Arguments> setMoney(){
        return Stream.of(
                Arguments.of("1000j"),
                Arguments.of("dfksdflk"),
                Arguments.of("900"),
                Arguments.of("23123")
        );
    }

    private static Stream<Arguments> setCorrectWinningNumbers(){
        return Stream.of(
                Arguments.of("1,2,3,4,5,6")
        );
    }

    private static Stream<Arguments> setWinningNumbers(){
        return Stream.of(
                Arguments.of("1,1,1,1,1"),
                Arguments.of("1,2,3,4,5,6,7,8,9,10"),
                Arguments.of("a,b,c,d,e,f"),
                Arguments.of("46,1,2,3,4,5")
        );
    }

    private static Stream<Arguments> setCorrectBonusNumber(){
        return Stream.of(
                Arguments.of("7"),
                Arguments.of("45"),
                Arguments.of("25")
        );
    }

    private static Stream<Arguments> setBonusNumber(){
        return Stream.of(
                Arguments.of("1"),
                Arguments.of("dkfsjfls"),
                Arguments.of("1,2,3,4")
        );
    }

    private InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}