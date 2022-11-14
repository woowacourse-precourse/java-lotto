package lotto.domain;

import lotto.dto.LottoResultDto;
import lotto.util.ResultPrice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.util.ResultPrice.*;

public class Checker {
    private static final int SECOND_OR_THIRD = 5;
    private static final int INCREASE_NUMBER = 1;

    private final LottoResultDto lottoResultDto;
    private Map<ResultPrice, Integer> totalScore = new HashMap<>() {{
        Arrays.stream(ResultPrice.values())
                .forEach(price -> put(price, 0));
    }};

    public Checker(LottoResultDto lottoResult) {
        lottoResultDto = lottoResult;
    }

    public Map<ResultPrice, Integer> getTotalScore(List<Lotto> lottoGroup) {
        setResultScoreByLottoGroup(lottoGroup);
        return totalScore;
    }

    private void setResultScoreByLottoGroup(List<Lotto> lottoGroup) {
        lottoGroup.forEach(this::setResultScoreByLotto);
    }

    private void setResultScoreByLotto(Lotto lotto) {
        long matchCount = getMatchedNumberCount(lotto);
        if (matchCount == SECOND_OR_THIRD) {
            setSecondOrThird(lotto);
            return;
        }

        for (ResultPrice price : values()) {
            if (matchCount == price.getMatch_count()) {
                setScoreCountByPlace(price);
            }
        }
    }

    private long getMatchedNumberCount(Lotto lotto) {
        List<Integer> basicNumbers = lottoResultDto.getBasicNumbers();
        List<Integer> lottoNumbers = lotto.getLotto();

        return lottoNumbers.stream()
                .filter(basicNumbers::contains)
                .count();
    }

    private void setScoreCountByPlace(ResultPrice place) {
        totalScore.merge(place, INCREASE_NUMBER, Integer::sum);
    }

    private void setSecondOrThird(Lotto lotto) {
        if (isContainBonusNumber(lotto)) {
            setScoreCountByPlace(SECOND);
            return;
        }
        setScoreCountByPlace(THIRD);
    }

    private boolean isContainBonusNumber(Lotto lotto) {
        Integer bonusNumber = lottoResultDto.getBonusNumber();
        List<Integer> lottoNumbers = lotto.getLotto();

        return lottoNumbers.contains(bonusNumber);
    }

}