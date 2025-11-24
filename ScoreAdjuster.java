import java.util.Scanner;                          // 匯入 Scanner 類別，用來從鍵盤讀取使用者輸入

public class ScoreAdjuster {                       // 宣告公開類別 ScoreAdjuster，檔名需為 ScoreAdjuster.java

    private static final double WEIGHT = 0.4;      // 宣告常數 WEIGHT，代表「原始分數所佔的權重 0.4」
    private static final int BASE = 60;            // 宣告常數 BASE，代表「固定加上的 60 分」
    private static final int END_INPUT = -1;       // 宣告常數 END_INPUT，輸入這個數字代表結束輸入

    public static void main(String[] args) {       // main 方法：Java 程式的進入點

        try (Scanner sc = new Scanner(System.in)) { // 建立 Scanner 物件，並用 try-with-resources 在結束時自動關閉

            System.out.println("=== 成績調分器 ===");           // 顯示程式標題
            System.out.println("公式：調整後 = 原始分數 × 0.4 + 60"); // 顯示調分公式
            System.out.println("請輸入原始分數（輸入 -1 結束）：");    // 提示使用者輸入分數與結束條件

            while (true) {                           // 無窮迴圈，不斷讀取使用者輸入
                System.out.print("原始分數：");       // 每次迴圈提示輸入一筆原始分數
                int raw = sc.nextInt();              // 讀取一個整數並存入變數 raw

                if (raw == END_INPUT) {              // 如果使用者輸入的是 END_INPUT（-1）
                    System.out.println("結束調分程式。"); // 顯示結束訊息
                    break;                           // 跳出 while 迴圈，不再繼續輸入
                }

                if (raw < 0 || raw > 100) {          // 檢查原始分數是否在 0~100 範圍內
                    System.out.println("請輸入 0~100 之間的分數，或輸入 -1 結束。"); // 提示輸入不合法
                    continue;                        // 回到迴圈開頭，要求重新輸入
                }

                double adjusted = raw * WEIGHT + BASE; // 套用調分公式：原始分數 × 0.4 + 60

                System.out.printf("原始分數：%d，調整後分數：%.2f%n", raw, adjusted);
                                                      // 使用 printf 印出原始分數與調整後分數（小數保留兩位）
            }
        }                                             // try-with-resources 區塊結束時，Scanner 會自動關閉
    }                                                 // main 方法結束
}                                                     // ScoreAdjuster 類別定義結束
