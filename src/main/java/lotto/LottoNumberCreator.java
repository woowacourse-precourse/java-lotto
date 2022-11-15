package lotto;
import java.util.Collections;
import java.util.List;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
public class LottoNumberCreator {
    private ArrayList<ArrayList<Integer>> numbersContainer = new ArrayList<>();

    public LottoNumberCreator(int money) {
        int ticketUnit = money / 1000;
        generateLottoNumberContainer(ticketUnit);
    }

    static private final int LOTTO_NUM_PER_ONE_LINE = 6;
    static private final int LOTTO_NUM_START_INCLUSIVE = 1;
    static private final int LOTTO_NUM_END_INCLUSIVE = 45;

    public void generateLottoNumberContainer(int ticketUnit) {
        for(int i = 0; i < ticketUnit; i++) {
            List<Integer> tempNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUM_START_INCLUSIVE, LOTTO_NUM_END_INCLUSIVE, LOTTO_NUM_PER_ONE_LINE);
            numbersContainer.add(ascendingSortNumbers(tempNumbers));
        }
    }

    public ArrayList<Integer> ascendingSortNumbers(List<Integer> numbers) {
        ArrayList<Integer> tempNumbers = new ArrayList<>();

        for(int num : numbers) {
            tempNumbers.add(num);
        }

        Collections.sort(tempNumbers);
        return tempNumbers;
    }

    public ArrayList<ArrayList<Integer>> getNumbersContainer() {
        return this.numbersContainer;
    }

    public void showHowManyTickets() {
        System.out.println(this.numbersContainer.size()+"개를 구매했습니다.");
        for(List list : numbersContainer) {
            System.out.println(list);
        }
    }
}

