package cn.bdqn.easybuy.service;

import cn.bdqn.easybuy.dao.OrderDetailMapper;
import cn.bdqn.easybuy.dao.OrderMapper;
import cn.bdqn.easybuy.entity.OrderDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Resource
    private OrderMapper orderMapper;


    public List<OrderDetail> queryAll(String serialNumber) {
        return orderDetailMapper.queryAll(serialNumber);
    }


    public List<OrderDetail> queryAllUserId(Integer uId) {
        List<Integer> ids=orderMapper.queryUid(uId);
        List<Integer> oIds=new ArrayList<Integer>();
        for (Integer id : ids) {
            oIds.add(id);
        }
        return orderDetailMapper.getAll(oIds);
    }


    public List<OrderDetail> getAll() {
        List<Integer> ids=orderMapper.getAll();
        List<Integer> oIds=new ArrayList<Integer>();
        for (Integer id : ids) {
           oIds.add(id);
        }
        return orderDetailMapper.getAll(oIds);
    }


}
