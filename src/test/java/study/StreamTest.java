package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamTest {
    @Test
    @DisplayName("스트림 중복 테스트")
    void 스트림_중복_제거_테스트(){
        List<Integer> target = Arrays.asList(1,2,3,4,5,5);
        List<Integer> expected = Arrays.asList(1,2,3,4,5);
        Assertions.assertThat(target.stream().distinct()).isEqualTo(expected);
    }
}
