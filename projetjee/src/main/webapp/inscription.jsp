<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body class="bg-secondary">
 <div class="container">
 <div class="row">
 <div class="col">
 <br><br><br>
 <div class="card">
 <div class="card-header">
<h2 class="text-center text-primary">Page d'inscription</h2>
</div>
<div class="card-body">
	<form method="post" action="inscription">
		<label class="text-center">CIN : </label>
		<input type="text"  placeholder="CIN" name="CIN"></br></br>
		<label>Nom : </label>
		<input type="text"  placeholder="Nom" name="Nom"></br></br>
		<label>Prénom : </label>
		<input type="text" placeholder="Prénom" name="Prenom"></br></br>
		<label>E-mail : </label>
		<input type="email" placeholder="E-mail" name="Email"></br></br>
		<label>password : </label>
		<input type="password"  placeholder="Mot de passe" name="password"></br></br>
		</br></br>
		<input class="btn btn-primary" type="submit">
	</form>
</div></div></div></div></div>
</body>
</html>