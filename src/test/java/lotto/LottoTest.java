package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    /*@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }*/

    /*@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }*/

    @DisplayName("로또 번호 string으로 받은 것 List에 넣기")
    @Test
    void changeStringToList() {

        Maker changeStringToList = new Maker();

        assertEquals(changeStringToList.lottoWinList("1,2,3,4,5,6"), List.of(1, 2, 3, 4, 5, 6));
    }


    @DisplayName("6개의 로또 번호를 생성해주는지")
    @Test
    void generateRandomLottoNumber() {

        assertEquals(pickUniqueNumbersInRange(1, 45, 6).size(), 6);

    }

    @DisplayName("돈을 넣은 만큼 로또 번호를 생성하고 그것을 배열에 담는지 확인")
    @Test
    void generateRandomLottoNumberAccordingToInputMoney() {

        Generator generator = new Generator();
        List<List<Integer>> lottoList = generator.generateRandomLottoNumber(14000);

        assertAll(
                () -> assertEquals(lottoList.size(), 14),
                () -> assertEquals(lottoList.get(0).size(), 6)
        );
    }

    @DisplayName("맞춘 개수 세기")
    @Test
    void compareHowManyCorrectExist() {

        List<List<Integer>> user = new ArrayList<>();

        List<Integer> lottoUsers1 = new ArrayList<>(Arrays.asList(4,6,10,41,42,45));
        List<Integer> lottoUsers2 = new ArrayList<>(Arrays.asList(5,6,21,36,42,45));
        List<Integer> lottoUsers3 = new ArrayList<>(Arrays.asList(1,2,10,29,30,44));
        List<Integer> lottoUsers4 = new ArrayList<>(Arrays.asList(4,7,10,15,32,45));

        user.add(lottoUsers1);
        user.add(lottoUsers2);
        user.add(lottoUsers3);
        user.add(lottoUsers4);

        List<Integer> lottoWinNumber = new ArrayList<>(Arrays.asList(3,6,10,36,42,45));

        List<Integer> correctNumber = new ArrayList<>(Arrays.asList(4,4,1,2));

        CompareHowManyCorrect compareHowManyCorrect = new CompareHowManyCorrect();

        assertEquals(compareHowManyCorrect.correctNumberList(user,lottoWinNumber,0),correctNumber);

    }

    @DisplayName("리스트의 중복된 개수를 찾을 수 있다.")
    @Test
    void countDuplcation() {
        List<Integer> gather = new ArrayList<>(Arrays.asList(1,2,3,6,8,10,2,4,6,9,30,45));

        CompareHowManyCorrect compareHowManyCorrect = new CompareHowManyCorrect();

        assertEquals(compareHowManyCorrect.caculateDuplication(gather,0),2);


    }

    @DisplayName("두 리스트를 합칠 수 있다.")
    @Test
    void gatherTwoLists() {
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer> winNumber = new ArrayList<>(Arrays.asList(7,8,9,10,5,6));

        List<Integer> gatherList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,5,6));


        CompareHowManyCorrect compareHowManyCorrect = new CompareHowManyCorrect();

        assertEquals(compareHowManyCorrect.gatherTwoLists(userNumber,winNumber),gatherList);

    }

    @DisplayName("리스트안에 특정 숫자가 있으면 참을 반환한다.")
    @Test
    void checkBonusNumber() {
        int bonusNumber = 10;
        List<Integer> userNumber1 = new ArrayList<>(Arrays.asList(1,4,7,10,14,30));
        List<Integer> userNumber2 = new ArrayList<>(Arrays.asList(1,4,7,13,14,30));

        CompareHowManyCorrect compareHowManyCorrect = new CompareHowManyCorrect();

        assertAll(
                ()-> assertTrue(compareHowManyCorrect.checkBonus(userNumber1,bonusNumber)),
                ()-> assertTrue(!compareHowManyCorrect.checkBonus(userNumber2,bonusNumber))
        );


    }
}
