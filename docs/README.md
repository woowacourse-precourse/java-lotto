## 프로그램 시나리오

- 금액을 넣는다.
- machine이 금액에 따른 구매 가능한 lotto 횟수를 계산한다.
- machine이 구매 가능한 횟수만큼 lotto를 생성한다.

- 당첨 번호를 입력한다.
- 보너스 번호를 입력한다.

- 판별할 machine에 당첨 번호와 보너스 번호를 넣는다.
- machine이 lotto의 결과를 판정한다.
- 원금 대비 당첨금의 비율을 계산한다.

---

## 기능 목록

### InputView

- [x] 로또를 구매할 금액을 입력한다. #insertMoney()
    - 입력 제약조건: 1000의 배수 수가 입력되어야 한다.
- [x] 당첨 번호를 입력한다. #inputWinningNumbers()
    - 입력 제약조건: comma로 구분된 1 이상 45 이하의 정수를 6개가 입력되어야한다.
- [x] 보너스 번호를 입력한다. #inputBonusNumber(winningNumbers)
    - 입력 제약조건: 1이상 45 이하의 정수 1개가 입력되어야한다.

> 각 입력 제약조건을 벗어나면, "[ERROR]"를 포함하는 출력과 IllegalArgumentException를 발생시키고 프로그램이 종료시킨다.

### OutputView
- [x] 에러 메세지를 출력한다. #printErrorMessage(message)
- [x] 구입금액 입력 메세지를 출력한다. #announceInsertMoney()
- [ ] lotto를 몇개 구매했는지 출력한다.
- [ ] 구매한 lotto를 출력한다.
- [x] 당첨 번호 입력 메세지를 출력한다. #announceInputWinningNumbers()
- [x] 보너스 번호 입력 메세지를 출력한다. #announceInputBonusNumber()
- [ ] 결과에대해 출력한다.
  - 출력 양식에 따른 등수 별 당첨 결과
  - 원금 대비 당첨금의 비율

### Machine

- [x] 입력한 금액에 대해 몇개의 lotto를 구매 할 수 있는지 계산한다. #countNumberOfLottos(money)
- [x] 구매할 수 있는 로또 개수만큼 로또를 생성한다. #generateLottos(numberOfLottos)
- [ ] 입력한 당첨 번호와 보너스 번호를 기준으로, lotto를 판정한다.
- [ ] 수익률을 계산한다.
    - 소수 둘째자리에서 반올림한다.

### Lotto
- [x] lotto 생성 시 validate 체크한다. #validate(numbers)
  - 숫자 갯수는 6개이다.
  - 중복되는 숫자는 불가능하다.
  - 1이상 45 이하의 숫자이다.
