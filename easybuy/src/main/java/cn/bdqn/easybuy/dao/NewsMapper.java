package cn.bdqn.easybuy.dao;

import cn.bdqn.easybuy.entity.News;

import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */
public interface NewsMapper {
    List<News> queryAllLimit();
    News queryNewsTitle(Integer id);
    List<News> queryAll();
}
