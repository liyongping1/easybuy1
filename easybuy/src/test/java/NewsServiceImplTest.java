import cn.bdqn.easybuy.entity.News;
import cn.bdqn.easybuy.service.NewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class NewsServiceImplTest {

    @Resource
    private NewsService newsService;
    @Test
    public void queryAll() throws Exception {
        List<News> list=newsService.queryAllLimit();
        for (News news : list) {
            System.out.println(news);
        }
    }

   /* @Test
    public void queryNewsTitle() throws Exception {
        News news=newsService.queryNewsTitle("会员特惠月开始了");
        System.out.println(news);
    }*/

}