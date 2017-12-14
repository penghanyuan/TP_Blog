package polytech.sgbd.blog.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;
	private String text;
	private Date date;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "message")
	private List<Link> links;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "message")
	private List<Image> images;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "message")
	private List<KeyWord> keyWords;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private User user;

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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
		if (links != null) {
			for (Link link : links) {
				link.setMessage(this);
			}
		}
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
		if (images != null) {
			for (Image img : images) {
				img.setMessage(this);
			}
		}
	}

	public List<KeyWord> getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(List<KeyWord> keyWords) {
		this.keyWords = keyWords;
		if (keyWords != null) {
			for (KeyWord keyword : keyWords) {
				keyword.setMessage(this);
			}
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		String k = "";
		if (this.keyWords != null) {
			for (int i = 0; i < this.keyWords.size(); i++) {
				if (!this.keyWords.get(i).getText().equals(""))
					k += "#" + this.keyWords.get(i).getText();
			}
		}
		return this.title + "\n\n\t" + this.text + "\t" + k + "\n\n" + df.format(this.date) + "\t\t\t @"
				+ this.user.getUserName();
	}

}
