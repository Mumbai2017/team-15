<?php

	$phone_no=$_POST("");
	$name=$_POST("");
	$email=$_POST("");
	$address=$_POST("");
	
	

	$connection=mysqli_connnect("","","");
	if(!$connection){
		die("Data connection failed".mysqli_error($connection));
	}
	$select_db=mysqli_select_db('');
	if(!$select_db){
		die("Database connection failed".mysql_error($select_db));
	}

?>