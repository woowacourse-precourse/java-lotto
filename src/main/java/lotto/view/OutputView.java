package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.dto.LottoDto;

public class OutputView {
    private static final char ARRAY_BEGIN = '[';
    private static final char ARRAY_END = ']';
    private static final String ARRAY_SEPARATOR = ", ";

    public void printIssuedLottos(LottoDto lottoDto) {
        System.out.println(lottoDto.getLottos().size() + "개를 구매했습니다.");
        for (List<Integer> lottoNumbers : lottoDto.getLottos()) {
            System.out.println(convertNumbersToStringArray(lottoNumbers));
        }
    }

    private String convertNumbersToStringArray(List<Integer> numbers) {
        return ARRAY_BEGIN + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(ARRAY_SEPARATOR)) + ARRAY_END;
    }
}
