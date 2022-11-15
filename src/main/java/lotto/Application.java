package lotto;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static Map<Rank, Integer> resultRankMap = new HashMap<Rank, Integer>();

    public static void main(String[] args) {
        try {
            int buyMoney = buyLotto();
            List<List<Integer>> buyLottoPrint = buyLottoPrint(buyMoney);
            Lotto myLottoNum = myLottoNum();
            int bonusNum = bonusNum(myLottoNum);

            for (int j = 0; j < buyLottoPrint.size(); j++) {
                List<Integer> lottoRandomNum = buyLottoPrint.get(j);

                int agreementCount = lottoStart(lottoRandomNum, myLottoNum);
                boolean bonusAgreement = bonusAgreement(bonusNum, lottoRandomNum);
                Rank rank = agreementLotto(agreementCount, bonusAgreement);
                prizeList(rank);
            }
            prizeListPrint();
            yield(buyMoney);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 7. prizeList (당첨 내역 저장) <br/>
     * lottoStart 값 받아서 일치 갯수 일치 당첨 복권 갯수 출력 <br/>
     * 
     */
    public static void prizeList(Rank rank) {
        Integer count = resultRankMap.get(rank);

        if (count == null) {
            count = 0;
        }
        resultRankMap.put(rank, count + 1);
    }

    /**
     * 11. prizeListPrint (당첨내역 통계 출력) <br/>
     */
    public static void prizeListPrint() {
        StringBuilder sb = new StringBuilder();
        head(sb);
        Rank[] rankArray = Rank.values();

        for (int i = rankArray.length; i > 0; i--) {
            Rank rank = rankArray[i - 1];
            body(sb, rank, resultRankMap.get(rank));
        }
        System.out.print(sb);
    }

    private static void head(StringBuilder sb) {
        sb.append("당첨 통계").append("\n").append("---").append("\n");
    }

    private static void body(StringBuilder sb, Rank rank, Integer count) {
        if (count == null) {
            count = 0;
        }

        String bonusMessage = "";
        if (Rank.SECOND.equals(rank)) {
            bonusMessage = ", 보너스 볼 일치";
        }

        sb.append(MessageFormat.format("{0}개 일치{1} ({2}원) - {3}개", rank.getlottoStart(), bonusMessage,
                NumberFormat.getInstance().format(rank.getprizeMoney()), count));
        sb.append("\n");

    }

    /**
     * 6. buyLotto (로또 구입) 완료 <br/>
     * 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다. <br/>
     * 1장에 1,000원. 소숫점 예외처리 발생 <br/>
     * 
     * @return
     */
    public static int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");

        int inputMoney = 0;

        try {
            inputMoney = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 타입 오류.");
        }
        if (inputMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액 입력 오류.");
        }

        int buyLotto = inputMoney / 1000;

        return buyLotto;
    }

    /**
     * 1. lottoRandomNum (Lotto 랜덤 숫자뽑기) <br/>
     * 숫자 1 ~ 45 Random, 중복되지 않는 숫자 6개 오름차순 저장
     * 
     * @return
     */
    public static List<Integer> lottoRandomNum() {
        List<Integer> lottoRandomNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return sort(lottoRandomNum);
    }

    private static List<Integer> sort(List<Integer> lottoRandomNumbers) {
        List<Integer> list = new ArrayList<Integer>();
        Object[] array = lottoRandomNumbers.toArray();
        Arrays.sort(array, 0, 6);
        for (Object obj : Arrays.asList(array)) {
            list.add(Integer.valueOf(String.valueOf(obj)));
        }
        return list;
    }

    /**
     * 10. buyLottoPrint (구매한 로또 lottoRandomNum 리스트 출력) <br/>
     * 
     * @param lottoRandomNum
     * @return
     */
    public static List<List<Integer>> buyLottoPrint(int buyLotto) {
        List<List<Integer>> buyLottoPrint = new ArrayList<List<Integer>>();

        System.out.println(buyLotto + "개를 구매했습니다.");

        for (int i = 0; i < buyLotto; i++) {
            List<Integer> list = lottoRandomNum();
            buyLottoPrint.add(list);
            System.out.println(list);
        }
        return buyLottoPrint;
    }

    /**
     * 2. myLottoNum (내가 뽑은 Lotto 숫자)
     * 
     * @param myLottoNum
     */
    public static Lotto myLottoNum() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String myPickNum = Console.readLine();
        String[] numbers = myPickNum.split(",");

        List<Integer> myLottoNum = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            try {
                myLottoNum.add(Integer.parseInt(numbers[i].trim()));
                Collections.sort(myLottoNum);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 입력 타입 오류.");
            }
        }
        return new Lotto(myLottoNum);
    }

    /**
     * 2-1. bonusNum (보너스 번호)
     * 
     * @return
     */
    public static int bonusNum(Lotto myLottoNum) {
        System.out.println("보너스 번호를 입력해 주세요.");

        int bonusPick = 0;

        try {
            bonusPick = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 타입 오류.");
        }

        if (myLottoNum.contains(bonusPick)) {
            throw new IllegalArgumentException("[ERROR] 중복입력.에러 발생.");
        }
        if (!myLottoNum.contains(bonusPick)) {

        }

        return bonusPick;
    }

    /**
     * 4. lottoStart (로또 번호 대조하기)<br/>
     * 
     * @param lottoRandomNum
     * @param myLottoNum
     * @return
     */
    public static int lottoStart(List<Integer> lottoRandomNum, Lotto myLottoNum) {
        int agreementCount = 0;

        for (int i = 0; i < lottoRandomNum.size(); i++) {
            if (myLottoNum.contains(lottoRandomNum.get(i))) {
                agreementCount++;
            }
        }

        return agreementCount;
    }

    /**
     * 4-1. bonusAgreement (보너스 번호 대조) <br/>
     * bonusNum, lottoRandomNum 전달 return
     * 
     * @param bonusNum
     * @param lottoRandomNum
     * @return
     */
    public static boolean bonusAgreement(int bonusNum, List<Integer> lottoRandomNum) {
        return lottoRandomNum.contains(bonusNum);
    }

    /**
     * 4-2. agreementLotto (로또 당첨 등수 리턴) <br/>
     * lottoStart (로또 번호 대조하기) 값에 따른 등수 리턴 <br/>
     * 
     * @param lottoStart
     * @return
     */
    public static Rank agreementLotto(int lottoStart, boolean bonusAgreement) {
        Rank rank = null;

        if (lottoStart == 6) {
            rank = Rank.FIRST;
        }
        if (lottoStart == 5 && bonusAgreement) {
            rank = Rank.SECOND;
        }
        if (lottoStart == 5) {
            rank = Rank.THIRD;
        }
        if (lottoStart == 4) {
            rank = Rank.FOURTH;
        }
        if (lottoStart == 3) {
            rank = Rank.FIFTH;
        }

        return rank;
    }

    /**
     * 8. yield (당첨금 수익률 계산) <br/>
     * (당첨금총액/매입금액)*100 <br/>
     * 수익률은 소숫점 둘째자리에서 반올림 한다. <br/>
     * 수익률 프린트
     * 
     * @return
     */
    public static void yield(int buyMoney) {
        double yield = 0.0;
        int money = buyMoney * 1000;

        int sumPrizeMoney = 0;

        for (Rank rank : Rank.values()) {
            if (resultRankMap.containsKey(rank)) {
                int prizeMoney = rank.getprizeMoney();
                int prizeCount = resultRankMap.get(rank);
                sumPrizeMoney += prizeMoney * prizeCount;
            }
        }
        yield = (double) sumPrizeMoney / money * 100;
        String yield2 = String.format("%.1f", yield);
        System.out.println("총 수익률은 " + yield2 + "%입니다.");
    }
}
