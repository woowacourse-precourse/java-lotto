style: 테스트 클래스의 static import 추가
style: 표출명이 지정되지 않은 테스트의 표출명 추가
refactor(LottoMachineTest): 투입한 금액에 알맞는 갯수의 로또가 발행되는지 확인하는 테스트 코드 추가
refactor(LottoTest): 테스트 코드의 패키지 변경
style: 필요없는 공백 라인 제거
style: 생성자가 없는 클래스의 생성자 추가
refactor(LottoRule): 인스턴스화가 필요 없어서 private 생성자 추가
refactor(LottoMessage): 인스턴스화가 필요 없어서 private 생성자 추가
refactor(ExceptionMessage): 인스턴스화가 필요 없어서 private 생성자 추가
refactor(Constant): 인스턴스화가 필요 없어서 private 생성자 추가
docs(CHANGELOG.md): 모든 커밋 목록을 포함하여 생성
docs(README.md): 클래스별 각 역할과 책임을 패키지 구조와 함께 나타내도록 수정
refactor(Profit): 원시값 정적 변수로 포장
refactor(LottoRank): 3등인지 확인하는 기능 메서드명 변경
refactor(Application): 예외를 기록하는 기능 추가
refactor(ResultView): remove wildcard import
style(formatting): 로직간 구분을 위한 줄 바꿈 추가
refactor(Application): 구매 관련 로직 분리
refactor(Application): 예외 관련 로직 변경
refactor(ResultView): 출력 관련 로직 변경 및 상수 추가
refactor(ResultView): 각 로직 사이의 공백을 넣는 리팩토링
refactor(ResultView): 수익률 출력 로직 변경 및 상수 추가
refactor(Constant): 상수관련 클래스 분리
docs(README.md): 클래스별 각 열할과 책임에 보편적 상수 클래스 추가
refactor(LottoMessage): 상수 오타 수정
refactor(Profit): 수익 관련 클래스 수정
feat(WinLotto): 로또 당첨으로 인한 수익을 추가하는 기능 구현
feat(WinLotto): 로또 당첨으로 인한 수익을 가져오는 기능 구현
docs(README.md): 기능 구현 목록 문서 내 오타 수정
docs(README.md): 기능 구현 목록내 로또 당첨 수익 관련 기능 추가
docs(WinLotto): 기능 구현 목록에 로또 당첨으로 인한 수익을 가져오는 기능 추가
refactor(ResultView): 당첨 조건별 일치 갯수와 보너스 볼 일치별 갯수를 출력하는 기능 수정
feat(LottoRank): 기능 구현 목록에 오름차순으로 정렬된 목록을 가져오는 기능 구현
docs(README.md): 기능 구현 목록에 오름차순으로 정렬된 목록을 가져오는 기능 추가
docs(README.md): 클래스별 각 역할과 책임의 LottoService 삭제
feat(WinLotto): 로또를 집계하는 기능 구현
feat(WinLotto): 로또를 집계하는 기능 구현
docs(README.md): 기능 구현 목록 수정
feat(ResultView): 당첨 조건별 일치 갯수와 보너스 볼 일치별 갯수를 출력하는 기능 구현
feat(ResultView): "---"를 출력하는 기능 구현
feat(LottoRank): 3등인지 확인하는 기능 구현
docs(README.md): 기능 구현 목록내 기능 수정
feat(LottoRank): 로또 순위를 가져오는 기능 구현
feat(ResultView): "당첨 통계"를 출력하는 기능 구현
docs(README.md): 기능 목록에 "---" 를 출력하는 기능 추가
docs(README.md): "당첨 통계"를 출력하는 기능 수정
feat(Lotto): 보너스 번호를 가지고 있는지 확인하는 기능 구현
feat(Lotto): 당첨 번호를 몇 개 가지고 있는지 확인하는 기능 구현
refactor(ProfitTest): 테스트 메서드 표출 이름 변경
feat(LottoRank): 당첨 순위에 해당하는 당첨금을 가져오는 기능 구현
feat(LottoRank): 당첨 순위에 해당하는 일치 개수를 가져오는 기능 구현
docs(README.md): 기능 구현 목록 수정
feat(ResultView): 수익률을 출력하는 기능 구현
refactor(Profit): 통계 클래스 수익 관련 클래스로 변경
feat(LottoStatistics): 수익률을 가져오는 기능
feat(LottoStatistics): 수익률을 계산하는 기능
refactor(Money): 돈 검증 관련 로직 수정
refactor(NumberInput): 보너스 번호가 로또 상한과 하한의 사이인지 확인하는 기능 수정
feat(NumberInput): 보너스 번호를 입력받는 기능 구현
feat(NumberInput): 보너스 번호가 로또 상한과 하한의 사이인지 확인하는 기능 구현
docs(README.md): 기능 구현 목록에 보너스 번호가 로또 상한과 하한의 사이인지 확인하는 기능 추가
feat(NumberInput): 보너스 번호가 숫자인지 확인하는 기능 구현
docs(README.md): 기능 구현 목록에 보너스 번호가 숫자인지 확인하는 기능을 추가
refactor(LottoTest): 테스트 메서드 출력 이름 변경
feat(NumberInput): 당첨 번호를 입력 받는 기능 구현
feat(NumberInput): 구분자로 나눈 값을 반환하는 기능 구현
docs(README.md): 기능 구현 목록 수정
feat(ResultView): 발행한 로또 수량 및 번호를 출력하는 기능
docs(README.md): 기능 구현 메서드명 변경
fix(Money): 로또 구입 금액을 가져오는 기능 다시 구현
feat(LottoMachine): 로또 구입 금액만큼 로또를 발행한다.
fix(LottoMachine): 로또를 발행하는 기능 구현
docs(README.md): 기능 구현 목록 수정
feat(Lotto): 로또 번호를 오름차순으로 정렬하는 기능
docs(README.md): 기능 구현 목록 중 메서드의 소속 클래스 수정
docs(README.md): 기능 구현 목록 중 기능 이름 수정
feat(Money): 로또 구입 금액을 가져온다.
docs(README.md): 클래스별 각 역할과 책임 수정
feat(MoneyInput): 숫자만으로 이루어져 있는지 판별하는 기능
feat(MoneyInput): 로또 구입 금액을 입력받는 기능
docs(README.md): 입력 관련 기능 메서드명 수정
docs(README.md): 숫자만으로 이루어져 있는지 판별하는 기능 구현 목록에 추가
feat(Money): 1,000원으로 나누어 떨어지는지 검증하는 기능
refactor(Lotto): Lotto 클래스의 패키지 위치 변경
feat(RequestView): "보너스 번호를 입력해 주세요." 출력 기능
feat(RequestView): "당첨 번호를 입력해 주세요." 출력 기능
feat(RequestView): "구입금액을 입력해 주세요." 출력 기능
docs(README.md): 기능 구현 목록 수정과 클래스 변경에 의한 문서 수정
feat(Lotto): 1부터 ~ 45사이의 숫자인지 검증하는 기능
feat(Lotto): 6자리인지 검증하는 기능
refactor(Lotto): 6자리인지 검증하는 기능
docs(README.md): 클래스별 각 역할과 책임 작성
docs(README.md): 기능 구현 목록 작성
feat: setup precourse lotto project