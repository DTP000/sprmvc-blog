package tk.dtp000.sprhibnmvc.blog.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;

	@Column(name="content")
	private String content;

	@Column(name = "published_on")
	private Timestamp publishedOn;
	
	@Column(name="likes")
	int likes;

	@ManyToOne
    @JoinColumn(name="comment_id")
	private Comment comments;
	
	@ManyToOne
    @JoinColumn(name="author_id")
	private Author author;

	@ManyToOne
    @JoinColumn(name="category_id")
	private Category category;
	
	@ManyToMany
    @JoinTable(name = "post_tag", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

	public Post() {
		super();
	}

	public Post(int id, String title, String content, Timestamp publishedOn, int likes, Comment comments, Author author,
			Category category, List<Tag> tags) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.publishedOn = publishedOn;
		this.likes = likes;
		this.comments = comments;
		this.author = author;
		this.category = category;
		this.tags = tags;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getPublishedOn() {
		return publishedOn;
	}

	public void setPublishedOn(Timestamp publishedOn) {
		this.publishedOn = publishedOn;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Comment getComments() {
		return comments;
	}

	public void setComments(Comment comments) {
		this.comments = comments;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}
