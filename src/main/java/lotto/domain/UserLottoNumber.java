package lotto.domain;

import java.util.List;

public class UserLottoNumber {

    private final RandomLottoNumberGenerator randomLottoNumberGenerator;
    private List<List<Integer>> lottoNumbersList;

    public UserLottoNumber() {
        this.randomLottoNumberGenerator = new RandomLottoNumberGenerator();
    }

    public void generateRandomLottoNumbers(int count) {
        lottoNumbersList = randomLottoNumberGenerator.makeRandomLottoNumberList(count);
    }



}
