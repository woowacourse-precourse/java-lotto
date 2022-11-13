# 미션 - 로또

## 기능 목록
- [ ] 사용자의 로또 번호와, 이번 회차의 로또 번호를 비교할 수 있다. - Player.compareLotto()
  - [ ] 사용자는 로또를 구입할 수 있다. - Player.buyLotto()
    - [ ] 구입 금액을 설정한다. - Player.setBuyMoney()
    - [ ] 1 ~ 45의 로또 번호를 발행할 수 있다. - Player.publishRandomNumbers() 
  - [ ] 이번 회차의 로또 당첨 번호를 설정한다. - Lotto.setNumbers()
    - [ ] 로또 번호의 개수 예외를 검사한다. - CustomException.checkValidate()
    - [ ] 로또 번호의 중복 예외를 검사한다. - CustomException.checkDuplicate()
    - [ ] 로또 번호의 범위 예외를 검사한다. - CustomException.checkRange()
  - [ ] 이번 회차의 로또 당첨 번호를 기져온다. - Lotto.getNumbers()
  - [ ] 이번 회차의 보너스 번호를 설정한다. - PlusLotto.setNumber()
    - [ ] 보너스 번호의 중복 예외를 검사한다. - CustomException.checkDuplicate()
    - [ ] 로또 번호의 범위 예외를 검사한다. - CustomException.checkRange()
- [ ] 사용자가 발행한 로또를 출력할 수 있다. - Player.printPublishLotto() 
- [ ] 사용자는 당첨 내역을 출력할 수 있다. - Player.printRank()
- [ ] 사용자는 수익률을 출력할 수 있다. - Player.printYield()