package cn.bdqn.easybuy.dao;

import cn.bdqn.easybuy.entity.Ordey;

import java.util.List;

/**
 * Created by Administrator on 2017/12/22.
 */
public interface OrdeyMapper {
    List<Ordey> queryAll(Integer uId);
    Integer createOrder(Integer ordeyId);
    Integer deleteOrdey(Integer ordeyId);

    Integer deleteOrderyIds(List<Integer> list);
}
