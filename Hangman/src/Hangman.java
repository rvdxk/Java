import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman
{
    List<String> words = List.of("komputer", "monitor", "klawiatura", "mysz", "drukarka", "skaner");
    //lista słów do odgadnięcia

    String word; // losowane słowo
    char[] userWord; //tworzenie tablicy dla wylosowanego słowa
    int lives = 3; //liczba żyć w grze

    public void play()
    {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        word = words.get(random.nextInt(words.size()));

        userWord = new char[word.length()];
        Arrays.fill(userWord, '_'); //wypełnienie pola znakiem: '_', przed odgadnięciem hasła

        while (!gameEnded())
        {
            System.out.println(userWord);

            System.out.println();

            if (lives > 1)
            {
                System.out.println("Pozostały Ci " + lives + " życia.");
            }
            else if (lives == 1)
            {
                System.out.println("Pozostało Ci " + lives + " życie.");
            }
            System.out.println();
            System.out.println("Wprowadź literę: ");

            char letter = scanner.nextLine().charAt(0);

            checkLetter(letter); //metoda sprawdzająca czy litera znajduję sie w haśle
        }

        if (lives == 0)
        {
            System.out.println("Wykorzystałeś wszystkie życia. Powodzenia następnym razem :)");
        } else {
            System.out.println("Brawo! Udało Ci się odgadnąc nasze słowo :)");
        }

        scanner.close();
    }

    private void checkLetter(char letter) {
        boolean foundLetter = false;

        for (int i = 0; i < word.length(); i++)
        {
            if (word.charAt(i) == letter) //jeżeli litera z hasła jest równa wprowadzanej
            {
                userWord[i] = letter; //uzupełnienie tablicy userWord, wprowadzoną literą
                foundLetter = true; //gdy odnajdziemy litere, wartość zmienia się na true
            }
        }

        if(!foundLetter && lives >= 1)
        {
            System.out.println("Niestety błędna litera. Spróbuj jeszcze raz.");
            lives--; // odejmujemy jedno życie
        }
    }



    private boolean gameEnded()
    {
        return lives == 0 || word.equals(String.valueOf(userWord));
        //gdy liczba żyć bedzie wynosić zero lub hasła bedą takie same, gra się zakończy
    }
}
