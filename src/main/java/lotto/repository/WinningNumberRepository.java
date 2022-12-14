package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.WinningNumber;

public class WinningNumberRepository {
    private static final WinningNumberRepository instance = new WinningNumberRepository();
    private static final List<WinningNumber> store = new ArrayList<>();
    public static final int WINNING_NUMBER_INDEX = 0;

    private WinningNumberRepository() {
    }

    public static WinningNumberRepository getInstance() {
        return instance;
    }

    public WinningNumber save(WinningNumber winningNumber) {
        store.add(winningNumber);
        return find();
    }

    public WinningNumber find() {
        return store.get(WINNING_NUMBER_INDEX);
    }
}
