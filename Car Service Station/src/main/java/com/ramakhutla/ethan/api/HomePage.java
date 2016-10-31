package com.ramakhutla.ethan.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ethon on 2016/10/31.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {

    @RequestMapping(value="home",method= RequestMethod.GET)
    public String Index(){return "<html>\n" +
            "<head>\n<title>Welcome to Ethon's center</title>\n</head>\n<body>\n<h1>Welcome to Shane's" +
            " Vehicle Service Center</h1>\n"+
            "<p>Technical Programming Assignments 2016..</p></body>\n</html>";}
}
