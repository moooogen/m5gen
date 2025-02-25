
## 	Before 변수

```

import java.util.Arrays;
import java.util.Scanner;

public class NnM_09_visited {
    static int N, M;
    static int[] number;
    static int[] anwser;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        number = new int[N];
        anwser = new int[M];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            number[i] = sc.nextInt();
        }
        Arrays.sort(number); // 정렬하여 중복된 숫자가 연속되도록 만듦

        dfs(0);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(anwser[i] + " ");
            }
            System.out.println();
            return;
        }

        int before = -1; // 이전에 선택한 숫자를 저장하여 중복 방지
        for (int i = 0; i < N; i++) {
            if (!visited[i] && before != number[i]) { // 이전과 같은 숫자라면 건너뜀
                visited[i] = true;
                anwser[depth] = number[i];
                before = number[i]; // 현재 숫자를 before에 저장 (다음 루프에서 중복 체크)
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}


```

**백트래킹 (Backtracking) 알고리즘을 활용한 순열 생성 문제**를 해결
주어진 `N`개의 숫자 중 `M`개를 선택하여 만들 수 있는 **모든 수열**을 출력하되,  **중복된 숫자가 포함된 경우는 한 번만 출력**하는 방식

----------

## **1️⃣ 코드 설계 방식**

### **✅ 입력 처리 및 기본 설정**


```
`static int N, M;
static int[] number;   // 입력받은 숫자 배열
static int[] anwser;   // 현재 선택된 수열
static boolean[] visited;  // 방문 여부 체크 배열` 
```

-   `number`: **사용할 숫자 배열**
-   `anwser`: **현재 DFS 탐색 중 저장하는 수열**
-   `visited`: **DFS 방문 체크 배열** (같은 수를 중복 사용하지 않도록 하기 위함)

### **✅ 정렬 후 탐색**



`Arrays.sort(number); // 정렬하여 중복된 숫자가 연속되도록 만듦` 

-   **입력된 숫자를 정렬하여 중복된 숫자가 연속되도록 만듦.**
-   이렇게 하면 **이전 숫자(`before`)와 비교하여 중복을 쉽게 제거할 수 있음.**

----------

## **2️⃣ 백트래킹 (DFS) 수행**

```
`static void dfs(int depth) {
    if (depth == M) {
        for (int i = 0; i < M; i++) {
            System.out.print(anwser[i] + " ");
        }
        System.out.println();
        return;
    }

    int before = -1; // 이전에 선택한 숫자를 저장하여 중복 방지
    for (int i = 0; i < N; i++) {
        if (!visited[i] && before != number[i]) { // 이전과 같은 숫자라면 건너뜀
            visited[i] = true;
            anwser[depth] = number[i];
            before = number[i]; // 현재 숫자를 before에 저장 (다음 루프에서 중복 체크)
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}` 
```

### **✅ 중복 제거 로직**

-   `before = -1`로 초기화하여 **이전 숫자 값을 저장**.
-   `if (!visited[i] && before != number[i])`
    -   **이전에 선택했던 숫자와 같으면 건너뜀** → 같은 깊이(depth)에서 같은 숫자가 두 번 나오지 않게 됨.
    -   즉, **한 DFS 트리의 같은 깊이(depth)에서 같은 숫자를 중복으로 선택하지 않도록 한다.**
-   `before = number[i];`
    -   **현재 선택한 숫자를 `before`에 저장**하여 다음 루프에서 중복인지 확인.

----------

## **3️⃣ 중복 제거 방식 비교**


`N과 M (9) - LinkedHashSet`

`Set` (`LinkedHashSet`)

**완성된 결과를 저장하며 중복 제거**


`N과 M (9) - visited[]`

`before` 변수 사용

**DFS 과정에서 중복 숫자를 건너뛰도록 함**


`before` 변수를 활용하여 중복을 방지
➡ **추가적인 `Set` 없이 중복이 제거되므로 더 효율적인 방식**!

----------

## **4️⃣ 시간 복잡도 분석**

 시간 복잡도 -> 최악의 경우 **O(N!)**

### **이유 분석**

-   `N`개의 숫자 중 `M`개를 선택하여 만들 수 있는 경우의 수  
    → **`N! / (N-M)!` (순열 공식)**
-   탐색 과정에서 `before` 변수를 사용하여 **같은 깊이에서 중복된 숫자를 선택하지 않도록 함**.
-   **중복이 제거되면서 탐색량이 줄어들지만, 여전히 최악의 경우 `O(N!)`에 가까운 연산량이 필요할 수 있음.**

----------

## 🔹 정리

| **설계 요소** | **설명** |
|--------------|----------------------------------------------|
| **입력 데이터** | `N`개의 수 중 `M`개를 선택하여 만들 수 있는 모든 순열 생성 |
| **중복 제거 방식** | `before` 변수를 사용하여 같은 깊이(depth)에서 중복 방지 |
| **백트래킹 동작** | `visited[]` 배열을 사용하여 숫자 중복 사용 방지 |
| **점화식** | `dfs(depth) → dfs(depth + 1)` (재귀 호출) |
| **시간 복잡도** | `O(N!)` (최악의 경우) |
| **공간 복잡도** | `O(N + M)` (입력 배열 + 방문 배열) |
| **최적화 여부** | ✅ `Set` 없이 `before` 변수 활용하여 효율적인 중복 제거 |
