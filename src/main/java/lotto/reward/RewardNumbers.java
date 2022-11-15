package lotto.reward;

import lotto.utils.LottoNumberException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RewardNumbers implements NumberStrategy {

    private static final String COMMA = ",";
    private static final int COUNT = 6;

    private final List<Numbers> lottoNumbers;

    public RewardNumbers(String input) {
        //checkNull(input);

        List<Numbers> inputNumbers = inputToRewardNumbers(input);
        //checkNumbers(inputNumbers);
        lottoNumbers = new ArrayList<>(inputNumbers);
    }

    @Override
    public List<Numbers> getLottoNumbers() {
        return null;
    }

    private List<Numbers> inputToRewardNumbers(String input) {
        return Arrays.stream(input.split(COMMA))
                .map(str -> Numbers.of(str))
                .collect(Collectors.toList());
    }

    private void checkNumbers(List<Numbers> inputNumbers) {
        if (inputNumbers.size() != COUNT) {
            throw new LottoNumberException();
        }
        if (inputNumbers.stream().distinct().count() != COUNT) {
            throw new LottoNumberException();
        }
    }
}
