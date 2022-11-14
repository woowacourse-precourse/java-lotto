package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

public class LottoAndUserNumberDto {

    private List<Lotto> guessNumberSet;

    private List<Integer> lottoNumber;

    private Integer bonusNumber;

    private Integer purchaseCost;

    public LottoAndUserNumberDto(List<Lotto> guessNumberSet, List<Integer> lottoNumber, Integer bonusNumber, Integer purchaseCost) {
        this.guessNumberSet = guessNumberSet;
        this.lottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
        this.purchaseCost = purchaseCost;
    }

    public Integer getPurchaseCost() {
        return purchaseCost;
    }

    public List<Lotto> getGuessNumberSet() {
        return guessNumberSet;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
