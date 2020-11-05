
package javasmoothing;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author melihakkose
 */


public class JavaSmoothing {

   //DIZI/LISTE TANIMLAMASI //YEDEK LISTE ILK SMOOTHING PROBLEMLERINI STATIK OLARAK GERCEKLESTIRIYORUZ
    public static List myList=new ArrayList<Double>();
    public static List myList2=new ArrayList<Double>();
    //DATA CONVERSION LIST //DIGER PROBLEMLERI DINAMIK DIZILER ILE YAPACAGIZ
    public static List myListData=new ArrayList<Double>();
    // DATA EXCLUDE & ADD LIST
    public static List myMaxData=new ArrayList<Double>();
    public static List myMinData=new ArrayList<Double>();
    //MSD KATSAYI
    public static int msdpow=0,msdValue=0;
    public static double intervalValue=0;
    //KAYIP DEGER, GENEL ATAMA, e,
    public static int missing=0,xp=0;
    public static double e=0;
    
    public static void main(String[] args){
        
        /*
        - Smoothing by Avarage
        - Smoothin by bin Boudaries
        - Smoothing by Range
        - Smoothing by Normalisation
        - Jack Knife
        - 3-4-5 Rule
        - Expectation Maximisation 
        
        */
        
        int menu=0;
       
        do{
            System.out.println("\n");
            mainMenu();
            System.out.println("\n");
            Scanner myMenu=new Scanner(System.in);
            menu=myMenu.nextInt();
            System.out.println("\n");
            
            if(menu==1){
                //RANDOM SAYILARI ILE LISTE OLUSTURUYORUZ
                createRandomArray(myList);
            }else if(menu==2){
                //SIRALAMA FONKSIYONU
                SortArray(myList);
            }else if(menu==3){
                //DIZIYI GOSTER
                displayArray(myList);
            }else if(menu==4){
                //SMOOTHING BY AVARAGE FONK
                smoothingByAvarage(myList);
            }else if(menu==5){
                // SMOOTHING BY BIN BOUDARIES
                smoothingByBinBoudaries(myList);
            }else if(menu==6){
                //SMOOTHING BY RANGE
                smoothingByRange(myList);
            }else if(menu==7){
                //NORMALIZASYON
                normalisationMain(myList);
            }else if(menu==8){
                //JACK KNIFE AND EXPECTATION MAXIMISATION
                jackNifeAndExpectationMain();
            }else if(menu==9){
                menu=12;
            }else{
                System.out.println("Gecersiz Deger!");
            }
        }while(menu!=12);    
    }
    
