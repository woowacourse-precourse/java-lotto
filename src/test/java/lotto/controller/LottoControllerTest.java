package lotto.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

public class LottoControllerTest {
    LottoController lottoController;

    @BeforeEach
    void beforeEach(){
        lottoController = new LottoController();
    }

}