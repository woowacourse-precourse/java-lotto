package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public  List<List<Integer>> LottoComp(){ // 자동 생성한 로또 번호들 모음
        int count = 0;
        int lottoCount = User.getUserLottoCount();

        List<List<Integer>> lottoComp = new ArrayList<>();

        while(count == lottoCount){
            List<Integer> lottoNumber = new ArrayList<>(Collections.emptyList());
            AutoLottoNumberToComp(lottoNumber, lottoComp);
            count++;
        }

        return lottoComp;
    }

    public  List<Integer> LottoAutoGenerator(){ // 로또 번호를 자동 생성함
        List<Integer> lottoNumberList = new ArrayList<>(Collections.emptyList());
        lottoNumberList = Randoms.pickUniqueNumbersInRange(1,45,6);
        return lottoNumberList;
    }

    public void AutoLottoNumberToComp(List<Integer> autoNumber, List<List<Integer>> NumberList){
        autoNumber = LottoAutoGenerator();
        System.out.println(autoNumber);
        Collections.sort(autoNumber);
        NumberList.add(autoNumber);
    }
}
