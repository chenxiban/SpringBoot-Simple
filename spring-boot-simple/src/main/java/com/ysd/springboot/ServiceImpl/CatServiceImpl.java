package com.ysd.springboot.ServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.ysd.springboot.dao.CatRepository;
import com.ysd.springboot.entity.Cat;
import com.ysd.springboot.service.CatService;

@Service
public class CatServiceImpl implements CatService {

	@Autowired
	private CatRepository repository;

	@Override
	public Cat insert(Cat cat) {
		return repository.save(cat);
	}

	@Override
	public List<Cat> insert(List<Cat> list) {
		return repository.save(list);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public void delete(Cat cat) {
		repository.delete(cat);
	}

	@Override
	public void delete(List<Cat> list) {
		repository.delete(list);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public Cat update(Cat cat) {
		return repository.save(cat);
	}

	@Override
	public List<Cat> update(List<Cat> list) {
		return repository.save(list);
	}

	@Override
	public Boolean exists(Integer id) {
		return repository.exists(id);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public Cat queryById(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<Cat> queryAll() {
		return repository.findAll();
	}

	@Override
	public List<Cat> queryAllSort(String fieldName) {// 排序
//		Sort sort = new Sort(Sort.Direction.DESC, "id"); 
//	    Pageable pageable = new PageRequest(page, size, sort);
		Sort sort = new Sort(Sort.Direction.DESC, fieldName, "id");
		return repository.findAll(sort);
	}

	@Override
	public Page<Cat> queryAllPage(Integer page, Integer size) {// 分页
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		Pageable pageable = new PageRequest(page, size, null);
		return repository.findAll(pageable);
	}

	// ----------------------------以上是JpaRepository已经实现好的基本增删改查-----------------

	@Override
	public Long queryMaxAge() {
		return repository.maxAge();
	}

	@Override
	public List<Cat> queryByNameLike(String name) {
		return repository.findByNameLike("%" + name + "%");
	}

	@Override
	public List<Cat> queryByName(String name) {
		return repository.queryByname(name);
	}

	@Override
	public List<Cat> queryByNameSQL(String name) {
		return repository.queryBynameSQL(name);
	}

	@Override
	public List<Cat> queryNameLikeAllSort(String nameLike, String fieldName) {// 带条件的排序
//		Sort sort = new Sort(Sort.Direction.DESC, "id"); 
//	    Pageable pageable = new PageRequest(page, size, sort);
		Sort sort = new Sort(Sort.Direction.DESC, fieldName, "id");
		return repository.findByNameLike("%" + nameLike + "%", sort);
	}

	@Override
	public Page<Cat> queryNameLikeAllPage(String nameLike, Integer page, Integer size) {// 带条件的分页
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		Pageable pageable = new PageRequest(page, size, sort);
		return repository.findByNameLike("%" + nameLike + "%", pageable);
	}
}