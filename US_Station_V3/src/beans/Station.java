package beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Station")
public class Station implements Serializable{
	/**
	 * Classe Metier "Station" : s'allie ˆ la BD
	 * contient les Get et les Set
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="station_id")
	private Integer station_id ;
	@Column(name="station_name", nullable=false)
	private String nameStation;
	@Column(name="station_comment")
	private String commentStation ;
	
	public Station() {
		// TODO Auto-generated constructor stub
	}
	public Station(String nameStation, String commentStation){
		this.nameStation=nameStation;
		this.commentStation=commentStation;
	}
	public Integer getStation_id() {
		return station_id;
	}
	public void setStation_id(Integer station_id) {
		this.station_id = station_id;
	}
	public String getNameStation() {
		return nameStation;
	}
	public void setNameStation(String nameStation) {
		this.nameStation = nameStation;
	}
	public String getCommentStation() {
		return commentStation;
	}
	public void setCommentStation(String commentStation) {
		this.commentStation = commentStation;
	}
	@Override
	public String toString() {
		return "Station [station_id=" + station_id + ", nameStation="
				+ nameStation + ", commentStation=" + commentStation + "]";
	}
}
