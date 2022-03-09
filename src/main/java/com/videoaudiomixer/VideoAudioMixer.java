package com.videoaudiomixer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VideoAudioMixer {
    private String ffmpegExe; // ffmpeg.exe file location (ffmpeg stored in local directory)

    public VideoAudioMixer(String ffmpegExe) {
        super();
        this.ffmpegExe = ffmpegExe;
    }

    public void mergeVideoAudio(String videoInputPath, String audioInputPath, String videoOutputPath) throws Exception {
        List<String> command = new ArrayList<>();

        // Program follow the command
        // ffmpeg -i video.mp4 -i audio.mp3 -c:v copy -map 0:v:0 -map 1:a:0 new_merged_video.mp4
        command.add(ffmpegExe); // ffmpeg
        command.add("-i");
        command.add(videoInputPath);
        command.add("-i");
        command.add(audioInputPath);
        command.add("-c:v");
        command.add("copy");
        command.add("-map");
        command.add("0:v:0");
        command.add("-map");
        command.add("1:a:0");
        command.add(videoOutputPath);

        // Print command that will be executed
        for (String item : command) {
            System.out.print(item);
        }
        System.out.println(); // for new line print

        // Process of execution (status)
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();

        InputStream errorStream = process.getErrorStream();
        InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String executionLine = "";
        while ((executionLine = bufferedReader.readLine()) != null) {
            System.out.println(executionLine);
        }

        if (bufferedReader != null) { inputStreamReader.close(); }
        if (errorStream != null) { errorStream.close(); }
    }

    public static void main(String[] args) {
        VideoAudioMixer mixer = new VideoAudioMixer("C:\\ffmpeg\\bin\\ffmpeg.exe");

        Scanner input = new Scanner(System.in);
        String videoPath, audioPath;

        System.out.print("Enter your video file location: ");
        videoPath = input.nextLine();
        System.out.print("Enter your audio file location: ");
        audioPath = input.nextLine();

        input.close();

        try {
            mixer.mergeVideoAudio(videoPath, audioPath, "C:\\Users\\Asus\\Videos\\new_video.mp4");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nCheck your output path\nC:\\Users\\Asus\\Videos\\new_video.mp4");
    }
}
