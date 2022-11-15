package Service;

import camp.nextstep.edu.missionutils.Console;
import domain.Lotto;
import domain.User;
import lotto.Application;
import view.RequestUser;
import view.SystemMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static domain.Winning.*;

public class GameService {

    SystemMessage systemMessage = new SystemMessage();

    private final int THOUSAND = 1000;
    private final int FIRST_NUM = 6;
    private final int SECOND_NUM = 5;
    private final int FOURTH_NUM = 4;
    private final int FIFTH_NUM = 3;

    public void run() {
        List<User> userLottoList = new ArrayList<>();
        int money = getMoney();
        int lottoCount = lottoCount(money);
        printLottoInfo(lottoCount, userLottoList);

        List<Integer> lottoNumbers = getWinningNumber();
        int bonusNumber = getBonusNumber();

        ConfirmationOfTheWinner(userLottoList, lottoNumbers, bonusNumber);
        printWinningStats(money);
    }

    public static int getMoney(){
        RequestUser.requestMoney();
        try{
            return Integer.parseInt(Console.readLine());
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

    public static int getBonusNumber(){
        RequestUser.requestBonusNum();
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

    public static List<Integer> getWinningNumber(){
        RequestUser.requestLottoNum();
        String lottery_number = Console.readLine();
        String[] test = lottery_number.split(",");
        List<Integer> result = new ArrayList<>();
        for (String i : test) {
            try {
                result.add(Integer.parseInt(i));
            } catch (Exception e) {
                throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
            }
        }
        HashSet<Integer> hash_result = new HashSet<>(result);
        if (hash_result.size() != 6) throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        return result;
    }

    public int lottoCount(int purchaseAmount) {
        int lottoCount = 0;
        if (purchaseAmount % THOUSAND == 0) {
            return purchaseAmount / THOUSAND;
        }

        if (purchaseAmount % THOUSAND != 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
        return lottoCount;
    }

    public void printLottoInfo(int lottoCount, List<User> userLottoList) {
        systemMessage.ticketsMessage(lottoCount);
        inputUserLottoNumber(lottoCount, userLottoList);
        printLottoNumberList(lottoCount, userLottoList);
    }

    private void printLottoNumberList(int lottoCount, List<User> userLottoList) {
        for (int i = 0; i < lottoCount; i++) {
            System.out.println(userLottoList.get(i).userNumber);
        }
    }

    private void inputUserLottoNumber(int lottoCount, List<User> userLottoList) {
        for (int i = 0; i < lottoCount; i++) {
            userLottoList.add(new User());
        }
    }

    private List<Integer> getLottoNumbers() {
        String[] lottoNumString = Console.readLine().split(",");
        return convertInteger(lottoNumString);
    }

    private List<Integer> convertInteger(String[] lottoNumString) {
        List<Integer> lottoNums = new ArrayList<>();
        for (String s : lottoNumString) {
            lottoNums.add(Integer.parseInt(s));
        }
        lottoNums.sort(Integer::compareTo);
        return lottoNums;
    }

    private void ConfirmationOfTheWinner(List<User> userLottoList, List<Integer> lottoNums, int bonusNumber) {
        for (User user : userLottoList) {
            List<Integer> userNumber = user.userNumber;
            List<Integer> matchNumber = userNumber.stream()
                    .filter(number -> lottoNums.stream()
                            .anyMatch(Predicate.isEqual(number)))
                    .collect(Collectors.toList());
            int match = matchNumber.size();
            setWinningCount(bonusNumber, userNumber, match);
        }
    }

    private void setWinningCount(int bonusNumber, List<Integer> userNumber, int match) {
        if (match == FIFTH_NUM) {FIFTH.setCount(+1);}
        if (match == FOURTH_NUM) {FOURTH.setCount(FOURTH.getCount() + 1);}
        if (match == SECOND_NUM) {
            if (userNumber.contains(bonusNumber)) {
                SECOND.setCount(SECOND.getCount() + 1);
                return;
            }
            THIRD.setCount(THIRD.getCount() + 1);
            return;
        }
        if (match == FIRST_NUM) {FIRST.setCount(FIRST.getCount() + 1);}
    }

    private void printWinningStats(int money) {
        systemMessage.winningMessage();
        printMatch();
        printYield(money);
    }

    private void printMatch() {
        System.out.println(FIFTH.getDESCRIPTION() + " " + FIFTH.getSRING_PRICE() + " - " + FIFTH.getCount() + "개");
        System.out.println(FOURTH.getDESCRIPTION() + " " + FOURTH.getSRING_PRICE() + " - " + FOURTH.getCount() + "개");
        System.out.println(THIRD.getDESCRIPTION() + " " + THIRD.getSRING_PRICE() + " - " + THIRD.getCount() + "개");
        System.out.println(SECOND.getDESCRIPTION() + " " + SECOND.getSRING_PRICE() + " - " + SECOND.getCount() + "개");
        System.out.println(FIRST.getDESCRIPTION() + " " + FIRST.getSRING_PRICE() + " - " + FIRST.getCount() + "개");
    }

    private int getPriceMoney() {
        return (FIFTH.getCount() * FIFTH.getPRICE())
                + (FOURTH.getCount() * FOURTH.getPRICE())
                + (THIRD.getCount() * THIRD.getPRICE())
                + (SECOND.getCount() * SECOND.getPRICE())
                + (FIRST.getCount() * FIRST.getPRICE());
    }

    private void printYield(int money) {
        int sum = getPriceMoney();
        System.out.printf("총 수익률은 %.1f%%입니다.", (double)sum/money*100);
    }

}
