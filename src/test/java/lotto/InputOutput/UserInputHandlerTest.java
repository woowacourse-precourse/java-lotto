package lotto.InputOutput;

import lotto.controller.Lotto;
import org.junit.jupiter.api.DisplayName;
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

        @DisplayName("8000원 지불 시 8장 뽑기")
        @Test
        void getHowMuchTickets_case1() {
            String input = "8000";
            int output = 8;
            beforeSetting(input);
            assertThat(inputHandler.getHowMuchTickets()).isEqualTo(output);
        }

        @DisplayName("15000원 지불 시 15장 뽑기")
        @Test
        void getHowMuchTickets_case2() {
            String input = "15000";
            int output = 15;
            beforeSetting(input);
            assertThat(inputHandler.getHowMuchTickets()).isEqualTo(output);
        }

        @DisplayName("문자열 입력 시 예외처리")
        @Test
        void getHowMuchTickets_exception1(){
            String input = "Hello World";
            getExceptionTest(input, functionSupply);
        }

        @DisplayName("음수 입력 시 예외처리")
        @Test
        void getHowMuchTickets_exception2() {
            String input = "-1000";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("1000원 단위로 떨어지지 않을 시 예외처리")
        @Test
        void getHowMuchTickets_exception3() {
            String input = "11500";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("특수문자 입력 시 예외처리")
        @Test
        void getHowMuchTickets_exception4() {
            String input = "!!@@##$%^";
            getExceptionTest(input,functionSupply);
        }
    }
    @Nested
    class GetWinningNumbersTest{
        Supplier<Lotto> functionSupply = () -> inputHandler.getWinningNumbers();

        @DisplayName("당첨숫자가 6개 아닐때 예외처리 : 5개")
        @Test
        void getWinningNumbersTest_exception1_1(){
            String input = "1,2,3,4,5";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("당첨숫자가 6개 아닐때 예외처리 : 8개")
        @Test
        void getWinningNumbersTest_exception1_2(){
            String input = "1,2,3,4,5,6,7,8";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("당첨숫자가 중복일 때 예외처리 : 4 중복")
        @Test
        void getWinningNumbersTest_exception2_1(){
            String input = "1,2,3,4,4,5";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("당첨숫자가 중복일 때 예외처리 : 1 중복")
        @Test
        void getWinningNumbersTest_exception2_2(){
            String input = "1,1,2,3,4,5";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("당첨숫자에 1~45 사이 아닌 것이 존재할때 예외처리 : 0")
        @Test
        void getWinningNumbersTest_exception3_1(){
            String input = "0,1,2,3,4,5";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("당첨숫자에 1~45 사이 아닌 것이 존재할때 예외처리 : 46")
        @Test
        void getWinningNumbersTest_exception3_2(){
            String input = "41,42,43,44,45,46";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("당첨숫자에 문자열 입력시 예외처리 : Hello")
        @Test
        void getWinningNumbersTest_exception4_1(){
            String input = "41,42,43,44,45,Hello";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("당첨숫자 입력에 콤마(,) 아닌 다른것 입력시 예외처리 : '.' ")
        @Test
        void getWinningNumbersTest_exception4_2(){
            String input = "40.41,42,43,44,45";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("당첨숫자 입력에 콤마(,) 아닌 다른것 입력시 예외처리 : '?' ")
        @Test
        void getWinningNumbersTest_exception4_3(){
            String input = "40,41,42?43,44,45";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("정상 당첨숫자 입력시 Lotto Class 로 output 생성되는지 체크 (1,2,3,4,5,6)")
        @Test
        void getWinningNumbersTest_case1_1(){
            String input = "1,2,3,4,5,6";
            beforeSetting(input);
            assertThat(functionSupply.get()).isInstanceOf(Lotto.class);
        }

        @DisplayName("정상 당첨숫자 입력시, 입력 사이즈가 6개 맞는지 체크 (1,2,3,4,5,6)")
        @Test
        void getWinningNumbersTest_case1_2() {
            String input = "1,2,3,4,5,6";
            beforeSetting(input);
            assertThat(functionSupply.get().getNumbers().size()).isEqualTo(WINNING_NUMBER_SiZE);
        }
        @DisplayName("정상 당첨숫자 입력시 Lotto Class 로 output 생성되는지 체크 (10,20,30,40,42,44)")
        @Test
        void getWinningNumbersTest_case2_1(){
            String input = "10,20,30,40,42,44";
            beforeSetting(input);
            assertThat(functionSupply.get()).isInstanceOf(Lotto.class);
        }
        @DisplayName("정상 당첨숫자 입력시, 입력 사이즈가 6개 맞는지 체크 (10,20,30,40,42,44)")
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

        @DisplayName("보너스 번호 입력 시 제대로 나오는지 체크.(7)")
        @Test
        void getBonusNumberTest_case1(){
            String input = "7";
            beforeSetting(input);
            int output = Integer.parseInt(input);
            assertThat(functionalSupply.get()).isEqualTo(output);
        }

        @DisplayName("보너스 번호 입력 시 제대로 나오는지 체크.(45)")
        @Test
        void getBonusNumberTest_case2(){
            String input = "45";
            beforeSetting(input);
            int output = Integer.parseInt(input);
            assertThat(functionalSupply.get()).isEqualTo(output);
        }

        @DisplayName("보너스 번호 입력에 문자열 들어갈 시, 예외처리")
        @Test
        void getBonusNumberTest_exception1_1(){
            String input = "I arrived at beach";
            getExceptionTest(input,functionalSupply);
        }

        @DisplayName("보너스 번호 입력에 문자열,특수문자 들어갈 시, 예외처리")
        @Test
        void getBonusNumberTest_exception1_2(){
            String input = "!!Hello PoHang!!";
            getExceptionTest(input,functionalSupply);
        }

        @DisplayName("보너스 번호 입력에 특수문자 들어갈 시, 예외처리")
        @Test
        void getBonusNumberTest_exception1_3(){
            String input = "!@#";
            getExceptionTest(input,functionalSupply);
        }

        @DisplayName("보너스 번호 입력에 음수 들어갈 시, 예외처리")
        @Test
        void getBonusNumberTest_exception2_1() {
            String input = "-43";
            getExceptionTest(input, functionalSupply);
        }

        @DisplayName("보너스 번호가 1~45 사이 숫자가 아닐 시, 예외처리. (50)")
        @Test
        void getBonusNumberTest_exception2_2() {
            String input = "50";
            getExceptionTest(input, functionalSupply);
        }

        @DisplayName("보너스 번호가 1~45 사이 숫자가 아닐 시, 예외처리. (0)")
        @Test
        void getBonusNumberTest_exception2_3() {
            String input = "0";
            getExceptionTest(input, functionalSupply);
        }

        @DisplayName("보너스 번호가 기존 당첨숫자와 중복일 시, 예외처리 (3)")
        @Test
        void getBonusNumberTest_exception3_1() {
            String input = "2";
            getExceptionTest(input, functionalSupply);
        }

        @DisplayName("보너스 번호가 기존 당첨숫자와 중복일 시, 예외처리 (5)")
        @Test
        void getBonusNumberTest_exception3_2() {
            String input = "5";
            getExceptionTest(input, functionalSupply);
        }
    }
}