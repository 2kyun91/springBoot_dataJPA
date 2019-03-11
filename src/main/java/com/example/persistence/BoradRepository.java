package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.dao.Board;

/*
 * Repository 인터페이스는(==BoradRepository) <T, ID> 두개의 재네릭 타입을 사용하는데
 * T는 앤티티 타입 클래스를  ID는 식별자(PK)의 타입을 의미한다.
 * 주로 사용되는 것은 CrudRepository를 상속받아 사용하는데
 * CrudRepository는 단순 CRUD 작업이 위주일 때
 * PagingAndSortingRepository는 페이징처리, 검색처리 등을 할 수 있다. 
 * */
public interface BoradRepository extends CrudRepository<Board, Long>{
	
}
