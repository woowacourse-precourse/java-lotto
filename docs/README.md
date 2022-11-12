# 📒 요구사항 정리

#### 🟩 개발 예정 ✅ 개발 완료

---

### <span style = "color:skyblue" >getPurchaseAmount</span> : 로또 구입 금액 입력
- 🟩 **`convertStringToInt`** → 문자입력을 숫자로 변환 
- 🟩 **`isMultipleOfThousand`** → 1000원으로 나누어 떨어지지 않으면 예외처리

### <span style = "color:skyblue" >getLottoCount</span> : 로또 개수 저장
- 🟩 **`getLottoAmount`** → 구입 금액과 로또 금액을 나눈 값을 저장

### <span style = "color:skyblue" >getLottos</span> : 로또 번호 출력
- 🟩 **`getLottoNumber`** → 제시된 라이브러리를 사용하여 개수만큼 랜덤번호 생성
- 🟩 **`printLottoNumber`** → 로또 번호 출력

### <span style = "color:skyblue" >getUserNumber</span> : 당첨 번호 입력
- 🟩 **`getUserNumber`** → 문자입력을 쉼표를 기준으로 구분하여 리스트 저장
- 🟩 **`isValidCommas`** → 쉼표로 구분되어 있지 않으면 예외처리
- 🟩 **`isUnique`** : 중복인 경우
- 🟩 **`isNumeric`** : 숫자가 아닌 경우
- 🟩 **`isValidRange`** : 숫자 범위 초과

### <span style = "color:skyblue" >getBonusNumber</span> : 보너스 번호 입력
- 🟩 **`getBonusNumber`** → 문자 하나를 입력
- 🟩 **`isNumeric`** → 숫자가 아니라면 예외처리
- 🟩 **`isvalidRange`** : 숫자 범위 초과
- 🟩 **`isUnique`** : 중복인 경우
- 
### <span style = "color:skyblue" >getWinningHistory</span> : 당첨 내역 확인
- 🟩 **`getAccordance`** → 로또 번호마다 값이 일치하는 개수 저장
- 🟩 **`matchWinning`** → 당첨내역 계산
- 🟩 **`printWinning`** → 당첨내역 출력

### <span style = "color:skyblue" >getYeild</span> : 수익률 계산
- 🟩 **`getYield`** → 수익률 계산
- 🟩 **`roundsYield`** → 소수점 둘째 자리에서 반올림
- 🟩 **`printYield`** → 수익률 출력

### +) 예외상황
- 🟩 **`isNumeric`** : 숫자가 아닌 경우
- 🟩 **`isMutipleOfThousand`** : 1000원으로 나누어 떨어지지 않는 경우
- 🟩 **`isValidCommas`** : 쉼표로 구분되지 않았을 때
- 🟩 **`isValidRange`** : 숫자 범위 초과
- 🟩 **`isUnique`** : 중복인 경우
- 🟩 **`isValidLength`** : 필요한 개수와 다를 때

# Git 커밋 메시지(temp)
```markdown
:sparkles: feat: <새로운 기능>
:truck: chore: <기타 변경사항>
:construction_worker: ci: <CI 에 관련된 빌드를 할때>
:memo: docs: <도큐멘트> 
:recycle: refactor: <리팩토링>
:test_tube: test: <테스트 코드>
:lipstick: style: <스타일>
:rewind: revert: <깃을 예전 단계로 돌려놓는다>
:zap: perf: <속도적인 측면에서 업그레이드 될때>
:bug: fix: <오류를 바꾼다>

##-------- 
#✨ feat: <새로운 기능>
#🚚 chore: 코드 의미에 영향을 주지 않는 변경사항 (형식 지정, 세미콜론 누락, gitignore 등)
#👷 ci: CI, 자동화 기능
#📝 docs: 문서의 추가, 수정, 삭제
#♻️ refactor: 코드 리팩토링
#🧪 test: 테스트 추가, 수정, 삭제 (비즈니스 로직에 변경 없음)
#💄 style: 코드 스타일 혹은 포맷 등에 관한 커밋
#⏪ revert: 깃 revert
#⚡️ perf: 퍼포먼스 상향
#🐛 fix: 버그
```