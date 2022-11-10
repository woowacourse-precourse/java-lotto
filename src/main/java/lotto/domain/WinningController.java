package lotto.domain;

import lotto.Lotto;
import lotto.WinningLotto;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningController {
    static final int BonusNumberIndex = 7;
    static final int ZERO = 0;
    private Map<WinningStandard, Integer> lottoWinningResultMap = new EnumMap<>(WinningStandard.class);

    public void init(){
        WinningStandard[] standards = WinningStandard.values();
        for(WinningStandard standard : standards){
            lottoWinningResultMap.put(standard, ZERO);
        }
    }
    public int getWinMoney(Map<WinningStandard, Integer> winningResultMap){
        int winMoney = 0;
        for(WinningStandard winningStandard : winningResultMap.keySet()){
            Integer number = winningResultMap.get(winningStandard);
            int won = Integer.parseInt(winningStandard.getWon().replaceAll(",", ""));
            int money = won * number;
            winMoney += money;
        }
        return winMoney;
    }

    public Map<WinningStandard, Integer> calculateWinningLottos(List<Lotto> purchasedLottos, WinningLotto winningLotto){
        init();
        for(Lotto lotto : purchasedLottos){
            compare(lotto, winningLotto);
        }
        return lottoWinningResultMap;
    }

    public void compare(Lotto lotto, WinningLotto winningLotto){
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        final int bonusNumber = winningLottoNumbers.get(BonusNumberIndex-1);
        int correctNumbers = 0;
        boolean isCorrectBonusNumber = false;
        for(int number : lotto.getNumbers()){
            if(number == bonusNumber){
                isCorrectBonusNumber = true;
                continue;
            }
            if(winningLottoNumbers.contains(number)){
                correctNumbers++;
            }
        }
        calculateWinningLotto(correctNumbers,isCorrectBonusNumber);
    }

    public void calculateWinningLotto(int correctNumbers, boolean isCorrectBonusNumber){
        checkFirst(correctNumbers);
        checkSecond(correctNumbers,isCorrectBonusNumber);
        checkThird(correctNumbers,isCorrectBonusNumber);
        checkFourth(correctNumbers);
        checkFifth(correctNumbers);
    }

    private void checkFirst(int correctNumbers) {
        if(correctNumbers == WinningStandard.FIRST.getNumber()){
            lottoWinningResultMap.put(WinningStandard.FIRST, lottoWinningResultMap.getOrDefault(WinningStandard.FIRST, ZERO)+ 1);
        }
    }

    private void checkSecond(int correctNumbers, boolean isCorrectBonusNumber){
        if(correctNumbers == WinningStandard.SECOND.getNumber() && isCorrectBonusNumber == true){
            lottoWinningResultMap.put(WinningStandard.SECOND, lottoWinningResultMap.getOrDefault(WinningStandard.SECOND, ZERO)+ 1);
        }
    }

    private void checkThird(int correctNumbers, boolean isCorrectBonusNumber){
        if(correctNumbers == WinningStandard.THIRD.getNumber() && isCorrectBonusNumber == false){
            lottoWinningResultMap.put(WinningStandard.THIRD, lottoWinningResultMap.getOrDefault(WinningStandard.THIRD,0)+ 1);
        }
    }

    private void checkFourth(int correctNumbers) {
        if(correctNumbers == WinningStandard.FOURTH.getNumber()){
            lottoWinningResultMap.put(WinningStandard.FOURTH, lottoWinningResultMap.getOrDefault(WinningStandard.FOURTH,0)+ 1);
        }
    }

    private void checkFifth(int correctNumbers) {
        if(correctNumbers == WinningStandard.FIFTH.getNumber()){
            lottoWinningResultMap.put(WinningStandard.FIFTH, lottoWinningResultMap.getOrDefault(WinningStandard.FIFTH,0)+ 1);
        }
    }
}
