package tw.core;


import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

import static org.junit.Assert.assertFalse;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    @Test
    public void test_numbers_in_range_and_not_repeat() {
        boolean errorFlag=false;
        RandomIntGenerator randIntGen = new RandomIntGenerator();

        for (int i = 0; i < 10; i++) {
            Boolean numAppear[] = {false, false, false};

            String randomNumStr = randIntGen.generateNums(3, 3);
            String numStrItems[] = randomNumStr.split(" ");

            for (String strItem : numStrItems)
                numAppear[Integer.parseInt(strItem)] = true;

            if (!numAppear[0] || !numAppear[1] || !numAppear[2])
                errorFlag = true;
        }

        assertFalse(errorFlag);
    }
}