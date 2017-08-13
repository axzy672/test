package com.myannotation.model;

public class User {
	private long id;
	private String Name;
	private int Qq;
	private String type;
	private int time;
	private String GraduateSchool;
	private int studentNumber;
	private String DailyLink;
	private String hope;
	private String teacher;
	private String knowFrom;
	private int createAt;
	private int updateAt;
	
	public void user(String Name, int Qq,String type,int time,String GraduateSchool,int studentNumber,String DailyLink,String hope,String teacher,String knowFrom,int createAt,int updateAt){ 
		this.Name = Name;
		this.Qq = Qq;
		this.type = type;
		this.time = time;
		this.GraduateSchool = GraduateSchool;
		this.studentNumber = studentNumber;
		this.DailyLink = DailyLink;
		this.hope = hope;
		this.teacher = teacher;
		this.knowFrom = knowFrom;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}
	
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

	public void settime(int time) {
		this.time = time;
	}
	public String getGraduateSchool() {
		return GraduateSchool;
	}

	public void setGraduateSchool(String GraduateSchool) {
		this.GraduateSchool = GraduateSchool;
	}
	public int getstudentNumber() {
		return studentNumber;
	}

	public void setstudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getDailyLink() {
		return DailyLink;
	}

	public void setDailyLink(String DailyLink) {
		this.DailyLink = DailyLink;
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
	public String getknowFrom() {
		return knowFrom;
	}

	public void setknowFrom(String knowFrom) {
		this.knowFrom = knowFrom;
	}
	public long getcreateAt() {
		return createAt;
	}

	public void setcreateAt(int createAt) {
		this.createAt = createAt;
	}
	public long getupdateAt() {
		return updateAt;
	}

	public void setupdateAt(int updateAt) {
		this.updateAt = updateAt;
	}
	
	@Override
    public String toString() {
        return "User [id=" + id + ", Name=" + Name + 
        		", Qq=" + Qq + ", type=" + type + ", "
        				+ "time=" + time + ", Graduate_School="
        		+ GraduateSchool + ", student_number=" + studentNumber + ""
        				+ ", Daily_link=" + DailyLink + ",hope =" + hope + ", "
        						+ "teacher=" + teacher + ", know_from=" + knowFrom + 
        						", create_at=" + createAt + ", update_at=" + updateAt + "]";
    }
	
}
