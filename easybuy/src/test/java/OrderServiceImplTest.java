import cn.bdqn.easybuy.entity.Order;
import cn.bdqn.easybuy.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OrderServiceImplTest {

    @Resource
    private OrderService orderService;
    @Test
    public void addOrder() throws Exception {
        Order order=new Order();
        order.setUserId(18);
        order.setLoginName("shangzezhong");
        order.setUserAddress("北京市海淀区成府路");
        order.setCost(8888);
        Integer n=orderService.addOrder(order);
        System.out.println(n);
    }

    @Test
    public void queryOrderBySerialNumber() throws Exception {
        Order order=orderService.queryOrderBySerialNumber("201712181651348443");
        System.out.println(order);
    }

    @Test
    public void queryOrderByLoginName() throws Exception {
        List<Order> list=orderService.queryOrderByLoginName("shangzezhong");
        for (Order order : list) {
            System.out.println(order);
        }
    }

}