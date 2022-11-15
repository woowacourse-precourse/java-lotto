package lotto;

import lotto.domain.Lotto;
import lotto.utils.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {

    // 숫자인지 확인하는 메서드 체크
    @ParameterizedTest
    @ValueSource(strings = {"1e1", "111e", "1 1", "abc"})
    void 숫자인지_확인하는_메서드_체크(String input){
        assertThatThrownBy(()->{
            Validator.validateInteger(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    // 숫자의 개수 확인하는 메서드 체크
    @ParameterizedTest
    @MethodSource("parametersProvider")
    void 숫자_개수_확인_체크(List<String> numbers, int size){
        assertThatThrownBy(()->{
            Validator.validateArraySize(numbers, size);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    //중복 확인하는 메서드 체크


    // 1000으로 나누어 떨어지는지 확인하는 메서드 체크
    @ParameterizedTest
    @ValueSource(ints = {1400, 13200, 243400, 1382938923})
    void 천으로_나누어떨어지는지_체크(int input){
        assertThatThrownBy(()->{
            Validator.validateBudget(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> parametersProvider(){
        return Stream.of(
                Arguments.arguments(List.of("15","24","1","2","3"), 6),
                Arguments.arguments(List.of("15","5","1","2"), 6),
                Arguments.arguments(List.of("15","5","1","2","3","4"), 5),
                Arguments.arguments(List.of("15","5","10","2","3","1"), 5),
                Arguments.arguments(List.of("16","17","18","19","20","21"), 7)
        );
    }


}
