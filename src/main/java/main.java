import java.util.Scanner;

public class main {

    public static String denarytobinary(String input) {
        Scanner sc = new Scanner(System.in);
        boolean validation = false;
        int number;

        while (!validation) {
            if (input.matches("[0-9]") || input.matches("[0-9][0-9]") || input.matches("[0-9][0-9][0-9]")) {
                number = Integer.parseInt(input);
                if (number < 256) {
                    validation = true;
                }
            } else {
                System.out.println("Number does not meet requirements.");
                System.out.println("Please input a number less than 256.");
                input = sc.nextLine();
            }
        }

        String binary = "";
        number = Integer.parseInt(input);
        int j = 128;
        int k = 127;

        for (int i = 0; i < 8; i++) {
            if (number > k) {
                binary = binary + "1";
                number -= j;
            } else {
                binary = binary + "0";
            }
            j /= 2;
            k = j - 1;
        }

        return binary;
    }


    public static int binarytodenary(String binary) {
        Scanner sc = new Scanner(System.in);
        boolean validation = false;

        while (!validation) {
            if (binary.length() == 8 && binary.matches("[0-1]")) {
                validation = true;
            } else {
                System.out.println("Code does not meet requirements.");
                System.out.println("Please input a 8 digit binary number.");
                binary = sc.nextLine();
            }
        }

        String[] digits = {};
        int output = 0;
        digits = binary.split("");

        if (digits[0].equals("1")) {
            output =+ 128;
        }
        if (digits[1].equals("1")) {
            output =+ 64;
        }
        if (digits[2].equals("1")) {
            output =+ 32;
        }
        if (digits[3].equals("1")) {
            output =+ 16;
        }
        if (digits[4].equals("1")) {
            output =+ 8;
        }
        if (digits[5].equals("1")) {
            output =+ 4;
        }
        if (digits[6].equals("1")) {
            output =+ 2;
        }
        if (digits[7].equals("1")) {
            output =+ 1;
        }

        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;
        String input;
        System.out.println("Please input 'binarytodenary' for binary to denary conversion.");
        System.out.println("Please input 'binarytohex' for binary to hexadecimal conversion.");
        System.out.println("Please input 'denarytobinary' for denary to binary conversion.");
        System.out.println("Please input 'denarytohex' for denary to hex conversion.");
        System.out.println("Please input 'hextobinary' for hexadecimal to binary conversion.");
        System.out.println("Please input 'hextodenary' for hexadecimal to denary conversion.");
        choice = sc.nextLine();

        if (choice.equals("binarytodenary")) {
            System.out.println("Please input a 8 digit binary number.");
            input = sc.nextLine();
            System.out.println(binarytodenary(input));
        }
        if (choice.equals("denarytobinary")) {
            System.out.println("Please input a number less than 256.");
            input = sc.nextLine();
            System.out.println(denarytobinary(input));
        }

    }

}
