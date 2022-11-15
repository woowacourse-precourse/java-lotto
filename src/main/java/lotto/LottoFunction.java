package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoFunction {
    public static List<List<Integer>> buyLottoUserPaid(int money) {
        LottoRepository lottoRepository = LottoRepository.newLottoRepository();
        int buyCount = money/1000;
        System.out.println();
        System.out.println(buyCount + "개를 구매했습니다.");

        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < buyCount; i++) {
            List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(randomNumbers);
            lottoNumbers.add(randomNumbers);
        }
        for (int i = 0; i < lottoNumbers.size(); i++) {
            System.out.println(lottoNumbers.get(i));
        }
        System.out.println();

        return lottoNumbers;
    }

    public static WinningNumbers makeWinningLotto() {
        String winningNumbers = UserInput.getWinningNumber();
        Lotto winningLotto = Lotto.newLottoWinningNumbers(winningNumbers);
        int bonusBall = createBonusNum(UserInput.getBonusNumber());

        return WinningNumbers.newWinningLottoWithInput(winningLotto, bonusBall);
    }

    private static int createBonusNum(String bonusBallNumber) {
        try {
            return Integer.parseInt(bonusBallNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 값을 입력해야 합니다.");
        }
    }

    public static Map<Integer, Integer> matchAllLottos(List<List<Integer>> lottoUser,WinningNumbers winningNum) {
        Map<Integer, Integer> matchedLottos = new HashMap<>();

        for (int i = 0; i < lottoUser.size(); i++) {
            Lotto lotto_ = new Lotto(lottoUser.get(i));
            ArrayList<Integer> li = winningNum.match(lotto_);
            matchedLottos.put(li.get(0), li.get(1));
        }

        return matchedLottos;
    }

    public static Map<String, Integer> printAllMatchResult(Map<Integer, Integer> matchedLottos) {
        Map<String, Integer> countLottos = new HashMap<>();
        countLottos.put("6",0);
        countLottos.put("5+1",0);
        countLottos.put("5",0);
        countLottos.put("4",0);
        countLottos.put("3",0);
        Set<Integer> keySet = matchedLottos.keySet();
        for (Integer key : keySet) {
            // System.out.println(key + " : " + matchedLottos.get(key));
            if (key==5 && matchedLottos.get(key)==1) {
                int t_ = countLottos.get("5+1")+1;
                countLottos.put("5+1",t_);
            }
            else if (key==5){
                countLottos.put("5",countLottos.get("5")+1);
            }
            else if (key==4){
                countLottos.put("4",countLottos.get("4")+1);
            }
            else if (key==3){
                countLottos.put("3",countLottos.get("3")+1);
            }
            else if (key==6){
                countLottos.put("6",countLottos.get("6")+1);
            }
        }
        return countLottos;
    }

    public static void printYield(Map<String,Integer> matchedLotto,
                                  int lottoMoney) {

        System.out.println("3개 일치 (5,000원) - "+matchedLotto.get("3")+"개,");
        System.out.println("4개 일치 (50,000원) - "+matchedLotto.get("4")+"개,");
        System.out.println("5개 일치 (1,500,000원) - "+matchedLotto.get("5")+"개,");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+matchedLotto.get("5+1")+"개,");
        System.out.println("6개 일치 (2,000,000,000원) - "+matchedLotto.get("6")+"개,");

        int totalYield = 0;
        Set<String> keySet = matchedLotto.keySet();
        for (String key : keySet) {
            if(matchedLotto.get(key)!=0){
                if (key=="3") {
                    totalYield+=5000*matchedLotto.get(key);
                }
                else if(key=="4") {
                    totalYield+=50000*matchedLotto.get(key);
                }
                else if(key=="5") {
                    totalYield+=1500000*matchedLotto.get(key);
                }
                else if(key=="5+1"){
                    totalYield+=30000000*matchedLotto.get(key);
                }
                else if (key == "6") {
                    totalYield+=2000000000*matchedLotto.get(key);
                }
            }
        }
        System.out.println("총 수익률은 " + String.format("%.1f", (float)totalYield/(float)lottoMoney*100) + "%입니다.");
    }

}
