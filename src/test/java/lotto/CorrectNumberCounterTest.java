package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CorrectNumberCounterTest {
    @DisplayName("리스트안에 특정 숫자가 있으면 참을 반환한다.")
    @Test
    void checkBonusNumber() {
        int bonusNumber = 10;
        List<Integer> userNumber1 = new ArrayList<>(Arrays.asList(1,4,7,10,14,30));
        List<Integer> userNumber2 = new ArrayList<>(Arrays.asList(1,4,7,13,14,30));

        CorrectNumberCounter correctNumberCounter = new CorrectNumberCounter();

        assertAll(
                ()-> assertTrue(correctNumberCounter.checkBonus(userNumber1,bonusNumber)),
                ()-> assertTrue(!correctNumberCounter.checkBonus(userNumber2,bonusNumber))
        );
    }

    @DisplayName("두 리스트를 합칠 수 있다.")
    @Test
    void gatherTwoLists() {
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer> winNumber = new ArrayList<>(Arrays.asList(7,8,9,10,5,6));

        List<Integer> gatherList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,5,6));


        CorrectNumberCounter correctNumberCounter = new CorrectNumberCounter();

        assertEquals(correctNumberCounter.gatherTwoLists(userNumber,winNumber),gatherList);

    }

    @DisplayName("리스트의 중복된 개수를 찾을 수 있다.")
    @Test
    void countDuplcation() {
        List<Integer> gather = new ArrayList<>(Arrays.asList(1,2,3,6,8,10,2,4,6,9,30,45));

        CorrectNumberCounter correctNumberCounter = new CorrectNumberCounter();

        assertEquals(correctNumberCounter.caculateCorrect(gather,0),2);


    }

    @DisplayName("맞춘 개수 세기")
    @Test
    void compareHowManyCorrectExist() {

        List<List<Integer>> user = new ArrayList<>();

        List<Integer> lottoUsers1 = new ArrayList<>(Arrays.asList(3,6,10,36,42,45));
        List<Integer> lottoUsers2 = new ArrayList<>(Arrays.asList(3,6,21,36,42,45));
        List<Integer> lottoUsers3 = new ArrayList<>(Arrays.asList(1,2,10,29,30,44));
        List<Integer> lottoUsers4 = new ArrayList<>(Arrays.asList(4,7,10,15,32,45));
        List<Integer> lottoUsers5 = new ArrayList<>(Arrays.asList(3,6,10,30,42,45));

        user.add(lottoUsers1);
        user.add(lottoUsers2);
        user.add(lottoUsers3);
        user.add(lottoUsers4);
        user.add(lottoUsers5);

        List<Integer> lottoWinNumber = new ArrayList<>(Arrays.asList(3,6,10,36,42,45));

        List<Integer> correctNumber = new ArrayList<>(Arrays.asList(7,5,1,2,6));

        CorrectNumberCounter correctNumberCounter = new CorrectNumberCounter();

        assertEquals(correctNumberCounter.correctNumberList(user,lottoWinNumber,30),correctNumber);

    }



}