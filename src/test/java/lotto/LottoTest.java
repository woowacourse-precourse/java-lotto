package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private static final Lotto WINNINGLOTTO = new Lotto(List.of(1,23,11,19,36,13));


    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능


    //당첨 개수 구하기 테스트
    @DisplayName("당첨된 로또 번호 개수가 예상개수와 일치하는지 테스트")
    @ParameterizedTest
    @CsvSource({"6,13,19,23,33,39,3","1,23,11,19,36,13,6","2,17,21,33,24,20,0"})
    void checkCountWinningNumbers(int num1,int num2,int num3,int num4,int num5,int num6,int expected) {

        Lotto lotto = new Lotto(List.of(num1,num2,num3,num4,num5,num6));

        int result = lotto.countMatchedNumbers(WINNINGLOTTO.getNumbers());
        assertThat(result).isEqualTo(expected);
    }



    //당첨 번호 개수가 5개 일때, 보너스 점수 일치 여부 테스트
    @DisplayName("당첨 번호 개수가 5개 일때, 보너스 점수가 일치하면 true를 반환한다.")
    @ParameterizedTest
    @CsvSource({"41,true","33,false"})
    void checkReturnValueOfBonusMatched(int bonusNum, boolean expected) {
        //1,23,11,19,36,13
        Lotto lotto = new Lotto(List.of(1,23,11,19,36,41));
        int matchNumCnt = lotto.countMatchedNumbers(WINNINGLOTTO.getNumbers());

        boolean result = lotto.checkBonusMatched(bonusNum,matchNumCnt);
        assertThat(result).isEqualTo(expected);
    }


    //등수 구하는 메서드 테스트
    @DisplayName("당첨 번호 개수에 따른 등수를 구한다.")
    @ParameterizedTest
    @CsvSource({"1,23,11,19,36,41,41,SECOND","1,25,11,19,32,17,13,FIFTH","1,23,11,19,36,41,39,THIRD"})
    void checkRankByWinningCnt(int num1,int num2,int num3,int num4,int num5,int num6,int bonusNum,Rank expected){
//        1,23,11,19,36,13
        Lotto lotto = new Lotto(List.of(num1,num2,num3,num4,num5,num6));
        int matchedNumCnt = lotto.countMatchedNumbers(WINNINGLOTTO.getNumbers());
        boolean isbonusMatched = lotto.checkBonusMatched(bonusNum,matchedNumCnt);

        Rank result = lotto.getRank(matchedNumCnt, isbonusMatched);
        assertThat(result).isEqualTo(expected);
    }
}
