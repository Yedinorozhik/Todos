import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void simpleTaskMatches() {
        SimpleTask task = new SimpleTask(24, "Написать тест");

        boolean actual = task.matches("Написать");
        boolean expected = true;

        Assertions.assertEquals(expected,actual);

    }

    @Test
    public void simpleTaskMatchesFalse() {
        SimpleTask task = new SimpleTask(24, "Написать тест");

        boolean actual = task.matches("текст");
        boolean expected = false;

        Assertions.assertEquals(expected,actual);

    }


    @Test
    public void MeetingMatchesTopicTrue() {
    Meeting task = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );
        boolean actual = task.matches("Выкатка");
        boolean expected = true;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void MeetingMatchesProjectTrue() {
        Meeting task = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = task.matches("Приложение");
        boolean expected = true;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void MeetingMatchesFalse() {
        Meeting task = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = task.matches("вторник");
        boolean expected = false;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void EpicMatchesTrue() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Молоко");
        boolean expected = true;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void EpicMatchesFalse() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Хелб");
        boolean expected = false;

        Assertions.assertEquals(expected,actual);
    }

}