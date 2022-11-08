package tk.dtp000.sprhibnmvc.blog.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "commented_on")
	private Timestamp commentedOn;
	
	@Column(name="content")
	private String content;

	@ManyToOne
    @JoinColumn(name="account_id")
	private Account account;
	
	@OneToMany(mappedBy="comments")
	private Set<Post> posts;

	public Comment() {
		super();
	}

	public Comment(int id, Timestamp commentedOn, String content, Account account, Set<Post> posts) {
		super();
		this.id = id;
		this.commentedOn = commentedOn;
		this.content = content;
		this.account = account;
		this.posts = posts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCommentedOn() {
		return commentedOn;
	}

	public void setCommentedOn(Timestamp commentedOn) {
		this.commentedOn = commentedOn;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	
}
