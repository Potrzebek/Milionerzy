import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
/*
    Java FX, Swing
 */
// JFRAME klasa, która Tworzy okienko w Javie

// Main dziediczy po JFRAME
// Main staje się okienkiem
// ponieważ dostaje wszystkie pola i metody
// które posiada klasa JFrame
public class Main extends JFrame implements ActionListener {
    // okna zawiera 2 buttony, i label
    private QuestionGenerator questionGenerator;
    public QuestionGenerator getQuestionGenerator() {
        return questionGenerator;
    }
    public void setQuestionGenerator(QuestionGenerator questionGenerator) {
        this.questionGenerator = questionGenerator;
    }
    private int currentQuestion;
    private List<Question> questionList = new ArrayList<>();
    // konstruktor klasy Main = domyślny, ale nadpisywany
    public Main(){
        setQuestionGenerator(new SimpleQuestionGenerator());
        questionList = questionGenerator.generateQuestions();
        setSize(500,500); // ustawia wielkość okna
        // metoda setSize() znajduje się w JFRAME
        setTitle("Millionaires"); // ustawia tytuł okna
        // metoda znajduje się w klasie JFRAME
        setVisible(true); // ustawiemy widoczne okno
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // zamykanie okna metoda setDefualtCloseOperation
        // WindowConstants.EXIT_ON_CLOSE
        // jest zmienna która jest w klasie WindowsConstans
        // i ma wartość 3
        // JButtonie taki zdefiniowano konstruktor
        JButton yesButton = new JButton("TAK");
        yesButton.addActionListener(this);

        JButton noButton = new JButton("NIE");
        noButton.addActionListener(this);
        label = new JLabel(questionList.get(currentQuestion).getContent(),
                0); // 0 wycentrowanie label
        // 3 rzędy, 1 kolumna
        setLayout(new GridLayout(3,1));

        // dodanie do okna pytanie o rzędzie numerze 1
        add(label);

        // dodanie do okna przycisku o rzędzie numerze 2
        add(yesButton);

        // dodanie do okna przycisku o rze∂żie numerze 3
        add(noButton);
    }

    private JLabel label;
    public static void main(String[] args) {
        // write your code here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
            }
        });


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button =(JButton) e.getSource ();
        System.out.println (button.getText ());

        currentQuestion++;
        label.setText(questionList.get(currentQuestion).getContent());
        System.out.println("Kliknięto mnie");
    }
}