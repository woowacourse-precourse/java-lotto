package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoProcessorImpl implements LottoProcessor{

    private final LottoRepository lottoRepository = new LottoRepository();

    @Override
    public int matchLottoNumber(Lotto winLotto, Lotto lotto) {
        int equalCount = 0;
        for(Integer number: lotto.getNumbers()) {
            if (winLotto.getNumbers().contains(number)) {
                equalCount++;
            }
        }
        return equalCount;
    }

    @Override
    public Boolean matchBonusNumber(Integer bonusNumber, Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    @Override
    public List<Lotto> createLottoByCount(Integer count) {
        List<Lotto> clientLotto = new ArrayList<>();
        IntStream.range(0, count)
                .forEach(i -> clientLotto.add(lottoRepository.create(sortLottoNumbers(createRandomNumber()))));

        return clientLotto;
    }

    @Override
    public Lotto createLotto(List<Integer> lottoNumbers) {
        return lottoRepository.create(lottoNumbers);
    }

    private List<Integer> createRandomNumber(){
        return Randoms.pickUniqueNumbersInRange(LottoEnum.LOTTO.getMinNum(), LottoEnum.LOTTO.getMaxNum(), LottoEnum.LOTTO.getSize());
    }

    private List<Integer> sortLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
