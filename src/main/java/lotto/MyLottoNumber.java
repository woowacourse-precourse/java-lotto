package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class MyLottoNumber {
    private ArrayList<ArrayList<Integer>> numbers=new ArrayList<>();
    public MyLottoNumber(int money){
        int lottoCount=money/1000;
        makeLotto(lottoCount);
    }
    private void makeLotto(int lottoCount){
        for(int i=0;i<lottoCount;i++){
            List<Integer> LottoNumbers= Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.add(sortLottoNumbers(LottoNumbers));
        }
    }
    private ArrayList<Integer> sortLottoNumbers(List<Integer> numbers){
        ArrayList<Integer> ans=new ArrayList();
        for(int num:numbers) ans.add(num);
        Collections.sort(ans);
        return ans;
    }
    public void CountMyLottoNumber(){
        System.out.println(this.numbers.size()+"개를 구매했습니다.");
        for(List list:numbers) System.out.println(list);
        System.out.println();
    }
    public ArrayList<ArrayList<Integer>> getNumbers(){
        return this.numbers;
    }
}
