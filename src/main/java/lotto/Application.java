package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
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
        int money = Integer.parseInt(Console.readLine());
        for(int i = 0; i < money / 1000; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
    }
    private static List<Integer> convertTrueNum(String tmp) {
        ArrayList<Integer> res = new ArrayList<>();
        List<String> tmpli = List.of(tmp.split(","));
        for(int i = 0; i < tmpli.size(); i++)
            res.add(Integer.parseInt(tmpli.get(i)));
        return res;
    }
    private static void allocateInitial(){ //입력받아서 bonusnum,truenum 만듬
        String lottolist = Console.readLine();
        bonusnum = (Integer.parseInt(Console.readLine()));

    }
    private static List<Integer> calcFinal(){ //로또 보고 몇등인지 계산하고 저장
        List<Integer> tmpres = List.of(new Integer[6]);

        return tmpres;
    }
    private static void printFinal(){ //마지막 결과 출력

    }
    public static void main(String[] args) {
        //로또 생성
        generateLotto();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        printAllLottos();
        //당첨 번호
        //보너스 번호
        //계산
        //당첨 통계 출력
    }
}
