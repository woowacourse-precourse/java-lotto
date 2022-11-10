package system.process;

import models.WinningLottoData;

import java.util.List;

public class WinningLotto {

    private WinningLottoData winningLottoData;

    public WinningLotto(){
        this.winningLottoData = createWinningLottoData();
    }

    private WinningLottoData createWinningLottoData(){

        List<Integer> lottoNumbers = inputSixLottoNumbers();
        int bonusNumber = inputBonusNumber();

        return new WinningLottoData(lottoNumbers,bonusNumber);

    }



}
