package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    private User user;

    @DisplayName("정상적으로 입력된다.")
    @Test
    void createUser() {
        assertThatNoException().isThrownBy(() -> new User(7000, List.of(1, 2, 3, 4, 5, 6), 7));
    }

    @DisplayName("사용자의 돈이 1000 단위가 아닐 경우 예외를 발생한다.")
    @Test
    void createUserByWrongUnitOfMoney() {
        assertThatThrownBy(() -> new User(70, List.of(1, 2, 3, 4, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 로또 번호가 6개가 되지 않을 경우 예외를 발생한다.")
    @Test
    void createUserByOverSizedLotto() {
        assertThatThrownBy(() -> new User(7000, List.of(1, 2, 3, 4, 5, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 로또 번호 범위가 1~45가 아닐 경우 예외를 발생한다.")
    @Test
    void createUserByWrongRangeOfLotto() {
        assertThatThrownBy(() -> new User(7000, List.of(1, -2, 3, 4, 500, 6), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 보너스 번호 범위가 1~45가 아닐 경우 예외를 발생한다.")
    @Test
    void createUserByWrongRangeOfBonus() {
        assertThatThrownBy(() -> new User(7000, List.of(1, 2, 3, 4, 5, 6), 700))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 로또와 보너스 번호가 중복일 경우 예외를 발생한다.")
    @Test
    void createUserByDuplicatedBonus() {
        assertThatThrownBy(() -> new User(7000, List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
