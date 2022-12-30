import java.util.Scanner;

public class secretmessage {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       int numberOfMessages = input.nextInt();
       input.nextLine();
       String[] messages = new String[numberOfMessages];
        for (int i = 0; i < numberOfMessages; i++) {
            String message = input.nextLine();
            message = makeSecretMessage(message);
            messages[i] = message;
        }
        print(messages);
    }
    public static int getSquareRoot(String message){
        int length = message.length();
        boolean done = false;
        int number;
        int squareRoot = 0;
        while (!done){
            number = squareRoot*squareRoot;
            if(number>=length){
                done = true;
            } else {
                number = 0;
                squareRoot++;
            }
        }
        return squareRoot;
    }
    public static String secretMessage(String message, int squareRoot){
        String newMessage = "";
        int index = message.length() - squareRoot;
        for (int j = 0; j < squareRoot; j++) {
            newMessage += message.charAt(index);
            int counter = index;
            int index2 = counter-squareRoot;
            for (int k = 0; k < squareRoot-1; k++) {
                newMessage += message.charAt(index2);
                index2 -= squareRoot;
            }
            index++;
        }
        return newMessage;
    }
    public static void print(String[] messages){
        for (String message : messages) {
            System.out.println(message);
        }
    }
    public static String removeSymbols(String message, int square){
        String result = "";
        for (int j = 0; j < square; j++) {
            if(message.charAt(j) != '*'){
                result += message.charAt(j);
            }
        }
        return result;
    }
    public static String addSymbols(String message, int square){
        for (int j = message.length(); j < square; j++) {
            message += "*";
        }
        return message;
    }
    public static String makeSecretMessage(String message){
        int squareRoot = getSquareRoot(message);
        int square = squareRoot*squareRoot;
        message = addSymbols(message, square);
        message = secretMessage(message, squareRoot);
        message = removeSymbols(message, square);
        return message;
    }
}
