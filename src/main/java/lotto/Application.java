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
            Winnig(winALottery(answer, Lottos, bonus));
            printCount();
            System.out.println("총 수익률은 "+rate(many)/10+"."+rate(many)%10+"%입니다.");
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
            System.out.println("[ERROR]");
        }

        if(temp%1000 != 0)
            throw new IllegalArgumentException("[ERROR]");

        temp = temp / 1000;
        System.out.println(temp+"개를 구매했습니다.");

        return temp;
    }

    public static Lotto createAnswer() throws IOException {
        List<String> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        System.out.println("당첨 번호를 입력해 주세요.");

        String answerN = Console.readLine();

        if(answerN != null)
            answer = List.of(answerN.split(","));

        if(answer.stream().distinct().count() != answer.size())
            throw new IllegalArgumentException("[ERROR] 겹치는 번호 입력");

        System.out.println(answer);

        for(int i =0; i<6; i++){
            temp.add(Integer.valueOf(answer.get(i)));
        }

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

    public enum Rank{
        first("6개 일치 (2,000,000,000원) - ",0),
        second("5개 일치, 보너스 볼 일치 (30,000,000원) - ",0),
        third("5개 일치 (1,500,000원) - ",0),
        fourth("4개 일치 (50,000원) - ",0),
        fifth("3개 일치 (5,000원) - ",0);

        private final String ment;
        private Integer count;
        Rank(String ment, Integer count){
            this.ment = ment;
            this.count = count;
        }
    }

    public static void Winnig(List winning) throws IOException {
        for(int i = 0; i<winning.size();i++){
            if(winning.get(i).equals(6)) Rank.first.count++;
            else if(winning.get(i).equals(7)) Rank.second.count++;
            else if (winning.get(i).equals(5)) Rank.third.count++;
            else if (winning.get(i).equals(4)) Rank.fourth.count++;
            else if (winning.get(i).equals(3)) Rank.fifth.count++;
        }
    }

    public static void printCount() throws IOException {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Rank.fifth.ment+Rank.fifth.count+"개");
        System.out.println(Rank.fourth.ment+Rank.fourth.count+"개");
        System.out.println(Rank.third.ment+Rank.third.count+"개");
        System.out.println(Rank.second.ment+Rank.second.count+"개");
        System.out.println(Rank.first.ment+Rank.first.count+"개");
    }

    public static Integer rate(Integer takeCost){
       int allAdd = 2000000000 * Rank.first.count + 30000000*Rank.second.count + 1500000*Rank.third.count + 50000*Rank.fourth.count+ 5000*Rank.fifth.count;
       int rate = allAdd*10 / takeCost;

       if(rate%10 >= 5)
           return rate/10 +1;

       return rate/10;
    }
}