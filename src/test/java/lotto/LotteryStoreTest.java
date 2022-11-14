package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LotteryStoreTest {

    LotteryStore ls = new LotteryStore();

    @ParameterizedTest
    @MethodSource("canPurChaseCorrectNumberOfLotteriesArgument")
    @DisplayName("금액에 맞게 Lotto의 수를 출력하는지 검사")
    void canPurChaseCorrectNumberOfLotteries(int amount, int size){
        assertThat(ls.purchaseLotteries(amount).size()).isEqualTo(size);
    }

    Stream<Arguments> canPurChaseCorrectNumberOfLotteriesArgument(){
        return Stream.of(
                Arguments.arguments(5000,5),
                Arguments.arguments(10000,10),
                Arguments.arguments(15000,15)
        );
    }


}
