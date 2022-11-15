package domain;

import controller.Controller;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.ResultMessage;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    private static Controller controller;

    @BeforeAll
    private static void init() {
        controller = new Controller();
    }

    @DisplayName("winningResult Key 값들이 ResultMessage enum 의 includeCount 값으로 됫는지 확인한다. ")
    @Test
    void createWinningResultSkeleton() {
        List<Lotto> totalNumbers = controller.createTotalNumbers(7);
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusWinning = 7;
        HashSet<String> resultSkeleton = new HashSet<>();
        for(ResultMessage rank : ResultMessage.values())
            resultSkeleton.add(rank.getIncludeCount());
        assertEquals(controller.createWinningResult(totalNumbers,winningNumbers,bonusWinning).keySet(), resultSkeleton);
    }
    @DisplayName("createWinningResult가 제대로 작동하는지 확인한다.")
    @Test
    void createWinningResult() {
        List<Lotto> totalNumbers = new ArrayList<>();
        totalNumbers.add(new Lotto(List.of(13,20,30,40,7,8)));
        totalNumbers.add(new Lotto(List.of(12,11,7,8,9,10)));
        totalNumbers.add(new Lotto(List.of(22,23,24,25,26,27)));
        totalNumbers.add(new Lotto(List.of(1,2,8,35,27,18)));
        totalNumbers.add(new Lotto(List.of(13,17,43,44,38,28)));
        totalNumbers.add(new Lotto(List.of(1,2,3,4,5,6)));
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusWinning = 7;
        HashMap<String,Integer> trueResult = new HashMap<>();
        trueResult.put("3",0);
        trueResult.put("4",0);
        trueResult.put("5",0);
        trueResult.put("Bonus",0);
        trueResult.put("6",1);
        assertEquals(controller.createWinningResult(totalNumbers,winningNumbers,bonusWinning), trueResult);
    }

}