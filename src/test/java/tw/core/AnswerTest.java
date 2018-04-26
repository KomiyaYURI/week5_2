package tw.core;

import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    @Test
    public void answerElementOutputTest() throws OutOfRangeAnswerException {
        Answer answer = Answer.createAnswer("1 2 3 4");

        String[] answerItems = answer.toString().split(" ");
        for (int i = 0; i < answerItems.length; i++) {
            assertEquals(i, answer.getIndexOfNum(answerItems[i]));
        }
    }
}