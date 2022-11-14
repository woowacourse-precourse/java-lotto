package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.enumeration.Rating;

import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;

public class Output {

    public void printNumberOfLotto(int lottoQuantity){
        System.out.println(lottoQuantity + "개를 구매했습니다.");
    }


    public void printLottoNumbers(List<Lotto> lottoNumbers){
        for(Lotto lotto : lottoNumbers){
            System.out.println(lotto);
        }
    }

    public void printStatisticsMessage(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

}
