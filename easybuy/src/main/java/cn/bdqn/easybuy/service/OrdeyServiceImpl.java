package cn.bdqn.easybuy.service;

import cn.bdqn.easybuy.dao.OrdeyMapper;
import cn.bdqn.easybuy.entity.Ordey;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/12/22.
 */
@Service
public class OrdeyServiceImpl implements OrdeyService {

    @Resource
    private OrdeyMapper ordeyMapper;
    @Override
    public List<Ordey> queryAll(Integer uId) {
        return ordeyMapper.queryAll(uId);
    }

    @Override
    public Integer createOrder(Integer ordeyId) {
        return ordeyMapper.createOrder(ordeyId);
    }

    @Override
    public Integer deleteOrdey(Integer ordeyId) {
        return ordeyMapper.deleteOrdey(ordeyId);
    }

    @Override
    public Integer deleteOrderyIds(List<Integer> list) {
        return ordeyMapper.deleteOrderyIds(list);
    }

    @Override
    public PageInfo<Ordey> queryAll(Integer pageNum, Integer pageSize, Integer uId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Ordey> list=ordeyMapper.queryAll(uId);
        PageInfo<Ordey> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
