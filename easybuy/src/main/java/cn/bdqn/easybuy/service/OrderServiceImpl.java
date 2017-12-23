package cn.bdqn.easybuy.service;

import cn.bdqn.easybuy.dao.OrderMapper;
import cn.bdqn.easybuy.entity.Order;
import cn.bdqn.easybuy.utils.SerialNumberUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;


    public Integer addOrder(Order order) {
        order.setSerialNumber(SerialNumberUtil.getOrderIdByUUId());
        return orderMapper.addOrder(order);
    }


    public Order queryOrderBySerialNumber(String serialNumber) {
        return orderMapper.queryOrderBySerialNumber(serialNumber);
    }


    public List<Order> queryOrderByLoginName(String loginName) {
        return orderMapper.queryOrderByLoginName(loginName);
    }



    public List<Order> queryAll() {
        return orderMapper.queryAll();
    }


    public List<Integer> getAll() {
        return orderMapper.getAll();
    }


    public List<Order> queryUidAll(Integer uId) {
        return orderMapper.queryUidAll(uId);
    }


    public List<Integer> queryUid(Integer uId) {
        return orderMapper.queryUid(uId);
    }


    public Integer createOrderByIds(List<Integer> orderIds) {
        return orderMapper.createOrderByIds(orderIds);
    }


    public Integer deleteOrderByIds(List<Integer> list) {
        return orderMapper.deleteOrderByIds(list);
    }

    public PageInfo<Order> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> list=orderMapper.queryAll();
        PageInfo<Order> pageInfo=new PageInfo<Order>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Order> queryUidAll(Integer pageNum, Integer pageSize, Integer uId) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> list=orderMapper.queryUidAll(uId);
        PageInfo<Order> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
