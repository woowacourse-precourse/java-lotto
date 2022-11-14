package lotto;

import java.util.ArrayList;

public class CompareLotto {
    public static ArrayList<Integer> comparelotto(ArrayList<ArrayList<Integer>> total, String[] lottolst, int bonus){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<total.size();i++){
            int cnt=0;
            for(int j=0;j<6;j++) {
                if (total.get(i).contains(Integer.parseInt(lottolst[j]))){
                    cnt+=1;
                }
            }
            System.out.println(cnt);
            //보너스 번호 확인
            if(cnt==5){
                if (total.get(i).contains(bonus)){
                    result.add(7,result.get(7)+1);

                }
            }else{
            result.add(cnt,result.get(cnt)+1);}
        }
        return result;
    }
}
