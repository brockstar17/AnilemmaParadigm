package com.github.brockstar17;

import java.io.IOException;

import javax.sound.sampled.*;

public class AudioRunner implements Runnable {
	private static AudioFormat LocalFormat;
	private static boolean runVar = false;

	public void run() {
		AudioInputStream AIO = null;
		byte[] OutArray = new byte[44100];
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, LocalFormat);
		System.out.println("Running!");
		if (!AudioSystem.isLineSupported(info)) {
			System.out.println("Line input is not supported! Check line input cables.");
			runVar = false;
		} else {
			try {
				TargetDataLine AudioInput = (TargetDataLine) AudioSystem.getLine(info);
				AudioInput.open(LocalFormat);
				AudioInput.start();
				AIO = new AudioInputStream(AudioInput);
				System.out.println(AudioInput.isRunning());
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("The audio stream was unavaliable. check that no other programs are recording audio.");
			}
			

		}

		while (runVar) { // Allow stopping of thread
			try {
				AIO.read(OutArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//AudioAquirer.dataProcess(OutArray);
			Plotting.dataProcess(Plotting.byteProcess(OutArray));
			// runVar =false; // to stop running after one time
		} // end of while

	}// end of run

	public static void changeThread(boolean run) {
		runVar = run;
	}

	public static void setFormat(AudioFormat AF) {
		LocalFormat = AF;
	}

}
