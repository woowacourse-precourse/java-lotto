package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            mainUI();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mainUI() {
        LottoSystem lottoSystem = new LottoSystem();
        LottoUser user = buyLottoUI(lottoSystem);

        user.buyLotto();
        lottoInfoUI(user.getLottos());

        setWinNumbersUI(lottoSystem);
        setBonusNumbersUI(lottoSystem);

        user.checkWin();
        showWinStatisticsUI(user);
        showReturnRateUI(user);
    }


    private static LottoUser buyLottoUI(LottoSystem lottoSystem) {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        long money;
        try {
            money = Long.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 정수여야 합니다");
        }

        LottoUser user = new LottoUser(money, lottoSystem);
        return user;
    }

    private static void lottoInfoUI(List<Lotto> lottos) {
        System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
        for (Lotto lotto : lottos) {
            String lottoNumbersStr = "[";
            List<Integer> lottoNumbers = lotto.getNumbers();
            for (int i = 0; i < lottoNumbers.size() - 1; i++) {
                lottoNumbersStr += lottoNumbers.get(i) + ", ";
            }
            lottoNumbersStr += lottoNumbers.get(lottoNumbers.size() - 1);
            lottoNumbersStr += "]";
            System.out.println(lottoNumbersStr);
        }
    }

    private static void setWinNumbersUI(LottoSystem lottoSystem) {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] inputSplited = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String i : inputSplited) {
                numbers.add(Integer.valueOf(i));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 정수여야 합니다.");
        }

        lottoSystem.setWinNumbers(numbers);
    }

    private static void setBonusNumbersUI(LottoSystem lottoSystem) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int bonusNumber;
        try {
            bonusNumber = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스번호는 정수여야 합니다");
        }

        lottoSystem.setBonusNumbers(bonusNumber);
    }

    private static void showWinStatisticsUI(LottoUser user) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<WinInfo, Integer> statistics = user.getStatistics();
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        for (int i = WinInfo.getTotalCount() - 1; i > 0; i--) {
            WinInfo winInfo = WinInfo.getByOrder(i);
            System.out.print(String.format("%d개 일치", winInfo.getMatchCnt()));
            if (winInfo.getBonusMatchCnt() > 0) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.print(String.format(" (%s원)", decimalFormat.format(winInfo.getWinMoney())));
            System.out.println(String.format(" - %d개", statistics.get(winInfo)));
        }
    }

    private static void showReturnRateUI(LottoUser user) {
        System.out.println(String.format("총 수익률은 %2.1f%%입니다.", user.getReturnRate() * 100));
    }

}
