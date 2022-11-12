package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.service.UserService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    private static final int MIN_RANGE_NUMBER = 1;
    private static final int MAX_RANGE_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    UserService userService = new UserService();

    public List<List<Integer>> LottoComp(){ // 자동 생성한 로또 번호들 모음
        int count = 0;
        int lottoCount = userService.getUserLottoCount();

        List<List<Integer>> lottoComp = new ArrayList<>();

        while(count == lottoCount){
            List<Integer> lottoNumber = new ArrayList<>(Collections.emptyList());
            AutoLottoNumberToComp(lottoNumber, lottoComp);
            count++;
        }

        return lottoComp;
    }

    public List<Integer> LottoAutoGenerator(){ // 로또 번호를 자동 생성함
        List<Integer> lottoNumberList = new ArrayList<>(Collections.emptyList());
        lottoNumberList = Randoms.pickUniqueNumbersInRange(MIN_RANGE_NUMBER,MAX_RANGE_NUMBER,LOTTO_NUMBER_COUNT);
        return lottoNumberList;
    }

    public void AutoLottoNumberToComp(List<Integer> autoNumber, List<List<Integer>> NumberList){
        autoNumber = LottoAutoGenerator();
        System.out.println(autoNumber);
        Collections.sort(autoNumber);
        NumberList.add(autoNumber);
    }
}
