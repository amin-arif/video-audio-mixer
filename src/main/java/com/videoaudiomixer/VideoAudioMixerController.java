package com.videoaudiomixer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VideoAudioMixerController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("show")
    public String show() {
        return "show";
    }
}

