package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

import static tw.core.GameStatus.CONTINUE;
import static tw.core.GameStatus.FAIL;
import static tw.core.GameStatus.SUCCESS;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    AnswerGenerator answerGenerator;
    Game game;

    @Before
    public void setUp() throws OutOfRangeAnswerException {
        answerGenerator = mock(AnswerGenerator.class);
    }

    @Test
    public void checkGuessResult() throws OutOfRangeAnswerException {
        when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));

        game = new Game(answerGenerator);

        Answer guess1 = Answer.createAnswer("8 0 5 7");
        GuessResult result1 = game.guess(guess1);
        assertEquals("0A0B", result1.getResult());

        Answer guess2 = Answer.createAnswer("1 4 3 2");
        GuessResult result2 = game.guess(guess2);
        assertEquals("2A2B", result2.getResult());

        Answer guess3 = Answer.createAnswer("4 3 2 1");
        GuessResult result3 = game.guess(guess3);
        assertEquals("0A4B", result3.getResult());

        Answer guess4 = Answer.createAnswer("1 2 3 4");
        GuessResult result4 = game.guess(guess4);
        assertEquals("4A0B", result4.getResult());
    }

    @Test
    public void checkStatusWhenFail() throws OutOfRangeAnswerException {
        when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));

        game = new Game(answerGenerator);
        Answer wrongGuess = Answer.createAnswer("8 0 5 7");
        for (int i = 0; i < 6; i++)
            game.guess(wrongGuess);

        assertEquals(FAIL, game.checkStatus());
    }

    @Test
    public void checkStatusWhenContinue() throws OutOfRangeAnswerException {
        when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));

        game = new Game(answerGenerator);
        Answer wrongGuess = Answer.createAnswer("8 0 5 7");
        game.guess(wrongGuess);

        assertEquals(CONTINUE, game.checkStatus());
    }

    @Test
    public void checkStatusWhenSucceed() throws OutOfRangeAnswerException {
        when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));

        game = new Game(answerGenerator);
        Answer rightGuess = Answer.createAnswer("1 2 3 4");
        game.guess(rightGuess);

        assertEquals(SUCCESS, game.checkStatus());
    }
}
