import java.util.ArrayList;                         // 使用動態陣列存放多筆分數
import java.util.List;                              // 使用 List 這個介面來描述「一串分數」
import java.util.Scanner;                           // 從鍵盤讀取分數

public class ExampleUtil_v2 {                          // 範例：計算多筆分數的總分與平均

    // 用常數命名取代魔法數字 -1，讓人一看就懂代表「結束輸入」
    private static final int END_INPUT = -1;        // 使用者輸入這個數字代表「不再輸入分數」

    public static void main(String[] args) {        // 程式進入點
        List<Integer> scores = readScoresFromUser();// ① 先把所有分數讀進來
        printScoreSummary(scores);                  // ② 再把統計結果印出來
    }

    /**
     * 從使用者那邊讀取多筆分數，直到輸入 END_INPUT 為止。
     */
    private static List<Integer> readScoresFromUser() {
        List<Integer> scores = new ArrayList<>();   // 建一個可以自動增長的分數清單

        try (Scanner sc = new Scanner(System.in)) { // 用 try-with-resources，結束時自動關閉 Scanner
            System.out.println("請輸入學生分數（輸入 " + END_INPUT + " 結束）：");

            while (true) {                          // 不斷要求輸入，直到使用者輸入 END_INPUT
                System.out.print("分數：");
                int scoreInput = sc.nextInt();      // 讀一個整數當作分數

                if (scoreInput == END_INPUT) {      // 如果輸入的是結束碼
                    break;                          // 跳出迴圈
                }
                scores.add(scoreInput);             // 否則就把這筆分數加進清單
            }
        }

        return scores;                              // 回傳所有輸入的分數
    }

    /**
     * 根據分數清單，輸出總筆數、總分與平均。
     */
    private static void printScoreSummary(List<Integer> scores) {
        if (scores.isEmpty()) {                     // 若完全沒有輸入任何分數
            System.out.println("沒有輸入任何分數。");
            return;                                 // 直接結束這個方法
        }

        int sum = calculateSum(scores);             // 計算總分
        double average = calculateAverage(sum, scores.size()); // 計算平均

        System.out.println("共輸入 " + scores.size() + " 筆分數。");
        System.out.println("總分為 " + sum);
        System.out.println("平均為 " + average);
    }

    /**
     * 計算所有分數的總和。
     */
    private static int calculateSum(List<Integer> scores) {
        int sum = 0;
        for (int score : scores) {                  // 走訪每一筆分數
            sum += score;                           // 累加到 sum
        }
        return sum;
    }

    /**
     * 根據總分與筆數計算平均值。
     */
    private static double calculateAverage(int sum, int count) {
        return (double) sum / count;                // 轉成 double 再除，避免整數除法截斷
    }
}
