# 로또

## 기능목록
- [x] User Class 작성한다. - User
  - [x] User의 구입금액을 입력 받는다. - User#Constructor()
  - [x] User의 구입 로또 리스트를 저장한다. - User#buyLotto()
- [x] Lotto Class 추가 기능 구현한다. - Lotto
  - [x] 당첨 번호와 비교하여 당첨 번호 개수 구한다. - Lotto#countWinningNumber()
  - [x] 당첨 번호와 비교하여 보너스 번호 유무를 구한다. - Lotto#hasBonusNumber()
- [x] 당첨 번호 Class 작성한다. - WinningNumber
  - [x] 당첨번호를 입력받는다. - WinningNumber#readWinningNumbers()
  - [x] 보너스번호를 입력받는다. - WinningNumber#readBonusNumber()
- [ ] 당첨 결과 Class 작성한다. - LottoResult
  - [ ] User와 당첨 번호를 입력받는다. LottoResult#Constructor()
  - [ ] User와 당첨 번호를 이용해 등수를 구한다.
- [x] 메시지 Package 작성한다. - Message
  - [x] 정상메시지 Class 작성한다. - Message#NormalMessage
  - [x] 에러메시지 Class 작성한다. - Message#ErrorMessage
- [x] 로또 당첨금액, 맞은 개수 정보를 담은 enum 작성한다. - LottoPlace
  - [x] 순위(맞은개수, 당첨금액) 포맷으로 작성한다.
