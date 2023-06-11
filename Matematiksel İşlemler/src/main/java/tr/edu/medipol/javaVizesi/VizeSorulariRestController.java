package tr.edu.medipol.javaVizesi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@RestController
public class VizeSorulariRestController {

    @GetMapping("/")
    public String kok (){
        return String.format("Muhammet Talha GÜR - H5210049");
    }

    @GetMapping("/soru1")
    public static Set<String> getOrtakKelimeler(String cumle1, String cumle2) {
        try {
            cumle1 = cumle1.toLowerCase();
            cumle2 = cumle2.toLowerCase();

        }

        catch (Exception e)
        {
          System.out.println("Hatalı giriş");
        }


        List<String> c1Kelimeleri = Arrays.asList(cumle1.split(" "));
        List<String> c2Kelimeleri = Arrays.asList(cumle2.split(" "));

        Set<String> ortakKelimeler = new HashSet<>();


        for (String kelime : c1Kelimeleri) {
            if (c2Kelimeleri.contains(kelime)) {
                ortakKelimeler.add(kelime);
            }
        }

        return ortakKelimeler;
    }

    @GetMapping ("/soru2")

    public static String duzenle(String metin) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < metin.length(); i++) {
            char karakter = metin.charAt(i);

            if (karakter != ' ') {
                sb.append(Character.toUpperCase(karakter));
            }
        }

        return sb.toString();
    }


    @GetMapping("/soru3")
    public static int[] Hesapla(int kisaYaricap, int uzunYaricap) {
        int alan = (int) (Math.PI * kisaYaricap * uzunYaricap);
        int cevre1 = (int) (Math.PI * (kisaYaricap + uzunYaricap));
        int cevre2 = (int) (Math.PI * Math.sqrt(2 * (kisaYaricap * kisaYaricap + uzunYaricap * uzunYaricap)));
        int cevre3 = (int) (Math.PI * ((3 * (kisaYaricap + uzunYaricap)) / 2 - Math.sqrt(kisaYaricap * uzunYaricap)));
        int[] sonuclar = {alan, cevre1, cevre2, cevre3};
        return sonuclar;
    }

    @GetMapping("/soru4")
    public static boolean DosyayaYazdir(int i) {

        String dosyaAdi = "karekokler_" + i + ".txt";

       //Burada önce "PrintWritter" metodu ile önce girdileri Stringe çeviriyoruz. Daha sonra "FileWritter" ile dosyaya yazdırıyoruz.
       //Herhangi bir sorun olursa diye try catch içine koyuyoruz. Eğer hata alırsa catch ile kullanıcının hata aldığını bildiriyoruz.
        try (PrintWriter yazdir = new PrintWriter(new FileWriter(dosyaAdi))) {

            for (int j = 0; j <= i; j++) {
                int karekok = (int) Math.sqrt(j);
                System.out.println("Yazdırma İşlemi Başarıyla Gerçekleşti!");
                yazdir.println(karekok);
            }
            return true;

        } catch (IOException exception) {  //Burada IOException kullanmamızın sebebi üzerinde çalıştığımız şeyin, dosya yazdırmakla ilgili olmasından dolayıdır.
            exception.printStackTrace();
            System.out.println("Yazdırmada Bir Hata Alındı");
            return false;
        }
    }



        public static void main (String[]args){

            Scanner scanner = new Scanner(System.in);

            // Soru 1
            System.out.print("İlk cümleyi giriniz: ");
            String cumle1 = scanner.nextLine();

            System.out.print("İkinci cümleyi giriniz: ");
            String cumle2 = scanner.nextLine();

            Set<String> ortakKelime = getOrtakKelimeler(cumle1, cumle2);


            if (ortakKelime.isEmpty()) {
                System.out.println("Ortak kelime yok.");
            } else {
                System.out.println("Ortak kelimeler:  ");
                for (String word : ortakKelime) {
                    System.out.println(word);
                }
            }

            // Soru 2
            System.out.print("Bir metin giriniz: ");
            String metin = scanner.nextLine();

            String sonuc = duzenle(metin);

            System.out.println("Gİrdiğiniz metnin boşlukları düzenlendi ve bütün harfler büyük harf ile değiştirildi.");
            System.out.println("Düzenlenen yeni metin: " + sonuc);


            // Soru 3
            System.out.print("Elipsin kısa yarıçapını giriniz: ");
            int kisaYaricap = scanner.nextInt();

            System.out.print("Elipsin uzun yarıçapını giriniz: ");
            int uzunYaricap = scanner.nextInt();

            int[] hesaplamalar = Hesapla(kisaYaricap, uzunYaricap);

            System.out.println("Elipsin alanı: " + hesaplamalar[0]);
            System.out.println("1. Formul ile çözüm : " + hesaplamalar[1]);
            System.out.println("2. Formul ile çözüm : " + hesaplamalar[2]);
            System.out.println("3. Formul ile çözüm : " + hesaplamalar[3]);

            // Soru 4
            int i = 10;
            boolean yazdirma = DosyayaYazdir(i);
            if (yazdirma) {
                System.out.println("Karakökler dosyaya başarıyla yazıldı!");
            } else {
                System.out.println("Dosya yazılırken bir hata oluştu!");
            }

        }
    }


