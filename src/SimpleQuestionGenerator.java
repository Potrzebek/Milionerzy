import java.util.ArrayList;
import java.util.List;

public class SimpleQuestionGenerator implements QuestionGenerator {

    @Override
    public List<Question> generateQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Czy Polska leży w Europie", true));
        questions.add(new Question("2+2=5", false));
        questions.add(new Question("3+2=5", false));
        questions.add(new Question("1+1=2", true));
        return questions;
    }

}