#로또 미션

## 기능 목록

- [ ] 로또 구매 금액을 입력한다  - **InputDevice**#sendMoney()
    - [ ] 구입 금액이 1000으로 나누어 떨어지는지 검증한다. - **Validator**#validateMoney()
- [ ] 금액을 바탕으로 로또를 생성한다. - **LottoGenerator**#createLotto()
- [ ] 구매한 로또의 수량 및 번호 정보를 출력한다 - **LottoView**#printLottoInfo()
- [ ] 로또 당첨 번호를 입력한다. - **InputDevice**#sendWinningNumbers()
    - [ ] 로또 당첨 번호를 검증한다. - **Validator**#validateWinningNumbers
- [ ] 로또 보너스 번호를 입력한다. - **InputDevice**#sendBonusNumber()
    - [ ] 보너스 번호를 검증한다. - **Validator**#validateBonusNumber
- [ ] 내가 구매한 로또의 번호와 당첨번호 및 보너스 번호를 비교한다. - **LottoService**#compareLottoNumbers()
- [ ] 비교 결과를 바탕으로 로또 당첨 결과를 출력한다 - **LottoView**#printLottoResult()
- [ ] 로또 수익률을 계산한다 - **LottoService**#calculateYield()
- [ ] 로또의 수익률을 출력한다 - **LottoView**#printYield()
