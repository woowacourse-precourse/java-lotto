package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class DataProcessing {
    public List<Integer> lottoRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }


    public List<Integer> sortLottoNumbers(List<Integer> randomNumbers) {
        List<Integer> sortNumbers = new ArrayList<>();
        sortNumbers.addAll(randomNumbers);
        Collections.sort(sortNumbers);
        return sortNumbers;
    }
    public List<List<Integer>> countCreateRandomNumbers(int count) {
        List<List<Integer>> boxNumbers = new ArrayList<>();
        for (int i=0;i<count;++i) {
            Lotto lotto = new Lotto(lottoRandomNumbers());
            boxNumbers.add(lotto.getNumbers());
        }
        return boxNumbers;
    }

    public int conversionMoney(String money) {
        ErrorUtil errorUtil = new ErrorUtil();
        int conversion = Integer.parseInt(money);
        errorUtil.errorInputMoney(conversion);
        return conversion;
    }

    public int countLotto(int money) {
        return money / 1000;
    }

    public String[] splitLottoNumber(String lottoNumbers) {
        ErrorUtil errorUtil = new ErrorUtil();
        String[] splitNumbers = lottoNumbers.split(",");
        errorUtil.errorInputLottoNumber(splitNumbers);
        errorUtil.errorInputCountLottoNumber(splitNumbers);
        return splitNumbers;
    }

    public List<Integer> lottoNumber(String lottoNumbers) {
        List<Integer> numbers = new ArrayList<>();
        ErrorUtil errorUtil = new ErrorUtil();
        String[] splitNumber = splitLottoNumber(lottoNumbers);
        for (int i=0;i<splitNumber.length;++i)
            numbers.add(Integer.parseInt(splitNumber[i]));
        errorUtil.errorOverlapLottoNumber(numbers);
        return numbers;
    }

    public  List<Integer> countWinLotto(List<Integer> lottoNumber, List<List<Integer>> boxRandomNumber,
                                        int count, int bonusNumber) {
        List<Integer> countWinLotto = new ArrayList<>();
        for (int i=0;i<count;++i)
            countWinLotto.add(winLotto(lottoNumber, boxRandomNumber.get(i), bonusNumber));
        return countWinLotto;
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

    public int[] resultWinLotto(List<Integer> countWin) {
        int[] resultLotto = {0, 0, 0, 0, 0};
        for (Integer integer : countWin) {
            if (integer == 6)
                resultLotto[4] += 1;
            else if (integer == 7)
                resultLotto[3] += 1;
            else if (integer == 5)
                resultLotto[2] += 1;
            else if (integer == 4)
                resultLotto[1] += 1;
            else if (integer == 3)
                resultLotto[0] += 1;
        }
        return resultLotto;
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