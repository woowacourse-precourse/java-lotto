package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class WinNumberReceiver {

    public static List<Integer> receiveWinNumber() {
        return Arrays.stream(readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}