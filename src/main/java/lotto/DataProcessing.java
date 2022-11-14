package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class DataProcessing {
    public List<Integer> lottoRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }


    public List<Integer> sortLottoNumbers(List<Integer> randomNumbers) {
        List<Integer> sortNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(sortNumbers);
        return sortNumbers;
    }

    public int conversionMoney(String money) {
        ErrorUtil errorUtil = new ErrorUtil();
        int conversion = Integer.parseInt(money);
        errorUtil.errorInputMoney(conversion);
        return conversion;
    }

    public String[] splitLottoNumber(String lottoNumbers) {
        ErrorUtil errorUtil = new ErrorUtil();
        String[] splitNumbers = lottoNumbers.split(",");
        errorUtil.errorInputLottoNumber(splitNumbers);
        errorUtil.errorInputCountLottoNumber(splitNumbers);
        return splitNumbers;
    }
    public boolean secondWin(List<Integer> randomNumber, int bonusNumber) {
        return randomNumber.contains(bonusNumber);
    }
    public int winLotto(List<Integer> lottoNumber, List<Integer> randomNumber, int bonusNumber) {
        int win;
        Set<Integer> countWin = new HashSet<>(lottoNumber);
        countWin.retainAll(randomNumber);
        win = countWin.size();
        if (win == 5 && secondWin(randomNumber, bonusNumber))
            win = 7;
        return win;
    }

    public int totalMoney(int[] resultWin) {
        int result = 0;
        int[] winMoney = {5000, 50000, 1500000, 30000000, 2000000000};
        for (int i=0;i<resultWin.length;++i)
            result += winMoney[i] * resultWin[i];
        return result;
    }

    public float totalReturn(int countLotto, int[] resultWin) {
        float principal = countLotto * 1000;
        float resultMoney = totalMoney(resultWin);
        return (resultMoney * 100) / principal;
    }
}