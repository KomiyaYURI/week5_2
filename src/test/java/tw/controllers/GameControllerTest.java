package tw.controllers;

import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;
import tw.GuessNumberModule;
import tw.commands.GuessInputCommand;
import tw.core.Answer;
import tw.validator.InputValidator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.google.inject.Guice.createInjector;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    GameController controller;
    GuessInputCommand inputModel;

    @Before
    public void setUp() throws IOException {
        controller = mock(GameController.class);
        controller.beginGame();

        inputModel = mock(GuessInputCommand.class);
    }


    @Test
    public void platTest() throws IOException {
        String input = "1 2 3 4";
        Answer answer = Answer.createAnswer(input);

        when(inputModel.input()).thenReturn(answer);
        controller.play(inputModel);

        // verify(controller, times(1)).play(inputModel);
    }

}