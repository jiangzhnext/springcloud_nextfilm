package com.next.jiangzh.springboot.nextfilmcinema.common;


import com.next.jiangzh.springboot.nextfilmcinema.NextfilmCinemaApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = NextfilmCinemaApplication.class)
@WebAppConfiguration
public class BaseControllerTest {

}
