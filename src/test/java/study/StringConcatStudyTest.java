package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringConcatStudyTest {
    private static final int TEN_POWER_SIX = 1000_000;

    @DisplayName("문자열 + 연산자는 문자열 concat보다 느린가")
    @Test
    void String_plus_operator_is_slower_than_String_concat() {
        List<String> strings = buildTestStrings(5);
        long stringPlusOperatorTime = measureTimeOf(() -> {
            String result = "";
            for (String string : strings) {
                result += string;
            }
            result.toString();
        });

        long stringConcatOperatorTime = measureTimeOf(() -> {
            String result = "";
            for (String string : strings) {
                result = result.concat(string);
            }
            result.toString();
        });

        printDifference(stringPlusOperatorTime, stringConcatOperatorTime);

        assertThat(stringPlusOperatorTime).isGreaterThanOrEqualTo(stringConcatOperatorTime);
    }

    @DisplayName("문자열 concat은 StringBuilder보다 느린가")
    @Test
    void String_concat_is_slower_than_StringBuilder_append() {
        List<String> strings = buildTestStrings(5);
        long stringConcatOperatorTime = measureTimeOf(() -> {
            String result = "";
            for (String string : strings) {
                result = result.concat(string);
            }
            result.toString();
        });

        long stringBuilderAppendTime = measureTimeOf(() -> {
            StringBuilder result = new StringBuilder();
            for (String string : strings) {
                result.append(string);
            }
            result.toString().toString();
        });

        printDifference(stringConcatOperatorTime, stringBuilderAppendTime);

        assertThat(stringConcatOperatorTime).isGreaterThanOrEqualTo(stringBuilderAppendTime);
    }

    private void printDifference(long longer, long shorter) {
        System.out.printf("Longer 시간 = %d ns = %f ms\n", longer, (double)longer / TEN_POWER_SIX);
        System.out.printf("Shorter 시간 = %d ns = %f ms\n", shorter, (double)shorter / TEN_POWER_SIX);
        System.out.printf("Longer가 Shorter보다 %.1f배 느렸다\n", (double)longer / shorter);
    }

    private long measureTimeOf(Runnable runnable) {
        long start = System.nanoTime();
        runnable.run();
        long end = System.nanoTime();
        return end - start;
    }

    private List<String> buildTestStrings(int count) {
        String testString = "학습테스트";
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            strings.add(testString);
        }
        return strings;
    }
}
