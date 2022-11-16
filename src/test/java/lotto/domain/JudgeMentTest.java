package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JudgeMentTest {
    JudgeMent judgeMent = new JudgeMent();
    List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
    List<Integer> numbers1 = Arrays.asList(1,2,3,4,5,7);
    Lotto lotto = new Lotto(numbers);
    Lotto lotto1 = new Lotto(numbers1);
    WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6",7);
    @BeforeEach
    void before(){
        judgeMent = new JudgeMent();
        numbers = Arrays.asList(1,2,3,4,5,6);
    }

    @Test
    void compareNumbers() {
        int i = judgeMent.compareNumbers(winningNumber.getNumbers(),numbers);
        assertTrue(i==6);
        i = judgeMent.compareNumbers(winningNumber.getNumbers(),numbers1);
        assertTrue(i==5);
    }

    @Test
    void getCorrectResult() {
    }

    @Test
    void getReward() {
        Reward reward = judgeMent.getReward(numbers,winningNumber);
        assertTrue(reward.getBIll() == Reward.SIX.getBIll());
        reward = judgeMent.getReward(numbers1,winningNumber);
        System.out.println(reward.getBIll());
        assertTrue(reward.getBIll() == Reward.FIVE_BONUS.getBIll());
    }

    @Test
    void map_투입_여부_확인() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);
        lottos.add(lotto1);
    }

    @Test
    void Reward_확인(){
        Reward reward = judgeMent.checkReward(numbers,winningNumber,6);
        assertTrue(reward.getBIll()==Reward.SIX.getBIll());
        reward = judgeMent.checkReward(numbers1,winningNumber,5);
        assertTrue(reward.getBIll()==Reward.FIVE_BONUS.getBIll());
    }
}