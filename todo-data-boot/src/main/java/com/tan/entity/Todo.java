package com.tan.entity;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@RequestMapping("/todo")
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	private String task;
	private String priority;
	private String status = "Pending";
	private LocalDate ad = LocalDate.now();
	private LocalDate cd;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "uid")
	private User user;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getAd() {
		return ad;
	}

	public void setAd(LocalDate ad) {
		this.ad = ad;
	}

	public LocalDate getCd() {
		return cd;
	}

	public void setCd(LocalDate cd) {
		this.cd = cd;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
