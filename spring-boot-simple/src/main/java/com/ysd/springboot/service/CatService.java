package com.ysd.springboot.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.ysd.springboot.entity.Cat;

public interface CatService {

	public Cat insert(Cat cat);

	public List<Cat> insert(List<Cat> list);

	public void delete(Integer id);

	public void delete(Cat cat);

	public void delete(List<Cat> list);

	public void deleteAll();

	public Cat update(Cat cat);

	public List<Cat> update(List<Cat> list);

	public Boolean exists(Integer id);

	public Long count();

	public Cat queryById(Integer id);

	public List<Cat> queryAll();

	public List<Cat> queryByNameLike(String name);

	public List<Cat> queryByName(String name);

	public List<Cat> queryByNameSQL(String name);

	public Long queryMaxAge();

	public List<Cat> queryAllSort(String fieldName);// 排序

	public Page<Cat> queryAllPage(Integer page, Integer size);// 分页,排序

	public List<Cat> queryNameLikeAllSort(String nameLike, String fieldName);// 带条件的排序

	public Page<Cat> queryNameLikeAllPage(String nameLike, Integer page, Integer size);// 带条件的分页
}