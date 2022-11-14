package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoManager {
    private final LottoGenerator lottoGenerator;
    private List<Integer> luckyNumbers = new ArrayList<>();

    public LottoManager() {
        lottoGenerator = new LottoGenerator();
    }

    public List<Lotto> createLottos(int count) {
        Lotto lotto;
        List<Integer> lottoNumbers;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoNumbers = lottoGenerator.createLottoNumbers();
            lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    public void inputLuckyNumbers() {
        String inputNumbers = Console.readLine();
        luckyNumbers = Stream.of(inputNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
