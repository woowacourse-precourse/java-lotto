package lotto.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoControllerTest {

    @Test
    void printLottoList() {
        LottoController lottoController = new LottoController(6);
        lottoController.printLottoList();
    }
}