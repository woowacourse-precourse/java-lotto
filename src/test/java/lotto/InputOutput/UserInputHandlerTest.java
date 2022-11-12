package lotto.InputOutput;

import lotto.controller.Lotto;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

class UserInputHandlerTest{

    private static final String ERROR_MESSAGE = "[ERROR]";

    OutputStream out;
    InputStream in;
    UserInputHandler inputHandler = new UserInputHandler();
    private final int WINNING_NUMBER_SiZE = 6;


    void beforeSetting(String input){
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    void exceptionRunning(Supplier<?> function){
        try{
            function.get();
        }catch(IllegalArgumentException | NoSuchElementException ignored){}
    }

    void getExceptionTest(String input, Supplier<?> functionalSupply){
        beforeSetting(input);
        assertSimpleTest(() -> {
            exceptionRunning(functionalSupply);
            assertThat(out.toString().trim()).contains(ERROR_MESSAGE);
        });
    }

    @Nested
    class GetHowMuchTicketsTest{

        Supplier<Integer> functionSupply = () -> inputHandler.getHowMuchTickets();
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
            getExceptionTest(input, functionSupply);
        }
        @Test
        void getHowMuchTickets_exception2() {
            String input = "-1000";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void getHowMuchTickets_exception3() {
            String input = "11500";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void getHowMuchTickets_exception4() {
            String input = "!!@@##$%^";
            getExceptionTest(input,functionSupply);
        }
    }
    @Nested
    class GetWinningNumbersTest{
        Supplier<Lotto> functionSupply = () -> inputHandler.getWinningNumbers();

        @Test
        void getWinningNumbersTest_exception1_1(){
            String input = "1,2,3,4,5";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void getWinningNumbersTest_exception1_2(){
            String input = "1,2,3,4,5,6,7,8";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void getWinningNumbersTest_exception2_1(){
            String input = "1,2,3,4,4,5";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void getWinningNumbersTest_exception2_2(){
            String input = "1,1,2,3,4,5";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void getWinningNumbersTest_exception3_1(){
            String input = "0,1,2,3,4,5";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void getWinningNumbersTest_exception3_2(){
            String input = "41,42,43,44,45,46";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void getWinningNumbersTest_exception4_1(){
            String input = "41,42,43,44,45,Hello";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void getWinningNumbersTest_exception4_2(){
            String input = "40.41,42,43,44,45";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void getWinningNumbersTest_exception4_3(){
            String input = "40,41,42?43,44,45";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void getWinningNumbersTest_case1_1(){
            String input = "1,2,3,4,5,6";
            beforeSetting(input);
            assertThat(functionSupply.get()).isInstanceOf(Lotto.class);
        }

        @Test
        void getWinningNumbersTest_case1_2() {
            String input = "1,2,3,4,5,6";
            beforeSetting(input);
            assertThat(functionSupply.get().getNumbers().size()).isEqualTo(WINNING_NUMBER_SiZE);
        }

        @Test
        void getWinningNumbersTest_case2_1(){
            String input = "10,20,30,40,42,44";
            beforeSetting(input);
            assertThat(functionSupply.get()).isInstanceOf(Lotto.class);
        }

        @Test
        void getWinningNumbersTest_case2_2() {
            String input = "10,20,30,40,42,44";
            beforeSetting(input);
            assertThat(functionSupply.get().getNumbers().size()).isEqualTo(WINNING_NUMBER_SiZE);
        }
    }

    @Nested
    class GetBonusNumberTest{
        Supplier<Integer> functionalSupply = () -> inputHandler.getBonusNumbers(makeLotto());

        Lotto makeLotto(){
            List<Integer> oneToSixListForBonusTest = new ArrayList<>();
            for(int listIndex = 1; listIndex <= 6; listIndex++){
                oneToSixListForBonusTest.add(listIndex);
            }

            return new Lotto(oneToSixListForBonusTest);
        }

        @Test
        void getBonusNumberTest_case1(){
            String input = "7";
            beforeSetting(input);
            int output = Integer.parseInt(input);
            assertThat(functionalSupply.get()).isEqualTo(output);
        }

        @Test
        void getBonusNumberTest_exception1_1(){
            String input = "I arrived at beach";
            getExceptionTest(input,functionalSupply);
        }

        @Test
        void getBonusNumberTest_exception1_2(){
            String input = "!!Hello PoHang!!";
            getExceptionTest(input,functionalSupply);
        }

        @Test
        void getBonusNumberTest_exception1_3(){
            String input = "!@#";
            getExceptionTest(input,functionalSupply);
        }

        @Test
        void getBonusNumberTest_exception2_1(){
            String input = "!@#";
            getExceptionTest(input,functionalSupply);
        }
    }
}