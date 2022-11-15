package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class LottoControllerTest {



    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6\n"})
    void 당첨_번호_입력_테스트(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int size = 6;
        LottoController lottoController = new LottoController();
        lottoController.setWinningNum();
        System.out.println(lottoController.getWinningNum().getNumbers());
        int result = lottoController.getWinningNum().getNumbers().size();
        assertThat(result).isEqualTo(size);
    }

    //@ParameterizedTest
    @ValueSource(strings = {"1500000\n1,5,15,40,34,43\n43\n"})
    void 로또_테스트(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoController lottoController = new LottoController();
        lottoController.doLotto();
        System.out.println(lottoController.getWinningNum().getNumbers());
        System.out.println(lottoController.getBonus().getNum());
        System.out.println(lottoController.getScores().toString());
        System.out.println(lottoController.getScores().getSumofScores());
    }


}