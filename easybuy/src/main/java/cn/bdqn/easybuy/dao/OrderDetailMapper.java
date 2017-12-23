package cn.bdqn.easybuy.dao;

import cn.bdqn.easybuy.entity.OrderDetail;

import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */
public interface OrderDetailMapper {
    public List<OrderDetail> queryAll(String serialNumber);
    public List<OrderDetail> queryAllUserId(Integer uId);

    public List<OrderDetail> getAll(List<Integer> oIds);

}
