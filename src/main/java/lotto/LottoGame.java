package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    private final int ticketPrice;
    private int money;
    private int ticketNumber;
    private List<Lotto> ticketList;

    public LottoGame(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void run() {
        money = getMoneyInput();
        ticketNumber = calculateHowManyTicketUserCanBuy();
        System.out.printf("%d개를 구매했습니다.\n", ticketNumber);
        ticketList = selectLottoNumbersOfManyTickets();
        printTicketList();
        LottoWinNumber answer = getLottoWinNumbersInput();
        LottoStatisticsCompiler compiler = new LottoStatisticsCompiler(ticketList, answer,
            ticketPrice);
        LottoStatistics statistics = compiler.compile();
        printStatistics(statistics);
    }

    private int getMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        int moneyInput = 0;
        try {
            moneyInput = getIntegerInput();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액 입력값은 정수값이어야 합니다.");
        }
        if (moneyInput < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액 입력값은 0 이상의 정수값이어야 합니다.");
        }
        return moneyInput;
    }

    private int getIntegerInput() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private int calculateHowManyTicketUserCanBuy() {
        return money / ticketPrice;
    }

    private List<Lotto> selectLottoNumbersOfManyTickets() {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < ticketNumber; i++) {
            lottoList.add(selectLottoNumbersOfOneTicket());
        }
        return lottoList;
    }

    private Lotto selectLottoNumbersOfOneTicket() {
        return new Lotto(pickLottoNumbersByRandom());
    }

    private List<Integer> pickLottoNumbersByRandom() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private LottoWinNumber getLottoWinNumbersInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String oneLine = Console.readLine();
        try {
            List<Integer> numbers = Arrays.stream(oneLine.split(",")).map(Integer::parseInt)
                .collect(Collectors.toList());
            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = getIntegerInput();
            return new LottoWinNumber(numbers, bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 당첨 번호를 입력해야 합니다.");
        }
    }

    private static void printStatistics(LottoStatistics statistics) {
        System.out.printf("당첨 통계\n"
                + "---\n"
                + "3개 일치 (5,000원) - %d개\n"
                + "4개 일치 (50,000원) - %d개\n"
                + "5개 일치 (1,500,000원) - %d개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
                + "6개 일치 (2,000,000,000원) - %d개\n"
                + "총 수익률은 %.01f%%입니다.\n",
            statistics.getHowManyPeopleInSpecificRanking(LottoResult.RANK_FIVE),
            statistics.getHowManyPeopleInSpecificRanking(LottoResult.RANK_FOUR),
            statistics.getHowManyPeopleInSpecificRanking(LottoResult.RANK_THREE),
            statistics.getHowManyPeopleInSpecificRanking(LottoResult.RANK_TWO),
            statistics.getHowManyPeopleInSpecificRanking(LottoResult.RANK_ONE),
            statistics.getRateOfReturn()
        );
    }

    private void printTicketList() {
        for (Lotto ticket : ticketList) {
            printTicketNumbers(ticket);
        }
    }

    private static void printTicketNumbers(Lotto ticket) {
        List<Integer> numbers = ticket.getNumbers();
        System.out.print("[");
        System.out.print(numbers.stream()
            .map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.print("]\n");
    }
}