  //MAIN MENU DISPLAY
  static void mainMenu(){
      System.out.println("-----ANA MENU -----");
       System.out.println("1. DIZI OLUSTUR");
            System.out.println("2. DIZIYI SIRALA");
            System.out.println("3. DIZIYI GOSTER");
            System.out.println("4. SMOOTHING BY AVARAGE");
            System.out.println("5. SMOOTHING BY BIN BOUDARIES");
            System.out.println("6. SMOOTHING BY RANGE");
            System.out.println("7. NORMALIZASYON");
            System.out.println("8. JACK KNIFE ve EXPACTATION MASXIMISATION");
            System.out.println("9. ÇIKIŞ");
   }
  //DIZI OLUSTURMA (STATIK)
  static void createRandomArray(List arr){
        
        if(arr.isEmpty()==false){
            arr.clear();
            Random rand= new Random(); //RANDOM SAYI URETMEK ICIN
            for(int i=0;i<12;i++){
                int randNumb= rand.nextInt(100); //0-100 ARASI RANDOM SAYI
                 myList.add(randNumb);//INDISLERE RANDOM SAYILARI ATIYORUZ
        }
            myList2.clear();
            myList2.addAll(arr);
            System.out.println("DIZI TEKRAR OLUSTURULDU!");
        }
        else{
             Random rand= new Random(); //RANDOM SAYI URETMEK ICIN
        for(int i=0;i<12;i++){
            int randNumb= rand.nextInt(100); //0-100 ARASI RANDOM SAYI
            myList.add(randNumb);//INDISLERE RANDOM SAYILARI ATIYORUZ
            
        }
        
        System.out.println("DIZI OLUSTURULDU!");
        }
         
    }
  //DIZIYI GORUNTULE
  static void displayArray(List arr){
        System.out.println("\n");
        if(arr.isEmpty()==false){
             for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i).toString());
        }
        }else{
            System.out.println("ONCE DIZI OLUSTURMALISINIZ!");
        }
       
    }
  //SIRALAMA FONKSIYONU
  static void SortArray(List arr) { 
        
        if(arr.isEmpty()==false){
           Collections.sort(arr);
           Collections.sort(myList2);
           System.out.println("DIZI SIRALANDI!");
        }else{
            System.out.println("ONCE DIZI OLUSTURMALISINIZ!");
        }
        
    }
  
  //SMOOTHING BY AVARAGE
  static void smoothingByAvarage(List arr){
       if(arr.isEmpty()==false){
            //GECICI DIZILERIMIZI OLUSTURALIM
            List temp1=new ArrayList<Double>(),temp2=new ArrayList<Double>(),temp3=new ArrayList<Double>();  
       //ANA DIZIMIZI AYRI DIZIYE BOLUYORUZ
       for(int i=0;i<arr.size();i++){
           if(i<4){
               temp1.add(i,myList.get(i).toString());
           }else if(i>=4 && i<8){     
               temp2.add(i-4,myList.get(i).toString());
           }else if(i>=8 && i<12){
               temp3.add(i-8,myList.get(i).toString());
           }
       }
       //BOLUNEN DIZILERI GOSTERIYORUZ
       System.out.println("---------------------------------------------");
       System.out.println("DIZIDEN OLUSTURULAN 1. GRUP:");       
       displayArray(temp1);
       System.out.println("---------------------------------------------");
       System.out.println("DIZIDEN OLUSTURULAN 2. GRUP:");
       displayArray(temp2);
       System.out.println("---------------------------------------------");
       System.out.println("DIZIDEN OLUSTURULAN 3. GRUP:");
       displayArray(temp3);
       
       double arrayTemp1=0,arrayTemp2=0,arrayTemp3=0,result1=0,result2=0,result3=0;
       for(int i=0;i<temp1.size();i++){
           arrayTemp1=arrayTemp1+ Double.valueOf(temp1.get(i).toString());   
           arrayTemp2=arrayTemp2+ Double.valueOf(temp2.get(i).toString()); 
           arrayTemp3=arrayTemp3+ Double.valueOf(temp3.get(i).toString()); 
       }
       result1=arrayTemp1/temp1.size();
       result2=arrayTemp2/temp2.size();
       result3=arrayTemp3/temp3.size();
       
       for(int i=0;i<temp1.size();i++){
           temp1.set(i,result1);
           temp2.set(i,result2);
           temp3.set(i,result3);
       }
       
       System.out.println("---------------------------------------------");
       System.out.println("DIZIDEN OLUSTURULAN 1. GRUP (ORTALAMA):");
       displayArray(temp1);
       System.out.println("---------------------------------------------");
       System.out.println("DIZIDEN OLUSTURULAN 2. GRUP (ORTALAMA):");
       displayArray(temp2);
       System.out.println("---------------------------------------------");
       System.out.println("DIZIDEN OLUSTURULAN 3. GRUP (ORTALAMA):");
       displayArray(temp3);
       }else{
           System.out.println("ONCE DIZI OLUSTURMALISINIZ!");
       }  
   }
  static void smoothingByRange(List arr){
      if(arr.isEmpty()==false){
            //GECICI DIZILERIMIZI OLUSTURALIM
            List temp1=new ArrayList<Double>(),temp2=new ArrayList<Double>(),temp3=new ArrayList<Double>();  
       //ANA DIZIMIZI AYRI DIZIYE BOLUYORUZ
       for(int i=0;i<arr.size();i++){
           if(i<4){
               temp1.add(i,myList.get(i).toString());
           }else if(i>=4 && i<8){     
               temp2.add(i-4,myList.get(i).toString());
           }else if(i>=8 && i<12){
               temp3.add(i-8,myList.get(i).toString());
           }
       }
       //BOLUNEN DIZILERI GOSTERIYORUZ
       System.out.println("---------------------------------------------");
       System.out.println("DIZIDEN OLUSTURULAN 1. GRUP:");       
       displayArray(temp1);
       System.out.println("---------------------------------------------");
       System.out.println("DIZIDEN OLUSTURULAN 2. GRUP:");
       displayArray(temp2);
       System.out.println("---------------------------------------------");
       System.out.println("DIZIDEN OLUSTURULAN 3. GRUP:");
       displayArray(temp3);
       
       double arrayTemp1=0,arrayTemp2=0,arrayTemp3=0;
       arrayTemp1=(Double.valueOf(temp1.get(temp1.size()-1).toString())-Double.valueOf(temp1.get(0).toString()))/4;   
       arrayTemp2=(Double.valueOf(temp2.get(temp2.size()-1).toString())-Double.valueOf(temp2.get(0).toString()))/4;
       arrayTemp3=(Double.valueOf(temp3.get(temp3.size()-1).toString())-Double.valueOf(temp3.get(0).toString()))/4;
          
          temp1.clear();
          temp2.clear();
          temp3.clear();
       for(int i=0;i<4;i++){
           temp1.add(i, arrayTemp1);
           temp2.add(i,arrayTemp2);
           temp3.add(i,arrayTemp3);
       }
       
       System.out.println("---------------------------------------------");
       System.out.println("DIZIDEN OLUSTURULAN 1. GRUP (RANJ):");
       displayArray(temp1);
       System.out.println("---------------------------------------------");
       System.out.println("DIZIDEN OLUSTURULAN 2. GRUP (RANJ):");
       displayArray(temp2);
       System.out.println("---------------------------------------------");
       System.out.println("DIZIDEN OLUSTURULAN 3. GRUP (RANJ):");
       displayArray(temp3);
       }else{
           System.out.println("ONCE DIZI OLUSTURMALISINIZ!");
       }  
  }
  static void smoothingByBinBoudaries(List arr){
      if(arr.isEmpty()==false){
            //GECICI DIZILERIMIZI OLUSTURALIM
            List temp1=new ArrayList<Double>(),temp2=new ArrayList<Double>(),temp3=new ArrayList<Double>();  
       //ANA DIZIMIZI AYRI DIZIYE BOLUYORUZ
       for(int i=0;i<arr.size();i++){
           if(i<4){
               temp1.add(i,myList.get(i).toString());
           }else if(i>=4 && i<8){     
               temp2.add(i-4,myList.get(i).toString());
           }else if(i>=8 && i<12){
               temp3.add(i-8,myList.get(i).toString());
           }
       }
       //BOLUNEN DIZILERI GOSTERIYORUZ
       System.out.println("---------------------------------------------");
       System.out.println("DIZIDEN OLUSTURULAN 1. GRUP:");       
       displayArray(temp1);
       System.out.println("---------------------------------------------");
       System.out.println("DIZIDEN OLUSTURULAN 2. GRUP:");
       displayArray(temp2);
       System.out.println("---------------------------------------------");
       System.out.println("DIZIDEN OLUSTURULAN 3. GRUP:");
       displayArray(temp3);
       double arrayTemp1=0,arrayTemp2=0,arrayTemp3=0;
       
       for(int i=0;i<4;i++){
           double fark=0,fark2=0;
           fark=Math.abs(Double.valueOf(temp1.get(i).toString())-Double.valueOf(temp1.get(0).toString()));
           fark2=Math.abs(Double.valueOf(temp1.get(temp1.size()-1).toString())-Double.valueOf(temp1.get(i).toString()));
           if(fark<fark2){
               temp1.set(i, temp1.get(0));
           }else{
               temp1.set(i, temp1.get(temp1.size()-1));
           }
       }
       for(int i=0;i<4;i++){
           double fark=0,fark2=0;
           fark=Math.abs(Double.valueOf(temp2.get(i).toString())-Double.valueOf(temp2.get(0).toString()));
           fark2=Math.abs(Double.valueOf(temp2.get(temp2.size()-1).toString())-Double.valueOf(temp2.get(i).toString()));
           if(fark<fark2){
               temp2.set(i, temp2.get(0));
           }else{
               temp2.set(i, temp2.get(temp2.size()-1));
           }
       }
       for(int i=0;i<4;i++){
           double fark=0,fark2=0;
           fark=Math.abs(Double.valueOf(temp3.get(i).toString())-Double.valueOf(temp3.get(0).toString()));
           fark2=Math.abs(Double.valueOf(temp3.get(temp3.size()-1).toString())-Double.valueOf(temp3.get(i).toString()));
           if(fark<fark2){
               temp3.set(i, temp3.get(0));
           }else{
               temp3.set(i, temp3.get(temp3.size()-1));
           }
       }
       
       System.out.println("---------------------------------------------");
       System.out.println("DIZIDEN OLUSTURULAN 1. GRUP (SINIR):");
       displayArray(temp1);
       System.out.println("---------------------------------------------");
       System.out.println("DIZIDEN OLUSTURULAN 2. GRUP (SINIR):");
       displayArray(temp2);
       System.out.println("---------------------------------------------");
       System.out.println("DIZIDEN OLUSTURULAN 3. GRUP (SINIR):");
       displayArray(temp3);
      
       }else{
           System.out.println("ONCE DIZI OLUSTURMALISINIZ!");
       }  
  }



  //SMOOTHING BY NORMALISATION (MIN-MAKS norm, NEW MIN-MAKS, Z-SCORE)
  //NORMALIZATION MENU
  static void normalisationMenu(){
      System.out.println("\n");
      System.out.println("---NORMALISATION MENU---");
       System.out.println("1. MIN-MAKS Normalizasyonu");
           System.out.println("2. Yeni MIN-MAKS Normalizasyonu");
           System.out.println("3. Z-SCORE Normalizasyonu");
           System.out.println("4. UST MENU");
   }
  //NORMALIZATION MAIN
  static void normalisationMain(List arr){
       
       int menuNormalisation=0;
       
       if(arr.isEmpty()==false){
           do{
               
           normalisationMenu();
           Scanner mymenuNormalisation=new Scanner(System.in);
           menuNormalisation=mymenuNormalisation.nextInt();
               System.out.println("\n");
           
           
           if(menuNormalisation==1){
               displayArray(arr);
               System.out.println("LISTEDEN NORMALIZASYONU BULUNACAK SAYIYI SECINIZ:");
               double numb=0;
               Scanner choseNumb=new Scanner(System.in);
               numb=choseNumb.nextDouble();
               minMaksNormalisation(numb,myList);
               
               
           }else if(menuNormalisation==2){
               displayArray(arr);
               System.out.println("LISTEDEN YENI NORMALIZASYONU HESAPLANACAK DEGERI SECINIZ: ");
               double numb=0,maks=0,min=0;
               Scanner choseNumb=new Scanner(System.in);
               Scanner newMaks=new Scanner(System.in);
               Scanner newMin=new Scanner(System.in);
               numb=choseNumb.nextDouble();
               
               System.out.println("YENI MAKSIMUM DEGER: ");
               maks=newMaks.nextDouble();
               System.out.println("YENI MINIMUM DEGER: ");
               min=newMin.nextDouble();
               
               newMinMaksNormalisation(numb,maks,min,myList);
               
           }else if(menuNormalisation==3){
               displayArray(arr);
               System.out.println("LISTEDEN ZSCORE' u HESAPLANACAK DEGERI SECINIZ: ");
               double numb=0;
               Scanner choseNumb=new Scanner(System.in);
                numb=choseNumb.nextDouble();
               zScoreNormalisation(myList,numb);
               
           }else if(menuNormalisation==4){
               menuNormalisation=6;
           }else{
               System.out.println("Hatalı Giriş!");
           }
       }while(menuNormalisation!=6);
       }else{
           System.out.println("ONCE DIZI OLUSTURMALISINIZ!");
       }
       
       
       
   }
  //HESAPLAYAN FONKSIYONLAR
  static void minMaksNormalisation(double number, List arr){
      double result=0;
      result=(number-Double.valueOf(arr.get(0).toString()))/(Double.valueOf(arr.get(arr.size()-1).toString())-Double.valueOf(arr.get(0).toString()));
      System.out.println("SECILEN SAYININ NORMALIZE DEGERI: "+ result);
      System.out.println("------------------------------------------------------");
  }
  static void newMinMaksNormalisation(double number,double newMax,double newMin, List arr){
      double result=0;
      result=(number-Double.valueOf(arr.get(0).toString()))/(Double.valueOf(arr.get(arr.size()-1).toString())-Double.valueOf(arr.get(0).toString()));
      result=result*(newMax-newMin)+newMin;
      System.out.println("SECILEN SAYININ "+newMin +"-"+newMax+" ARALIGINDA YENI NORMALIZE DEGERI: "+ result);
      System.out.println("------------------------------------------------------");
  }  
  static void zScoreNormalisation(List arr,double number){
      double sum=0,standartD=0, length=arr.size(),zScore=0;
      for(int i=0;i<arr.size();i++){
          sum=sum+Double.valueOf(arr.get(i).toString());
      }
      double mean= sum/length;
      
     for(int i=0;i<arr.size();i++){
         standartD=standartD+Math.pow(Double.valueOf(arr.get(i).toString())-mean,2);
     }
     standartD=Math.sqrt(standartD/arr.size());
     
     zScore=number-mean/standartD;
      System.out.println("LISTENIN STANDAR SAPMASI: "+standartD);
      System.out.println("LISTENIN ORTALAMASI: "+mean);
      System.out.println("SECILEN SAYININ Z SCORE' u: "+zScore);
  }
  
  //VERI DONUSUMU MENU
  static void jackNifeAndExpectationMenu(){
      System.out.println("\n");
      System.out.println("--- JACK-KNIFE & EXPECTATION MAXIMISATION Kuralı MENU---");
       System.out.println("1. DIZI OLUSTUR");
      System.out.println("2. DIZIYI GOSTER");
      System.out.println("3. DIZIYI SIRALA");
      System.out.println("4. KAYIP DEGER SAYISINI BELIRLE");
      System.out.println("5. HATA PAYINI BELİRLE (e)");
      System.out.println("6. EKSIK DEGERLER ICIN GENEL DEGER ATAYIN");
      System.out.println("7. EXPECTATION MAXIMISATION");
      System.out.println("8. JACK-KNIFE HESAPLA");
      System.out.println("9. UST MENUYE DON");
  }
  static void jackNifeAndExpectationMain(){
       int menu=0;
     do{
         jackNifeAndExpectationMenu();
         System.out.println("\n");
         Scanner chose=new Scanner(System.in);
         int select=chose.nextInt();
         System.out.println("\n");
         
         if(select==1){
             //DIZI OLUSTUR
             Scanner maks=new Scanner(System.in);
             Scanner numb=new Scanner(System.in);
             int max=0, num=0;
             System.out.println("DIZI 0 ILE HANGI ARALIKTA OLSUN: ");
             max=maks.nextInt();
             System.out.println("DIZIDE KAÇ ADET SAYI OLSUN: ");
             num=numb.nextInt();
             createArrayforData(max,num);
             
         }else if(select==2){
             //DIZIYI GOSTER
             displayArray(myListData);
         }else if(select==3){
             //DIZIYI SIRALA
             sortStaticArray(myListData);
         }else if(select ==4){
             // KAYIP DEGER
              Scanner missingNumb=new Scanner(System.in);
              System.out.println("KAC ADET SAYI BILINMIYOR: ");
              missing =missingNumb.nextInt();
         }else if(select==5){
             // HATA PAYI
             Scanner eValue=new Scanner(System.in);
             System.out.println("HATA PAYI: ");
             e =eValue.nextDouble();
         }else if(select==6){
             //EKSIK DEGER GENEL ATAMA
             Scanner xpValue=new Scanner(System.in);
             System.out.println("BILINMEYEN DEGERLERE GENEL ATAMA: ");
             xp =xpValue.nextInt();
         }else if(select==7){
             //EXPECTATION
             ExpectationMaximisation(missing,e,xp,myListData);
         }else if(select==8){
             //JACKKNIFE
             JackKnife(missing,e,xp,myListData);
         }else if(select==9){
             //UST MENUYE CIKIS
             menu=10;
         }else{
             System.out.println("HATALI GIRIS!");
         }
     }while(menu!=10);
  }
  static void ExpectationMaximisation(int missing, double e, int numb, List arr){
        int data=0, xpValue=0,breakP=0;
      double dataMean=0,xpMean=0,result=0;
          xpValue=(numb*missing);
          do{
        for(int j=0;j<arr.size();j++){
            data=data+(int)arr.get(j);
        }
        
        dataMean=data/arr.size();
        xpMean=xpValue/arr.size();
        if((xpMean+dataMean)-numb<e){
            breakP=1;
        }else{
            numb=(int)(xpMean+dataMean);
            data=0;
        }
      }while(breakP!=1);
    result=(double)(xpMean+dataMean);
          System.out.println("Sonuç:");
    System.out.println("xP TOPLAMI: "+xpValue);
    System.out.println("xP ORTALAMA: "+xpMean);
    System.out.println("VERILERIN ORTALAMASI: " +dataMean);
    System.out.println("KAYIP SAYI TAHMINI: "+result);
    result=0;
    dataMean=0;
    xpMean=0;
  }
  static void JackKnife(int missing, double e, int numb, List arr){
      int data=0, xpValue=0,breakP=0;
      double dataMean=0,xpMean=0,result=0;
      for(int i=0;i<missing;i++){
          xpValue=(numb*missing);
          do{
        for(int j=0;j<arr.size();j++){
            data=data+(int)arr.get(j);
        }
        
        dataMean=data/arr.size();
        xpMean=xpValue/arr.size();
        if((Math.abs(xpMean+dataMean))-numb<e){
            breakP=1;
        }else{
            numb=(int)(xpMean+dataMean);
            data=0;
        }
      }while(breakP!=1);
    result=(double)Math.abs((xpMean+dataMean));
          System.out.println((i+1)+". Sonuçlar:");
    System.out.println("xP TOPLAMI: "+xpValue);
    System.out.println("xP ORTALAMA: "+xpMean);
    System.out.println("VERILERIN ORTALAMASI: " +dataMean);
    System.out.println("KAYIP SAYI TAHMINI: "+result);
    result=0;
    dataMean=0;
    xpMean=0;
    
    }
  }
  //VERI DONUSUMU ICIN DINAMIK DIZI
  static void createArrayforData(int maks,int number){
      
      if(myListData.isEmpty()==true){
          Random rand= new Random();
          for(int i=0;i<number;i++){
            int numb=rand.nextInt(maks);
            if(numb==0){
              numb=rand.nextInt(maks);
            }
          myListData.add(i, numb);
        }
           System.out.println("DIZI OLUSTURULDU! \n");
      }else{
          myMaxData.clear();
          myMinData.clear();
          
          myListData.clear();
          Random rand= new Random();
      
      for(int i=0;i<number;i++){
          int numb=rand.nextInt(maks);
          if(numb==0){
              numb=rand.nextInt(maks);
          }
          myListData.add(i, numb);
      }
           System.out.println("DIZI YENILENDI! \n");
      }
     
  }
 //OLUSTURULAN DIZIYI SIRALAMA
 static void sortStaticArray(List arr){
     if(arr.isEmpty()==false){
         Collections.sort(arr);
         System.out.println("DIZI SIRALANDI! \n");
     }else{
         System.out.println("Once DIZI OLUSTURMALISINI! \n");
     }
 }

 
 

 
}
