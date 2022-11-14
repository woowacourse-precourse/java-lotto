package lotto;

import java.util.ArrayList;

public class CompareLotto {
    public static void comparelotto(ArrayList<ArrayList<Integer>> total,String[] lottolst,int bonus){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<total.size();i++){
            int cnt=0;
            for(int j=0;j<6;j++) {
                if (total.get(i).contains(Integer.parseInt(lottolst[j]))){
                    cnt+=1;
                }
            }
            System.out.println(cnt);
            result.add(cnt);
        }

    }
}
