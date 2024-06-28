package com.techacademy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class KadaiFirstController {

    // 仕様1:指定日の曜日を算定する
    @GetMapping("/dayofweek/{date}")
    public String dispDayOfWeek(@PathVariable String date) {
        try {
            // 年、月、日を抽出する
            int year = Integer.parseInt(date.substring(0,4)); // 例：20240101 -> 2024　0からはじまり4番目は含まない
            int month = Integer.parseInt(date.substring(4,6)) - 1; // 例：20240101 -> 01 (Calendar用に-1　Integer.perseIntメソッドを使うと文字列を整数型に変換できる
            int day = Integer.parseInt(date.substring(6, 8)); // 例：20240101 -> 01

            // Calendarオブジェクトを作成し、年、月、日を取得する
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day);

            //　曜日を取得する
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            // 曜日を文字列に変換する
            String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            return days[dayOfWeek - 1];
            } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                return "Invalid date format. Please use yyyymmdd.";
            }
    }

// 仕様2:四則演算を行う　足し算

      @GetMapping("/plus/{val1}/{val2}")
      public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
      int res = 0;
      res = val1 + val2;
      return "計算結果:" + res;
     }


// 引き算
      @GetMapping("/minus/{val1}/{val2}")
      public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
      int res = 0;
      res = val1 - val2;
      return "計算結果:" + res;
      }

// 掛け算
      @GetMapping("/times/{val1}/{val2}")
      public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
      int res = 0;
      res = val1 * val2;
      return "計算結果:" + res;
      }

// 割り算
      @GetMapping("/divide/{val1}/{val2}")
      public String calcDivide (@PathVariable int val1, @PathVariable int val2){
      int res = 0;
      res = val1 / val2;
      return "計算結果:" + res;
      }

}

