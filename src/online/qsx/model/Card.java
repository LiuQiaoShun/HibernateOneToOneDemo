package online.qsx.model;

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
@Table(name="tb_card")
public class Card {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="car_id")
	private Long id;
	@Column(name="car_money")
	private Integer money;
	@Column(name="car_point")
	private Integer point;
	
	//特殊属性  一对一
	//EAGER是做联表查询的，LAZY是多次查询的，当有多个表进行联表查询的时候用eager，当只单独查询其中一个的时候用lazy。
	@OneToOne(targetEntity=User.class,cascade={CascadeType.ALL},fetch=FetchType.EAGER)//前一个是做增删改，后面一个是做查询的！
	@JoinColumn(name="user_id")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Card(Long id, Integer money, Integer point) {
		super();
		this.id = id;
		this.money = money;
		this.point = point;
	}

	public Card(Integer money, Integer point) {
		super();
		this.money = money;
		this.point = point;
	}

	public Card(Long id) {
		super();
		this.id = id;
	}

	public Card() {
		super();
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", money=" + money + ", point=" + point + "]";
	}
	
	

}
