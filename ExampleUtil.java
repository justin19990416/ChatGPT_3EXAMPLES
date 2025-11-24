import java.util.ArrayList;              // 匯入 ArrayList 類別，用來存放可變長度的整數清單
import java.util.Scanner;                // 匯入 Scanner 類別，用來從鍵盤讀取使用者輸入

public class ExampleUtil {               // 宣告公開類別 ExampleUtil，檔名需為 ExampleUtil.java

    public static void main(String[] args) {   // main 方法：Java 程式執行進入點

        Scanner sc = new Scanner(System.in);   // 建立 Scanner 物件 sc，從標準輸入（鍵盤）讀取資料
        ArrayList<Integer> scores = new ArrayList<>(); // 建立整數型別的 ArrayList，用來儲存多筆分數

        System.out.println("請輸入學生分數（輸入 -1 結束）："); // 提示使用者輸入分數，輸入 -1 代表結束

        while (true) {                            // 無窮迴圈，一直讀分數直到遇到 -1
            System.out.print("分數：");            // 提示目前要輸入一筆分數
            int s = sc.nextInt();                 // 從鍵盤讀取一個整數並存入變數 s
            if (s == -1) {                        // 如果使用者輸入 -1
                break;                            // 跳出 while 迴圈，停止輸入
            }
            scores.add(s);                        // 將剛輸入的分數 s 加到清單 scores 之中
        }

        if (scores.isEmpty()) {                   // 如果清單是空的（完全沒有輸入任何分數）
            System.out.println("沒有輸入任何分數。"); // 顯示提示訊息
        } else {                                  // 否則（有輸入分數）
            int sum = 0;                          // 宣告整數 sum，用來累加所有分數
            for (int x : scores) {                // 使用 for-each 迴圈，逐一走訪清單中的每一個分數 x
                sum += x;                         // 將目前的分數 x 累加到 sum
            }
            double avg = (double) sum / scores.size(); // 將總分 sum 除以筆數 size，計算平均值（轉型為 double）
            System.out.println("共輸入 " + scores.size() + " 筆分數。"); // 顯示總共有幾筆分數
            System.out.println("總分為 " + sum);     // 顯示總分
            System.out.println("平均為 " + avg);     // 顯示平均分數
        }

        sc.close();                               // 關閉 Scanner，釋放相關資源
    }                                            // main 方法結束
}                                                // ExampleUtil 類別結束
