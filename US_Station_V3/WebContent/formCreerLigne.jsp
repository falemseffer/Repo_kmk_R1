<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<form action="ControleLigne" method="post">
	<fieldset>
		<legend>Informations Station</legend>

			<label for="ligne_name">Name :<span class="requis">*</span></label> <input
				type="text" id="ligne_name" name="ligne_name" value="" size="20"
				maxlength="20" /> <br /> 
				
			<label for="heurePremierTrain">Heure Premier Train
				: </label> <input type="time" name="heurePremierTrain">  <br />
				
			<label for="heureDernierTrain">Heure Dernier Train
				: </label> <input type="time" name="heureDernierTrain">  <br />
				
			<label for="capaciteDeCirculation">Capacite De Circulation
				: </label> <input type="number" name="capaciteDeCirculation"> <br />
				
			<label for="nombreDeCanton">nombre De Canton
				: </label> <input type="number" name="nombreDeCanton"> <br />
				
			<label for="capaciteMaxDeVoyageur">Capacite Max De Voyageur
				: </label> <input type="number" name="capaciteMaxDeVoyageur"> <br />
				
			<label for="kilometrageTotal">kilométrage Total
				: </label> <input type="number" name="kilometrageTotal"> <br />
				
			<label for="ligne_comment">Comment
				: </label> <input type="text" id="ligne_comment" name="ligne_comment"
				value="" size="80" maxlength="20" /> <br />
				
				

	</fieldset>

	<input type="submit" value="add" name="action" /> <input type="reset"
		value="Reset" /> <br />
		
		
		
</form>


	
	