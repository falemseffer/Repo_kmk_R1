package beans;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="station")
public class Station {	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idstation")
	private Integer idStation ;
	@Column(name="nomstation")
	private String nomStation;
	@Column(name="commentaire")
	private String commentaireStation;
	
	@OneToMany(mappedBy="station")
	private List<Canton> cantonlist;
	
	public Station() {
		super();
		
	}

	public Station(String nomStation, String commentaireStation) {
		// TODO Auto-generated constructor stub
		super();
		this.nomStation=nomStation;
		this.commentaireStation=commentaireStation;
	}
	public Integer getIdStation() {
		return idStation;
	}

	public void setIdStation(Integer idStation) {
		this.idStation = idStation;
	}

	public String getNomStation() {
		return nomStation;
	}

	public void setNomStation(String nomStation) {
		this.nomStation = nomStation;
	}

	public String getCommentaireStation() {
		return commentaireStation;
	}

	public void setCommentaireStation(String commentaireStation) {
		this.commentaireStation = commentaireStation;
	}

	public List<Canton> getCantonlist() {
		return cantonlist;
	}

	public void setCantonlist(List<Canton> cantonlist) {
		this.cantonlist = cantonlist;
	}
	
	

}
