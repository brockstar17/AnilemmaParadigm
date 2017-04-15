package com.github.brockstar17;

import javax.sound.sampled.AudioFormat;

public class AudioAquirer {
public static void startRecording(){
		AudioRunner.setFormat(new AudioFormat(192000,16,2,true,false));// for audioformat Sample rate, bit depth, channels,signed,BigEndian
		AudioRunner.changeThread(true);
		(new Thread(new AudioRunner())).start();// start audio runner Run method
		//AudioRunner.changeThread(false);
	}

	public static void dataProcess(byte[] x) {
		//System.out.println(x);
		for (int g = 0; g < x.length; g+=2)
			System.out.println((x[g] & 0xFF)*(x[g+1] & 0xFF) +",");

	}
	public static void stopRecording(){
		AudioRunner.changeThread(false);
	}
	
}

