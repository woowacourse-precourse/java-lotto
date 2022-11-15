package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.util.Sets;

public class GenerateLotto {
    private final int lottoQuantity;
    private final List<List<Integer>> lottoNumberGroup = new ArrayList<>();
    private List<Integer> lottoNumbers;

    public GenerateLotto(int lottoQuantity) {
        this.lottoQuantity = lottoQuantity;
        generateLottoGroup();
    }

    private void generateLottoNumber() {
        List<Integer> numbers;
        Set<Integer> checkDuplication;
        do {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            checkDuplication = Sets.newHashSet(numbers);
        } while (numbers.size() != checkDuplication.size());

        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        this.lottoNumbers = sortedNumbers;
    }

    private void generateLottoGroup() {
        for (int i = 0; i < lottoQuantity; i++) {
            generateLottoNumber();
            this.lottoNumberGroup.add(this.lottoNumbers);
        }
    }

    public List<List<Integer>> getLottoNumbers() {
        return this.lottoNumberGroup;
    }
}
