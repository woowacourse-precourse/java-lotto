package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class LottoService {
    UserInterface userInterface = new UserInterface();
    List<Lotto> lottos;
    Integer bonusNumber;

    public void purchaseLottos() {
        this.lottos = new ArrayList<>();
        System.out.println("구입금액을 입력해 주세요.");
        int numberOfLottos = userInterface.getPrice() / 1000;
        System.out.println(numberOfLottos + "개를 구매했습니다.");
        IntStream.range(0,numberOfLottos).forEach(i -> {
            List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
            Collections.sort(randomNumbers);
            Lotto lotto = new Lotto(randomNumbers);
            this.lottos.add(lotto);
        });
    }
    public void printLottos() {
        lottos.forEach(Lotto::printLotto);
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = userInterface.getWinningNumbers();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = userInterface.getBonusNumber();
        if(winningNumbers.contains(bonusNumber)) {
            System.out.println("[ERROR] 중복된 보너스 번호 입니다.");
            throw new IllegalArgumentException();
        }
        this.bonusNumber = bonusNumber;
        return winningNumbers;
    }

    public List<Integer> compareWinnings(List<Integer> winningNumbers){
        List<Integer> scoreList = new ArrayList<>();
        this.lottos.forEach(lotto -> scoreList.add(lotto.compareLotto(winningNumbers)));
        return scoreList;
    }
    public List<Boolean> compareBonus(){
        List<Boolean> bonusList = new ArrayList<>();
        this.lottos.forEach(lotto -> bonusList.add(lotto.containsNumber(this.bonusNumber)));
        return bonusList;
    }
    public void printWinnings(List<Integer> scoreList, List<Boolean> bonusList) {
        System.out.println("당첨 통계");
        System.out.println("---");
        int threeWins = (int) scoreList.stream().filter(i->i==3).count();
        int fourWins = (int) scoreList.stream().filter(i->i==4).count();
        int fiveWinsNoBonus = (int) IntStream.range(0,scoreList.size())
                .filter(i -> scoreList.get(i) == 5 && bonusList.get(i) == false)
                .count();
        int fiveWinsAndBonus = (int) IntStream.range(0,scoreList.size())
                .filter(i -> scoreList.get(i) == 5 && bonusList.get(i) == true)
                .count();
        int sixWins = (int) scoreList.stream().filter(i->i==6).count();
        System.out.println("3개 일치 (5,000원) - " + threeWins + "개");
        System.out.println("4개 일치 (50,000원) - " + fourWins + "개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveWinsNoBonus + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveWinsAndBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixWins + "개");
        double rate = (threeWins * 5000 + fourWins * 50000 + fiveWinsNoBonus * 1500000 + fiveWinsAndBonus * 30000000 + sixWins * 2000000000) * 100.0 / (scoreList.size() * 1000);
        System.out.println("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
    }
}
