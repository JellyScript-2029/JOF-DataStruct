package random;
public class Lyrics {
    public static void main(String[] args) throws InterruptedException {
        String lyrics1 = "If you love me, baby, let me hear you say it";
        String lyrics2 = "I know I'm your favorite";
        String lyrics3 = "First you love me, then you leave me in the basement";
        String lyrics4 = "I know I'm your favorite";
        String lyrics5 = "If you love me, baby, let me hear you say it";
        String lyrics6 = "I know I'm your favorite";
        String lyrics7 = "First you love me, then you leave me on the pavement"; 
        String lyrics8 = "I know I'm your favorite";

        for (int i = 0; i < lyrics1.length(); i++) {
            System.out.print(lyrics1.charAt(i));
                Thread.sleep(80);
        }
        System.out.println();
        for (int i = 0; i < lyrics2.length(); i++) {
            System.out.print(lyrics2.charAt(i));
            Thread.sleep(80); 
        }
        System.out.println(); Thread.sleep(2700);
        for (int i = 0; i < lyrics3.length(); i++) {
            System.out.print(lyrics3.charAt(i));
            Thread.sleep(70); 
        }
        System.out.println(); 
        for (int i = 0; i < lyrics4.length(); i++) {
            System.out.print(lyrics4.charAt(i));
            Thread.sleep(80); 
        
        }
        System.out.println();Thread.sleep(2500);
        for (int i = 0; i < lyrics5.length(); i++) {
            System.out.print(lyrics5.charAt(i));
            Thread.sleep(80); 
        
        }
        System.out.println();
        for (int i = 0; i < lyrics6.length(); i++) {
            System.out.print(lyrics6.charAt(i));
            Thread.sleep(80); 
        
        }
        System.out.println(); Thread.sleep(2600);
        for (int i = 0; i < lyrics7.length(); i++) {
            System.out.print(lyrics7.charAt(i));
            Thread.sleep(70); 
        
        }
        System.out.println();
        for (int i = 0; i < lyrics8.length(); i++) {
            System.out.print(lyrics8.charAt(i));
            Thread.sleep(80); 
        
        }
        System.out.println();
    }
}