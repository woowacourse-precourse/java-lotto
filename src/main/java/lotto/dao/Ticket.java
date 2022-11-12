package lotto.dao;

import lotto.vo.Lotto;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ticket {
    private static Ticket ticket;

    private final List<Lotto> database = new LinkedList<>();

    private Ticket() {

    }

    public static Ticket getInstance() {
        if (ticket == null) {
            ticket = new Ticket();
        }

        return ticket;
    }

    public static Ticket newInstance() {
        ticket = new Ticket();
        return ticket;
    }

    public boolean insert(Lotto lotto) {
        return this.database.add(lotto);
    }

    public boolean delete(Lotto lotto) {
        return this.database.remove(lotto);
    }

    public Lotto getLatest() {
        this.throwNullPointerExceptionIfEmpty();

        return this.database.get(this.database.size() - 1);
    }

    public List<Lotto> getAll() {
        this.throwNullPointerExceptionIfEmpty();

        return Collections.unmodifiableList(this.database);
    }

    public boolean isEmpty() {
        return this.database.size() == 0;
    }

    private void throwNullPointerExceptionIfEmpty() {
        if (this.isEmpty()) {
            throw new NullPointerException("PurchaseNumber 에 등록된 데이터가 없어요.");
        }
    }
}
