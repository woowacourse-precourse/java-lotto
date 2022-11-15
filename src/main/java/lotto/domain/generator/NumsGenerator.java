package lotto.domain.generator;

import lotto.domain.lotto.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumsGenerator {
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 6;

    public static List<LottoNumber> RandomNumber(){
        final List<LottoNumber> lottoNumbers = new ArrayList<>(LottoNumber.getCache().values());

        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(START_INDEX, END_INDEX);
    }

    public static List<LottoNumber> generate(final List<Integer> lottoNums){
        return lottoNums.stream()
                .map(LottoNumber::getInstance)
                .sorted()
                .collect(Collectors.toList());
    }
}
