<?php;

	$user_id=$_POST("");
	$type=$_POST("");
	$text=$_POST("");

	$conn = mysqli_connect($servername, $username, $password, $dbname);
	if(!$conn) {
		die("Connection failed" . mysqli_error());
	}
 	else {
 		echo "Connected successfully";
 	}
 	$q="insert into feedback values("'.type.'","'.user_id.'","'.text.'");
?>