package model;

import domain.lotto.LottoRepository;
import domain.user.User;

public class Model {

    private static Model instance = new Model();

    private Model() {
    }

    public static Model getInstance() {
        return instance;
    }

    private LottoRepository lottoRepository;
    private User user;

    public LottoRepository getLottoRepository() {
        return lottoRepository;
    }

    public void setLottoRepository(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setYield(int yield) {
        this.user.setYield(yield);
    }
}
