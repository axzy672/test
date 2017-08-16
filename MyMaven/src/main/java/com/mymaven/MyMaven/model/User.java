package com.mymaven.MyMaven.model;

public class User {
	private long id;
	private String Name;
	private int Qq;
	private String type;
	private long time;
	private String Graduate_School;
	private int student_number;
	private String Daily_link;
	private String hope;
	private String teacher;
	private String know_from;
	private long create_at;
	private long update_at;
	
	public long getId(){
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public int getQq() {
		return Qq;
	}

	public void setQq(int Qq) {
		this.Qq = Qq;
	}
	public String gettype() {
		return type;
	}

	public void settype(String type) {
		this.type = type;
	}
	public long gettime() {
		return time;
	}

	public void settime(long time) {
		this.time = time;
	}
	public String getGraduate_School() {
		return Graduate_School;
	}

	public void setGraduate_School(String Graduate_School) {
		this.Graduate_School = Graduate_School;
	}
	public int getstudent_number() {
		return student_number;
	}

	public void setstudent_number(int student_number) {
		this.student_number = student_number;
	}
	public String getDaily_link() {
		return Daily_link;
	}

	public void setDaily_link(String Daily_link) {
		this.Daily_link = Daily_link;
	}
	public String gethope() {
		return hope;
	}

	public void sethope(String hope) {
		this.hope = hope;
	}
	public String getteacher() {
		return teacher;
	}

	public void setteacher(String teacher) {
		this.teacher = teacher;
	}
	public String getknow_from() {
		return know_from;
	}

	public void setknow_from(String know_from) {
		this.know_from = know_from;
	}
	public long getcreate_at() {
		return create_at;
	}

	public void setcreate_at(long create_at) {
		this.create_at = create_at;
	}
	public long getupdate_at() {
		return update_at;
	}

	public void setupdate_at(long update_at) {
		this.update_at = update_at;
	}
	
	@Override
    public String toString() {
        return "User [id=" + id + ", Name=" + Name + 
        		", Qq=" + Qq + ", type=" + type + ", "
        				+ "time=" + time + ", Graduate_School="
        		+ Graduate_School + ", student_number=" + student_number + ""
        				+ ", Daily_link=" + Daily_link + ",hope =" + hope + ", "
        						+ "teacher=" + teacher + ", know_from=" + know_from + 
        						", create_at=" + create_at + ", update_at=" + update_at + "]";
    }
}
