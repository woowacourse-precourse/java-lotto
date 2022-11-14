package lotto;

import lotto.console.InputManager;
import org.junit.jupiter.api.Test;

import java.io.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputManagerTest {

    // 사용자 입력
    void putSystemInput(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    /**
     * getPrice - 로또 구입 금액 입력
     */
    @Test
    void getPrice_테스트() {
        String price = Integer.toString(ProgramManager.LOTTO_PRICE);
        putSystemInput(price);
        assertThat(ProgramManager.LOTTO_PRICE).isEqualTo(InputManager.getInput_price());
    }

    @Test
    void getPrice_시작값_0_예외_테스트() {
        String price = "0" + ProgramManager.LOTTO_PRICE;
        putSystemInput(price);

        assertSimpleTest(() ->
                assertThatThrownBy(InputManager::getInput_price)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getPrice_숫자_이외_값_예외_테스트1() {
        String price = "10아랄라000";
        putSystemInput(price);

        assertSimpleTest(() ->
                assertThatThrownBy(InputManager::getInput_price)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getPrice_숫자_이외_값_예외_테스트2() {
        String price = "10000j";
        putSystemInput(price);

        assertSimpleTest(() ->
                assertThatThrownBy(InputManager::getInput_price)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getPrice_구입_단위_예외_테스트() {
        String price = Integer.toString(ProgramManager.LOTTO_PRICE + 1);
        putSystemInput(price);

        assertSimpleTest(() ->
                assertThatThrownBy(InputManager::getInput_price)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    /**
     * getInput_predictLottoNumber - 당첨 번호 입력
     */
    @Test
    void getInput_predictLottoNumber_테스트() {
        String userPredictLottoNumber = "1,2,3,4,5,6";
        putSystemInput(userPredictLottoNumber);
        assertThat(InputManager.convertStringToIntegerList(userPredictLottoNumber)).isEqualTo(InputManager.getInput_predictLottoNumber());
    }

    @Test
    void getInput_predictLottoNumber_숫자_쉼표_이외_입력값_예외_테스트() {
        String userPredictLottoNumber = "1,앍,3,4,5,6";
        putSystemInput(userPredictLottoNumber);
        assertSimpleTest(() ->
                assertThatThrownBy(InputManager::getInput_predictLottoNumber)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getInput_predictLottoNumber_공백_예외_테스트1() {
        String userPredictLottoNumber = "1,2, ,4,5,6";
        putSystemInput(userPredictLottoNumber);
        assertSimpleTest(() ->
                assertThatThrownBy(InputManager::getInput_predictLottoNumber)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getInput_predictLottoNumber_공백_예외_테스트2() {
        String userPredictLottoNumber = "1,2,3, 4,5,6";
        putSystemInput(userPredictLottoNumber);
        assertSimpleTest(() ->
                assertThatThrownBy(InputManager::getInput_predictLottoNumber)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getInput_predictLottoNumber_길이_예외_테스트() {
        String userPredictLottoNumber = "1,23,4,5,6";
        putSystemInput(userPredictLottoNumber);
        assertSimpleTest(() ->
                assertThatThrownBy(InputManager::getInput_predictLottoNumber)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getInput_predictLottoNumber_범위_초과_예외_테스트() {
        String userPredictLottoNumber = "1,2,46,4,5,6";
        putSystemInput(userPredictLottoNumber);
        assertSimpleTest(() ->
                assertThatThrownBy(InputManager::getInput_predictLottoNumber)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getInput_predictLottoNumber_범위_미만_예외_테스트() {
        String userPredictLottoNumber = "1,2,0,4,5,6";
        putSystemInput(userPredictLottoNumber);
        assertSimpleTest(() ->
                assertThatThrownBy(InputManager::getInput_predictLottoNumber)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    /**
     * getInput_predictBonusLottoNumber - 보너스 번호 입력
     */
    @Test
    void getInput_predictBonusLottoNumber_테스트() {
        String userPredictBonusLottoNumber = "22";
        putSystemInput(userPredictBonusLottoNumber);
        assertThat(Integer.parseInt(userPredictBonusLottoNumber)).isEqualTo(InputManager.getInput_predictBonusLottoNumber());
    }

    @Test
    void getInput_predictBonusLottoNumber_숫자_이외_입력_예외_테스트() {
        String userPredictBonusLottoNumber = "앍";
        putSystemInput(userPredictBonusLottoNumber);
        assertSimpleTest(() ->
                assertThatThrownBy(InputManager::getInput_predictBonusLottoNumber)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getInput_predictBonusLottoNumber_시작값_0_입력_예외_테스트() {
        String userPredictBonusLottoNumber = "06";
        putSystemInput(userPredictBonusLottoNumber);
        assertSimpleTest(() ->
                assertThatThrownBy(InputManager::getInput_predictBonusLottoNumber)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getInput_predictBonusLottoNumber_공백_입력_예외_테스트() {
        String userPredictBonusLottoNumber = " ";
        putSystemInput(userPredictBonusLottoNumber);
        assertSimpleTest(() ->
                assertThatThrownBy(InputManager::getInput_predictBonusLottoNumber)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getInput_predictBonusLottoNumber_범위_초과_예외_테스트() {
        String userPredictBonusLottoNumber = "46";
        putSystemInput(userPredictBonusLottoNumber);
        assertSimpleTest(() ->
                assertThatThrownBy(InputManager::getInput_predictBonusLottoNumber)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getInput_predictBonusLottoNumber_범위_미만_예외_테스트() {
        String userPredictBonusLottoNumber = "0";
        putSystemInput(userPredictBonusLottoNumber);
        assertSimpleTest(() ->
                assertThatThrownBy(InputManager::getInput_predictBonusLottoNumber)
                        .isInstanceOf(IllegalArgumentException.class));
    }

}
