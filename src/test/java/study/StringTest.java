package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Nested
    @DisplayName("요구사항 1")
    class Requirement1 {
        @Test
        @DisplayName("\"1,2\"을 , 로 after 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다")
        void test1() {
            // given
            String before = "1,2";

            // when
            String[] after = before.split(",");

            // then
            assertThat(after).containsExactly("1", "2");
        }

        @Test
        @DisplayName("\"1\"을 , 로 after 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
        void test2() {
            // given
            String before = "1";

            // when
            String[] after = before.split(",");

            // then
            assertThat(after).contains("1");
        }

        @Test
        @DisplayName("assertj의 contains 메서드는 배열의 원소가 중복이 있어도 포함하기만 하면 테스트가 성공한다.")
        void test3() {
            // given
            String before = "1112";

            // when
            String[] after = before.split("");

            // then
            assertThat(after).contains("2", "1");
        }

        @Test
        @DisplayName("assertj의 containsExactly 메서드는 배열의 인덱스마다 원소가 모두 일치해야 성공을 반환한다.")
        void test4() {
            // given
            String before = "1112";

            // when
            String[] after = before.split("");

            // then
            assertThat(after).containsExactly("1", "1", "1", "2");
        }
    }

    @Nested
    @DisplayName("요구사항 2")
    class Requirement2 {
        @Test
        @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환\n"
                + "하도록 구현한다.")
        void test1() {
            // given
            String before = "(1,2)";
            String answer = "1,2";

            // when
            String after = before.substring(1, before.length() - 1);

            // then
            assertThat(after).isEqualTo(answer);
        }
    }

    @Nested
    @DisplayName("요구사항 3")
    class Requirement3 {
        @Test
        @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습\n"
                + "테스트를 구현한다")
        void test1() {
            // given
            String before = "abc";

            // when
            char first = before.charAt(0);

            // then
            assertThat(first).isEqualTo('a');
        }

        @Test
        @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면\n"
                + "StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
        void test2() {
            // given
            String before = "abc";

            assertThatThrownBy(() -> before.charAt(1000))
                    .isInstanceOf(StringIndexOutOfBoundsException.class);
        }

        @Test
        @DisplayName("JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다")
        void test3() {
            assertThat(true).isTrue();
        }

        @Test
        @DisplayName("assertj의 assertThatNullPointerException()을 테스트해보자")
        void test4() {
            // given
            String before = null;

            assertThatNullPointerException()
                    .isThrownBy(() -> before.length());
        }
    }

}
