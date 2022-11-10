package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class LottoInput {

    private String readLine() {
        return Console.readLine().trim();
    }

    int readInt() {
        return Integer.parseInt(readLine());
    }

    Lotto readLotto() {
        String[] lottoStrNumbers = readLine().split(",");
        List<Integer> lottoNumbers = Stream.of(lottoStrNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }
}
