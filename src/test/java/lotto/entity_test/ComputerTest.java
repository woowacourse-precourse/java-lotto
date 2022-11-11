package lotto.entity_test;

import lotto.domain.Lotto;
import lotto.model.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {

    Computer computer;

    @BeforeEach
    void initializeClass(){
        computer = new Computer();
    }

    @Test
    @DisplayName("문자열을 입력하면 정수형 리스트로 저장한다. ")
    void saveWinningTicketTest(){
        computer.saveWinningTicket("1,2,3,4,5,6");
        assertThat(computer.getComputerNumber()).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("보너스 넘버를 입력하면 정수형으로 저장한다. ")
    void saveBonusNumberTest(){
        computer.saveBonusNumber("7");
        assertThat(computer.getBonusNumber()).isEqualTo(7);
    }
}
