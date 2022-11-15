package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringToIntegerMapperTest {

    @Test
    void toInt() {
        assertThat(StringToIntegerMapper.toInt("1")).isEqualTo(1);
    }

    @Test
    void toIntList() {
        assertThat(StringToIntegerMapper.toIntList("1,2,3,4,5,6", ",")).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}