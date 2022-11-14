package lotto.function;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static lotto.function.Tools.*;
import static lotto.function.Validation.*;

public class Start {

    public void run(){
        int price = howMuch();
        List<List<Integer>> Lotto = showLotto(price);
        List<Integer> winner = typeWinningNumber();
        int bonus = typeBonusNumber(winner);
        showStatistics(Lotto,winner,bonus);
    }

}
