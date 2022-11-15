package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        try {
            int userLottoAmount = how_many_lotto(); //구매할 로또 개수 입력
            List<List> userLottoList = createLotto(userLottoAmount); //구매한만큼 로또 발행
            List<Integer> WinLottoList = winLotto(); //로또 당첨 번호 생성
            int BonusNumber = winBonusLotto(); //당첨 보너스 숫자 생성
            List<List> userResult = compareLotto(userLottoList, WinLottoList, BonusNumber);
            List<Integer> prizeResult = getPrize(userResult);
            printPrize(prizeResult);
            getPrizeMoney(prizeResult, userLottoAmount);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }


    //1.사용자의 구입 금액 입력
    public static int how_many_lotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String user_input = Console.readLine();
        int amount = 0;
        exception_how_many_lotto(user_input);
        amount = Integer.parseInt(user_input)/1000;
        return amount;
    }

    //1.사용자의 구입 금액 입력 예외 검사
    private static void exception_how_many_lotto(String user_input) {
        int money = 0;
        try{
            money = Integer.parseInt(user_input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    //2.구입 금액만큼의 로또 번호 생성, 출력
    public static List<List> createLotto(int lotto_amount) {
        System.out.println("\n" + lotto_amount + "개를 구매하였습니다.");
        List<List> lotto_list = new ArrayList<>();
        for(int i=0; i< lotto_amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            new Lotto(numbers);
            System.out.println(numbers);
            lotto_list.add(numbers);
        }
        return lotto_list;
    }

    //3.당첨 번호 입력
    public static List<Integer> winLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String win_lotto = Console.readLine();
        exception_winLotto(win_lotto);
        List<Integer> winLottoList = new ArrayList<>();
        String[] numbers = win_lotto.split(",");
        for(int i=0; i<numbers.length; i++){
            winLottoList.add(Integer.parseInt(numbers[i]));
        }
        new Lotto(winLottoList);
        return winLottoList;
    }

    //3.당첨 번호 입력 예외 처리
    private static void exception_winLotto(String win_lotto) {
        String[] winLottoList = win_lotto.split("");
        int cnt = 0;
        for (int i = 0; i < winLottoList.length; i++) {
            if(winLottoList[i].equals(",")){
                cnt++;
            }
        }
        if(cnt!=5){
            throw new IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력해야 합니다.");
        }
        winLottoList = win_lotto.split(",");
        for (int i = 0; i < winLottoList.length; i++) {
            if(Integer.parseInt(winLottoList[i])>45 || Integer.parseInt(winLottoList[i])<1){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    //4.보너스 번호 입력
    public static int winBonusLotto() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String n = Console.readLine();
        exception_winBonusLotto(n);
        int bonusNum = Integer.parseInt(n);
        return bonusNum;
    }

    //4.보너스 번호 입력 예외 처리
    private static void exception_winBonusLotto(String n) {
        int bonus = 0;
        try{
            bonus = Integer.parseInt(n);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하여야 합니다.");
        }
        if(bonus>45 || bonus<1){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    //5.당첨 통계 비교
    public static List<List> compareLotto(List<List> userLottoList, List<Integer> winLottoList, int bonusNum) {
        List<List> userLottoResult = new ArrayList<>(); //당첨결과, 금액 저장할 리스트
        exception_winLottoList_bonusNum(winLottoList, bonusNum);

        int lottoCount = 0;
        int bonusCount = 0;
        for (int i = 0; i < userLottoList.size(); i++) {
            bonusCount = 0;
            lottoCount = existLotto(userLottoList.get(i), winLottoList);
            if(lottoCount != 6){
                bonusCount = existBonusLotto(userLottoList.get(i), bonusNum);
            }
            userLottoResult.add(resultLotto(lottoCount, bonusCount));
        }
        return userLottoResult;
    }

    //5.보너스 번호와 당첨 로또 번호 예외 처리
    private static void exception_winLottoList_bonusNum(List<Integer> winLottoList, int bonusNum) {
        if(winLottoList.contains(bonusNum)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 로또 번호와 다른 숫자여야 합니다.");
        }
    }

    //5.당첨 로또 번호 리스트와 사용자가 구매한 로또 리스트의 값을 하나씩 비교
    private static int existLotto(List lottoList, List<Integer> winLottoList){
        int answer = 0;
        for (int i = 0; i < 6; i++) {
            if(lottoList.contains(winLottoList.get(i))){
                answer++;
            }
        }
        return answer;
    }

    //5.보너스 번호와 사용자가 구매한 로또 리스트의 값을 비교
    private static int existBonusLotto(List lottoList, int bonusNum) {
        int answer = 0;
        if(lottoList.contains(bonusNum)) {
            answer++;
        }

        return answer;
    }

    //5.당첨로또번호와 보너스 번호를 비교해서 얻은 결과를 등수별로 저장해서 리스트로 반환
    private static List<Integer> resultLotto(int lottoCount, int bonusCount) {
        int[] prize = {0,0,0,0,0}; //순서대로 1등부터 5등
        List<Integer> prizeList = new ArrayList<>();

        if(lottoCount == 6){
            prize[0]+=1; //1등
        }
        if(bonusCount == 1 && lottoCount == 5){
            prize[1]+=1; //2등
        }
        if(bonusCount==0 && lottoCount==5){
            prize[2]+=1; //3등
        }
        if(lottoCount==4){
            prize[3]+=1; //4등
        }
        if(lottoCount==3){
            prize[4]+=1; //5등
        }

        for (int i = 0; i < prize.length; i++) {
            prizeList.add(prize[i]);
        }

        return prizeList;
    }

    //5.결과 계산
    public static List<Integer> getPrize(List<List> userLottoResult) {
        List<Integer> winLottoResult = new ArrayList<>();
        int first=0, second=0, third=0, fourth=0, fifth=0;
        for (int i = 0; i < userLottoResult.size(); i++) {
            first += Integer.parseInt(String.valueOf(userLottoResult.get(i).get(0)));
            second += Integer.parseInt(String.valueOf(userLottoResult.get(i).get(1)));
            third += Integer.parseInt(String.valueOf(userLottoResult.get(i).get(2)));
            fourth += Integer.parseInt(String.valueOf(userLottoResult.get(i).get(3)));
            fifth += Integer.parseInt(String.valueOf(userLottoResult.get(i).get(4)));
        }
        winLottoResult.add(first);
        winLottoResult.add(second);
        winLottoResult.add(third);
        winLottoResult.add(fourth);
        winLottoResult.add(fifth);

        return winLottoResult;
    }

    //5.게임결과 출력
    public static void printPrize(List<Integer> LottoResult) {
        System.out.println("당첨 통계\n" + "---");
        System.out.println("3개 일치 (5,000원) - " + LottoResult.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + LottoResult.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + LottoResult.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + LottoResult.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + LottoResult.get(0) + "개");
    }

    //5.총 상금 계산
    public static void getPrizeMoney(List<Integer> winLottoResult, int lottoAmount){
        int total_prize = 0;
        int cost = lottoAmount * 1000;
        total_prize += 2000000000 * winLottoResult.get(0);
        total_prize += 30000000 * winLottoResult.get(1);
        total_prize += 1500000 * winLottoResult.get(2);
        total_prize += 50000 * winLottoResult.get(3);
        total_prize += 5000 * winLottoResult.get(4);
        getPrizeRate(total_prize, cost);
    }

    //5.수익률 계산
    private static double getPrizeRate(int total_prize, int cost) {
        double rate = (total_prize / (double)cost) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
        return rate;
    }


}
