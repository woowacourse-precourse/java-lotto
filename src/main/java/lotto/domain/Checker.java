package lotto.domain;

import lotto.dto.LottoResultDto;
import lotto.util.ResultPrice;

import java.util.List;
import java.util.Map;

import static lotto.util.ResultPrice.*;

public class Checker {
    private static final int MATCH_FIRST = 6;
    private static final int MATCH_SECOND_OR_THIRD = 5;
    private static final int MATCH_FOURTH = 4;
    private static final int MATCH_FIFTH = 3;
    private static final int INCREASE_NUMBER = 1;

    private final LottoResultDto lottoResultDto;

    private Map<ResultPrice, Integer> totalScore = Map.of(
            FIRST, 0,
            SECOND, 0,
            THIRD, 0,
            FOURTH, 0,
            FIFTH, 0
    );

    public Checker(LottoResultDto dto) {
        lottoResultDto = dto;
    }

    public Map<ResultPrice, Integer> getTotalScore() {
        return totalScore;
    }

    private void setResultScoreByLottoNumber(List<Integer> lotto) {
        long matchCount = getMatchNumberCount(lotto);

        if (matchCount == MATCH_FIRST) {
            setScoreCountByPlace(FIRST);
        }

        if (matchCount == MATCH_SECOND_OR_THIRD) {

            if (isContainBonusNumber(lotto)) {
                setScoreCountByPlace(SECOND);
                return;
            }

            setScoreCountByPlace(THIRD);
            return;
        }

        if (matchCount == MATCH_FOURTH) {
            setScoreCountByPlace(FOURTH);
        }

        if (matchCount == MATCH_FIFTH) {
            setScoreCountByPlace(FIFTH);
        }
    }

    private void setScoreCountByPlace(ResultPrice rate) {
        totalScore.merge(rate, INCREASE_NUMBER, Integer::sum);
    }

    private boolean isContainBonusNumber(List<Integer> lotto) {
        Integer bonusNumber = lottoResultDto.getBonusNumber();
        return lotto.contains(bonusNumber);
    }

    private long getMatchNumberCount(List<Integer> lotto) {
        List<Integer> basicNumbers = lottoResultDto.getBasicNumbers();

        return lotto.stream()
                .filter(basicNumbers::contains)
                .count();
    }

}