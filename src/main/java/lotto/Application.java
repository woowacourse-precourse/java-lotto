package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Application {
    public static void main(String[] args) {
        start();
    }
    static void start() {
        int money;
        List<List<Integer>> lottototal = new ArrayList<>();
        List<Integer> winnum = new ArrayList<>();
        List<Integer> winstat = new ArrayList<>();
        int bonusnum;

        money = lottobuy();

        randomnum(money,lottototal);

        Enterwinningnumber(winnum);

        bonusnum = EnterBonusnumber();

        for(int i=0;i<lottototal.size();i++) {
            winningstats(lottototal.get(i),winnum,bonusnum,money,winstat);
        }
        last(winstat,money);
    }
    static int lottobuy() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = 0;
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력하세요.");
        }
        return money;
    }
    static void randomnum(int count,List<List<Integer>> lottototal) {
        count /= 1000;
        List<Integer> lottoinput = new ArrayList<>();
        System.out.println(count+"개를 구매했습니다.");
        for(int i=0;i<count;i++) {
            lottoinput = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottototal.add(lottoinput);
            System.out.println(lottoinput);
        }
    }

    static List<Integer> Enterwinningnumber (List<Integer> winnum) {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] inputnum = Console.readLine().split(",");
        for(int i=0;i<inputnum.length;i++) {
            winnum.add(Integer.parseInt(inputnum[i]));
        }
        new Lotto(winnum);

        return winnum;
    }
    static int EnterBonusnumber () {
        int bonusnum;
        System.out.println("\n보너스 번호를 입력해 주세요.");
        bonusnum = Integer.parseInt(Console.readLine());
        if(45 < bonusnum||bonusnum < 1) {
            throw new IllegalArgumentException("[ERROR] 범위가 잘못되었습니다.");
        }
        return bonusnum;
    }
    static void winningstats (List<Integer> lottotatal , List<Integer> winnum, int bonusnum,int money,List<Integer> winstat) {
        int pnt = 0;
        int bonuspnt = 0;
        for(int i=0;i<winnum.size();i++) {
            if(lottotatal.contains(winnum.get(i))) {
                pnt++;
            }
        }
        if(lottotatal.contains(bonusnum)) {
            bonuspnt++;
        }
        aaaa(pnt,bonusnum,winstat);
    }
    static void last(List<Integer> winstat,int money) {
            int[] num = new int[5];
            double lassdd= 0;
            for(int i=0;i<winstat.size();i++) {
                num[winstat.get(i)]++;
            }
            int total = (num[0]*5000)+(num[1]*50000)+(num[2]*1500000)+(num[3]*30000000)+(num[4]*2000000000);
            if(total<money) {
                lassdd = (double) (total*100)/money;
            }
            if(money<total) {
                lassdd = (double) (total/money)*100;
            }
            System.out.println("당첨 통계");
            System.out.println("---");
            System.out.println("3개 일치 (5,000원) - "+num[0]+"개");
            System.out.println("4개 일치 (50,000원) - "+num[1]+"개");
            System.out.println("5개 일치 (1,500,000원) - "+num[2]+"개");
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+num[3]+"개");
            System.out.println("6개 일치 (2,000,000,000원) - "+num[4]+"개");
            System.out.println("총 수익률은 "+lassdd+"%입니다.");
    }
    static void aaaa(int pnt,int bonus,List<Integer> winstat) {
        if(pnt==3) {
            winstat.add(0);
        }
        if(pnt==4) {
            winstat.add(1);
        }
        if(pnt==5) {
            if(bonus==1) {
                winstat.add(2);
            }
            winstat.add(3);
        }
        if(pnt==6) {
            winstat.add(4);
        }
        }
    }

