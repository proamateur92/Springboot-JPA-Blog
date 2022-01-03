package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//ORM -> Java(다른언어) Object -> 테이블로 매핑해주는 기술
@Entity // User 클래스가 MySQL에 테이블에 생성이 된다.
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increament
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량 데이터
	private String content; // 섬머노트 라이브러리 <html> 태그가 섞여서 디자인이 됨.

	@ColumnDefault("0")
	private int count; // 조회수
	
	// Many = Board, One = User
	@ManyToOne(fetch=FetchType.EAGER)  // EAGER 전략, join해서 바로 데이터를 가져온다. / LAZY 전략, 데이터를 가져올 수도 있고, 없을 수도 있음. 
	@JoinColumn(name="userId")
	private User user; // DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.
	
	@OneToMany(mappedBy="board", fetch=FetchType.EAGER) // mappedBy 연관관계의 주인이 아니다. 테이블에 생성되는 FK가 아니다.) DB에 컬럼을 만들지 마세요.
	private List<Reply> reply;
	
	@CreationTimestamp // 데이터가 insert or update 될 때
	private Timestamp createDate;
}
