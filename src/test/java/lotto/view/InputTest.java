package lotto.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

        // When & Then
        System.setIn(inputStream);
        assertThatThrownBy(()->inputTest.getMoney())
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

    private InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}