package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Domain {
    private static final String INPUT_LOTTO_AMOUNT = "로또금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ENTER = "\n";

    private static final String OUTPUT_LOTTO_PURCHASE_COUNT = "개를 구매했습니다.";

    private static final int TICKET_PRICE = 1000;
    private static final int MAX_VALUE_OF_LOTTO_NUMBER = 45;
    private static final int MIN_VALUE_OF_LOTTO_NUMBER = 1;
    private static final int LOTTO_COUNT = 6;

    private static int lottoAmount;
    private static int ticketNumbers;

    private static final List<Lotto> lottoList = new ArrayList<>();
    private static List<String> winningNumbers = new ArrayList<>();
    private static int bonusNumber;
    private static final List<Rank> prizeList = new ArrayList<>();

    // TODO: 티켓 구매 루틴을 실행한다.
    public void buyTicket(){
        initializationLottoAmount();
        initializationTicketNumbers();
        initializationLottoList();
        printLottoNumbers();
    }

    // TODO: 우승번호, 보너스번호 입력 루틴을 실행한다.
    public void receiveWinningNumber(){
        initializationWinningNumbers();
        initializationBonusNumber();
    }

    // TODO: 구매 티켓의 번호를 비교하여 당첨 내역, 수익률을 출력하는 루틴을 실행한다.

    // TODO: 로또 금액 문장 출력 후 로또 금액을 입력 받는다.
    private static int inputLottoAmount(){
        System.out.println(INPUT_LOTTO_AMOUNT);
        return Exception.validateAmount(Console.readLine());
    }

    // TODO: LOTTO_AMOUNT 변수를 초기화 한다.
    private static void initializationLottoAmount(){
        lottoAmount = inputLottoAmount();
    }

    // TODO: TICKET_NUMBERS 변수를 초기화 한다.
    private static void initializationTicketNumbers(){
        ticketNumbers = lottoAmount / TICKET_PRICE;
    }

    // TODO: winningNumbers 리스트를 초기화 한다.
    private static void initializationWinningNumbers() {
        System.out.println(ENTER + INPUT_WINNING_NUMBERS);
        winningNumbers = Exception.validateWinningNumbers(Console.readLine());
    }

    // TODO: bonusNumber 변수를 초기화 한다.
    private static void initializationBonusNumber() {
        System.out.println(ENTER + INPUT_BONUS_NUMBER);
        bonusNumber = Integer.parseInt(Exception.validateBonusNumber(Console.readLine()));
    }

    // TODO: lottoList를 초기화 한다.
    private static void initializationLottoList(){
        for(int i=0; i<ticketNumbers; i++)
            createLottoTicket();
    }

    // TODO: 로또 객체 생성 후 로또 번호를 랜덤으로 생성한다.
    private static void createLottoTicket(){
        lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(
                MIN_VALUE_OF_LOTTO_NUMBER, MAX_VALUE_OF_LOTTO_NUMBER, LOTTO_COUNT)));
    }

    // TODO: 로또 구매 개수 및 번호를 출력한다.
    public void printLottoNumbers(){
        System.out.println(ENTER + ticketNumbers + OUTPUT_LOTTO_PURCHASE_COUNT);
        for(Lotto lottoTicket : lottoList)
            System.out.println(lottoTicket.getNumbers());
    }

    public static List<String> getWinningNumbers() {
        return winningNumbers;
    }

    // TODO: 로또 번호와 당첨 번호를 비교 한다.
    private static void lotteryComparison(){
        for(Lotto lottoTicket : lottoList) {

            int hitCount = 0;
            boolean hitBonus = false;

            for(int number : lottoTicket.getNumbers()){
                if (winningNumbers.contains(Integer.toString(number))) hitCount++;
                if (bonusNumber == number) hitBonus = true;
            }

            prizeList.add(Rank.valueOf(hitCount, hitBonus));
        }
    }

    // TODO: 당첨 통계를 출력한다.
    public void printWinStatistics(){
        DecimalFormat decFormat = new DecimalFormat("###,###");
        System.out.println(ENTER + "당첨 통계" + ENTER + "---");
        for(Rank rank : Rank.values()){
            if(rank.getHitBonus()){
                System.out.println(rank.getHitCount() + "개 일치, 보너스 볼 일치 " +
                        "(" + decFormat.format(rank.getPrizeMoney()) + "원) - " +
                        Collections.frequency(prizeList, rank) + "개");
                continue;
            }else if(rank.getHitCount() == 0){
                continue;
            }
            System.out.println(rank.getHitCount() + "개 일치" +
                    " (" + decFormat.format(rank.getPrizeMoney()) + "원) - " +
                    Collections.frequency(prizeList, rank) + "개");
        }
    }

    // TODO: 총 수익률을 출력한다.
    public void printYield(){
        float totalPrizeMoney = 0;
        for (Rank rank : Rank.values())
            totalPrizeMoney += rank.getPrizeMoney() * Collections.frequency(prizeList, rank);

        float yield = (totalPrizeMoney / lottoAmount) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }
}
