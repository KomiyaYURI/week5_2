package tw.core.generator;

import org.junit.Before;
import org.junit.Test;
import tw.commands.GuessInputCommand;
import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    RandomIntGenerator randIntGernerator;
    AnswerGenerator answerGenerator;

    @Before
    public void setUp() {
        randIntGernerator = mock(RandomIntGenerator.class);
        answerGenerator = new AnswerGenerator(randIntGernerator);
    }

    @Test
    public void should_get_equal_when_randomIntGenerator_return_same_data() throws OutOfRangeAnswerException {

        Answer expexted_answer = Answer.createAnswer("1 2 3 4");

        when(randIntGernerator.generateNums(9, 4)).thenReturn("1 2 3 4");

        Answer test_answer = answerGenerator.generate();
        assertEquals(test_answer.toString(), expexted_answer.toString());
    }
}

