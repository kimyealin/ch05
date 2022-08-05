package yeling.spring.domain;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.CascadeType;

@Getter
@Setter
@ToString(exclude="boardList")
@Entity
@Table(name="MYUSER")
public class Member {
	@Id
	@Column(name="MEMBER_ID")
	private String id;
	private String password;
	private String name;
	private String role;
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER , cascade=CascadeType.ALL)
	private List<Board> boardList = new ArrayList<Board>();
}
