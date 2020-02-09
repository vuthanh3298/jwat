package entity;
// Generated Feb 7, 2020, 11:04:24 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Lesson generated by hbm2java
 */
@Entity(name = "lesson")
@Table(name = "lesson", catalog = "jwat")
public class Lesson implements java.io.Serializable {

	private int id;
	private Chapter chapter;
	private String name;
	private Integer time;
	private Set<Schedule> schedules = new HashSet<Schedule>(0);
	private Set<Users> userses = new HashSet<Users>(0);

	public Lesson() {
	}

	public Lesson(int id) {
		this.id = id;
	}

	public Lesson(int id, Chapter chapter, String name, Integer time, Set<Schedule> schedules, Set<Users> userses) {
		this.id = id;
		this.chapter = chapter;
		this.name = name;
		this.time = time;
		this.schedules = schedules;
		this.userses = userses;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_chapter")
	public Chapter getChapter() {
		return this.chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "time")
	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lesson")
	public Set<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(Set<Schedule> schedules) {
		this.schedules = schedules;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "attendance", catalog = "jwat", joinColumns = {
			@JoinColumn(name = "id_lesson", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_user", nullable = false, updatable = false) })
	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

}
