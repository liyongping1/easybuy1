package cn.bdqn.easybuy.service;

import cn.bdqn.easybuy.entity.Order;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 */

public interface OrderService {
    Integer addOrder(Order order);

    Order queryOrderBySerialNumber(String serialNumber);

    List<Order> queryOrderByLoginName(String loginName);


    List<Order> queryAll();

    List<Integer> getAll();

    List<Order> queryUidAll(Integer uId);

    List<Integer> queryUid(Integer uId);

    Integer createOrderByIds(List<Integer> orderIds);

    Integer deleteOrderByIds(List<Integer> list);

    PageInfo<Order> queryAll(Integer pageNum, Integer pageSize);
    PageInfo<Order> queryUidAll(Integer pageNum,Integer pageSize,Integer uId);
}