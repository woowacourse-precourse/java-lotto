package lotto.service;

import lotto.Lotto;
import lotto.PriceChecker;
import lotto.PrizeDetails;
import lotto.StringToIntegerMapper;
import lotto.reposiotory.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class PrizeSerivce {
    final Repository prizeRepository;

    public PrizeSerivce(Repository prizeRepository) {
        this.prizeRepository=prizeRepository;
    }

    public void savePrizeLotto(String userInput) {
        Lotto lotto = new Lotto(StringToIntegerMapper.toIntList(userInput, ","));
        lotto.setPriceDetails(PrizeDetails.SIX_PRIZE);

        prizeRepository.save(lotto);
    }

    static List<Integer> getPrizeList(List<PrizeDetails> prizeDetails) {
        return prizeDetails.stream().map(p -> p.getPrice()).collect(Collectors.toList());
    }

    public Lotto findPrizeLotto() {
        return prizeRepository.findAll().get(0);
    }

    public void valideBonusNumber(String bonusInput) {
        if(PriceChecker.hasBonusNumber(findPrizeLotto().getNumbers(),StringToIntegerMapper.toInt(bonusInput))){
            throw new IllegalArgumentException("당첨 번호와 중복된 보너스번호를 입력하지 말아주세요.");
        }
    }
}