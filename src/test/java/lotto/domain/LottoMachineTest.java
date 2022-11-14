package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class LottoMachineTest {
    LottoMachine lottoMachine;

    public LottoMachineTest() {
    }

    @Test
    void 다섯개_로또_생성() {
        lottoMachine = new LottoMachine(5);
        lottoMachine.getLottosNumberList().stream().forEach(System.out::println);
    }

    @Test
    void 다섯개_로또_생성후_출력() {
        lottoMachine = new LottoMachine(5);
        lottoMachine.getLottosNumberList().stream().forEach(System.out::println);
    }

    @Test
    void 당첨번호_저장() {
        lottoMachine = new LottoMachine(5);
        List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        Lotto lotto = new Lotto(winningNumber);
        int bonusNumber = 7;
        lottoMachine.saveWinningNumber(lotto,bonusNumber);
    }

    @Test
    void 당첨_개수_확인() {
        lottoMachine = new LottoMachine(20);
        List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        Lotto lotto = new Lotto(winningNumber);
        int bonusNumber = 7;
        lottoMachine.saveWinningNumber(lotto,bonusNumber);
        lottoMachine.getWinningList();
    }

    @Test
    void 당첨_금액_확인() {
        lottoMachine = new LottoMachine(101);
        List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        Lotto lotto = new Lotto(winningNumber);
        int bonusNumber = 7;
        lottoMachine.saveWinningNumber(lotto,bonusNumber);
        lottoMachine.getWinningList();
    }

    @Test
    void 당첨번호_정상입력() {
        List<Integer> winningNumber = new ArrayList<>(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;
        lottoMachine = new LottoMachine(5);
        lottoMachine.saveWinningNumber(new Lotto(winningNumber),bonusNumber);
    }


    @Test
    void 당첨번호_숫자개수가_작을경우_에러() {
        List<Integer> winningNumber = List.of(1,2,3,4,5);
        int bonusNumber = 7;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lottoMachine.saveWinningNumber(new Lotto(winningNumber),bonusNumber);
        });
    }

    @Test
    void 당첨번호_중복된_숫자가_있을경우_에러() {
        List<Integer> winningNumber = List.of(1,2,3,4,5,5);
        int bonusNumber = 7;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lottoMachine.saveWinningNumber(new Lotto(winningNumber),bonusNumber);
        });
    }
}
