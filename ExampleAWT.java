import java.awt.BorderLayout;                    // 匯入 BorderLayout，幫助我們安排視窗元件的位置
import java.awt.Button;                          // 匯入 Button 類別，用來建立按鈕
import java.awt.Frame;                           // 匯入 Frame 類別，代表一個視窗
import java.awt.Label;                           // 匯入 Label 類別，用來顯示文字
import java.awt.event.ActionEvent;               // 匯入 ActionEvent 類別，代表按鈕被按下的事件物件
import java.awt.event.ActionListener;            // 匯入 ActionListener 介面，用來處理按鈕事件
import java.awt.event.WindowAdapter;             // 匯入 WindowAdapter 類別，簡化視窗事件處理
import java.awt.event.WindowEvent;               // 匯入 WindowEvent 類別，代表視窗相關事件

public class ExampleAWT extends Frame              // 宣告公開類別 ExampleAWT，繼承 Frame 代表本身就是一個視窗
        implements ActionListener {                // 並實作 ActionListener 介面，用來處理按鈕被按下的事件

    private int count = 0;                         // 宣告整數成員變數 count，用來記錄按鈕被按了幾次
    private Label label;                           // 宣告 Label 物件參考，稍後用來顯示計數結果

    public ExampleAWT() {                          // 建構子：建立視窗物件時會執行這裡的程式碼
        super("AWT 按鈕計數器");                    // 呼叫父類別 Frame 的建構子，設定視窗標題文字

        label = new Label("目前按鈕尚未被按下。");   // 建立 Label 物件並給初始文字
        Button button = new Button("按我一下");     // 建立一個按鈕物件，按鈕文字為「按我一下」

        button.addActionListener(this);            // 設定按鈕的事件監聽器為目前這個物件（ExampleAWT 本身）

        setLayout(new BorderLayout());            // 設定視窗的版面配置管理員為 BorderLayout
        add(label, BorderLayout.NORTH);           // 將 label 放在視窗的上方（NORTH 位置）
        add(button, BorderLayout.CENTER);         // 將按鈕放在視窗中央（CENTER 位置）

        setSize(300, 150);                        // 設定視窗大小為 300x150 像素
        setLocationRelativeTo(null);              // 將視窗置中顯示（JDK 8 之後 Frame 支援此方法）

        addWindowListener(new WindowAdapter() {   // 替視窗註冊一個 WindowListener 來處理關閉事件
            @Override                             // 覆寫 WindowAdapter 的 windowClosing 方法
            public void windowClosing(WindowEvent e) { // 當使用者按下關閉按鈕時會呼叫這裡
                System.exit(0);                   // 結束整個程式
            }
        });

        setVisible(true);                         // 設定視窗為可見，視窗才會真的顯示出來
    }

    @Override                                     // 標示這個方法是實作自 ActionListener 介面的 actionPerformed
    public void actionPerformed(ActionEvent e) {  // 當按鈕被按下時，會自動呼叫這個方法
        count++;                                  // 將計數器 count 加 1
        label.setText("按鈕已被按下 " + count + " 次。"); // 更新標籤上的文字，顯示目前被按的次數
    }

    public static void main(String[] args) {      // main 方法：程式進入點
        new ExampleAWT();                         // 建立一個 ExampleAWT 物件，建構子內會負責把視窗建好並顯示
    }                                             // main 方法結束
}                                                 // ExampleAWT 類別結束
