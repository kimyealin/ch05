package yeling.spring.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import yeling.spring.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
	List<Board> findByTitle(String searchKeyword);
	List<Board> findByContentContaining(String searchKeyword);
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	//	List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);

	//위치기반 파라미터 사용
	/*
	 * @Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
	 * List<Board> queryAnnotationTest1(String searchKeyword);
	 */

	/*
	 * //이름기반 파라미터 사용
	 * 
	 * @Query("SELECT b FROM Board b WHERE b.title like %:searchKeyword% " +
	 * "ORDER BY b.seq DESC") List<Board>
	 * queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);
	 * 
	 * //특정 변수만 조회
	 * 
	 * @Query("SELECT b.seq, b.title, b.writer, b.regDate FROM Board b " +
	 * "WHERE b.title like %:searchKeyword% ORDER BY b.seq DESC") List<Object[]>
	 * queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
	 * 
	 * //네이티브 쿼리 사용하기
	 * 
	 * @Query(value =
	 * "select seq, title, writer, reg_date from myboard where title like '%'||?1||'%' "
	 * + "order by seq desc", nativeQuery = true) List<Object[]>
	 * queryAnnotationTest3(String searchKeyword);
	 * 
	 * //페이징 및 정렬처리
	 * 
	 * @Query("SELECT b FROM Board b ORDER BY b.seq desc") List<Board>
	 * queryAnnotationTest4(Pageable paging);
	 */
}
