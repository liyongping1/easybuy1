import cn.bdqn.easybuy.entity.OrderDetail;
import cn.bdqn.easybuy.service.OrderDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OrderDetailServiceImplTest {

    @Resource
    private OrderDetailService orderDetailService;
    @Test
    public void getAll() throws Exception {
        List<OrderDetail> list=orderDetailService.getAll();
        for (OrderDetail orderDetail : list) {
            System.out.println(orderDetail);
        }
    }

}