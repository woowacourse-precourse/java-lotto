package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("로또 번호가 List 자료형으로 변형되는지 테스트")
    @Test
    void convertToList() {
        User user = new User();

        List<Integer> result = user.convertToList("1,2,3,4,5,6");
        assertThat(result).isEqualTo(
                List.of(1, 2, 3, 4, 5, 6)
        );
    }
}