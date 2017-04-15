package com.github.brockstar17;

import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Port;
import javax.sound.sampled.TargetDataLine;

	public class AudioRunner implements Runnable {
		private static AudioFormat LocalFormat;
		private static boolean runVar = false;
		private static Port PortType = (Port) Port.Info.LINE_IN;

		public void run() {
			AudioInputStream AIO = null;
			byte[] OutArray = new byte[48000];
			//DataLine.Info line = new DataLine.Info(TargetDataLine.class, LocalFormat);
			System.out.println("Running!");
			
				try {
					TargetDataLine AudioInput = (TargetDataLine) AudioSystem.getLine(
				            (Info) PortType);
					AudioInput.open(LocalFormat);
					AudioInput.start();
					AIO = new AudioInputStream(AudioInput);
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("The audio stream was unavaliable. check that no other programs are recording audio.");
				}

			

			while (runVar) { // Allow stopping of thread
				try {
					AIO.read(OutArray);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Plotting.dataProcess(Plotting.byteProcess(OutArray));

				// runVar =false; // to stop running after one time
			} // end of while
			try {
				AIO.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}// end of run
		public static void changeInput(String s){
			switch(s){
			case "LINE_IN":
				PortType = (Port) Port.Info.LINE_IN;
				break;
			case "MICROPHONE":
				PortType = (Port) Port.Info.MICROPHONE;
				break;
			case "SPEAKER":
				PortType = (Port) Port.Info.SPEAKER;
				break;
			default:
				
				break;
			}
		}

		public static void changeThread(boolean run) {
			runVar = run;
		}

		public static void setFormat(AudioFormat AF) {
			LocalFormat = AF;
		}

	}