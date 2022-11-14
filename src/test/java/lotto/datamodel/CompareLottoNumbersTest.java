package lotto.datamodel;

import lotto.datamodel.CompareLottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CompareLottoNumbersTest {
    CompareLottoNumbers compare = new CompareLottoNumbers(List.of(5,8,14,23,35,37), 10);
    @Test
    void countSameLottoNumber() {
        List<Integer> result = compare.calculator(6, List.of(List.of(1,2,3,4,5,6),
                                                                        List.of(5,8,14,22,26,30),
                                                                        List.of(5,8,14,23,26,30),
                                                                        List.of(12,18,33,39,40,44),
                                                                        List.of(4,9,19,29,39,43),
                                                                        List.of(7,15,17,24,26,31)));
        System.out.println(result);
    }
}
