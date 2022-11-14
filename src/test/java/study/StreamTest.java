package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StreamTest {

    private final String[] names = new String[]{"James", "Kristine", "Bob"};

    @Test
    @DisplayName("스트림 생성 후 출력")
    void createArrayStream() {
        Stream<String> namesStream = Arrays.stream(names);
        namesStream.forEach(System.out::println);
    }

    @Test
    @DisplayName("스트림 필터 적용 후 출력")
    void filterAndPrint() {
        Stream<String> namesStream = Arrays.stream(names);
        namesStream.filter("James"::equals)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("스트림 필터 적용 후 배열로 변환")
    void filterAndConvertToArray() {
        Stream<String> namesStream = Arrays.stream(names);
        String[] filteredNames = namesStream.filter("James"::equals)
                .toArray(String[]::new);
        assertThat(filteredNames).isNotEmpty()
                .hasSize(1);
    }

    @Test
    @DisplayName("스트림으로 각 문자열을 대문자로 변경")
    void map() {
        Stream<String> namesStream = Arrays.stream(names);
        String[] upperNames = namesStream.map(String::toUpperCase).toArray(String[]::new);
        assertThat(upperNames)
                .containsExactly("JAMES", "KRISTINE", "BOB");

    }

    @Test
    @DisplayName("스트림으로 배열 정렬")
    void sortData() {
        String[] sortedNames = Arrays.stream(names)
                .sorted()
                .toArray(String[]::new);
        assertThat(sortedNames).isSorted();
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    @Test
    @DisplayName("데이터 가공후 컬렉션에 저장")
    void processDataAndStoreToCollection() {
        List<Integer> even = IntStream.range(1, 1001) // 1 ~ 1000
                .boxed()
                .filter(StreamTest::isEven)
                .collect(Collectors.toList());
        assertThat(even).isNotEmpty().size().isEqualTo(500);
    }
}
