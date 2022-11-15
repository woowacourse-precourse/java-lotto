package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import net.bytebuddy.implementation.bytecode.Throw;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Application {


    private static int inputCheck(String user_Input){
        try{
            int user_price = 0;
            for(int i=0;i<user_Input.length();i++){
                if((9<user_Input.charAt(i)-'0'&&user_Input.charAt(i)-'0'>0)){
                    throw new IllegalArgumentException();
                }
            }

            user_price=Integer.parseInt(user_Input);
            if(user_price<1000||user_price%1000!=0){
                throw new IllegalArgumentException();
            }
            return user_price;
        }catch( IllegalArgumentException e){
            System.out.println("[ERROR] !!");;
        }
       return 0;
    }


    private static List<Integer> makeRlotto(String lucky_lotto){
        String[] split_lotto = lucky_lotto.split(",");
        List<Integer> lotto1 = new ArrayList<>();
        for (int i = 0; i < split_lotto.length; i++) {
            lotto1.add(Integer.parseInt(split_lotto[i]));
        }
        return  lotto1;
    }
    private static HashMap<Integer,Integer> hash(HashMap<Integer,Integer> map){
        map.put(3,5000);
        map.put(4,50000);
        map.put(5,1500000);
        map.put(-1,30000000);
        map.put(6,2000000000);
        return  map;
    }
    private static double calculate(HashMap<Integer,Integer>map ,User user){
        int price = 0;
        for(int i=3;i<=6;i++){
            price+=map.get(i)*Collections.frequency(user.getCount(),i);
        }
        if(Collections.frequency(user.getCount(),-1)!=0)price+=map.get(-1)*Collections.frequency(user.getCount(),-1);

        double yield = (double) price/(double) user.getUser_price()*100;
        return  yield;
    }
    private static double calculate2(User user){
        int price = 0;
        for(Mathing mc : Mathing.values()){
            price += mc.getPrice()*Collections.frequency(user.getCount(),mc.getNum());
        }
        double yield = (double) price/(double) user.getUser_price()*100;
        return  yield;
    }
    public static void main(String[] args) {
        Print print = new Print();
        Print.pricePrint();
        User user = new User(inputCheck(camp.nextstep.edu.missionutils.Console.readLine()));
        user.setLotto_num(user.getUser_price() / 1000);
        Print.numPrint(user);
        //user.putMyLotto();
        Print.myLottoPrint(user.getMy_lotto());
        Print.lottoPrint();
        Lotto lotto = new Lotto(makeRlotto(camp.nextstep.edu.missionutils.Console.readLine()));
        System.out.println(lotto.getNumbers().toString());
        Print.bonusPrint();
        int bonus_num = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        user.countMyLotto(user,bonus_num,lotto);
        Print.winningsPrint(user.getCount());
        HashMap<Integer,Integer> map = new HashMap<>();
        map = hash(map);
        //Print.yieldPrint(calculate(map,user));
        Print.yieldPrint(calculate2(user));
    }
}
