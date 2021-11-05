package HomeWorks;

import java.util.Scanner;
public class IkinciDereceDenlemleri {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("(ax²+bx+c)Ýkinci Dereceden Bir Denklemdir. \n Denklemin Deðerlerini Sýrayla Giriniz...");
		System.out.println("a Deðerini Giriniz: ");
		double a=sc.nextInt();
		System.out.println("b Deðerini Giriniz: ");
		double b=sc.nextInt();						
		System.out.println("c Deðerini Giriniz: ");
		double c=sc.nextInt();
		
		
		double delta =(b * b)-(4 * a * c);
		if (delta >0) {
			double x1=((-1*b)- Math.sqrt(delta))/(2 * a);
			double x2=((-1*b)+ Math.sqrt(delta))/(2 * a);
			System.out.println(" x1="+ x1 +  "\n x2="+ x2);						
		}
		if (delta <0) {
			System.out.println("Denklemin Gerçel Kökü Yoktur!");	
}
		if(delta==0) {
			double x= (-1 * b)/(2 * a);
			System.out.println("Çakýþýk Kökü Vardýr: x1=x2"+x);
		}
		
	}

}
