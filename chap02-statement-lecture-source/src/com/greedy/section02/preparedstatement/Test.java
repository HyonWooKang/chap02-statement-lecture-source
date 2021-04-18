package com.greedy.section02.preparedstatement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {

   public static void main(String[] args) {
       // XML 만드는 파일을 작업할건데 key , value값을 그대로 담은
      // Properties 
      
      Properties prop = new Properties();
      
      // keyString -> 임의의 값 넣은 것 , 조회할 떄 아이디 
      prop.setProperty("keyString", "valueString");
      
      // output인 이유는 properties로 만들어서 xml로 뽑아오기 때문 ?? input은 있는거 
      try {
         prop.storeToXML(new FileOutputStream("src/com/greedy/section02/preparedstatement/employee-query.xml"), null);
         // null은 만드는 파일에 주석 달아주는거임. 
         // 이렇게 하고 실행하면 xml파일 생김. 
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
      
      
   }

}