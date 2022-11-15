package lotto.service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import lotto.business.model.Lotto;
import lotto.business.model.LottoAnswer;
import lotto.business.model.LottoEnum;
import lotto.business.model.ResultEnum;

public class CalculateLotto {
    private final static int INIT_VALUES = 0;
    private final static int ADD_AMOUNT = 1;
    public EnumMap<ResultEnum, Integer> calculateResult(List<Lotto> lottos, LottoAnswer lottoAnswer) {
        EnumMap<ResultEnum, Integer> result = new EnumMap<>(ResultEnum.class);
        initEnumMap(result);
        List<Integer> answerNumbers = new ArrayList<>(lottoAnswer.getLottoNumber());
        Integer bonusNumber = lottoAnswer.getBonusNumber();

        for (Lotto lotto : lottos) {
            calcLotto(result, answerNumbers, bonusNumber, lotto);
        }

        return result;
    }

    private void initEnumMap(EnumMap<ResultEnum, Integer> result) {
        for (ResultEnum resultEnum : ResultEnum.values()) {
            result.put(resultEnum, INIT_VALUES);
        }
    }

    private void calcLotto(EnumMap<ResultEnum, Integer> result,
                           List<Integer> answerNumber, Integer bonusNumber, Lotto lotto) {
        List<Integer> numbers = new ArrayList<>(lotto.getLottoNumber());
        Integer hitAmount = calcHitAmount(numbers, answerNumber);
        Boolean bonusHit = isBonusHit(hitAmount, numbers, bonusNumber);
        referenceEnum(result, hitAmount, bonusHit);
    }

    private Integer calcHitAmount(List<Integer> numbers, List<Integer> answerNumber) {
        numbers.removeAll(answerNumber);
        return LottoEnum.SIZE.getValue() - numbers.size();
    }

    private Boolean isBonusHit(Integer hitAmount, List<Integer> numbers, Integer bonusNumber) {
        if (Objects.equals(hitAmount, ResultEnum.HIT_5.getHitAmount())) {
            return numbers.contains(bonusNumber);
        }

        return false;
    }

    private void referenceEnum(EnumMap<ResultEnum, Integer> result, Integer hitAmount, Boolean bonusHit) {
        for (ResultEnum resultEnum : result.keySet()) {
            boolean amountFlag = Objects.equals(resultEnum.getHitAmount(), hitAmount);
            boolean bonusFlag = Objects.equals(resultEnum.getIsBonusHit(), bonusHit);
            putToMap(result, resultEnum, amountFlag, bonusFlag);
        }
    }

    private void putToMap(EnumMap<ResultEnum, Integer> result, ResultEnum resultEnum, boolean amountFlag,
                          boolean bonusFlag) {
        if (amountFlag && bonusFlag) {
            result.put(resultEnum, result.get(resultEnum) + ADD_AMOUNT);
        }
    }

    public Double calculateROI(Integer purchasePrice, EnumMap<ResultEnum, Integer> result) {
        int sumOfReward = INIT_VALUES;
        for (ResultEnum resultEnum : result.keySet()) {
            sumOfReward += resultEnum.getRewardAmount() * result.get(resultEnum);
        }

        return (((double) sumOfReward / (double) purchasePrice) * 100);
    }


}
