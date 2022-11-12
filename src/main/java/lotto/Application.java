package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.error.OptionalDoubleShouldHaveValueCloseToOffset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Application {

    static List<Lotto> Lottos = new ArrayList<>();

    public static void main(String[] args) {
        try {
            int many = takeCost();
            for (int i = 0; i < many; i++) {
                Lottos.add(new Lotto(getLotto()));
                Lottos.get(i).printLotto();
            }
            Lotto answer = createAnswer();
            int bonus = createBonus();
            List<Integer> prize = Winnig(winALottery(answer, Lottos, bonus));
            printCount(prize);
            System.out.println("총 수익률은 "+rate(many,prize)/10+"."+rate(many,prize)%10+"%입니다.");
        }catch (IOException e){
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public static Integer takeCost() throws IOException {
        System.out.println("구매 금액을 입력하세요");
        String cost = Console.readLine();

        if(cost == null){
            throw new IllegalArgumentException("[ERROR]");
        }

        int temp = 0;
        try {
            temp = Integer.parseInt(cost);
        }catch (NumberFormatException e){
            System.out.println("[ERROR]1");
        }

        if(temp%1000 != 0)
            throw new IllegalArgumentException("[ERROR]");

        temp = temp / 1000;
        System.out.println(temp+"개를 구매했습니다.");

        return temp;
    }

    public static void CostRight(int cost) {
        if (cost % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 입력 금액 오류");
    }

    public static Lotto createAnswer() throws IOException {
        List<String> answer = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");

        String answerN = Console.readLine();

        if(answerN != null)
            answer = List.of(answerN.split(","));

        System.out.println(answer);
        List<Integer> temp = new ArrayList<>();


        if(answer.stream().distinct().count() != answer.size())
            throw new IllegalArgumentException("[ERROR] 겹치는 번호 입력");

        for(int i =0; i<6; i++){
            temp.add(Integer.valueOf(answer.get(i)));
        }

        System.out.println(temp);

        return new Lotto(temp);
    }


    public static int createBonus() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String bonus = Console.readLine();

        return Integer.parseInt(bonus);
    }

    public static List<Integer> getLotto(){
        List<Integer> MyLotto = Randoms.pickUniqueNumbersInRange(1,45,6);

        return MyLotto;
    }

    public static List<Integer> winALottery(Lotto answer, List<Lotto> MyLotto, Integer bouns)throws IOException{
        List<Integer> winnig = new ArrayList<>();
        for(int i = 0; i < MyLotto.size(); i++){
            int Howmany = MyLotto.get(i).compareLotto(answer,bouns);
            winnig.add(Howmany);
        }
        return winnig;
    }

    public static List<Integer> Winnig(List winning) throws IOException {
        List<Integer> count = new ArrayList<>();

        int first = 0,second=0,third=0,fourth=0,fifth = 0;

        for(int i = 0; i<winning.size();i++){
            if(winning.get(i).equals(6)) first++;
            else if(winning.get(i).equals(7)) second++;
            else if (winning.get(i).equals(5)) third++;
            else if (winning.get(i).equals(4)) fourth++;
            else if (winning.get(i).equals(3)) fifth++;
        }
        count.add(fifth); count.add(fourth); count.add(third); count.add(second);count.add(first);

        return count;
    }


    public static void printCount(List Winning) throws IOException {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+Winning.get(0)+"개");
        System.out.println("4개 일치 (50,000원) - "+Winning.get(1)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+Winning.get(2)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+Winning.get(3)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+Winning.get(4)+"개");
    }

    public static Integer rate(Integer takeCost,List Winnng){
       int allAdd = 2000000000 * (int)Winnng.get(4) + 30000000*(int)Winnng.get(3) + 1500000*(int)Winnng.get(2) + 50000*(int) Winnng.get(1)+ 5000*(int) Winnng.get(0);
       int rate = allAdd*10 / takeCost;

       if(rate%10 >= 5)
           return rate/10 +1;

       return rate/10;
    }
}
