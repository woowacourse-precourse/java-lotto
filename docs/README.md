# 로또

## 기능목록
- [ ] User Class 작성한다. - User
  - [ ] User의 구입금액을 입력 받는다. - User#Constructor()
  - [ ] User의 구입 로또 리스트를 저장한다. - User#buyLotto()\
- [ ] Lotto Class 추가 기능 구현한다. - Lotto
  - [ ] 당첨 번호와 비교하여 당첨 번호 개수 구한다. - Lotto#countWinningNumber()
  - [ ] 당첨 번호와 비교하여 보너스 번호 유무를 구한다. - Lotto#hasBonusNumber()
- [ ] 당첨 번호 Class 작성한다. - ResultNumber
  - [ ] 당첨번호를 입력받는다. - ResultNumber#setWinningNumber()
  - [ ] 보너스번호를 입력받는다. - ResultNumber#setBonusNumber()
- [ ] 당첨 결과 Class 작성한다. - LottoResult
  - [ ] User와 당첨 번호를 입력받는다. LottoResult#Constructor()
  - [ ] User와 당첨 번호를 이용해 등수를 구한다.
- [ ] 메시지 Package 작성한다. - Message
  - [ ] 정상메시지 Class 작성한다. - Message#NormalMessage
  - [ ] 에러메시지 Class 작성한다. - Message#ErrorMessage
