package polytech.sgbd.blog.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String address;
	private String email;
	
	@Transient
	private Date createdDate;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="user")
	private List<Message> messages;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessage(List<Message> messages) {
		this.messages = messages;
		
		if(messages != null){
			for(Message msg : messages){
				msg.setUser(this);
			}
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
