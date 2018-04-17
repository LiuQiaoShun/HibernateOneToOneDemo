package online.qsx.model;

import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_User")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;
	@Column(name="user_name")
	private String loginName;
	
	private String password;
	
	@Column(name="user_newDate")
	private Date newDate;
	@OneToOne(targetEntity=Card.class,cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="car_id")
	private Card card;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getNewDate() {
		return newDate;
	}
	public void setNewDate(Date newDate) {
		this.newDate = newDate;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public User(Long id, String loginName, String password, Date newDate) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.password = password;
		this.newDate = newDate;
	}
	public User(String loginName, String password, Date newDate) {
		super();
		this.loginName = loginName;
		this.password = password;
		this.newDate = newDate;
	}
	public User(Long id) {
		super();
		this.id = id;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", password=" + password + ", newDate=" + newDate + "]";
	}
	public String toStringAndCard() {
		return "User [id=" + id + ", loginName=" + loginName + ", password=" + password + ", newDate=" + newDate + 
				"card="+card+"]";
	}
	
}
