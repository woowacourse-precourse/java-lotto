package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public int winLotto(List<Integer> lottoNumber, List<Integer> randomNumber) {
        int win = 0;
        for (int i=0;i<randomNumber.size();++i) {
            lottoNumber.add(randomNumber.get(i));
        }
        win = (int) (6 - (lottoNumber.size() - lottoNumber.stream().distinct().count()));
        return win;
    }
}