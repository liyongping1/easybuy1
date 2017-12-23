package cn.bdqn.easybuy.service;

import cn.bdqn.easybuy.dao.NewsMapper;
import cn.bdqn.easybuy.entity.News;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Resource
    private NewsMapper newsMapper;
    public List<News> queryAllLimit() {
        return newsMapper.queryAllLimit();
    }

    public News queryNewsTitle(Integer id) {
        return newsMapper.queryNewsTitle(id);
    }


    public PageInfo<News> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<News> list=newsMapper.queryAll();
        PageInfo<News> pageInfo=new PageInfo<News>(list);
        return pageInfo;
    }
}
