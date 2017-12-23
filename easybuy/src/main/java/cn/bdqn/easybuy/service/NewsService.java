package cn.bdqn.easybuy.service;

import cn.bdqn.easybuy.entity.News;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */
public interface NewsService {
    List<News> queryAllLimit();
    News queryNewsTitle(Integer id);

    PageInfo<News> queryAll(Integer pageNum,Integer pageSize);
}
