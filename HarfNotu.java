/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
GİRİLEN NOTA KARŞILIK GELEN HARF NOTUNU VEREN PROGRAM
 100-90 AA
  90-80 BB
  80-70 CC
  70-   FF

 YANLIŞ GİRİLEN DEĞERLER İÇİN, "GEÇERLİ NOT GİRİLMEDİ!" ÇIKTISI BASTIRAN PROGRAM
*/
package javaapplication2;

import java.util.Scanner; /* KULLANICIDAN SAYI ALMAK İÇİN GEREKLİ KÜTÜPHANE 
VEYA java.util.Scanner yazılarak kütüphane import etmeden kullanılabilir*/

/**
 *
 * @author melih
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here  
        Scanner s =new Scanner(System.in);
        int sonuc=0; // WHILE DÖNGÜSÜ İÇİN GEREKLİ İŞLEM DEĞİŞKENİ
        
        while(sonuc==0) //DOĞRU SONUÇ GİRİLENE KADAR PROGRAMIN ÇALIŞMASI İÇİN WHILE DÖNGÜSÜ OLUŞTURUYORUZ
        {
            System.out.println("Vize Notunuzu giriniz:");
            int vize= s.nextInt();
            System.out.println("Ödev Notunuzu giriniz:");
            int odev= s.nextInt();
            System.out.println("Final Notunuzu giriniz:");
            int fin= s.nextInt();
            double not= (vize*0.40)+(fin*0.50)+(odev*0.10); //vizenin %40 ödevin %50 si ödevin %10 u
        
            if((vize>=0 && vize<=100) && (odev>=0 && odev<=100) && (fin>=0 && fin<=100) ) //GİRİLEN NOTLARIN 0DAN KÜÇÜK VEYA 100 DEN BÜYÜK OLMAMASINI SAĞLAYAN İF BLOĞU
            {
                if(not>=90 && not<=100)
                    {
                        System.out.println("Notunuz:"+not+" Harf Notunuz AA");
                    }
                else if(not<90 && not>=80)
                    {
                        System.out.println("Notunuz:"+not+" Harf Notunuz BB");
                    }
                else if(not<80 && not>=70)
                    {
                        System.out.println("Notunuz:"+not+" Harf Notunuz CC");
                    }
                else if(not>=0 && not<70)
                    {
                        System.out.println("Notunuz:"+not+" Harf Notunuz FF");
                    }
                else
                    {
                        System.out.println("Yanlış Not");
                    }
                    sonuc +=1;
            }
            else
            {
                System.out.println("Geçerli Not Girilmedi!");
            }

        }
                  
        
    }
    
}
