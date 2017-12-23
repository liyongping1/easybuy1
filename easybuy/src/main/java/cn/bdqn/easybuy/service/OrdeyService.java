package cn.bdqn.easybuy.service;

import cn.bdqn.easybuy.entity.Ordey;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/12/22.
 */
public interface OrdeyService {
    List<Ordey> queryAll(Integer uId);
    Integer createOrder(Integer ordeyId);

    Integer deleteOrdey(Integer ordeyId);

    Integer deleteOrderyIds(List<Integer> list);

    PageInfo<Ordey> queryAll(Integer pageNum,Integer pageSize,Integer uId);
}
