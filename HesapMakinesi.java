/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
-- BU PROGRAMDA BASİT HESAP MAKİNESİ İŞLEMLERİ YANINDA 
-- BELİRLİ DÖNGÜLER İLE OLUŞTURULACAK HESAPLAMALAR YAPILACAK
-- TOPLAMA/ ÇIKARMA/ ÇARPMA/ BÖLME/ KALAN HESAPLAMA/ FAKTÖRİYEL/ ÜS HESAPLAMA/ KAREKÖK ALMA/ İKİ SAYI İLE TOPLAMA/ÇARPMA/TEK/ÇİFT İŞLEMLERİ
-- GENEL OLARAK SEÇİLEN İŞLEM SONRASI BELİRTİLEN ADIMLAR GERÇEKLEŞTİRİLİP İSTENEN İŞLEM YERİNE GETİRİLECEK
*/

package hesapmakinesi;

import java.util.Scanner;

/**
 *
 * @author melih
 */
public class HesapMakinesi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Scanner sec=new Scanner(System.in);
        
        
        int secim=-1;
         
        
        while(secim==-1) // MENÜYÜ HER İŞLEM SONRASI KARŞIMIZA ÇIKARMASI İÇİN GEREKLİ WHILE DÖNGÜSÜ
        {
            //ÖRNEK MENÜMÜZ. BURADAN SEÇİLEN İŞLEME GÖRE YÖNLENDİRME YAPILACAK
            System.out.println("0. Çıkış");
            System.out.println("1. Toplama ");
            System.out.println("2. Çıkarma ");
            System.out.println("3. Çarpma ");
            System.out.println("4. Bölme ");
            System.out.println("5. Kalan Hesaplama ");
            System.out.println("6. Faktöriyel ");
            System.out.println("7. Üs Hesaplama");
            System.out.println("8. Karekök Alma");
            System.out.println("9. İki Sayı Arasındaki Tek Sayıları Bulma ");
            System.out.println("10. İki Sayı Arasındaki Çift Sayıları Bulma");
            System.out.println("11. İki Sayı Arasındaki Sayıların Toplamı ");
            System.out.println("12. İki Sayı Arasındaki Sayıların Çarpımı ");
            
            int menu=sec.nextInt();

            if(menu==0) //ÇIKIŞ İŞLEMİNİN GERÇEKLEŞTİĞİ İF ELSE BLOĞU
            {
                secim+=1;
            }
            else if(menu==1) // TOPLAMA İŞLEMİ
            {
                System.out.println("\nTOPLANACAK SAYILARI GİRİNİZ:(İşlemi bitirmek için (0) )\n");
                double toplam=0;
                char son=' ';
                while(son==' ')
                {              
                    double islem=sec.nextDouble();
                    if(islem==0)
                    {
                        System.out.println("\nGİRİLEN SAYILARIN TOPLAMI:"+ toplam);
                        son='+';
                        
                    }
                    else
                    {
                        toplam=toplam+islem;
                    }
                }
                

            }
            else if(menu==2) //ÇIKARMA İŞLEMİ
            {
                System.out.println("\nBAŞLANGIÇ SAYISINI GİRİNİZ:");
                double sayi1=sec.nextDouble();
                System.out.println("\nÇIKARILACAK SAYILARI GİRİNİZ:(İslemi bitirmek için (0) )\n");
                double cikarma=0;
                char son=' ';
                
                while(son==' ')
                {              
                    double islem=sec.nextDouble();
                    
                    if(islem==0)
                    {
                        System.out.println("\nGİRİLEN SAYILARIN FARKI:"+ cikarma+" \n");
                        son='-';
                    }
                    else
                    {
                        cikarma=sayi1-islem;
                        sayi1=cikarma;
                    }
                }
            }
            else if(menu==3) //ÇARPMA İŞLEMİ
            {
                System.out.println("\nÇARPILACAK SAYILARI GİRİNİZ:(İşlemi bitirmek için (0) )\n");
                double carpim=1;
                char son=' ';
                while(son==' ')
                {              
                    double islem=sec.nextDouble();
                    if(islem==0)
                    {
                        System.out.println("\nGİRİLEN SAYILARIN ÇARPIMI:"+ carpim);
                        son='*';
                        
                    }
                    else
                    {
                        carpim=carpim*islem;
                    }
                }
            }
            else if(menu==4) //BÖLME İŞLEMİ
            {
                System.out.println("\nBAŞLANGIÇ SAYISINI GİRİNİZ:");
                double sayi1=sec.nextDouble();
                System.out.println("\nBÖLEN SAYILARI GİRİNİZ:(İslemi bitirmek için (0) )\n");
                double bolme=0;
                char son=' ';
                
                while(son==' ')
                {              
                    double islem=sec.nextDouble();
                    
                    if(islem==0)
                    {
                        System.out.println("\nGİRİLEN SAYILARIN BÖLÜMÜNDEN KALAN:"+ bolme+" \n");
                        son='-';
                    }
                    else
                    {
                        bolme=sayi1/islem;
                        sayi1=bolme;
                    }
                }
            }
            else if(menu==5)//MOD ALMA İŞLEMİ
            {
                char son=' ';
                double kalan=0;
                while(son==' ')
                {        
                    System.out.println("\nBAŞLANGIÇ SAYISINI GİRİNİZ:(İslemi bitirmek için (0))\n");
                    double sayi1=sec.nextDouble();
                    
              
                    if(sayi1==0)
                    {
                        System.out.println("\nBÖLÜMDEN KALAN:"+ kalan+" \n");
                        son='-';
                        
                    }
                    else
                    {
                        System.out.println("\nBÖLEN SAYISINI GİRİNİZ:\n");
                        double islem=sec.nextDouble();
                        kalan=sayi1%islem;
                        
                    }
                }
            }
            else if(menu==6)//FAKTÖRİYEL İŞLEMİ
            {
                System.out.println("\nFAKTÖRİYEL ALINACAK SAYIYI GİRİNİZ:");
                int fak=sec.nextInt();
                int sonuc=1;
                for(int i=fak;i>1;i--)
                {
                    sonuc=sonuc*i;
                }
                System.out.println("\nGİRİLEN SAYININ FAKTÖRİYELİ:"+ sonuc);
                
            }
            else if(menu==7) // ÜS ALMA İŞLEMİ
            {
                System.out.println("\nÜSSÜ ALINACAK SAYININ TABAN DEĞERİ:");
                double taban=sec.nextDouble();
                System.out.println("\nÜSSÜ ALINACAK SAYININ ÜS DEĞERİ:");
                double us=sec.nextDouble();
                double sonuc=1;
                for(double i=us;i>=1;i--)
                {
                    sonuc*=taban;
                }
                System.out.println(taban+" SAYISININ "+ us+".DERECEDEN ÜSSÜ: "+sonuc);
            }
            else if(menu==8) //KÖK ALMA İŞLEMİ
            {
                System.out.println("\nKÖKÜ ALINACAK SAYI: ");
                double ic=sec.nextDouble();
                System.out.println("\n"+ic+" SAYISININ KÖKÜ: "+ Math.sqrt(ic));
                
            }
            else if(menu==9) //TEK SAYILARI YAZDIRMA İŞLEMİ
            {
                System.out.println("\nBAŞLANGIÇ SAYISINI GİRİNİZ: ");
                double sayi1=sec.nextDouble();
                System.out.println("\nBİTİŞ SAYISINI GİRİNİZ: ");
                double sayi2=sec.nextDouble();
                
                for(double i=sayi1;i<=sayi2;i++)
                {
                    if(i%2!=0)
                    {
                        System.out.println("\nTEK SAYI:"+i);
                    }
                }
                
            }
            else if(menu==10)//ÇİFT SAYILARI YAZDIRMA İŞLEMİ
            {
                System.out.println("\nBAŞLANGIÇ SAYISINI GİRİNİZ: ");
                double sayi1=sec.nextDouble();
                System.out.println("\nBİTİŞ SAYISINI GİRİNİZ: ");
                double sayi2=sec.nextDouble();
                
                for(double i=sayi1;i<=sayi2;i++)
                {
                    if(i%2==0)
                    {
                        System.out.println("\nÇİFT SAYI:"+i);
                    }
                }
            }
            else if(menu==11)// İKİ SAYI ARASINDAKİ SAYILARI TOPLAMA İŞLEMİ
            {
                System.out.println("\nBAŞLANGIÇ SAYISINI GİRİNİZ: ");
                double sayi1=sec.nextDouble();
                System.out.println("\nBİTİŞ SAYISINI GİRİNİZ: ");
                double sayi2=sec.nextDouble();
                double toplam=0;
                for(double i=sayi1;i<=sayi2;i++)
                {
                    toplam=toplam+i;
                }
                System.out.println(sayi1+" DEN "+sayi2+" YE KADAR OLAN SAYILARIN TOPLAMI: "+toplam);
                
            }
            else if(menu==12) //İKİ SAYI ARASINDAKİ SAYILARIN ÇARPIMI
            {
                System.out.println("\nBAŞLANGIÇ SAYISINI GİRİNİZ: ");
                double sayi1=sec.nextDouble();
                System.out.println("\nBİTİŞ SAYISINI GİRİNİZ: ");
                double sayi2=sec.nextDouble();
                double carpim=1;
                for(double i=sayi1;i<=sayi2;i++)
                {
                    carpim=carpim*i;
                }
                System.out.println(sayi1+" DEN "+sayi2+" YE KADAR OLAN SAYILARIN ÇARPIMI:"+carpim);
            }
            else
            {
                System.out.println("\nHATALI GİRİŞ!\n");
            }
            
            
        }
        
      
    }
    
}
