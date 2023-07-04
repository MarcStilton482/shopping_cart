/*package com.cart.shopping_cart;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class SynthesizerUtil {
    private static SynthesizerUtil instance;
    //public Synthesizer synthesizer;
    private FreeTTSSynthesizer synthesizer;
    private Voice voice;

    private SynthesizerUtil() {
        //synthesizer = new Synthesizer();
        synthesizer = new FreeTTSSynthesizer();

        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice("kevin16");
        voice.allocate();
    }

    public static SynthesizerUtil getInstance() {
        if (instance == null) {
            instance = new SynthesizerUtil();
        }
        return instance;
    }

    public Synthesizer getSynthesizer() {
        return (Synthesizer) synthesizer;
    }

    public Voice getVoice() {
        return voice;

        }
    public void speak(String text) {
        synthesizer.setVoice(voice);
        synthesizer.speak(text);
    }
    public void dispose() {
        synthesizer.deallocate();
    }
}*/