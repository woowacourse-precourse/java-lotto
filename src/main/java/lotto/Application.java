package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static int initmoney;
    private static int bonusnum;
    private static List<Integer> truenum;
    private static ArrayList<Lotto> lottos;
    private static List<Integer> res;
    private static void printAllLottos(){
        for(int i = 0; i < lottos.size(); i++){
            lottos.get(i).printInfo();
        }
    }
    private static void generateLotto(){ //가격 입력받아서 로또들 생성
        System.out.println("구입금액을 입력해 주세요.");
        try{
            String tmp = Console.readLine();
            System.out.println(tmp);
            int money = Integer.parseInt(tmp);
            initmoney = money;
            System.out.println(initmoney);
        } catch(Exception e){
            System.out.println("[ERROR]");
            throw new IllegalArgumentException();
        }
        lottos = new ArrayList<>();
        for(int i = 0; i < initmoney / 1000; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
    }
    private static List<Integer> convertTrueNum(String tmp) {
        ArrayList<Integer> res = new ArrayList<>();
        List<String> tmpli = List.of(tmp.split(","));
        for(int i = 0; i < tmpli.size(); i++){
            int cur = Integer.parseInt(tmpli.get(i));
            if(cur < 0 || cur > 45) throw new IllegalArgumentException();
            res.add(cur);
        }

        return res;
    }
    private static void allocateInitial(){ //입력받아서 bonusnum,truenum 만듬
        String lottolist = Console.readLine();
        bonusnum = (Integer.parseInt(Console.readLine()));
        if(bonusnum < 0 || bonusnum > 45) throw new IllegalArgumentException();
        truenum = convertTrueNum(lottolist);
    }
    private static List<Integer> calcFinal(){ //로또 보고 몇등인지 계산하고 저장
        List<Integer> tmpres = new ArrayList<>(6);
        for(int i = 0; i < 6; i++) tmpres.add(0);
        for(int i = 0; i < lottos.size(); i++){
            LottoRank rr = lottos.get(i).getRtn(truenum,bonusnum);
            tmpres.set(rr.getValue(),tmpres.get(rr.getValue())+1);
        }
        return tmpres;
    }
    private static void printFinal(){ //마지막 결과 출력
        System.out.println("당첨 통계\n---\n");
        long ressum = 0;
        System.out.printf("3개 일치 (5,000원) - %d개\n", res.get(LottoRank.Fifth.getValue()));
        ressum += 5000 * res.get(LottoRank.Fifth.getValue());
        System.out.printf("4개 일치 (50,000원) - %d개\n",res.get(LottoRank.Fourth.getValue()));
        ressum += 50000 * res.get(LottoRank.Fourth.getValue());
        System.out.printf("5개 일치 (1,500,000원) - %d개\n",res.get(LottoRank.Third.getValue()));
        ressum += 1500000 * res.get(LottoRank.Third.getValue());
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",res.get(LottoRank.Second.getValue()));
        ressum += 30000000 * res.get(LottoRank.Second.getValue());
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n",res.get(LottoRank.First.getValue()));
        ressum += (long)2000000000 * res.get(LottoRank.First.getValue());
      //  System.out.println(ressum/initmoney);
        System.out.printf("총 수익률은 %.1f%%입니다.", ((double)(ressum)) / initmoney*100);
    }
    public static void main(String[] args) {
        //로또 생성
        try {
            generateLotto();
        }catch(Exception e){
            return;
        }
        System.out.println(lottos.size() + "개를 구매했습니다.");
        printAllLottos();
        //당첨 번호
        //보너스 번호
        allocateInitial();
        //계산
        res = calcFinal();
        //당첨 통계 출력
        printFinal();
    }
}
