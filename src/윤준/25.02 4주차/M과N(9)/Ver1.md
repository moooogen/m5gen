##  M과N (LinkedHashSet)

**백트래킹 (Backtracking) 알고리즘을 활용한 순열 생성 문제**를 해결
`N`개의 숫자 중 `M`개를 선택하여 만들 수 있는 **모든 수열**을 출력하되, **중복되는 수열은 한 번만 출력**

----------
````
import java.util.Arrays;

import java.util.LinkedHashSet;

import java.util.Scanner;

  

  

public  class NnM_09_ME {

static  int  N, M;

static  int[] number;

static  int[] anwser;

static  boolean[] visited;

static LinkedHashSet<String> ans;

  

public  static  void main(String[] args) {

Scanner sc = new Scanner(System.in);

N = sc.nextInt();

M = sc.nextInt();

number = new  int[N];

anwser = new  int[M];

visited = new  boolean[N];

ans = new LinkedHashSet<>();

for(int  i = 0; i < N; i++) {

number[i] = sc.nextInt();

}

Arrays.sort(number);

dfs(0);

ans.forEach(System.out::println);

}

static  void dfs(int  depth) {

if(depth == M) {

StringBuilder sb = new StringBuilder();

for(int  i= 0; i <M; i++) {

int  num = anwser[i];

sb.append(num).append(" ");

}

ans.add(sb.toString().trim());

return;

}

for(int  i = 0; i < N; i++) {

if(!visited[i]) {

visited[i] = true;

anwser[depth] = number[i];

dfs(depth + 1);

visited[i] = false;

}

}

}

  

}
````

- stringBulider로 다시 받는 이유
- 숫자 배열을 직접 사용하여 순열을 관리할 경우, 배열의 각 요소가 메모리 주소에 따라 구분되므로, 숫자 배열의 내용이 동일해도 다른 배열 객체로 간주되어 중복 제거가 어려워짐. 이를 방지하기 위해 순열을 문자열로 변환하면, 동일한 숫자 조합은 동일한 문자열로 변환되어 `HashSet`을 통한 중복 제거가 효과적.

### 예시 설명

예를 들어, 순열 [1, 2]와 [1, 2]가 있을 때, 두 순열이 배열 형태로 저장되면, 두 배열은 각각 다른 객체로 인식됩니다. 그러나 문자열로 변환된 "1 2"는 동일한 문자열로 인식되어 `HashSet`에서 자동으로 중복이 제거.

- sb의 상태는 "1 9 " <- 9 뒤에 띄어쓰기가 한 칸 있음. 

- ans.add(sb.toString().trim()) → ans에 "1 9" 추가

- trim()을 사용하여 공백 제거 

## **1️⃣ 코드 설계 방식**

### **✅ 입력 처리 및 기본 설정**
````

`static int N, M;
static int[] number;   // 입력받은 숫자 배열
static int[] anwser;   // 현재 선택된 수열
static boolean[] visited;  // 중복 방문 방지용 배열
static LinkedHashSet<String> ans;  // 중복 수열 방지용 Set` 

-   `number`: **사용할 숫자 배열**
-   `anwser`: **현재 DFS 탐색 중 저장하는 수열**
-   `visited`: **DFS 방문 체크 배열**
-   `ans`: **중복 제거를 위해 `LinkedHashSet` 사용**  
    → **`Set`을 사용하면 같은 내용의 수열을 한 번만 저장할 수 있음.** → **`LinkedHashSet`을 사용하여 입력 순서대로 저장됨.**

````
----------

## **2️⃣ 백트래킹 (DFS) 수행**


````
`static void dfs(int depth) {
    if (depth == M) {  // M개 선택 완료
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(anwser[i]).append(" ");
        }
        ans.add(sb.toString().trim()); // 중복 방지를 위해 Set에 저장
        return;
    }

    for (int i = 0; i < N; i++) {
        if (!visited[i]) {
            visited[i] = true;
            anwser[depth] = number[i];
            dfs(depth + 1);
            visited[i] = false; // 백트래킹 (원상복구)
        }
    }
}` 
````

### **백트래킹 탐색 과정**

-   `depth == M`이면 **완성된 수열을 `Set`에 추가**
-   `for`문을 통해 **모든 숫자 탐색**
    -   `visited[i] = true` → **선택한 숫자를 방문 체크**
    -   `dfs(depth + 1)` → **다음 숫자 선택 진행**
    -   `visited[i] = false` → **백트래킹 (선택 취소 후 복구)**

----------

## **3️⃣ 중복 제거 (`LinkedHashSet` 활용)**



`ans = new LinkedHashSet<>();` 

-   같은 숫자로 이루어진 **중복 수열을 저장하지 않도록 `Set`을 사용**.
-   **`LinkedHashSet`을 사용하여 `순서를 유지`**하면서 중복을 자동으로 제거.

----------

## **4️⃣ 시간 복잡도 분석**

시간 복잡도 최악의 경우 **O(N!)** 

### **이유 분석**

- 수열을 모두 구하고 hashset의 특성을 이용해서 중복을 제거하기 때문!

-   `N`개의 숫자 중 `M`개를 선택하여 만들 수 있는 경우의 수  
    → **`N! / (N-M)!` (순열 공식)**
-   탐색 과정에서 `Set`을 사용하여 **중복을 제거**하지만, 최악의 경우에도 `O(N!)`에 가까운 시간이 소요됨.

### **예제 실행 시 연산량**

-   `N = 4, M = 2` → 최대 `4P2 = 4! / 2! = 12` 개의 수열 탐색
-   `N = 8, M = 4` → 최대 `8P4 = 8! / 4! = 1680` 개 탐색



## 🔹 정리

| **설계 요소** | **설명** |
|--------------|----------------------------------------------|
| **입력 데이터** | `N`개의 수 중 `M`개를 선택하여 만들 수 있는 모든 순열 생성 |
| **중복 제거 방식** | `LinkedHashSet<String>`을 사용하여 중복된 수열 방지 |
| **백트래킹 동작** | `visited[]` 배열을 사용하여 숫자 중복 사용 방지 |
| **점화식** | `dfs(depth) → dfs(depth + 1)` (재귀 호출) |
| **시간 복잡도** | `O(N!)` (최악의 경우) |
| **공간 복잡도** | `O(N + M + P)` (입력 배열, 방문 배열, 결과 저장) |
| **최적화 여부** | 불필요한 연산을 줄이기 위해 정렬 후 탐색 (정렬: O(N log N)) |
