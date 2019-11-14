package com.ysd.springboot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ysd.springboot.entity.Cat;

public interface CatRepository extends JpaRepository<Cat, Integer> {

	// ******************** []JPQL或者HQL 方式 ] 序号参数*******************

	@Query(" SELECT MAX(c.age) FROM Cat c ")
	public Long maxAge();

	@Query("select c from Cat c where  c.name like %:name% ")
	List<Cat> queryByname(@Param(value = "name") String name);

	// ----------------------------以下是自定义条件查询--------------------------------------
	// Like --- 等价于 SQL 中的 "like"，比如 findByNameLike(String name);
	public List<Cat> findByNameLike(String name);

	// Like --- 等价于 SQL 中的 "like"，比如 findByNameLike(String name);
	public List<Cat> findByNameLike(String name, Sort sort);

	public Page<Cat> findByNameLike(String name, Pageable pageable);

	// **************** 原生SQL********************
	@Query(value = " SELECT * FROM cattb WHERE NAME LIKE %:name% ", nativeQuery = true)
	List<Cat> queryBynameSQL(@Param(value = "name") String name);
}
