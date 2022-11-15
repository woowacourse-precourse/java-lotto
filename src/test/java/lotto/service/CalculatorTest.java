package lotto.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.service.Calculator.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {

    @ParameterizedTest
    @DisplayName("가격 당 로또 개수 검증")
    @CsvSource(
            value = {
                    "100000000:100000",
                    "0:0",
                    "999:0"
            },
            delimiter = ':'
    )
    void test1(int input, int output) {
        assert lottoNumbersPerCost(input) == output;
    }

    @Test
    void test2() {
        System.out.println(calculateRevenueRate(0, 8));
        assert calculateRevenueRate(0, 8) == 0;
    }

    @ParameterizedTest
    @DisplayName("교집합 연산 검증")
    @CsvSource(value = {
            "1,2,3,4,5,6:1,2,3,4,5,6:1,2,3,4,5,6",
            "2,4,6,8,10,12:1,2,3,4,5,6:2,4,6",
            "7,8,9,10,11,12:1,2,3,4,5,6:",
    }, delimiter = ':')
    void test3(String input1, String input2, String output) {
        List<Integer> lst1 = stringToList(input1);
        List<Integer> lst2 = stringToList(input2);
        Set<Integer> s1 = stringToSet(output);
        System.out.println(intersection(lst1, lst2).toString());
        assert intersection(lst1, lst2).containsAll(s1);
    }

    public List<Integer> stringToList(String input) {
        if(input==null) {
            return List.of();
        }
        return Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public Set<Integer> stringToSet(String input) {
        if(input==null) {
            return Set.of();
        }
        return Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());
    }
}