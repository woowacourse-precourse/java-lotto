package lotto.numbers_generator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LottoNumberGeneratorSequenceImpl implements LottoNumbersGenerator{
    Queue<List<Integer>> numbersQueue = new LinkedList<>();

    public LottoNumberGeneratorSequenceImpl(List<List<Integer>> numbersList){
        numbersQueue.addAll(numbersList);
    }

    @Override
    public List<Integer> generate() {
        return numbersQueue.poll();
    }
}
