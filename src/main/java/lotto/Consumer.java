package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Consumer {
    private List<Integer> winning() {
        List<Integer> lottonumbers = Arrays.asList(Console.readLine().split(","))
                .stream()
                .map((s -> Integer.parseInt(s.trim())))
                .collect(Collectors.toList());

        return lottonumbers;
    }
}
