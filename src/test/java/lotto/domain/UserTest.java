package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void 콤마를기준으로잘구분하는지확인() {
        List<Integer> result = user.splitNumbers("1,2,3");
        List<Integer> answer = Arrays.asList(1, 2, 3);

        assertThat(result).isEqualTo(answer);
    }
}