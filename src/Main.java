import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Question> questionList = new ArrayList<>();

        File data = new File("./data.txt");
        Scanner read = new Scanner(data);
        while (read.hasNextLine()) {
            String line = read.nextLine();
            if (line.isEmpty()) {
                read.close();
                break;
            }
            String[] input = line.split(";");
            questionList.add(new Question(input[0], input[1].equals("I")));
        }
        read.close();
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        double point = 0;
        int answered = 0;
        while (answered < 15) {
            int randomindex = rnd.nextInt(0, questionList.size());
            Question current = questionList.remove(randomindex);
            System.out.println(current.question);
            String line = sc.nextLine();
            boolean ans = line.toLowerCase().equals("i");
            answered++;
            point += ans == current.answer ? 1 : -0.5;
            System.out.println((ans == current.answer ? "Helyes" : ("Helytelen. A helyes válasz: " + current.toString())) + "\tPontok: " + point + " - Százalék: " + (point/answered)*100 + "%\n");
        }
        sc.close();
        System.out.println("Pontok: " + point + "\nSzázalékos eredmény: " + (point/answered) * 100);
    }
}