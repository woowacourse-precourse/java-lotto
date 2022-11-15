package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumberGenerator {

    private static final List<Integer> lottoNumbers = IntStream.rangeClosed(1, 45)
            .mapToObj(Integer::new)
            .collect(toList());

    public Set<Integer> newLottoNumber() {
        List<Integer> newNumbers;
        Collections.shuffle(lottoNumbers);
        newNumbers = lottoNumbers.subList(0, 6);
        Collections.sort(newNumbers);

        return new HashSet<>(newNumbers);
    }

}