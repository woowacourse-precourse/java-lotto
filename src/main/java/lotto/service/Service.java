package lotto.service;

import lotto.Lotto;
import lotto.LottoGenerator;
import lotto.domain.User;
import lotto.reposiotory.Repository;

import java.util.List;

//비즈니스로직
public class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository=repository;
    }

    public User saveUser(String amount) {
        User user = new User(amount);
        repository.save(user);
        return user;
    }

    public List<Lotto> genLottos(User inputUser) {
        User findUser=repository.findById(inputUser.getId());
        findUser.setLottos(LottoGenerator.generatLottos(findUser.getAmount()));
        return findUser.getLottos();
    }
}
