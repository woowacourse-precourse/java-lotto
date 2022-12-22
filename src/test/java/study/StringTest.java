package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Nested
    @DisplayName("Split 테스트")
    class SplitTest {

        @Test
        @DisplayName("쉼표로 구분된 \"1,2\"를 split했을 때 1과 2로 분리되는지 확인한다.")
        void split_ShouldReturnTrueForSplitIntoEachElement() {
            //given
            String sample = "1,2";

            //when
            String[] result = sample.split(",");

            //then
            assertThat(result.length).isEqualTo(2);
        }

        // next
        @Test
        @DisplayName("\"1\"을 split했을 때 1만 포함하는 배열인지 확인한다.")
        void HasOnlyOneElementWhenSplitingIntoHavingOneCharacter() {
            //given
            String sample = "1";

            //when
            String[] result = sample.split(",");

            //then
            assertThat(result).containsExactly("1");
        }
    }


    @Test
    @DisplayName("substring 메서드를 활용해 \"(1,2)\"에서 ()제거한다.")
    void substring_ShouldReturnTrueForExtractingExpectedValues() {
        //given
        String sample = "(1,2)";

        //when
        String result = sample.substring(1, 4);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    @Nested
    class RangeTest {
        @Test
        @DisplayName("문자열 경계의 범위를 벗어나는 인덱스를 참조할 때 예외가 발생한다.")
        void assertThatThrownBy_ShouldThrowIfOutOfBound() {
            //given
            String sample = "abc";
            int index = 3;


            assertThatThrownBy(() -> {
                sample.charAt(index);       //when
            }).isInstanceOf(StringIndexOutOfBoundsException.class)   //then
                    .hasMessageContaining("%d", index);
        }

        @Test
        @DisplayName("이번에는 다른 메서드를 통해 문자열 경계 범위를 벗어났는지 확인한다.")
        void assertThatExceptionOfType_ShouldThrowIfOutOfBound() {
            //given
            String sample = "abc";
            int index = 3;

                                            //then
            assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                    .isThrownBy(() -> {
                            sample.charAt(index);   //when
                    })
                    .withMessageContaining("String index out of range: %d", index);
        }
    }
}
