# 로또 게임
 
## 기능 목록

- [] 1-45범위의 서로다른 임의의 6개의 번호를 가진 수를 생성한다. - GameManager.publishRandomLotto()
- [] 당첨 결과를 계산한다. - LottoGame.calculateResult()
  - [] 당첨 등수와 금액을 계산한다. - LottoGame.calculateRank()
  - [] 구매 금액 대비 수익률을 계산한다. - LottoGame.calculateEarningRatio()

- [] 구입금액, 당첨번호, 보너스 번호를 입력받아 로또 게임을 생성해 실행한다. - GameManager.run()

- [] 입력 - Input
  - [] 구입 금액을 입력받는다. -  Input.inputPrice()
  - [] 당첨 번호를 입력받는다. - Input.inputWinningLotto()
  - [] 보너스 번호를 입력받는다. - Input.inputBonusNumber()

- [] 출력 - View
  - [] 발행한 로또 수량과 번호를 출력한다. - View.publishedLotto() 
  - [] 당첨내역을 출력한다. View.printLottoResult()

- [] validation
  - [] 로또 발행 시 중복되지 않는 6개 숫자인지 검증한다. - Lotto.validate()




