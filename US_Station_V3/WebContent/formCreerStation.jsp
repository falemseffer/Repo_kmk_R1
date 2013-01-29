<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<form action="ControleStation" method="post">
	<fieldset>
		<legend>Informations Station</legend>

		<label for="nameStation">Name :<span class="requis">*</span></label> <input
			type="text" id="nameStation" name="nameStation" value="" size="20"
			maxlength="20" /> <br /> <label for="commentStation">Comment
			: </label> <input type="text" id="commentStation" name="commentStation"
			value="" size="80" maxlength="20" /> <br />

	</fieldset>

	<input type="submit" value="add" name="action" /> <input type="reset"
		value="Reset" /> <br />
</form>