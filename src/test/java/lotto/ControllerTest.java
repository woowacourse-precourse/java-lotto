package lotto;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ControllerTest {
    private LotteryController controller = new LotteryController();

    @DisplayName("쉼표로 구분된 문자열을 정수 리스트로 변환한다.")
    @Test
    void parseStringTest() throws Exception {
        Method parseMethod = LotteryController.class.getDeclaredMethod("parseStringToList", String.class);
        parseMethod.setAccessible(true);

        String supposeInput = "1,2,3,4,5,6";
        List actual = (List) parseMethod.invoke(controller, supposeInput);
        assertThat(actual).contains(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("금액: 입력한 값은 1000으로 나누어져야 한다")
    @Test
    void validateNumIsDivisibleTest() throws Exception {
        Method validateMethod = LotteryController.class.getDeclaredMethod("validateNumIsDivisible", int.class);
        validateMethod.setAccessible(true);
        try {
            validateMethod.invoke(controller, 1111);
        } catch(InvocationTargetException e) {
            Assertions.assertEquals(IllegalArgumentException.class, e.getTargetException().getClass());
        }
    }

    @DisplayName("당첨번호: 입력한 값들은 1부터 45까지 사이여야 한다")
    @Test
    void validateNumListInRangeTest() throws Exception {
        Method validateMethod = LotteryController.class.getDeclaredMethod("validateNumListInRange", List.class);
        validateMethod.setAccessible(true);
        try {
            validateMethod.invoke(controller, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 46)));
        } catch(InvocationTargetException e) {
            Assertions.assertEquals(IllegalArgumentException.class, e.getTargetException().getClass());
        }
    }

    @DisplayName("당첨번호: 입력한 값들은 6개의 숫자로 구성되어야 한다")
    @Test
    void validateNumListCount() throws Exception {
        Method validateMethod = LotteryController.class.getDeclaredMethod("validateNumListCount", List.class);
        validateMethod.setAccessible(true);
        try {
            validateMethod.invoke(controller, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)));
        } catch(InvocationTargetException e) {
            Assertions.assertEquals(IllegalArgumentException.class, e.getTargetException().getClass());
        }
    }

    @DisplayName("당첨번호: 입력한 값들은 중복되지 않아야 한다")
    @Test
    void validateNumListNotDuplicateTest() throws Exception {
        Method validateMethod = LotteryController.class.getDeclaredMethod("validateNumListNotDuplicate", List.class);
        validateMethod.setAccessible(true);
        try {
            validateMethod.invoke(controller, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 5)));
        } catch(InvocationTargetException e) {
            Assertions.assertEquals(IllegalArgumentException.class, e.getTargetException().getClass());
        }
    }

    @DisplayName("보너스번호: 입력한 값은 1부터 45까지 사이여야 한다")
    @Test
    void validateNumInRangeTest() throws Exception {
        Method validateMethod = LotteryController.class.getDeclaredMethod("validateNumInRange", int.class);
        validateMethod.setAccessible(true);
        try {
            validateMethod.invoke(controller, 46);
        } catch(InvocationTargetException e) {
            Assertions.assertEquals(IllegalArgumentException.class, e.getTargetException().getClass());
        }
    }

    @DisplayName("당첨번호와 몇 개의 숫자가 일치하는지 판단하여 해당하는 Rank를 반환한다.")
    @Test
    void compareTest() throws Exception {
        Method compareMethod = LotteryController.class.getDeclaredMethod("compare", Lotto.class, Lotto.class, Boolean.class);
        compareMethod.setAccessible(true);

        int bonusNumber = 10;
        Lotto winningNumber
                = new Lotto(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto userNumberOne
                = new Lotto(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto userNumberTwo
                = new Lotto(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 10)));
        Lotto userNumberThree
                = new Lotto(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 9)));
        Lotto userNumberFour
                = new Lotto(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 9, 10)));
        Lotto userNumberFive
                = new Lotto(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 8, 9, 10)));
        Lotto userNumberSix
                = new Lotto(new ArrayList<Integer>(Arrays.asList(1, 2, 7, 8, 9, 10)));

        Rank firstRank = (Rank) compareMethod.invoke(controller, winningNumber, userNumberOne, userNumberOne.getNumbers().contains(bonusNumber));
        Rank secondRank = (Rank) compareMethod.invoke(controller, winningNumber, userNumberTwo, userNumberTwo.getNumbers().contains(bonusNumber));
        Rank thirdRank = (Rank) compareMethod.invoke(controller, winningNumber, userNumberThree, userNumberThree.getNumbers().contains(bonusNumber));
        Rank fourthRank = (Rank) compareMethod.invoke(controller, winningNumber, userNumberFour, userNumberFour.getNumbers().contains(bonusNumber));
        Rank fifthRank = (Rank) compareMethod.invoke(controller, winningNumber, userNumberFive, userNumberFive.getNumbers().contains(bonusNumber));
        Rank NoRank = (Rank) compareMethod.invoke(controller, winningNumber, userNumberSix, userNumberSix.getNumbers().contains(bonusNumber));

        assertThat(firstRank).isEqualTo(Rank.FIRST);
        assertThat(secondRank).isEqualTo(Rank.SECOND);
        assertThat(thirdRank).isEqualTo(Rank.THIRD);
        assertThat(fourthRank).isEqualTo(Rank.FOURTH);
        assertThat(fifthRank).isEqualTo(Rank.FIFTH);
        assertThat(NoRank).isEqualTo(Rank.NONE);
    }


}
