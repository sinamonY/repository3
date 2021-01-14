package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
//@Table(name="mydata")
public class MyData {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO) //データベースの主キーのフィールドに対して値を自動生成。列挙型のGenerationTypeに自動的に（auto）値を割り振る。
	//githubのメールアドレス自動生成されたけど、それみたいなことかな？

	@Column
	private long id; //大きい整数型longで変数idを用意。

	@Column(length = 50, nullable = false) //名前は半角５０文字まで。ヌルはダメ。
	private String name;

	@Column(length = 200, nullable =true) //メールアドレスは半角２００文字まで。ヌルでもOK。
	private String mail;

	@Column(nullable = true) //名前はヌルでもOK.
	private Integer age;

	@Column(nullable = true) //メモもヌルでもOK.
	private String memo;

	public long getId() { //変数idに入っているidを取得
		return id;
	}

	public void setId(long id) { //取得した自動生成idを書き換える。
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setNmae(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}

