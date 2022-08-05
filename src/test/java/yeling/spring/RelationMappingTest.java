package yeling.spring;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import yeling.spring.domain.Board;
import yeling.spring.domain.Member;
import yeling.spring.persistence.BoardRepository;
import yeling.spring.persistence.MemberRepository;

@SpringBootTest
public class RelationMappingTest {
	@Autowired
	private BoardRepository boardRepo;
	@Autowired
	private MemberRepository memberRepo;
	@Test
	/*public void testManyToOneInsert() {
		Member member1 = new Member();
		member1.setId("aaaa");
		member1.setPassword("1111");
		member1.setName("손오공");
		member1.setRole("User");
//		memberRepo.save(member1);
		Member member2 = new Member();
		member2.setId("bbbb");
		member2.setPassword("2222");
		member2.setName("사오정");
		member2.setRole("Admin");
//		memberRepo.save(member2);
		for(int i=1; i<=3; i++) {
			Board board = new Board();
			board.setMember(member1);
			board.setTitle("손오공이 등록한 글 " + i);
			board.setContent("손오공이 등록한 글 내용 " + i);
			board.setRegDate(new Date());
			board.setCnt(0L);
//			boardRepo.save(board);
		}
		memberRepo.save(member1);
		for(int i=1; i<=3; i++) {
			Board board = new Board();
			board.setMember(member2);
			board.setTitle("사오정이 등록한 글 " + i);
			board.setContent("사오정이 등록한 글 내용 " + i);
			board.setRegDate(new Date());
			board.setCnt(0L);
//			boardRepo.save(board);
		}
		memberRepo.save(member2);
	}*/
	/*public void testManyToOneSelect() {
		Board board = boardRepo.findById(5L).get();
		System.out.println("[ " + board.getSeq() + "번 게실글 정보 ]");
		System.out.println("제목 : " + board.getTitle());
		System.out.println("내용 : " + board.getContent());
		System.out.println("작성자 : " + board.getMember().getName());
		System.out.println("작성자 권한 : " + board.getMember().getRole());
	}*/
	/*public void testTwoWayMapping() {
		Member member = memberRepo.findById("aaaa").get();
		System.out.println("=======================");
		System.out.println(member.getName() + "이 작성한 게시글 목록");
		System.out.println("=======================");
		List<Board> list = member.getBoardList();
		for(Board board : list) {
			System.out.println(board.toString());
		}
	}*/
	public void testCascadeDelete() {
		memberRepo.deleteById("bbbb");
	}
}
