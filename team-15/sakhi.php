<?php

	$name=check($_POST(""));
	$email=check($_POST(""));
	$password=check($_POST(""));
	$phone_no=check($_POST(""));
	$online=check($_POST(""));
	$address=check($_POST(""));
	$lat=check($_POST(""));
	$long=check($_POST(""));
	
	$connection=mysqli_connnect("","","");
	if(!$connection){
		die("Data connection failed".mysqli_error($connection));
	}
	$select_db=mysqli_select_db('');
	if(!$select_db){
		die("Database connection failed".mysql_error($select_db));
	}
	
	$cnt = mysql_num_rows(mysql_query("SELECT * FROM TABLE"));
<<<<<<< HEAD
	$query="insert into customer values("",".$name",".$email.",".$password.",".$phone_no.","$address",".$online.","$lat",".$long.");"
=======
	$query="insert into customer values("null",".$name.",".$email.",".$password.",".$phone_no.","$address",".$online.","$lat",".$long.");"
>>>>>>> c135fa9420fde02f80908b4c9807685afaff7fd6

	function check(m){
			
	  $data = trim($data);
	  $data = stripslashes($data);
	  $data = htmlspecialchars($data);
	  return $data;		
	}
?>
