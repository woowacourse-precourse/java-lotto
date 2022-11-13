package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class DataProcessing {
    public List<Integer> lottoRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> sortLottoNumbers(List<Integer> sortNumbers) {
        Collections.sort(sortNumbers);
        return sortNumbers;
    }

    public List<List<Integer>> countCreateRandomNumbers(int count) {
        List<List<Integer>> boxNumbers = new ArrayList<>();
        for (int i=0;i<count;++i) {
            boxNumbers.add(sortLottoNumbers(lottoRandomNumbers()));
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

    public  List<Integer> countWinLotto(List<Integer> lottoNumber, List<List<Integer>> boxRandomNumber, int count) {
        List<Integer> countWinLotto = new ArrayList<>();
        for (int i=0;i<count;++i)
            countWinLotto.add(winLotto(lottoNumber, boxRandomNumber.get(i)));
        return countWinLotto;
    }
    public int winLotto(List<Integer> lottoNumber, List<Integer> randomNumber) {
        int win;
        Set<Integer> countWin = new HashSet<>(lottoNumber);
        countWin.retainAll(randomNumber);
        win = countWin.size();
        return win;
    }
}