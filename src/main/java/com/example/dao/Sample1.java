package com.example.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
    @Getter
	@Setter
	@Entity
	@Table(name = "tbl_sample1")
	@EqualsAndHashCode(of = "sno")
	@ToString
*/
public class Sample1 {
	
	// 오라클의 시퀀스를 생성하려면 @SequenceGenerator를 이용해서 생성되는 Sequence의 이름과 SequenceGenerator의 이름을 지정해 주어야 한다.
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sample1")
//	// @GeneratedValue(strategy = GenerationType.IDENTITY) // 오라클 12c 버전부터 지원하는 어노테이션이다.
//	@SequenceGenerator(name = "seq_sample1", sequenceName = "SEQ_SAMPLE1", allocationSize = 1, initialValue = 1)
//	public Long sno;
//	
//	public String col1;
//	public String col2;
}
