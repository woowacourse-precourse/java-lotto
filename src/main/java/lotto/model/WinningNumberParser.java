package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static lotto.controller.LottoSystem.LOTTO_NUM_COUNT;

public class WinningNumberParser {
    public List<Integer> parse(String input) throws IllegalArgumentException {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력이 쉼표로 끝났습니다.");
        }
        List<String> slices = List.of(input.split(","));
        if (slices.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] 번호 개수가 %d개가 아닙니다.", LOTTO_NUM_COUNT));
        }
        validateSlices(slices);
        return slices.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
    }

    private void validateSlices(List<String> slices) {
        SingleLottoNumValidator singleLottoNumValidator = new SingleLottoNumValidator();
        Set<String> set = new HashSet<>();
        for (String slice : slices) {
            if (set.contains(slice)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
            }
            singleLottoNumValidator.validate(slice);
            set.add(slice);
        }
    }
}
