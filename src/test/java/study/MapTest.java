package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class MapTest {

    Map<Integer, Integer> test;

    @BeforeEach
    void mapDataSetting() {
        test = new HashMap<>();
        for (int i = 1; i < 6; i++) {
            test.put(i, i);
        }
    }


    @DisplayName("ComputeIfPresent는 해당 Key값이 map에 있을 경우에 key값의 value에 해당 람다식을 적용하는 함수이다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void ComputeIfPresent_테스트(int intArg) {
        test.computeIfPresent(intArg, (key, value) -> value + intArg);
        assertThat(test.get(intArg)).isEqualTo(2 * intArg);
    }

    @DisplayName("ComputeIfPresent는 해당 Key값이 map에 없을 경우는 아무 행동을 하지 않는다")
    @ParameterizedTest
    @ValueSource(ints = {6, 7, 8, 9, 10})
    void ComputeIfPresent_값이_없는_경우_테스트(int intArg) {
        test.computeIfPresent(intArg, (key, value) -> value + intArg);

        assertThat(test.values()).containsExactly(1, 2, 3, 4, 5);
    }

    @DisplayName("ComputeIfAbsent는 해당 Key값에 value가 없는 경우 key에 해당 value를 할당해준다")
    @ParameterizedTest
    @ValueSource(ints = {6, 7, 8, 9, 10})
    void ComputeIfAbsent_테스트(int intArg) {
        test.computeIfAbsent(intArg,(key) -> intArg);
        assertThat(test.values()).containsExactly(1, 2, 3, 4, 5, intArg);
    }

    @DisplayName("ComputeIfAbsent는 해당 Key값에 value가 있는 경우 아무것도 하지 않는다")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void ComputeIfAbsent가_무시되는_경우_테스트(int intArg) {
        test.computeIfAbsent(intArg,(key) -> 100);
        assertThat(test.values()).containsExactly(1, 2, 3, 4, 5);
    }

    @DisplayName("Map.getOrDefault(key,default)는 해당 key값이 존재할 경우 가져오고 아니면 default 값을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,1","6,0","2,2","100,0"})
    void Map의_getOrDefault_테스트(int intArg, int expected) {
        assertThat(test.getOrDefault(intArg,0)).isEqualTo(expected);
    }

}
