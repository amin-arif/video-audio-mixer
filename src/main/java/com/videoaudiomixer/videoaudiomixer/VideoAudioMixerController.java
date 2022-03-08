package com.videoaudiomixer.videoaudiomixer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class VideoAudioMixerController {

    @RequestMapping("/")
    public String showInfo() {
        return "Check Controller";
    }

    @GetMapping("/index")
    public String index() {return "index";}
}
