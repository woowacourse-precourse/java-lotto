package lotto;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

/*
 * 무작위의 Lotto 번호를 생성, 저장하는 클래스
 */
public class LottoMachine{

    private List<Integer> createLottoNum()
    {
        List<Integer> lottoNumber = new ArrayList<Integer>();
        for(int i = 0; i < 6; i++)
        {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumber = numbers;
        }
        return lottoNumber;
    }

    public List<List<Integer>> getLottoNum(int numOfLotto)
    {
        List<List<Integer>> lottoNumbers = new ArrayList<List<Integer>>();
        for(int i = 0; i < numOfLotto; i++)
        {
            lottoNumbers.add(createLottoNum());
        }
        return lottoNumbers;
    }

}