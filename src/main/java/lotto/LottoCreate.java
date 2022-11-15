package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoCreate {

    private List<Integer> lottoNumbers;

    public LottoCreate() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().collect(Collectors.toList());
    }

    public LottoCreate(List<Integer> numbers){
        this.lottoNumbers = numbers;
        validate();

    }

    public void validate(){
        if(this.lottoNumbers.size() !=6)
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER_ERROR);
        if(this.lottoNumbers.stream().anyMatch(i -> (i < 0 || i > 45)))
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER_BOUND_ERROR);
        if(this.lottoNumbers.stream().anyMatch((i) -> this.lottoNumbers.stream().filter((j) -> Objects.equals(i, j)).count() != 1L))
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER_REPETITION_ERROR);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
