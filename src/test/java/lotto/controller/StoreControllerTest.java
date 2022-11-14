package lotto.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StoreControllerTest {
    private StoreController storeController;

    @Test
    @DisplayName("유효한 값을 입력한 경우 정상적으로 종료된다.")
    void checkRunWithValidInput() throws IOException {
        //given
        storeController = new StoreController();
        String paidMoney = "3000";
        String winningNumber = "1,2,3,4,5,6";
        String bonusNumber = "7";
        String input = paidMoney + "\n" + winningNumber + "\n" + bonusNumber;

        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        storeController.run();
        inputStream.close();

        //then
        assertThat(outputStream.toString()).contains("총 수익률은");
        outputStream.close();
    }
}
