package lotto;

import java.util.Collections;
import java.util.List;

public class Printer {

    public void printUserLottoNumber(List<List<Integer>> lottoInput){

        int amountLotto = lottoInput.size();

        System.out.println(amountLotto + "개를 구매하셨습니다.");

        for(int i =0; i<amountLotto; i++){
            Collections.sort(lottoInput.get(i));
            System.out.println(lottoInput.get(i));
        }

    }

    public void printWinList(int correctNumber){


    }

    public void printRevenue(int correctNumber){

    }

}
