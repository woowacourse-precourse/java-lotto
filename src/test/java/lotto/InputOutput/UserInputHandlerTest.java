package lotto.InputOutput;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

class UserInputHandlerTest{

    private static final String ERROR_MESSAGE = "[ERROR]";

    OutputStream out;
    InputStream in;
    UserInputHandler inputHandler = new UserInputHandler();
    Supplier<Integer> functionSupply;

    void beforeSetting(String input){
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    void exceptionRunning(Supplier<Integer> function){
        try{
            function.get();
        }catch(IllegalArgumentException | NoSuchElementException ignored){}
    }

    @Test
    void getHowMuchTickets_case1() {
        String input = "8000";
        int output = 8;
        beforeSetting(input);
        assertThat(inputHandler.getHowMuchTickets()).isEqualTo(output);
    }

    @Test
    void getHowMuchTickets_case2() {
        String input = "15000";
        int output = 15;
        beforeSetting(input);
        assertThat(inputHandler.getHowMuchTickets()).isEqualTo(output);
    }

    @Test
    void getHowMuchTickets_exception1(){
        String input = "Hello World";
        beforeSetting(input);
        functionSupply = () -> inputHandler.getHowMuchTickets();
        assertSimpleTest(() ->{
            exceptionRunning(functionSupply);
            assertThat(out.toString().trim()).isEqualTo("[ERROR] 구입 금액에는 정수만 입력할 수 있습니다.");
        });
    }
    @Test
    void getHowMuchTickets_exception2() {
        String input = "-1000";
        beforeSetting(input);
        functionSupply = () -> inputHandler.getHowMuchTickets();
        assertSimpleTest(() -> {
            exceptionRunning(functionSupply);
            assertThat(out.toString().trim()).isEqualTo("[ERROR] 지불하는 돈은 양수여야 합니다.");
        });
    }

    @Test
    void getHowMuchTickets_exception3() {
        String input = "11500";
        beforeSetting(input);
        functionSupply = () -> inputHandler.getHowMuchTickets();
        assertSimpleTest(() -> {
            exceptionRunning(functionSupply);
            assertThat(out.toString().trim()).contains("[ERROR] 로또는 1,000원 단위로 구입할 수 있습니다.");
        });
    }

    @Test
    void getHowMuchTickets_exception4() {
        String input = "!!@@##$%^";
        beforeSetting(input);
        functionSupply = () -> inputHandler.getHowMuchTickets();
        assertSimpleTest(() -> {
            exceptionRunning(functionSupply);
            assertThat(out.toString().trim()).contains("[ERROR] 구입 금액에는 정수만 입력할 수 있습니다.");
        });
    }
}