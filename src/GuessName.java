import java.util.Scanner;

public class GuessName {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        String yourName = input.nextLine();

        String name = yourName.toLowerCase();

        int sum = 0;
        for (int i = 0; i < name.length(); i++){

            switch (name.charAt(i)){
                case 'a', 'j', 's':
                    sum+=1;
                    break;
                case 'b', 'k', 't':
                    sum+=2;
                    break;
                case 'c', 'l', 'u':
                    sum+=3;
                    break;
                case 'd', 'm', 'v':
                    sum+=4;
                    break;
                case 'e', 'n', 'w':
                    sum+=5;
                    break;
                case 'f', 'o', 'x':
                    sum+=6;
                    break;
                case 'g', 'p', 'y':
                    sum+=7;
                    break;
                case 'h', 'q', 'z':
                    sum+=8;
                    break;
                case 'i', 'r':
                    sum+=9;
                    break;
            }
        }
        while (sum>9){
            sum-= 9;
        }
        System.out.println("You are in chapter : " +sum);
    }
}
