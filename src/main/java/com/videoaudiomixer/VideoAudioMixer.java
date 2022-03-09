package com.videoaudiomixer;

import java.util.ArrayList;
import java.util.List;

public class VideoAudioMixer {
    private String ffmpegExe;

    public VideoAudioMixer(String ffmpegExe) {
        super();
        this.ffmpegExe = ffmpegExe;
    }

    public void mergeVideoAudio(String videoInputPath, String audioInputPath, String videoOutputPath) throws Exception
    {
        List<String> command = new ArrayList<>();

        // Command that program follow
        // ffmpeg -i v.mp4 -i a.wav -c:v copy -map 0:v:0 -map 1:a:0 new.mp4

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

        for (String item : command) {
            System.out.print(item);
        }

        ProcessBuilder process = new ProcessBuilder(command);
        process.start();
    }

    public static void main(String[] args)
    {
        VideoAudioMixer mixer = new VideoAudioMixer("C:\\ffmpeg\\bin\\ffmpeg.exe");

        try {
            mixer.mergeVideoAudio("D:\\KANON\\Videos\\trivubon_video.mp4", "D:\\KANON\\Videos\\baba_audio.mp3", "D:\\KANON\\Videos\\new_video.mp4");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
