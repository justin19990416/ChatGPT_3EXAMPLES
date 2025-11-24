import java.io.BufferedWriter;                   // 匯入 BufferedWriter 類別，提供緩衝區加速寫入檔案
import java.io.FileWriter;                       // 匯入 FileWriter 類別，負責實際將文字寫入檔案
import java.io.IOException;                      // 匯入 IOException 類別，處理檔案輸出入錯誤

public class ExampleIO {                         // 宣告公開類別 ExampleIO，檔名為 ExampleIO.java

    public static void main(String[] args) {     // main 方法：程式執行起點

        String fileName = "note.txt";            // 宣告字串變數 fileName，指定要輸出的檔名為 note.txt

        // 使用 try-with-resources 語法，自動關閉檔案資源
        try (FileWriter fw = new FileWriter(fileName);     // 建立 FileWriter 物件 fw，負責寫入文字到指定檔案
             BufferedWriter bw = new BufferedWriter(fw)) { // 用 BufferedWriter 包住 fw，增加緩衝區提高效率

            bw.write("這是一個由 ChatGPT 產生的檔案。\n"); // 寫入第一行文字並加上換行符號
            bw.write("第二行：Hello Java I/O!\n");          // 寫入第二行文字
            bw.write("第三行：檔案名稱是 " + fileName);     // 寫入第三行，順便印出檔名

            System.out.println("已成功將資料寫入檔案：" + fileName); // 在主控台提示寫檔成功
        } catch (IOException e) {                  // 捕捉在打開或寫入檔案過程中可能發生的 IOException 例外
            System.out.println("寫入檔案時發生錯誤：" + e.getMessage()); // 顯示錯誤訊息，方便除錯
        }                                          // try-catch 區塊結束
    }                                              // main 方法結束
}                                                  // ExampleIO 類別結束
