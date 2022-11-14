package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoManager {
    private final LottoGenerator lottoGenerator;
    private List<Integer> luckyNumbers = new ArrayList<>();
    private int bonusNumber = 0;
    private final Map<List<Integer>, String> prize = new HashMap<>();

    public LottoManager() {
        lottoGenerator = new LottoGenerator();
        prize.put(Arrays.asList(6, 0), "FIRST");
        prize.put(Arrays.asList(5, 1), "SECOND");
        prize.put(Arrays.asList(5, 0), "THIRD");
        prize.put(Arrays.asList(4, 0), "FOURTH");
        prize.put(Arrays.asList(4, 1), "FOURTH");
        prize.put(Arrays.asList(3, 0), "FIFTH");
        prize.put(Arrays.asList(3, 1), "FIFTH");
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

    public void inputBonusNumbers() {
        bonusNumber = Integer.parseInt(Console.readLine());
    }
}
