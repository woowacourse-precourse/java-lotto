package lotto;

import java.util.ArrayList;
import java.util.List;

public class PrintLotto {

    public void issuance(int cnt) {
        MakeLottoNumber makeLottoNumber = new MakeLottoNumber();
        List<List<Integer>> lottoList = new ArrayList<>();

        System.out.println(cnt+"개를 구매했습니다.");
        for(int i=0; i<cnt; i++){
            lottoList.add(makeLottoNumber.returnLottoNumber());
            System.out.println(lottoList.get(i));
        }

    }
}
