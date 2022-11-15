package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CompareNumberTest {

    @Test
    @DisplayName("3개 일치할 경우")
    void match3Numbers(){
        CompareNumber compareNumber = new CompareNumber(List.of(List.of(1,2,3,4,5,6)), List.of(1,2,3,7,8,9),10);
        compareNumber.compareLotto();
        Assertions.assertEquals(List.of(1,0,0,0,0),compareNumber.getLottoResult());
    }

    @Test
    @DisplayName("4개 일치할 경우")
    void match4Numbers(){
        CompareNumber compareNumber = new CompareNumber(List.of(List.of(1,2,3,4,5,6)), List.of(1,2,3,4,7,8),10);
        compareNumber.compareLotto();
        Assertions.assertEquals(List.of(0,1,0,0,0),compareNumber.getLottoResult());
    }

    @Test
    @DisplayName("5개 일치할 경우")
    void match5Numbers(){
        CompareNumber compareNumber = new CompareNumber(List.of(List.of(1,2,3,4,5,6)), List.of(1,2,3,4,5,9),10);
        compareNumber.compareLotto();
        Assertions.assertEquals(List.of(0,0,1,0,0),compareNumber.getLottoResult());
    }

    @Test
    @DisplayName("5개와 보너스 숫자가 일치할 경우")
    void match5NumbersBonus(){
        CompareNumber compareNumber = new CompareNumber(List.of(List.of(1,2,3,4,5,6)), List.of(1,2,3,4,5,9),6);
        compareNumber.compareLotto();
        Assertions.assertEquals(List.of(0,0,0,1,0),compareNumber.getLottoResult());
    }

    @Test
    @DisplayName("6개 일치할 경우")
    void match6Numbers(){
        CompareNumber compareNumber = new CompareNumber(List.of(List.of(1,2,3,4,5,6)), List.of(1,2,3,4,5,6),10);
        compareNumber.compareLotto();
        Assertions.assertEquals(List.of(0,0,0,0,1),compareNumber.getLottoResult());

    }
}