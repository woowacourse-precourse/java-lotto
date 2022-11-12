package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class LottoManagerTest {

    LottoManager lottoManager;

    public InputStream getPlayerInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @BeforeEach
    void beforeEach() {
        lottoManager = new LottoManager();
    }

    @ParameterizedTest
    @DisplayName("올바른 값 입력받고 출력하기")
    @ValueSource(strings = {"3000"})
    void printUserLotto(String input) {
        InputStream in = getPlayerInput(input);
        System.setIn(in);

        lottoManager.userWantLotto();
    }
}