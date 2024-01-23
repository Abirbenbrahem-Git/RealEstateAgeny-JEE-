<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demande de location</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body class="bg-secondary">
	<div class="container">
		 <div class="row">
			 <div class="col">
			 <br><br><br>
			 <div class="card text-center">
			 <div class="card-header">
			<h2 class="text-center text-primary">Demande de location</h2>
			</div>
			<div class="card-body">
				<form method="POST" action="demandeLocation">
				    Date De Départ: 
				 <input type="date"   name="datedepart"></br></br>
				 Date D'Arrivée: 
				 <input type="date"   name="datearrive">
				                       </br></br>
								 ID immobilier: 
				 <input type="number"   name="idimmobilier">
				                       </br></br>
					<input class="btn btn-primary" type="submit">
					
					</form></div></div></div></div></div>
</body>
</html>