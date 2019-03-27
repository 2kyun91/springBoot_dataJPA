package com.example;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dto.Board;
import com.example.persistence.BoradRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoradRepositoryTests {
	
	@Autowired
	private BoradRepository boardRepo;
	
	@Test
	public void inspect() {
		// 실제 객체의 클래스 이름 -> com.sun.proxy.$Proxy92
		Class<?> clz = boardRepo.getClass(); 
		
		System.out.println("1 : " + clz.getName()); 
		
		// 클래스가 구현하고 있는 인터페이스 목록 -> BoradRepository, Repository, TransactionalProxy, Advised, DecoratingProxy
		Class<?>[] interfaces = clz.getInterfaces();
		
		Stream.of(interfaces).forEach(inter -> System.out.println("2 :" + inter.getName()));
		
		// 클래스의 부모 클래스 -> java.lang.reflect.Proxy
		Class<?> superClasses = clz.getSuperclass(); 
		
		System.out.println("3 : " + superClasses.getName());
	}
	
	@Test
	public void testInsert() {
		Board board = new Board();
		
		// bno는 시퀀스로 자동 생성 방식을 이용하도록 설정하였기 때문에 따로 지정하지 않는다.
		board.setTitle("게시물의 제목");
		board.setContent("게시물의 내용");
		board.setWriter("user01");
		
		boardRepo.save(board);
		
		/*
		 * 콘솔에 출력되는 내용 Hibernate: insert into tbl1_boards (content, regdate, title,
		 * updatedate, writer, bno) values (?, ?, ?, ?, ?, ?) 메이븐 디펜던시 설정을 따로 해주면 "?"
		 * 부분의 값이 실제 입력값으로 출력된다.
		 */
	}
	
	@Test
	public void testRead() {
		/*
		 * 식별 데이터를 Long타입으로 사용했는데 1L은 1번에 해당하는 데이터를 의미하고 3L은 3번에 해당하는 데이터를 의미한다. 시퀀스로 자동
		 * 생성되는 값을 조건으로 조회하는경우 해당 값이 실제로 존재하는지 파악해야 한다. findOne() 함수가 없어지고
		 * findById().get()으로 대체 되었다.
		 */
		Board board = boardRepo.findById(3L).get();
		
		System.out.println("testRead : " + board);
	}
	
	@Test
	public void testUpdate() {
		/*
		 * JPA는 데이터 베이스에 바로 작업을 하는 JDBC와는 달리 스스로 엔티티 객체들을 메모리상에서 관리하고 필요한 경우에 데이터베이스에 작업을 하게 된다.
		 * 따라서  엔티티 객체가 우선적으로 메모리상에 존재해야 하므로 select를 실행해야 한다.
		 * */
		System.out.println("Read first.........");
		Board board = boardRepo.findById(3L).get();
		
		System.out.println("Update Title.........");
		board.setTitle("수정된 제목");
		
		System.out.println("Call Save().........");
		boardRepo.save(board);
	}
	
	@Test
	public void testDelete() {
		System.out.println("DELETE Entity by PK");
		boardRepo.deleteById(3L);
		
//		System.out.println("DELETE Entity Object");
//		Board board = boardRepo.findById(3L).get();
//		boardRepo.delete(board);
	}
	
}
