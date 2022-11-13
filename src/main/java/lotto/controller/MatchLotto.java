package lotto.controller;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatchLotto {

    public static List<Integer> splitTargetLotto(String targetInput) {
        List<String> targetNumber = Arrays.asList(targetInput.split(","));
        List<Integer> targetLotto = targetNumber.stream().map(Integer::parseInt).collect(Collectors.toList());

        return targetLotto;
    }
}
