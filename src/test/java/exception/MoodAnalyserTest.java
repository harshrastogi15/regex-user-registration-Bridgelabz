package exception;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public void Given_IaminSadMood_message_ConstructorShouldReturnSAD(){
        String test = "I am in Sad Mood";
        MoodAnalyser obj = new MoodAnalyser(test);
        String mood = obj.analyseMood();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void Given_IaminHappyMood_message_ConstructorShouldReturnSAD(){
        String test = "I am in Happy Mood";
        MoodAnalyser obj = new MoodAnalyser(test);
        String mood = obj.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }


}
