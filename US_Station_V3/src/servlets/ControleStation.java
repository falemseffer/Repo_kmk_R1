	package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Station;

import utils.DAO_Station;

/**
 * Servlet implementation class testDelete
 */
@WebServlet("/ControleStation")
public class ControleStation extends HttpServlet {
	
	DAO_Station m = new DAO_Station();
	private static final long serialVersionUID = 1L;
	String message ="";
    Station st = new Station() ;
    int id  ;
    String  nameS;
	String  commentS ;
    String nameStation ;
    String commentStation ; 
    List< Station > malist ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleStation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		//Controle Action Suppression
		if ("Supprimer".equals(action)) {
			String message = "La sélection d'une station est obligatoire, Merci de le faire svp <br>" +
					"1) Sélectionner une station <br>"+
					"2) Cliquer sur le bouton en bas 'Supprimer'";
				
			String select[] = request.getParameterValues("id"); 
		    StringBuffer sb = new StringBuffer(); 
		    // Je contrôle si le ID est null alors j'affiche un message
		    	if(request.getParameterValues("id")==null){
		    		 request.setAttribute( "message", message );
		    		 malist = m.listst();	
		    		 request.setAttribute("malist",malist);
			        this.getServletContext().getRequestDispatcher( "/listStation.jsp" ).forward( request, response );
			        	//Je Supprime si l'id existe 
		    	}else {
						    for(int i = 0; i < select.length; i++) {
						        sb.append(select[i] + ",");
						    }
					    String vwarnid = sb.toString(); 
					    vwarnid = vwarnid.substring(0, vwarnid.length()-1);
					    System.out.print(vwarnid);
				    // convertion le id qui est string ==> en int
				   int  i = Integer.parseInt(vwarnid); 
				    m.delete(i);
					malist = m.listst();	
					request.setAttribute("malist",malist);
	        this.getServletContext().getRequestDispatcher( "/listStation.jsp" ).forward( request, response );
		    	}
		}		
	//Controle Modifier Station
		if("Modifier".equals(action)){
			String message = "La sélection d'une station est obligatoire, Merci de le faire svp <br>" +
					"1) Sélectionner une station <br>"+
					"2) Cliquer sur le bouton en bas 'Modifier'";
			String select[] = request.getParameterValues("id"); 
		    StringBuffer sb = new StringBuffer(); 
		    // Je contrôle si le ID est null alors j'affiche un message
		    	if(request.getParameterValues("id")==null){
		    		 request.setAttribute( "message", message );
		    		 malist = m.listst();	
		    		 request.setAttribute("malist",malist);
			        this.getServletContext().getRequestDispatcher( "/listStation.jsp" ).forward( request, response );
			
		    	}
		    	else{
			    for(int i = 0; i < select.length; i++) {
			        sb.append(select[i] + ",");
			    }
			    String vwarnid = sb.toString(); 
			    vwarnid = vwarnid.substring(0, vwarnid.length()-1);
			    ArrayList<Station> li = (ArrayList<Station>) m.valueStation(vwarnid);
				   for(Station s : li){						 
					   		id = s.getStation_id();
						    nameS =s.getNameStation();
						    commentS =s.getCommentStation();						    					   
						   message = "Vous êtes sur le point de modifier :" ;							
						 
				   }		    				
				 request.setAttribute( "message", message );
				 request.setAttribute( "name", nameS );	
				 request.setAttribute( "comment", commentS );	
			       
				this.getServletContext().getRequestDispatcher(  "/EcranModifierStation.jsp" ).forward( request, response );	
		    	}
		}
		//Controle Creer Station
		if("add".equals(action)){
			   /*
	         * Récupération des données saisies, envoyées en tant que paramètres de
	         * la requête GET générée à la validation du formulaire
	         */
	         nameStation = request.getParameter( "nameStation" );
	         commentStation = request.getParameter( "commentStation" );    
	        if ( nameStation.trim().isEmpty()) {
	            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> " +
	            			"Merci de le faire / click "+
	            		"<a href=\"creerStation.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
	            request.setAttribute( "message", message );
	            this.getServletContext().getRequestDispatcher( "/creerStation.jsp" ).forward( request, response );
	       
	        } else {
	        	//ajout de paramètre sans DAO
	        	DAO_Station.createStation(nameStation,commentStation);
	            message = "Création '" +nameStation+"' avec succès !";	          
	            st.setNameStation( nameStation );
	            st.setCommentStation( commentStation );        
	            request.setAttribute( "station", st );
	            request.setAttribute( "message", message );
	            malist = m.listst();	
	        	request.setAttribute("malist",malist);
	            this.getServletContext().getRequestDispatcher( "/listStation.jsp" ).forward( request, response );
	        }
		}
		
		//Controle Update Station
		if("Update".equals(action)){	
			   /*
	         * Récupération des données saisies, envoyées en tant que paramètres
	         * la requête GET générée à la validation du formulaire
	         */
	         nameStation = request.getParameter( "nameStation" );
	         commentStation = request.getParameter( "commentStation" );    
	        if ( nameStation.trim().isEmpty()) {
	            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> " +
	            			"Merci de le faire / click "+
	            		"<a href=\"creerStation.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
	            request.setAttribute( "message", message );
	            this.getServletContext().getRequestDispatcher( "/creerStation.jsp" ).forward( request, response );
	       
	        } else {
	        	//ajout de paramètre sans DAO
	        	st.setStation_id(id);
	        	st.setCommentStation(commentStation);
	        	st.setNameStation(nameStation);
	        	m.Edit(st);
	        	//m.Editst(id,nameStation,commentStation);
	            message = "Modification de : '" +nameStation+"' avec succès !";	          
	            st.setNameStation( nameStation );
	            st.setCommentStation( commentStation );        
	            request.setAttribute( "station", st );
	            request.setAttribute( "message", message );
	            malist = m.listst();	
	        	request.setAttribute("malist",malist);
	            this.getServletContext().getRequestDispatcher( "/listStation.jsp" ).forward( request, response );
	        }
			
		}
		if("afficher".equals(action) || "Actualiser".equals(action)){	
			malist = m.listst();	
			request.setAttribute("malist",malist);
			this.getServletContext().getRequestDispatcher( "/listStation.jsp" ).forward( request, response );

		}
			
	}

}
