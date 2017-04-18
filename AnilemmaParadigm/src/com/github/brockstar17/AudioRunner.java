package com.github.brockstar17;

import java.io.IOException;

import javax.sound.sampled.*;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.sound.sampled.*;

public class AudioRunner implements Runnable {
	private static AudioFormat LocalFormat = new AudioFormat(192000, 16, 2, true, false);
	private static boolean runVar = false;
	private ByteArrayOutputStream recordBytes;
	private static TargetDataLine audioLine = null;
	public void run() {
		try {
			audioLine = AudioSystem.getTargetDataLine(LocalFormat);
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	        DataLine.Info info = new DataLine.Info(TargetDataLine.class, LocalFormat);
	 
	        // checks if system supports the data line
	        if (!AudioSystem.isLineSupported(info)) {
	            try {
					throw new LineUnavailableException(
					        "The system does not support the specified format.");
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	 
	        try {
				audioLine = AudioSystem.getTargetDataLine(LocalFormat);
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	 
	        try {
				audioLine.open(LocalFormat);
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        audioLine.start();
	        byte[] buffer = new byte[48000];
	        int bytesRead = 0;
	    recordBytes = new ByteArrayOutputStream();
	 
	        while (runVar) {
	            bytesRead = audioLine.read(buffer, 0, buffer.length);
	            recordBytes.write(buffer, 0, bytesRead);
	            PaintDisplay.dataProcess(PaintDisplay.byteProcess(buffer));
	        }// end of while

	}// end of run

	public static void changeThread(boolean run) {
		runVar = run;
		if(audioLine != null && run == false) {
	            audioLine.drain();
	            audioLine.close();
	        }
	    }

	public static void setFormat(AudioFormat AF) {
		LocalFormat = AF;
	}
}

