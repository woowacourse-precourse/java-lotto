package lotto;

import lotto.domain.Money;
import lotto.domain.Judgement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JudgementTest {
    @DisplayName("2등 확인 테스트")
    @Test
    void checkPlace2Test(){
        Set<Integer> winner = new HashSet<>();
        winner.add(1);
        winner.add(2);
        winner.add(3);
        winner.add(4);
        winner.add(5);
        winner.add(6);
        winner.add(7);
        Set<Integer> lotto = new HashSet<>();
        lotto.add(1);
        lotto.add(3);
        lotto.add(5);
        lotto.add(6);
        lotto.add(7);
        lotto.add(8);
        lotto.add(9);
        Judgement jud=new Judgement();
        Money money=new Money("0");
        String bonusNumber="7";
        assertThat(jud.checkPlaceWin(winner,lotto,bonusNumber,money)==2);
    }
    @DisplayName("3등 확인 테스트")
    @Test
    void checkPlace3Test(){
        Set<Integer> winner = new HashSet<>();
        winner.add(1);
        winner.add(2);
        winner.add(3);
        winner.add(4);
        winner.add(5);
        winner.add(6);
        winner.add(7);
        Set<Integer> lotto = new HashSet<>();
        lotto.add(1);
        lotto.add(3);
        lotto.add(5);
        lotto.add(6);
        lotto.add(2);
        lotto.add(8);
        lotto.add(9);
        Judgement jud=new Judgement();
        Money money=new Money("0");
        String bonusNumber="7";
        assertThat(jud.checkPlaceWin(winner,lotto,bonusNumber,money)==3);
    }
    @DisplayName("1등 확인 테스트")
    @Test
    void checkPlace1Test(){
        Set<Integer> winner = new HashSet<>();
        winner.add(1);
        winner.add(2);
        winner.add(3);
        winner.add(4);
        winner.add(5);
        winner.add(6);
        winner.add(7);
        Set<Integer> lotto = new HashSet<>();
        lotto.add(1);
        lotto.add(3);
        lotto.add(5);
        lotto.add(6);
        lotto.add(7);
        lotto.add(2);
        lotto.add(9);
        Judgement jud=new Judgement();
        String bonusNumber="7";
        Money money=new Money("0");
        assertThat(jud.checkPlaceWin(winner,lotto,bonusNumber,money)==1);
    }
    @DisplayName("미당첨 확인 테스트")
    @Test
    void checkPlace0Test(){
        Set<Integer> winner = new HashSet<>();
        winner.add(1);
        winner.add(2);
        winner.add(3);
        winner.add(4);
        winner.add(5);
        winner.add(6);
        winner.add(7);
        Set<Integer> lotto = new HashSet<>();
        lotto.add(1);
        lotto.add(2);
        lotto.add(8);
        lotto.add(9);
        lotto.add(10);
        lotto.add(11);
        lotto.add(12);
        Judgement jud=new Judgement();
        String bonusNumber="7";
        Money money=new Money("0");
        assertThat(jud.checkPlaceWin(winner,lotto,bonusNumber,money)==0);
    }

}