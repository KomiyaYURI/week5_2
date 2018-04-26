package tw.core;

import org.junit.Test;
import tw.validator.InputValidator;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {

    @Test
    public void should_get_true_when_judge_right_numbers() {
        String rightInput = "1 2 3 4";
        InputValidator validator = new InputValidator();

        assertTrue(validator.validate(rightInput));
    }

    @Test
    public void should_get_false_when_judge_false_numbers() {
        String wrongInput = "1 2 3 44";
        InputValidator validator = new InputValidator();

        assertFalse(validator.validate(wrongInput));
    }
}
