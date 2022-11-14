package Character;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class UserTest {

    User user = new User();

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    void makeLottoBundleTest() {
        int howManyLotto = 3;
        int result = 3;
        user.makeLottoBundle(howManyLotto);
        assertEquals(result,user.getLottoBundle().size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void inputWinningNumberTest(String winningNumberInput) {
        InputStream in = generateUserInput(winningNumberInput);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        List<Integer> answer = List.of(1,2,3,4,5,6);
        user.inputWinningNumber();
        assertEquals(user.getWinningNumber(),answer);
    }

    @ParameterizedTest
    @ValueSource(strings = {"f308urw!a,"})
    void inputWinningNumberErrorTest1(String winningNumberInput) {
        InputStream in = generateUserInput(winningNumberInput);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(() -> user.inputWinningNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,가,나,3,4"})
    void inputWinningNumberErrorTest2(String winningNumberInput) {
        InputStream in = generateUserInput(winningNumberInput);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(() -> user.inputWinningNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7"})
    void splitStringToIntegerArray(String inputtedWinningNumber) {
        InputStream in = generateUserInput(inputtedWinningNumber);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        List<Integer> result = List.of(1,2,3,4,5,6,7);
        assertEquals(result,user.splitStringToIntegerArray(inputtedWinningNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"7"})
    void inputBonusNumberTest(String bonusNumberInput) {
        int result = 7;
        InputStream in = generateUserInput(bonusNumberInput);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        user.inputBonusNumber();
        assertEquals(user.getBonusNumber(),7);
    }

    @ParameterizedTest
    @ValueSource(strings = {"!"})
    void inputBonusNumberErrorTest(String bonusNumberInput) {
        InputStream in = generateUserInput(bonusNumberInput);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(() -> user.inputWinningNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"46"})
    void inputBonusNumberOutOfRangeTest(String bonusNumberInput) {
        InputStream in = generateUserInput(bonusNumberInput);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(() -> user.checkBonusNumberRange(Integer.parseInt(bonusNumberInput)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void countingWinningNumberTest() {
        List<Integer> result = List.of(0,0,0,2,0,1,1,0);
        user.countWinningNumber(3,false);
        user.countWinningNumber(3,false);
        user.countWinningNumber(5,false);
        user.countWinningNumber(5,true);
        assertEquals(result,user.getWinningNumberCounting());
    }

    @Test
    void calculateEarningTest() {
        double result = 31510000;
        user.countWinningNumber(3,false);
        user.countWinningNumber(3,false);
        user.countWinningNumber(5,false);
        user.countWinningNumber(5,true);
        user.calculateEarning();
        assertEquals(result,user.getEarning());
    }

    @ParameterizedTest
    @ValueSource(strings = {"100000"})
    void calculateEarningRateTest(String moneyInput) {
        double result = 0.5;
        InputStream in = generateUserInput(moneyInput);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        user.setMoney();
        user.countWinningNumber(4,false);
        user.calculateEarning();
        assertEquals(result,user.calculateEarningRate());
    }
}
