package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.DB.LottoData;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {
    LottoData lottoData = new LottoData();

    public void setLottoCount(int price){
        lottoData.setCountOfLotto(price);
    }

    public void makeLottoNumber(){
        List<Lotto> lottoList = new ArrayList<Lotto>();
        for(int i = 0; i < lottoData.getCountOfLotto(); i++){
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumber);
            lottoList.add(lotto);
        }
        lottoData.setLottoList(lottoList);
    }

    public int countOfLotto(){
        return lottoData.getCountOfLotto();
    }

    public List<List<Integer>> listOfLotto(){
        List<Lotto> lottoList = lottoData.getLottoList();
        List<List<Integer>> lottoNumber = new ArrayList<List<Integer>>();
        for(Lotto lotto : lottoList){
            lottoNumber.add(lotto.getLottoNumber());
        }
        return lottoNumber;
    }
}
