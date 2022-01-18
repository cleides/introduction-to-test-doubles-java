
import com.techreturners.bubbleteaordersystem.model.BubbleTeaTypeEnum;
import com.techreturners.bubbleteaordersystem.service.BubbleTeaRouletteService;

import testhelper.RandomStub;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.*;  // only for parameterized test arguments
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BubbleTeaRouletteServiceParameterizedTest {

    @ParameterizedTest
    @MethodSource("bubbleTeaTypes")
    void testBubbleTeaRouletteService (int input, BubbleTeaTypeEnum resultExpected)
    {
        RandomStub randomStub = new RandomStub(input);
        BubbleTeaRouletteService bubbleTeaRouletteService = new BubbleTeaRouletteService(randomStub);
        assertEquals(resultExpected, bubbleTeaRouletteService.getRandomBubbleTeaType());
    }

    private static Stream<Arguments> bubbleTeaTypes() {
        return Stream.of(
                arguments(BubbleTeaTypeEnum.OolongMilkTea.ordinal(), BubbleTeaTypeEnum.OolongMilkTea),
                arguments(BubbleTeaTypeEnum.JasmineMilkTea.ordinal(), BubbleTeaTypeEnum.JasmineMilkTea),
                arguments(BubbleTeaTypeEnum.MatchaMilkTea.ordinal(), BubbleTeaTypeEnum.MatchaMilkTea),
                arguments(BubbleTeaTypeEnum.PeachIceTea.ordinal(), BubbleTeaTypeEnum.PeachIceTea),
                arguments(BubbleTeaTypeEnum.LycheeIceTea.ordinal(), BubbleTeaTypeEnum.LycheeIceTea));
    }
}
